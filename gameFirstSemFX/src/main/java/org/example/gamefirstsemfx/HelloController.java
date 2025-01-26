package org.example.gamefirstsemfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import org.example.gamefirstsemfx.model.Game;
import org.example.gamefirstsemfx.model.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private static final String KICK_TEXT = "Kick!";
    private static final String START_TEXT = "Start";
    private static final String RESTART_TEXT = "Restart";


    private Game game;

    @FXML
    public ProgressBar healthFirst;
    @FXML
    public ProgressBar healthSecond;
    @FXML
    public Label nameFirst;
    @FXML
    public Label nameSecond;
    @FXML
    public Slider damageFirst;
    @FXML
    public Slider damageSecond;
    @FXML
    public Label whichPlayer;
    @FXML
    public Button kickBtn;

    private String buttonState;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        changeBtn(START_TEXT);

    }

    private void doBindings() {
        bindFirstPlayer();
        bindSecondPlayer();
    }

    private void bindFirstPlayer() {
        Player first = this.game.getFirst();
        nameFirst.textProperty().bindBidirectional(first.nameProperty());
        damageFirst.valueProperty().bindBidirectional(first.damageProperty());
        healthFirst.progressProperty().bindBidirectional(first.hpProperty());
    }

    private void bindSecondPlayer() {
        Player second = this.game.getSecond();
        nameSecond.textProperty().bindBidirectional(second.nameProperty());
        damageSecond.valueProperty().bindBidirectional(second.damageProperty());
        healthSecond.progressProperty().bindBidirectional(second.hpProperty());
    }

    @FXML
    protected void onKickButtonAction() {
        switch (buttonState) {
            case START_TEXT:
                startAction();
                break;
            case KICK_TEXT:
                kickAction();
                break;
            case RESTART_TEXT:
                restartAction();
                break;
        }

    }

    private void kickAction() {
        game.doKick();
        if (!game.isOn()) {
            whichPlayer.textProperty().setValue(game.getWinner().getName() + " has won!!!");
            changeBtn(RESTART_TEXT);
        } else {
            whichPlayer.textProperty().setValue(game.getKicker().getName() + " is kicking");
        }
        System.out.println(healthFirst.getProgress());
    }

    private void startAction() {
        this.game = new Game();
        changeBtn(KICK_TEXT);
        doBindings();
    }

    private void restartAction() {
        game = new Game();
        changeBtn(KICK_TEXT);
        doBindings();
    }

    private void changeBtn(String state) {
        buttonState = state;
        kickBtn.setText(state);
    }
}