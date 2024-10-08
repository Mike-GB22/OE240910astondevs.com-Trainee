//2024.09.24
import Units.Archer;
import Units.Hero;
import Units.Mage;
import Units.Warrior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainingGround {
    public static void main(String[] args) {
        System.out.println("Task 1:");
        //Units.Hero adam = new Units.Hero("Adam");
        Hero adam = new Warrior("Adam");
        adam.attackEnemy();
        printSplitter();

        System.out.println("Task 2:");
        List<Hero> heros = new ArrayList<>(
                Arrays.asList(
                        //new Units.Hero("Adam"),
                        new Mage("Maggie"),
                        new Warrior("Bersek"),
                        new Archer("Archerudel")
                        ));
        for(Hero hero : heros){
            hero.attackEnemy();
        }
    }

    public static void printSplitter(){
        System.out.println("-----------------------------");
    }
}
