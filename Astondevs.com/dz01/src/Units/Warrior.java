package Units;

import Units.Weapons.Swords.Sword;
import Units.Weapons.Weapon;

import java.util.Random;

public class Warrior extends Hero{

    public Warrior(String name, Weapon weapon){
        super(HeroesTypes.Warrior, name, weapon);
    }

    public Warrior(String name){
        this(name, new Sword());
    }

    @Override
    public void attackEnemy(){
        System.out.printf("Alert: Units.Warrior %s is attacking %n", name);
    }

    public void attackEnemy(Enemy enemy){
        int damage = new Random().nextInt(20);
        this.attackEnemy(enemy, damage);
    }

}

