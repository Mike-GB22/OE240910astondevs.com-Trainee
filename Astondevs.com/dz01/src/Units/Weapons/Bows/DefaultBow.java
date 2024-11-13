package Units.Weapons.Bows;

import Units.Weapons.Weapon;
import Units.Weapons.WeaponsTypes;

public class DefaultBow extends Weapon {

    public DefaultBow(String name, int damage, int level) {
        super(WeaponsTypes.RANGED_WEAPON, name, damage, level, 30, 200, 1);
    }
}