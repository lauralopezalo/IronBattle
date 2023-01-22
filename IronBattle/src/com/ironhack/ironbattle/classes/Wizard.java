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
            System.out.println(getName() + " atacó con bola de fuego, perdiendo 5 puntos de mana . Le restan " + mana + " puntos de mana. " + character.getName() +
                    " ha recibido " + fireball + " puntos de daño. El hp de" + character.getName() + " ahora es de " + character.getHp());
        }
        else {
            character.setHp(character.getHp() - 2);
            mana++;
            System.out.println(getName() + " atacó con HIT, perdiendo 1 punto de mana . Le restan " + mana + " puntos de mana. " + character.getName() +
                            " ha recibido " + " 2 puntos de daño. El hp de " + character.getName() +  " ahora es de " + character.getHp());

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