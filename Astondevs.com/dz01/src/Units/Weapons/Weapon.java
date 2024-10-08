package Units.Weapons;


import Units.Abilities.AbilitiesTypes;

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

    public float getDamage(Map<AbilitiesTypes, Integer> abilities){
        return defaultDamage
                * getCoefficientByTypeOfWeaponAndAbilitiesOfHero(abilities) / 300
                * getCoefficientByLevelOfWeaponsAndAbilitiesOfHero(abilities);
    }

    public int getCoefficientByTypeOfWeaponAndAbilitiesOfHero(Map<AbilitiesTypes, Integer> abilities){
        switch (typeOfWeapon) {
            case magicalWeapon :
                return abilities.get(AbilitiesTypes.MAGIC) * 100
                        +  abilities.get(AbilitiesTypes.STRENGTH) * 10
                        +  abilities.get(AbilitiesTypes.DEXTERITY) * 50;
            case meleeWeapon:
                return abilities.get(AbilitiesTypes.MAGIC) * 10
                        +  abilities.get(AbilitiesTypes.STRENGTH) * 100
                        +  abilities.get(AbilitiesTypes.DEXTERITY) * 50;
            case rangedWeapon:
                return abilities.get(AbilitiesTypes.MAGIC) * 10
                        +  abilities.get(AbilitiesTypes.STRENGTH) * 50
                        +  abilities.get(AbilitiesTypes.DEXTERITY) * 100;
            default: return 30;
        }
    }

    public float getCoefficientByLevelOfWeaponsAndAbilitiesOfHero(Map<AbilitiesTypes, Integer> abilities){
        return abilities.get(AbilitiesTypes.LEVEL) / levelOfWeapons;
    }

    public WeaponsTypes getWeaponsTypes(){
        return typeOfWeapon;
    }
}
