package com.ironhack.ironbattle.main;
import com.ironhack.ironbattle.classes.Character;
import com.ironhack.ironbattle.classes.Warrior;
import com.ironhack.ironbattle.classes.Wizard;
import java.lang.reflect.Array;

import com.ironhack.ironbattle.classes.Character;
import com.ironhack.ironbattle.classes.Warrior;
import com.ironhack.ironbattle.classes.Wizard;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a name for the first fighter");
        String nameFighter1 = scanner.nextLine();
        System.out.print("Enter the class of the character (Wizard o Warrior): ");
        String type1 = scanner.nextLine();
        while (!type1.equalsIgnoreCase("Warrior") && !type1.equalsIgnoreCase("Wizard")) {
            System.out.print("Invalid class. Choose Wizard or Warrior: ");
            type1 = scanner.nextLine();
        }
        Character fighter1 = (type1.equalsIgnoreCase("Wizard")) ? new Wizard(nameFighter1) : new Warrior(nameFighter1);


        System.out.println("Enter a name for the second fighter");
        String nameFighter2 = scanner.nextLine();
        System.out.print("Enter the class of the character (Wizard o Warrior): ");
        String type2 = scanner.nextLine();
        while (!type2.equalsIgnoreCase("Warrior") && !type2.equalsIgnoreCase("Wizard")) {
            System.out.print("Invalid class. Choose Wizard or Warrior: ");
            type2 = scanner.nextLine();
        }
        Character fighter2 = (type2.equalsIgnoreCase("Wizard")) ? new Wizard(nameFighter2) : new Warrior(nameFighter2);

        System.out.println(fighter1.toString());
        System.out.println(fighter2.toString());

        System.out.println("Ready for combat? (y/n)");
        String ready = scanner.nextLine();
        scanner.close();

        if (ready.equals("y")) {
            fight(fighter1, fighter2);
        }
        else {
            System.out.println("Aborted mission");
        }

    }

    public static void fight(Character fighter1, Character fighter2) {
        int initialHpFighter1 = fighter1.getHp();
        int initialHpFighter2 = fighter2.getHp();
        System.out.println(fighter1.getClass());
        int classAtribute1 = (fighter1 instanceof Wizard) ? (((Wizard) fighter1).getMana()) : (((Warrior) fighter1).getStamina());
        int classAtribute2 = (fighter2 instanceof Wizard) ? (((Wizard) fighter2).getMana()) : (((Warrior) fighter2).getStamina());

        int roundCounter = 1;

        while (fighter1.isAlive() && fighter2.isAlive()){
            System.out.println("Round " + roundCounter);
            fighter1.attack(fighter2);
            fighter2.attack(fighter1);
            roundCounter++;
            if (!fighter1.isAlive() && !fighter2.isAlive())
            {
                System.out.println("\nDOUBLE DEATH BLOW! There can be only one. FIGHT!\n\n");
                restartCharacters(fighter1, fighter2, initialHpFighter1, initialHpFighter2, classAtribute1, classAtribute2);
                roundCounter = 1;
            }
        }
        if (fighter1.isAlive() && !fighter2.isAlive())
            System.out.println("\n\n" + fighter1.getName().toUpperCase() +" WINS!!!!!!\n\n");
        else
            System.out.println("\n\n" + fighter2.getName().toUpperCase() +" WINS!!!!!!\n\n");


    }

    public static void restartCharacters(Character fighter1, Character fighter2, int initialHpFighter1, int initialHpFighter2, int classAtribute1, int classAtribute2){
        fighter1.setHp(initialHpFighter1);
        fighter2.setHp(initialHpFighter2);
        if ((fighter1 instanceof Wizard)) {
            ((Wizard) fighter1).setMana(classAtribute1);
        } else {
            ((Warrior) fighter1).setStamina(classAtribute1);
        }
        if ((fighter2 instanceof Wizard)) {
            ((Wizard) fighter2).setMana(classAtribute2);
        } else {
            ((Warrior) fighter2).setStamina(classAtribute2);
        }
        fighter1.setAlive(true);
        fighter2.setAlive(true);
        System.out.println(fighter1);
        System.out.println(fighter2);
    }

}