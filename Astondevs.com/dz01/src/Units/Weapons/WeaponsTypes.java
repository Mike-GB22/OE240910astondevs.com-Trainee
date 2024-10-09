package Units.Weapons;

public enum WeaponsTypes {
    MELEE_WEAPON("Оружие ближнего боя"),
    RANGED_WEAPON("Оружие дальнего боя"),
    MAGICAL_WEAPON("Магическое оружие");

    public final String typeOfWeapon;
    private WeaponsTypes(String type){
        typeOfWeapon = type;
    }
}
