package Units.Weapons;

public enum WeaponsTypes {
    meleeWeapon("������ �������� ���"),
    rangedWeapon("������ �������� ���"),
    magicalWeapon("���������� ������");

    public final String typeOfWeapon;
    private WeaponsTypes(String type){
        typeOfWeapon = type;
    }
}
