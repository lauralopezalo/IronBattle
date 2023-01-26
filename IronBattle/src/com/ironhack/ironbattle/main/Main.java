package com.ironhack.ironbattle.main;

import com.ironhack.ironbattle.classes.Warrior;
import com.ironhack.ironbattle.classes.Wizard;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {



    }


    public static void fight(Wizard wizard, Warrior warrior) {
        int initialHpWizard = wizard.getHp();
        int initialHpWarrior = warrior.getHp();
        int initialMana = wizard.getMana();
        int initialStamina = warrior.getStamina();
        int roundCounter = 1;

        while (wizard.isAlive() && warrior.isAlive()){
            System.out.println("Round " + roundCounter);
            wizard.attack(warrior);
            warrior.attack(wizard);
            roundCounter++;
            if (!wizard.isAlive() && !warrior.isAlive())
            {
                System.out.println("\nDOUBLE DEATH BLOW! There can be only one. FIGHT!\n\n");
                restartCharacters(wizard, warrior, initialHpWizard, initialHpWarrior, initialMana, initialStamina);
                roundCounter = 1;
            }
        }
        if (wizard.isAlive() && !warrior.isAlive())
            System.out.println("\n\nKORBI WINS!!!!!!\n\n");
        else
            System.out.println("\n\nBRUTO WINS!!!!!!\n\n");

    }

    public static void restartCharacters(Wizard wizard, Warrior warrior, int initialHpWizard, int initialHpWarrior, int initialMana, int initialStamina){
        wizard.setHp(initialHpWizard);
        warrior.setHp(initialHpWarrior);
        wizard.setMana(initialMana);
        warrior.setStamina(initialStamina);
        wizard.setAlive(true);
        warrior.setAlive(true);
        System.out.println(warrior);
        System.out.println(wizard);
    }

}