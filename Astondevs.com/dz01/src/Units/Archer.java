package Units;

import Units.Weapons.Bows.Bow;
import Units.Weapons.Weapon;

import java.util.Random;

 public class Archer extends Hero {

    public Archer(String name, Weapon weapon){
        super(HeroesTypes.ARCHER, name, weapon);
    }

     public Archer(String name){
         this(name, new Bow());
     }
}
