//2024.10.07 zip
package Units;

import Units.Abilities.AbilitiesTypes;
import Units.Weapons.WeaponsTypes;

import java.util.HashMap;
import java.util.Map;

public enum HeroesTypes {
    Ghost("Ghost")
    , Archer("Archer")
    , Mage("Mage")
    , Warrior("Warrior");

    private Map<AbilitiesTypes, Integer> defaultAbilities = new HashMap<>();
    private final String typeOfHero;

    private HeroesTypes(String name){
        this.typeOfHero = name;
        setDefaultAbilities();
    }

    public String getTypeOfHero(){
        return typeOfHero;
    }

    public Map<AbilitiesTypes, Integer> defaultAbilities(){
        return defaultAbilities;
    }
    private void setDefaultAbilities(){
        this.defaultAbilities.put(AbilitiesTypes.LEVEL, AbilitiesTypes.LEVEL.getDefaultValue());
        this.defaultAbilities.put(AbilitiesTypes.STRENGTH, AbilitiesTypes.STRENGTH.getDefaultValue());
        this.defaultAbilities.put(AbilitiesTypes.DEXTERITY, AbilitiesTypes.DEXTERITY.getDefaultValue());
        this.defaultAbilities.put(AbilitiesTypes.EVASION, AbilitiesTypes.EVASION.getDefaultValue());
        this.defaultAbilities.put(AbilitiesTypes.MAGIC, AbilitiesTypes.MAGIC.getDefaultValue());
        switch (this){
            case Warrior -> {
                this.defaultAbilities.put(AbilitiesTypes.STRENGTH, 100);
                break;
            }
            case Archer -> {
                this.defaultAbilities.put(AbilitiesTypes.EVASION, 100);
                break;
            }
            case Mage -> {
                this.defaultAbilities.put(AbilitiesTypes.MAGIC, 100);
                break;
            }
            case Ghost -> {
                break;
            }
            default -> {
            }
        }
    }


//    private void setDefaultAbilities(){
//        switch (this){
//            case Warrior -> {
//                this.defaultAbilities.put(WeaponsTypes.magicalWeapon, 30);
//                this.defaultAbilities.put(WeaponsTypes.meleeWeapon, 100);
//                this.defaultAbilities.put(WeaponsTypes.rangedWeapon, 60);
//                break;
//            }
//            case Archer -> {
//                this.defaultAbilities.put(WeaponsTypes.magicalWeapon, 30);
//                this.defaultAbilities.put(WeaponsTypes.meleeWeapon, 60);
//                this.defaultAbilities.put(WeaponsTypes.rangedWeapon, 100);
//                break;
//            }
//            case Mage -> {
//                this.defaultAbilities.put(WeaponsTypes.magicalWeapon, 100);
//                this.defaultAbilities.put(WeaponsTypes.meleeWeapon, 60);
//                this.defaultAbilities.put(WeaponsTypes.rangedWeapon, 30);
//                break;
//            }
//            case Ghost -> {
//                this.defaultAbilities.put(WeaponsTypes.magicalWeapon, 500);
//                this.defaultAbilities.put(WeaponsTypes.meleeWeapon, 0);
//                this.defaultAbilities.put(WeaponsTypes.rangedWeapon, 0);
//                break;
//            }
//            default -> {
//                this.defaultAbilities.put(WeaponsTypes.magicalWeapon, 10);
//                this.defaultAbilities.put(WeaponsTypes.meleeWeapon, 10);
//                this.defaultAbilities.put(WeaponsTypes.rangedWeapon, 10);
//            }
//        }
//    }

}
