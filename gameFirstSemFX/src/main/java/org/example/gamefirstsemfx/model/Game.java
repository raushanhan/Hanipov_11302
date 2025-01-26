package org.example.gamefirstsemfx.model;

public class Game {

    private final Player first;
    private final Player second;

    private Player kicker;
    private Player receiver;

    public Game() {
        first = new Player(1, 10, "Usal");
        second = new Player(1, 10, "Eybet");
        kicker = first;
        receiver = second;
        System.out.println(first + " " + second + " " + kicker + " " + receiver);
    }

    public void doKick() {
        kicker.kick(receiver);
        Player middle = receiver;
        receiver = kicker;
        kicker = middle;
    }

    public boolean isOn() {
        return first.isAlive() && second.isAlive();
    }

    public Player getWinner() {
        if (first.isAlive() && !second.isAlive()) {
            return first;
        }
        return second;
    }

    public Player getFirst() {
        return first;
    }

    public Player getSecond() {
        return second;
    }

    public Player getKicker() {
        return kicker;
    }
}
