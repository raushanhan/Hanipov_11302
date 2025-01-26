package org.example.gamefirstsemfx.model;

import javafx.beans.property.*;

public class Player {

    private DoubleProperty hp = new SimpleDoubleProperty();
    private IntegerProperty damage = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();

    public Player(double hp, int damage, String name) {
        this.hp.setValue(hp);
        this.damage.setValue(damage);
        this.name.setValue(name);
    }

    public double getHp() {
        return hp.get();
    }

    public DoubleProperty hpProperty() {
        return hp;
    }

    public int getDamage() {
        return damage.get();
    }

    public IntegerProperty damageProperty() {
        return damage;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public boolean isAlive() {
        return getHp() > 0;
    }

    public void kick(Player receiver) {
        receiver.hpProperty().setValue(receiver.getHp() -  getDamage() / (double) 100);
    }
}
