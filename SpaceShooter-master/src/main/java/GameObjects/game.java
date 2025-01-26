package GameObjects;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.ArrayList;

import static Game.SpaceShooter.*;

public class game {

    private static player player;
    private static ArrayList<String> input;
    private static int score;

    private static double dimX;
    private static double dimY;

    private static Scene gameScene;
    private static Pane gameBox;

    private static double playerVelocity;
    private static final double playerBaseVelocity = 0.01;


    public game(double x, double y) {
        player = new player(0, 0);
        input = new ArrayList<>();
        dimX = x;
        dimY = y;
        score = 0;
        playerVelocity = playerBaseVelocity;


        BorderPane root = new BorderPane();
        gameBox = new Pane();

        Image back = new Image("/images/Background.png", x, y, false, false);
        ImageView background = new ImageView(back);
        background.setX(0);
        background.setY(0);

        gameBox.getChildren().add(background);
        gameBox.getChildren().addAll(player);
        gameBox.getChildren().addAll(player.getCANNON());

        spawnAsteroid(400, 250);
        spawnAsteroid(550, 250);


        gameScene = new Scene(root);

        gameBox.setOnMouseClicked(this::mouseClick);

        gameScene.setOnKeyPressed(event -> {
            String keyInput = event.getCode().toString();
            System.out.println(keyInput + " was pressed!");
            if (!input.contains(keyInput)) {
                input.add(keyInput);
            }
        });

        gameScene.setOnKeyReleased(event -> {
            String keyInput = event.getCode().toString();
            input.remove(keyInput);
        });

        gameBox.setOnMouseDragged(event -> player.rotateCannon(event));
        gameBox.setOnMouseMoved(event -> player.rotateCannon(event));

        gameBox.setOnMousePressed(event -> {
//            player.rotateCannon(event);

            if (event.getButton().toString().equals("PRIMARY")) {
                player.startFiring();
            }
        });

        gameBox.setOnMouseReleased(event -> player.stopFiring());

        root.setCenter(gameBox);
        Text text = new Text("Score: " + score + " Velocity: " + playerVelocity);
        root.setTop(text);
    }

    public Scene getGameScene() {
        return gameScene;
    }

    public void moveGameObjects() {
        moveCharacter();
        changeCharacterSpeed();
    }

    private void changeCharacterSpeed() {
        boolean one = input.contains("DIGIT1");
        boolean two = input.contains("DIGIT2");
        boolean three = input.contains("DIGIT3");

        if (one) {
            playerVelocity = playerBaseVelocity;
        }
        if (two) {
            playerVelocity = playerBaseVelocity * 5;
        }
        if (three) {
            playerVelocity = playerBaseVelocity * 10;
        }
        BorderPane pane = (BorderPane) gameScene.getRoot();
        pane.setTop(new Text("Score: " + score + " Velocity: " + playerVelocity));
    }


    private void moveCharacter() {
        boolean w = input.contains("W");
        boolean a = input.contains("A");
        boolean s = input.contains("S");
        boolean d = input.contains("D");
        boolean ctrl = input.contains("CONTROL");

        if (w) {
            if (!ctrl) {
                player.addVelocity(0, -playerVelocity);
            } else {
                player.addVelocity(0, -playerVelocity / 10d);
            }
        }
        if (a) {
            if (!ctrl) {
                player.addVelocity(-playerVelocity, 0);
            } else {
                player.addVelocity(-playerVelocity / 10d, 0);
            }
        }
        if (s) {
            if (!ctrl) {
                player.addVelocity(0, playerVelocity);
            } else {
                player.addVelocity(0, playerVelocity / 10d);
            }
        }
        if (d) {
            if (!ctrl) {
                player.addVelocity(playerVelocity, 0);
            } else {
                player.addVelocity(playerVelocity / 10d, 0);
            }
        }

        player.update((double) 1000 / getUpdateRate());

        addFlameEffects(w, a, s, d, ctrl);

        player.rotateCannon();

        ObservableList<Node> list = gameBox.getChildren();
        for (int i = 0; i < list.size(); i++) {
            Node nd = list.get(i);

            if (nd instanceof asteroid) {
                asteroid ast = (asteroid) nd;

                ObservableList<Node> listproj = gameBox.getChildren();

                for (int j = 0; j < listproj.size(); j++) {

                    Node pro = listproj.get(j);
                    if (pro instanceof projectile) {
                        if (ast.intersects((projectile) pro)) {
                            list.remove(pro);
                            score += 100;
                            BorderPane pane = (BorderPane) gameScene.getRoot();
                            pane.setTop(new Text("Score: " + score + " Velocity: " + playerVelocity));
                            if (ast.getHit()) {
                                list.remove(ast);
                            }
                        }
                    }
                }
            }
            if (nd instanceof projectile) {
                projectile pro = (projectile) nd;
                if (!pro.isOutOfBounds()) {
                    pro.update((double) 1000 / getUpdateRate());
                } else {
                    list.remove(pro);
                }
            }
        }
    }

