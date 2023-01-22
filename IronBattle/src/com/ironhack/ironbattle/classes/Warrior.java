package com.ironhack.ironbattle;

public class Warrior extends Character {
    public int stamina;
    public int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

}
