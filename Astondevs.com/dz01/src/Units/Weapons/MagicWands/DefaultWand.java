package Units.Weapons.MagicWands;

import Units.Weapons.Weapon;
import Units.Weapons.WeaponsTypes;

public class DefaultWand extends Weapon {

    public DefaultWand(String name, int damage, int level) {
        super(WeaponsTypes.MAGICAL_WEAPON, name, damage, level, 30, 90, 10);
    }
}
