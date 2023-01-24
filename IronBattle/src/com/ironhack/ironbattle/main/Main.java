package com.ironhack.ironbattle.main;
import com.ironhack.ironbattle.classes.Character;
import com.ironhack.ironbattle.classes.Warrior;
import com.ironhack.ironbattle.classes.Wizard;
import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {

        Wizard merlin = new Wizard("Merlin");
        Wizard  kirbi = new Wizard("Kirbi");
        Warrior bruto = new Warrior("Bruto");
        Warrior brave = new Warrior("brave");

        System.out.println(bruto.toString());
        System.out.println(kirbi.toString());

        while (bruto.getHp() > 0 && kirbi.getHp() > 0){
            bruto.attack(kirbi);
            kirbi.attack(bruto);
        }
        if(bruto.getHp()<=0 && kirbi.getHp()>0){
            System.out.println("KIRBI HA GANADO LA BATALLA!!!");
        }else if(kirbi.getHp()<=0 && bruto.getHp()>0) {
            System.out.println("BRUTO HA GANADO LA BATALLA!!!");
        }

    }
}