package Units;

import Units.Weapons.MagicWands.Wand;
import Units.Weapons.Swords.Sword;
import Units.Weapons.Weapon;

import java.util.Random;

public class Mage  extends Hero{

    public Mage(String name, Weapon weapon){
        super(HeroesTypes.Mage, name, weapon);
    }

    public Mage(String name){
        this(name, new Wand());
    }
    @Override
    public void attackEnemy(){
        System.out.printf("Alert: Units.Mage %s is attacking%n", name);
    }

    @Override
    public void attackEnemy(Enemy enemy){
        int damage = new Random().nextInt(10);
        this.attackEnemy(enemy, (int) (damage*0.5));
        if(enemy.isAlive()) this.attackEnemy(enemy, damage);
        if(enemy.isAlive()) this.attackEnemy(enemy, (int) (damage*1.3));
    }

}

