package com.ironhack.ironbattle.classes;

import com.ironhack.ironbattle.interfaces.Attacker;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

//    public Wizard(String name, int hp, int mana, int intelligence) {
//        super(name, hp);
//        this.mana = mana;
//        this.intelligence = intelligence;
//    }

    public Wizard(String name) {
        super(name);
        this.mana = (int)(Math.random()*50-10+1)+10;
        this.intelligence = (int)(Math.random()*50)+10;
    }


    public void attack(Character character) {
        int fireball = intelligence;

        int attack = (int)(Math.random()*2+1);
        if (attack == 1 && mana >= fireball){
            character.setHp(character.getHp() - fireball);
            mana = mana - 5;
            System.out.println(getName() + " casts Fireball and lost 5 points of mana  ." + mana + " points left." + character.getName() +
                    "receives " + fireball + " points of damage. " + character.getHp() + "life points left\n");
        }
        else {
            character.setHp(character.getHp() - 2);
            mana++;
            System.out.println(getName() + " casts Staff Hit and wins 1 point of mana  . " + character.getName() + "receives 2 points of damage. " + character.getHp() + "life points left\n");
        }
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        return "Character sheet: \nName: " + getName() +
                "\nMana: " + mana + " points" +
                "\nIntelligence: " + intelligence + " points" +
                "\nHp: " + getHp() + " points\n";
    }
}
