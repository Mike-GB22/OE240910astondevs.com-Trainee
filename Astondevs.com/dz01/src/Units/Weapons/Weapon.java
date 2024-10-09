package Units.Weapons;


import Units.Abilities.AbilitiesTypes;
import Units.Hero;

import java.util.Map;

public abstract class Weapon {

    protected final int defaultDamage;
    protected final int levelOfWeapons;
    protected final int distance100PercentDamage;
    protected final int maxDistance;
    protected final int maxDistanceDamageCoefficient;
    protected WeaponsTypes typeOfWeapon;
    protected String name;

    public Weapon(WeaponsTypes type, String name, int damage, int level, int distance, int maxDistance, int maxDistanceDamageCoefficient){
        typeOfWeapon = type;
        this.name = name;
        defaultDamage = damage;
        levelOfWeapons = level;
        distance100PercentDamage = distance;
        this.maxDistance = maxDistance;
        this.maxDistanceDamageCoefficient = maxDistanceDamageCoefficient;
    }

    public Weapon(WeaponsTypes type, String name, int damage, int level){
        this(type, name, level, level, 3, 4, 50);
    }
    public String getName(){
        return name;
    };

    public double getDamage(Hero hero){
        return defaultDamage
                * getCoefficientByLevelOfWeaponsAndLevelOfHero(hero) /100
                * getCoefficientByTypeOfWeaponAndAbilitiesOfHero(hero) / 100
                * getCoefficientByLevelOfWeaponProficiency(hero) / 100;
    }

    public double getDamage(Hero hero, int distance){
        double maxDamage = getDamage(hero);
        if(distance <= distance100PercentDamage) return maxDamage;
        if(distance > maxDistance) return 0;
        int deltaDistanceMinusDistance100PercentDamage = distance - distance100PercentDamage;
        int deltaMAXDistanceMinusDistance100PercentDamage = maxDistance - distance100PercentDamage;
        return  maxDistanceDamageCoefficient
                + (100 - maxDistanceDamageCoefficient) / deltaMAXDistanceMinusDistance100PercentDamage
                * (deltaMAXDistanceMinusDistance100PercentDamage - deltaDistanceMinusDistance100PercentDamage);
    }

    public double getCoefficientByTypeOfWeaponAndAbilitiesOfHero(Hero hero){
        Map<AbilitiesTypes, Integer> abilities = hero.getAbilities();
        switch (typeOfWeapon) {
            case MAGICAL_WEAPON:
                return abilities.get(AbilitiesTypes.MAGIC) * 1.0
                        +  abilities.get(AbilitiesTypes.STRENGTH) * 0.1
                        +  abilities.get(AbilitiesTypes.DEXTERITY) * 0.5;
            case MELEE_WEAPON:
                return abilities.get(AbilitiesTypes.MAGIC) * 0.1
                        +  abilities.get(AbilitiesTypes.STRENGTH) * 1.0
                        +  abilities.get(AbilitiesTypes.DEXTERITY) * 0.5;
            case RANGED_WEAPON:
                return abilities.get(AbilitiesTypes.MAGIC) * 0.1
                        +  abilities.get(AbilitiesTypes.STRENGTH) * 0.5
                        +  abilities.get(AbilitiesTypes.DEXTERITY) * 1.0;
            default: return 30;
        }
    }

    public double getCoefficientByLevelOfWeaponProficiency(Hero hero){
        Map<WeaponsTypes, Double> levelOfProficiency = hero.getLevelOfWeaponProficiency();
        return levelOfProficiency.get(this.typeOfWeapon);
    }

    public double getCoefficientByLevelOfWeaponsAndLevelOfHero(Hero hero){
        Map<AbilitiesTypes, Integer> abilities = hero.getAbilities();
        double coefficient = abilities.get(AbilitiesTypes.LEVEL) / levelOfWeapons;
        if(coefficient > 2) {
            coefficient = 1 + Math.log(coefficient) / Math.log(2);
        }
        return coefficient * 100;
    }

    public WeaponsTypes getWeaponsTypes(){
        return typeOfWeapon;
    }

    public String toString(){
        return getWeaponsTypes() + ": " + getName();
    }
}
