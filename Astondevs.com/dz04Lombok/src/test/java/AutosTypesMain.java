
class AutosTypesMain {
    public static void main(String[] args) {

        for(AutosTypes enumElement : AutosTypes.values()){
            System.out.printf("enum: %s, type: %s, countOfTire: %d%n"
                    , enumElement, enumElement.getType(), enumElement.getCountOfTire());
        }

        for(AutosTypes enumElement : AutosTypes.values()){
            System.out.println("Enum by NAME: " + AutosTypes.valueOf(enumElement.name()));
        }

    }

}