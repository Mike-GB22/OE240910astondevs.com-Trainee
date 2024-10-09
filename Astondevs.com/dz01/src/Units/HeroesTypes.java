//2024.10.07 zip
package Units;

import Units.Abilities.AbilitiesTypes;
import Units.Weapons.WeaponsTypes;

import java.util.HashMap;
import java.util.Map;

public enum HeroesTypes {
    GHOST("Ghost" )
    , ARCHER("Archer")
    , MAGE("Mage")
    , WARRIOR("Warrior");


    private final Map<AbilitiesTypes, Integer> defaultAbilities = new HashMap<>();
    private final Map<WeaponsTypes, Double> defaultLevelOfWeaponProficiency = new HashMap<>();
    private final Map<WeaponsTypes, Integer> defaultAptitudeForLearningWeapon = new HashMap<>();
    private final String typeOfHero;

    static {
        for(HeroesTypes type: HeroesTypes.values()){
            setDefaultAbilities(type);
            setDefaultLevelOfWeaponProficiency(type);
            setDefaultAptitudeForLearningWeapon(type);
        }
    }

    HeroesTypes(String name){
        this.typeOfHero = name;
    }

    public String getTypeOfHero(){
        return typeOfHero;
    }

    public Map<WeaponsTypes, Double> getDefaultLevelOfWeaponProficiency() {
        return defaultLevelOfWeaponProficiency;
    }

    public Map<WeaponsTypes, Integer> getDefaultAptitudeForLearningWeapon() {
        return defaultAptitudeForLearningWeapon;
    }

    public Map<AbilitiesTypes, Integer> getDefaultAbilities(){
        return defaultAbilities;
    }
    private static void setDefaultAbilities(HeroesTypes type){
        type.defaultAbilities.put(AbilitiesTypes.LEVEL, AbilitiesTypes.LEVEL.getDefaultValue());
        type.defaultAbilities.put(AbilitiesTypes.STRENGTH, AbilitiesTypes.STRENGTH.getDefaultValue());
        type.defaultAbilities.put(AbilitiesTypes.DEXTERITY, AbilitiesTypes.DEXTERITY.getDefaultValue());
        type.defaultAbilities.put(AbilitiesTypes.EVASION, AbilitiesTypes.EVASION.getDefaultValue());
        type.defaultAbilities.put(AbilitiesTypes.MAGIC, AbilitiesTypes.MAGIC.getDefaultValue());
        switch (type) {
            case WARRIOR -> type.defaultAbilities.put(AbilitiesTypes.STRENGTH, 100);
            case ARCHER -> type.defaultAbilities.put(AbilitiesTypes.EVASION, 100);
            case MAGE -> type.defaultAbilities.put(AbilitiesTypes.MAGIC, 100);
            case GHOST -> type.defaultAbilities.put(AbilitiesTypes.MAGIC, 500);
            default -> {
            }
        }
    }
    private static void setDefaultLevelOfWeaponProficiency(HeroesTypes type){
        switch (type){
            case WARRIOR -> {
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.MAGICAL_WEAPON, 30d);
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.MELEE_WEAPON, 100d);
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.RANGED_WEAPON, 60d);
                break;
            }
            case ARCHER -> {
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.MAGICAL_WEAPON, 30d);
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.MELEE_WEAPON, 60d);
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.RANGED_WEAPON, 100d);
                break;
            }
            case MAGE -> {
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.MAGICAL_WEAPON, 100d);
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.MELEE_WEAPON, 60d);
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.RANGED_WEAPON, 30d);
                break;
            }
            case GHOST -> {
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.MAGICAL_WEAPON, 500d);
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.MELEE_WEAPON, 0d);
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.RANGED_WEAPON, 0d);
                break;
            }
            default -> {
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.MAGICAL_WEAPON, 10d);
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.MELEE_WEAPON, 10d);
                type.defaultLevelOfWeaponProficiency.put(WeaponsTypes.RANGED_WEAPON, 10d);
            }
        }
    }
    private static void setDefaultAptitudeForLearningWeapon(HeroesTypes type){
        switch (type){
            case WARRIOR -> {
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.MAGICAL_WEAPON, 10);
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.MELEE_WEAPON, 100);
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.RANGED_WEAPON, 30);
                break;
            }
            case ARCHER -> {
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.MAGICAL_WEAPON, 10);
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.MELEE_WEAPON, 30);
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.RANGED_WEAPON, 100);
                break;
            }
            case MAGE -> {
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.MAGICAL_WEAPON, 100);
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.MELEE_WEAPON, 30);
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.RANGED_WEAPON, 10);
                break;
            }
            case GHOST -> {
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.MAGICAL_WEAPON, 500);
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.MELEE_WEAPON, 0);
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.RANGED_WEAPON, 0);
                break;
            }
            default -> {
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.MAGICAL_WEAPON, 10);
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.MELEE_WEAPON, 10);
                type.defaultAptitudeForLearningWeapon.put(WeaponsTypes.RANGED_WEAPON, 10);
            }
        }
    }

}
