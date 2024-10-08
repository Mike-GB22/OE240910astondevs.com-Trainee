package Units.Weapons;

public enum WeaponsTypes {
    meleeWeapon("Оружие ближнего боя"),
    rangedWeapon("Оружие дальнего боя"),
    magicalWeapon("Магическое оружие");

    public final String typeOfWeapon;
    private WeaponsTypes(String type){
        typeOfWeapon = type;
    }
}