    private static void spawnAsteroid(double x, double y) {
        asteroid ast = new asteroid(x, y);
        ast.setPosition(x - ast.getWidth() / 2, y - ast.getHeight() / 2);
        gameBox.getChildren().add(ast);
    }

    private void mouseClick(MouseEvent event) {
        System.out.println("game was clicked at: " + event.getX() + "," + event.getY() + " (" + event.getButton() + ")");
        switch (event.getButton()) {
            case PRIMARY:
            case MIDDLE:
            case NONE:

                break;
            case SECONDARY:

                spawnAsteroid(event.getX(), event.getY());

                break;
        }
    }

    private void addFlameEffects(boolean w, boolean a, boolean s, boolean d, boolean ctrl) {
        addFlameEffectUP(w, ctrl);
        addFlameEffectLeft(a, ctrl);
        addFlameEffectDOWN(s, ctrl);
        addFlameEffectRIGHT(d, ctrl);
    }

    private void addFlameEffectUP(boolean on, boolean ctrl) {
        if (on) {

            if (!ctrl) {
                if (!gameBox.getChildren().contains(player.getUP())) {
                    gameBox.getChildren().add(player.getUP());
                    gameBox.getChildren().remove(player.getUP_SMALL());
                }
            } else {
                if (!gameBox.getChildren().contains(player.getUP_SMALL())) {
                    gameBox.getChildren().add(player.getUP_SMALL());
                    gameBox.getChildren().remove(player.getUP());
                }
            }
        } else {
            gameBox.getChildren().remove(player.getUP());
            gameBox.getChildren().remove(player.getUP_SMALL());
        }
    }

    private void addFlameEffectLeft(boolean on, boolean ctrl) {
        if (on) {
            if (!ctrl) {
                if (!gameBox.getChildren().contains(player.getLEFT())) {
                    gameBox.getChildren().add(player.getLEFT());
                    gameBox.getChildren().remove(player.getLEFT_SMALL());
                }
            } else {
                if (!gameBox.getChildren().contains(player.getLEFT_SMALL())) {
                    gameBox.getChildren().add(player.getLEFT_SMALL());
                    gameBox.getChildren().remove(player.getLEFT());
                }
            }
        } else {
            gameBox.getChildren().remove(player.getLEFT());
            gameBox.getChildren().remove(player.getLEFT_SMALL());
        }
    }

    private void addFlameEffectDOWN(boolean on, boolean ctrl) {
        if (on) {
            if (!ctrl) {
                if (!gameBox.getChildren().contains(player.getDOWN())) {
                    gameBox.getChildren().add(player.getDOWN());
                    gameBox.getChildren().remove(player.getDOWN_SMALL());
                }
            } else {
                if (!gameBox.getChildren().contains(player.getDOWN_SMALL())) {
                    gameBox.getChildren().add(player.getDOWN_SMALL());
                    gameBox.getChildren().remove(player.getDOWN());
                }
            }
        } else {
            gameBox.getChildren().remove(player.getDOWN());
            gameBox.getChildren().remove(player.getDOWN_SMALL());
        }
    }

    private void addFlameEffectRIGHT(boolean on, boolean ctrl) {
        if (on) {
            if (!ctrl) {
                if (!gameBox.getChildren().contains(player.getRIGHT())) {
                    gameBox.getChildren().add(player.getRIGHT());
                    gameBox.getChildren().remove(player.getRIGHT_SMALL());
                }
            } else {
                if (!gameBox.getChildren().contains(player.getRIGHT_SMALL())) {
                    gameBox.getChildren().add(player.getRIGHT_SMALL());
                    gameBox.getChildren().remove(player.getRIGHT());
                }
            }
        } else {
            gameBox.getChildren().remove(player.getRIGHT());
            gameBox.getChildren().remove(player.getRIGHT_SMALL());
        }
    }

    static void spawnProjectile(double x, double y, double mousex, double mousey, double angle) {
        gameBox.getChildren().add(new projectile(x, y, mousex, mousey, angle));
    }

    static double getGameDimX() {
        return dimX;
    }

    static double getGameDimY() {
        return dimY;
    }

    private String getDebugInfo() {
        return "Time: " + getTime() / getUpdateRate() + ", Position: " + (short) player.getPositionX() + " (" + (short) (player.getPositionX()
                + player.getWidth()) + "), " + (short) player.getPositionY() + " (" + (short) (player.getPositionY() + player.getHeight()) + ")" + "Game objects: " + gameBox.getChildren().size()
                + "\nwidth: " + player.getWidth() + ", height: " + player.getHeight()
                + ", Velocity: " + player.getVelocityX() + "," + player.getVelocityY();
    }
}