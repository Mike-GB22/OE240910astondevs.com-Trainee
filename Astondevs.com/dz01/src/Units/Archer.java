package Units;

import Units.Weapons.Bows.Bow;
import Units.Weapons.Swords.Sword;
import Units.Weapons.Weapon;

import java.util.Random;

 public class Archer extends Hero {

    public Archer(String name, Weapon weapon){
        super(HeroesTypes.Archer, name, weapon);
    }

     public Archer(String name){
         this(name, new Bow());
     }

    @Override
    public void attackEnemy(){
        System.out.printf("Alert: Units.Archer %s is attacking%n", name);
    }

    @Override
    public void attackEnemy(Enemy enemy){
        int damage =  new Random().nextInt(15);
        this.attackEnemy(enemy, damage);
    }

}
