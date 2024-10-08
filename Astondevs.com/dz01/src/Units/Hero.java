package Units;

import Units.Abilities.AbilitiesTypes;
import Units.Weapons.Weapon;

import java.util.Map;

abstract public class Hero <T extends Weapon> extends Enemy{

    protected HeroesTypes typeOfHero = HeroesTypes.Ghost;
    protected T weapon1;
    protected Map<AbilitiesTypes, Integer> abilities;
    public Hero(HeroesTypes type, String name, T weapon)
    {
        super(name);
        typeOfHero = type;
        abilities = type.defaultAbilities();
        weapon1 = weapon;
    }

    public String getName(){
        return name;
    }

    abstract public void attackEnemy();
    abstract public void attackEnemy(Enemy enemy);

    public boolean attackEnemy(Enemy enemy, int damage){
        if(!this.isAlive()) return false;
        System.out.printf("Alert: %s %s is attacking by %s on %s, damage %d %n"
                , typeOfHero, name, weapon1.getName(), enemy.name, damage);
        enemy.takeDamage((int) weapon1.getDamage(abilities));
        return true;
    }
}
