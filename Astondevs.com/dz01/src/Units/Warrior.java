package Units;

import Units.Weapons.Swords.Sword;
import Units.Weapons.Weapon;

import java.util.Random;

public class Warrior extends Hero{

    public Warrior(String name, Weapon weapon){
        super(HeroesTypes.WARRIOR, name, weapon);
    }

    public Warrior(String name){
        this(name, new Sword());
    }
}

