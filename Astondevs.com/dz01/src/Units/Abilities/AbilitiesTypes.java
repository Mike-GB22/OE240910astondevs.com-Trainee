package Units.Abilities;

public enum AbilitiesTypes {
    MAGIC("�����", 1),
    STRENGTH("����", 30),
    EVASION("��������� �� �����", 30),
    DEXTERITY("��������", 30),
    LEVEL("������� ���������", 1);
    private String name;
    private int defaultValue;

    private AbilitiesTypes(String name, int defaultValue){
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public int getDefaultValue(){
        return defaultValue;
    }
}
