package Units.Abilities;

public enum AbilitiesTypes {
    MAGIC("Магия", 1),
    STRENGTH("Сила", 30),
    EVASION("Уклонение от отаки", 30),
    DEXTERITY("Ловкость", 30),
    LEVEL("Уровень персонажа", 1);
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
