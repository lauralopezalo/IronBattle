package com.ironhack.ironbattle.classes;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RandomCsvCharacter {

    public static void readCsv(String[] args) throws IOException {

        File file = new File("IronBattle/src/com/ironhack/ironbattle/files/teams.csv");

        Scanner scanner = new Scanner(file);
        String data = scanner.nextLine();

        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
        }
            String[] row = data.split(",");

            System.out.println("Name: " + row[0]);


            public Character ramdomCharacter () {
                Character newCharacter = new Character() {
                    String result = row[(int) (Math.random() * (11 - 1 + 1) + 10)];
                    name =result;
                    this.result =name;

                }
                @Override
                public void setName (String name){
                    this.name = name;
                }
            }
        }
    }
}
//
//    public static void main(String[] args) throws IOException {
//
//
//        public static Character Character(){
//
//            File file = new File("IronBattle/src/com/ironhack/ironbattle/files/teams.csv");
//            Scanner scanner = new Scanner(file);
//            String data = scanner.nextLine();
//
//            while (scanner.hasNextLine()) {
//                data = scanner.nextLine();
//
//                String[] row = data.split(",");
//
//                System.out.println("CLASS: " + row[0] + "\n" +
//                        "ID: " + row[1] + "\n" +
//                        "Name: " + row[2] + "\n");
//
//                public Character ramdomCharacter(int i){
//                    i = (int) (Math.random() * (11 - 1 + 1) + 10)
//                    if (row[i] == "Class::WIZARD")
//                        character = new Wizard(row[i]);
//                } else{
//                    return Warrior = new Warrior(row[i]);
//                    character = new Warrior(row[i])
//                }
//            }
//        }