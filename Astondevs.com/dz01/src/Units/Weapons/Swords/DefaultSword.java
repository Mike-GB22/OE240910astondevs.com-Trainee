package Units.Weapons.Swords;

import Units.Weapons.Weapon;
import Units.Weapons.WeaponsTypes;

public class DefaultSword extends Weapon {
    public DefaultSword(String name, int damage, int level, int distance) {
        super(WeaponsTypes.meleeWeapon, name, damage, level, distance, (int)(distance * 1.5), 50);
    }
}
