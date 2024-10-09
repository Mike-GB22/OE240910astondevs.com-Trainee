package Units;

import Units.Abilities.AbilitiesTypes;
import Units.Weapons.Weapon;
import Units.Weapons.WeaponsTypes;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

abstract public class Hero extends Enemy{

    protected HeroesTypes typeOfHero = HeroesTypes.GHOST;
    protected Weapon weapon1;
    protected Weapon weapon2;
    private final Map<AbilitiesTypes, Integer> profileAbilities;
    private final Map<WeaponsTypes, Double> profileLevelOfWeaponProficiency;
    private final Map<WeaponsTypes, Integer> profileAptitudeForLearningWeapon ;
    
    public Hero(HeroesTypes type, String name, Weapon weapon)
    {
        super(name);
        typeOfHero = type;
        weapon1 = weapon;
        profileAbilities = type.getDefaultAbilities();
        profileLevelOfWeaponProficiency = type.getDefaultLevelOfWeaponProficiency();
        profileAptitudeForLearningWeapon = type.getDefaultAptitudeForLearningWeapon();
    }

    public String getName(){
        return name;
    }

    public Weapon getWeapon(){
        return weapon1;
    }

    public HeroesTypes getTypeOfHero(){
        return typeOfHero;
    }

    public Weapon getSecondWeapon(){
        return weapon2;
    }

    public Map<AbilitiesTypes, Integer> getAbilities() {
        return profileAbilities;
    }

    public Map<WeaponsTypes, Double> getLevelOfWeaponProficiency() {
        return profileLevelOfWeaponProficiency;
    }

    public Map<WeaponsTypes, Integer> getAptitudeForLearningWeapon() {
        return profileAptitudeForLearningWeapon;
    }

    //TODO Обучение оружию
    //TODO Генерация урона переданного
    //TODO Генерация урона принятого
    //TODO Учет дистанции

    public void attackEnemy(Enemy enemy){
        attackEnemy(enemy, 3);
    }
    public void attackEnemy(Enemy enemy, int distance){
        if(!this.isAlive()) return;
        Weapon weapon = weapon1;
        double damage = weapon.getDamage(this, distance) * getLuck();
        weaponLearning(weapon);


        System.out.printf("Hero %s %s attacks %s with %s, damage sent %.2f %n"
                , typeOfHero, name, enemy.name, weapon.getName(), damage);
        enemy.takeDamage(damage);
    }

    public double dodgeAnAttack(double damage){
        return damage
                * (100
                - profileAbilities.get(AbilitiesTypes.EVASION) * getLuck()
                - profileAbilities.get(AbilitiesTypes.DEXTERITY) * getLuck()
                ) / 100;
    }

    public void weaponLearning(Weapon weapon){
        WeaponsTypes weaponsTypes = weapon.getWeaponsTypes();
        profileLevelOfWeaponProficiency.put(weaponsTypes,
        profileLevelOfWeaponProficiency.get(weaponsTypes) +
                profileAptitudeForLearningWeapon.get(weaponsTypes) / 10000.0);
    }
    
    public double getLuck(){
        return 0.9 + (new Random().nextInt(200)) / 1000.0;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(String.format("INFO HERO NAME: %s, HERO TYPE: %s, HEALTH: %d", name, typeOfHero, (int) getHealth()));
        s.append("\nABILITIES                  : ");
        s.append(profileAbilities.keySet().stream()
                .map(x -> x + ": " + profileAbilities.get(x))
                .collect(Collectors.joining(", ")));

        s.append("\nLEVEL OF WEAPON PROFICIENCY: ");
        s.append(profileLevelOfWeaponProficiency.keySet().stream()
                .map(x -> x + ": " + profileLevelOfWeaponProficiency.get(x))
                .collect(Collectors.joining(", ")));

        s.append("\nAPTITUDE FOR LEARNING      : ");
        s.append(profileAptitudeForLearningWeapon.keySet().stream()
                .map(x -> x + ": " + profileAptitudeForLearningWeapon.get(x))
                .collect(Collectors.joining(", ")));

        s.append("\nWEAPON 1: " + (weapon1 != null ? weapon1 : " - "));
        s.append("\nWEAPON 2: " + (weapon2 != null ? weapon2 : " - "));
        s.append("\n");
        return s.toString();
    }

}
