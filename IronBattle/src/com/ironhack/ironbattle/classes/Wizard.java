package com.ironhack.ironbattle.classes;

import com.ironhack.ironbattle.interfaces.Attacker;

public class Wizard extends Character  {

    private int hp;
    private int mana;
    private int intelligence;


    public Wizard(String name) {
        super(name);
        this.hp = (int)(Math.random()*(100-50+1))+50;
        this.mana = (int)(Math.random()*(50-10+1))+10;
        this.intelligence = (int)(Math.random()*(50-1))+1;
    }

    public Wizard(String name, int hp) {
        super(name, hp);
        this.hp = hp;
        this.mana = (int)(Math.random()*(50-10+1))+10;
        this.intelligence = (int)(Math.random()*(50-1))+1;
    }

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name);
        this.hp = hp;
        this.mana = mana;
        this.intelligence = intelligence;
    }

    public void attack(Character character) {
        int fireball = intelligence;

        String attack = (((int)(Math.random()*2)+1 == 1) ? "Fireball" : "Staff Hit");
        if (attack.equals("Fireball") && mana >= 5){
            character.setHp(character.getHp() - fireball);
            mana = mana - 5;
            System.out.println(getName() + " casts " + attack + " and lost 5 points of mana. Mana points left: " + mana + "\n" + character.getName() + " receives " + fireball + " points of damage. Life points left: " + character.getHp() + "\n" );
        }
        else {
            character.setHp(character.getHp() - 2);
            mana++;
            System.out.println(getName() + " casts " + attack + " and wins 1 point of mana. Mana points left: " + mana + "\n"  + character.getName() + " receives 2 points of damage. Life points left: " + character.getHp() + "\n" );
        }
        if (character.getHp() < 1) character.setAlive(false);
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
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
        return "Character sheet: \nName: " + getName() + " (" +
                this.getClass().getName().substring(getClass().getName().lastIndexOf(".")+ 1) + ")" +
                "\nId: " + getId() +
                "\nMana (10/50): " + mana + " points" +
                "\nIntelligence (1/50): " + intelligence + " points" +
                "\nHp (50/100): " + hp + " points\n";
    }
}
