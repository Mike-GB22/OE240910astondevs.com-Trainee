import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AutosTypesTest {
    private static List<Enums> listOfEnums = new ArrayList<>();

    @AllArgsConstructor
    static class Enums{
        @Getter
        String enumName;
        @Getter
        String type;
        @Getter
        int countOfTire;
    }

    @BeforeAll
    static void start(){
        listOfEnums.add(new Enums("MOTORBIKE",  "Motorbike", 2));
        listOfEnums.add(new Enums("AUTO", "Auto", 4));
        listOfEnums.add(new Enums("TRUCK", "Truck", 6));
        listOfEnums.add(new Enums("TRAIN", "Truck trailer", 6));
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void getType() {
        assertEquals(
                listOfEnums.get(1).getType()
                , AutosTypes.valueOf(listOfEnums.get(1).getEnumName()).getType());
        assertNotEquals(
                listOfEnums.get(1).getType()
                , AutosTypes.valueOf(listOfEnums.get(2).getEnumName()).getType());
    }

    @Test
    void getCountOfTire() {
        assertEquals(
                listOfEnums.get(1).getCountOfTire()
                , AutosTypes.valueOf(listOfEnums.get(1).getEnumName()).getCountOfTire());
        assertNotEquals(
                listOfEnums.get(1).getCountOfTire()
                , AutosTypes.valueOf(listOfEnums.get(2).getEnumName()).getCountOfTire());
    }

    @Test
    void values() {
        List<Enums> listToCheck = new ArrayList<>(listOfEnums);
        List<AutosTypes> listOfOriginalEnums = Arrays.asList(AutosTypes.values());
        assertEquals(listOfOriginalEnums.size(), listToCheck.size());

        listToCheck.removeIf(x -> listOfOriginalEnums.contains(AutosTypes.valueOf(x.enumName)));
        assertEquals(0, listToCheck.size());
    }

    @Test
    void valueOf() {
        assertEquals(AutosTypes.AUTO, AutosTypes.valueOf("AUTO"));
        assertNotEquals(AutosTypes.MOTORBIKE, AutosTypes.valueOf("AUTO"));
    }
}