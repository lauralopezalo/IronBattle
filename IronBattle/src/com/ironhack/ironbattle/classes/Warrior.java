package com.ironhack.ironbattle.classes;
import com.ironhack.ironbattle.interfaces.Attacker;

public class Warrior extends Character implements Attacker {
    public int stamina;
    public int strength;

    public int hp;

    public Warrior(String name) {
        super(name);
        this.stamina = (int)(Math.random()*(50-10+1)+10);
        this.strength =  (int)(Math.random()*(10-1+1)+1);
        this.hp = (int)(Math.random()*(200-100+1)+100);
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
    public void attack(Character character) {

        int randomAttack = 0;
        int heavyAttack = strength;
        int weakAttack = strength/2;


            if ((int)(Math.random()*10+1)<5 && stamina >=1){
                character.setHp(character.getHp() - randomAttack);
                randomAttack = weakAttack;
                stamina++;
                System.out.println(character.getName() + " ha realizado el Ataque Debil," + "inflingiendo un daño de " + randomAttack + " sobre " + character.getName() + ". Tu stamina ahora es de: " + stamina);

            }else if((int)(Math.random()*10+1)>5 && stamina >=5){
                randomAttack = heavyAttack;
                stamina-=5;
                System.out.println(getName() + " ha realizado el Ataque Fuerte," + "inflingiendo un daño de " + randomAttack + " sobre " + character.getName() + ". Tu stamina ahora es de: " + stamina + ". El hp de " + character.getName() + " ahora es de " + character.getHp());
            }else{
                randomAttack = weakAttack;
                stamina++;
                System.out.println(getName() + " ha realizado el Ataque Debil," + "inflingiendo un daño de " + randomAttack + " sobre " + character.getName() + ". Tu stamina ahora es de: " + stamina + ". El hp de " + character.getName() + " ahora es de " + character.getHp());

            }


    }

    @Override
    public String toString() {
        return "Character sheet: \nName: " + getName() +
                " Ha realizado el ataque " +
                "\nStamina: " + stamina + " points" +
                "\nStrength: " + strength + " points" +
                "\nHp: " + getHp() + " points\n";
    }
}
