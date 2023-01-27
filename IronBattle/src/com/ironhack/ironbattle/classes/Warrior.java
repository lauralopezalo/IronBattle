package com.ironhack.ironbattle.classes;
import com.ironhack.ironbattle.interfaces.Attacker;


public class Warrior extends Character {

    private int hp;
    private int stamina;
    private int strength;

    public Warrior(String name) {
        super(name);
        this.hp = (int)(Math.random()*(200-100+1))+100;
        this.stamina = (int)(Math.random()*(50-10+1)+10);
        this.strength = (int)(Math.random()*(10)+1);
    }

    public Warrior(String name, int hp) {
        super(name, hp);
        this.hp = hp;
        this.stamina = (int)(Math.random()*(50-10+1)+10);
        this.strength = (int)(Math.random()*(10)+1);
    }

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name);
        this.hp = hp;
        this.stamina = stamina;
        this.strength = strength;
    }

    @Override
    public void attack(Character character) {

        int heavyAttack = strength;
        int weakAttack = strength/2;

        String attack = (((int)(Math.random()*2)+1 == 1) ? "Heavy Attack" : "Weak Attack");
        if (attack.equals("Heavy Attack") && stamina >= 5){
            character.setHp(character.getHp() - heavyAttack);
            stamina = stamina - 5;
            System.out.println(getName() + " casts " + attack + " and lost 5 points of stamina. Stamina points left: " + stamina + "\n" + character.getName() + " receives " + heavyAttack + " points of damage. Life points left: " + character.getHp() + "\n" );
        }
        else {
            character.setHp(character.getHp() - weakAttack);
            stamina++;
            System.out.println(getName() + " casts " + attack + " and wins 1 point of stamina. Stamina points left: " + stamina + "\n" + character.getName() + " receives " + weakAttack + " points of damage. Life points left: " + character.getHp() + "\n" );
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

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
      
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Character sheet: \nName: " + getName() + " (" +
                this.getClass().getName().substring(getClass().getName().lastIndexOf(".")+ 1) + ")" +
                "\nId: " + getId() +
                "\nStamina (10/50): " + stamina + " points" +
                "\nStrength (1/10): " + strength + " points" +
                "\nHp (100/200): " + hp + " points\n";
    }
}

