//2024.09.24
import Units.Archer;
import Units.Hero;
import Units.Mage;
import Units.Warrior;
import Units.Weapons.MagicWands.Wand;
import Units.Weapons.Swords.Sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainingGround {
    public static void main(String[] args) {
        System.out.println("Task 1:");
        Hero adam = new Warrior("Adam", new Wand());
        System.out.println(adam);
        System.out.println("Training by self");
        for(int i = 0; i < 1000; i++){
            adam.weaponLearning(adam.getWeapon());
        }
        System.out.println(adam);
        printSplitter();

        Hero maggi = new Mage("Maggie", new Sword());
        System.out.println(maggi);

        adam.attackEnemy(maggi, 3);
        maggi.attackEnemy(adam, 3);

    }

    public static void printSplitter(){
        System.out.println("-----------------------------");
    }
}
