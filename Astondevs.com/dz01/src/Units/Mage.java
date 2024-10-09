package Units;

import Units.Weapons.MagicWands.Wand;
import Units.Weapons.Weapon;

import java.util.Random;

public class Mage  extends Hero{

    public Mage(String name, Weapon weapon){
        super(HeroesTypes.MAGE, name, weapon);
    }

    public Mage(String name){
        this(name, new Wand());
    }
}

