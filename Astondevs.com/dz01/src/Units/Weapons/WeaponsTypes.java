package Units.Weapons;

public enum WeaponsTypes {
    MELEE_WEAPON("������ �������� ���"),
    RANGED_WEAPON("������ �������� ���"),
    MAGICAL_WEAPON("���������� ������");

    public final String typeOfWeapon;
    private WeaponsTypes(String type){
        typeOfWeapon = type;
    }
}
