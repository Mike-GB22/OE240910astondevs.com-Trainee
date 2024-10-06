//2024.10.06 zip
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class AutoTest {
    AutosTypes type1 = AutosTypes.AUTO;
    AutosTypes type2 = AutosTypes.TRAIN;

    int countOfTire1 = type1.getCountOfTire();
    int countOfTire2 = type2.getCountOfTire();

    Color color1 = Color.BLACK;
    Color color2 = Color.RED;

    String name1 = "VAZ";
    String name2 = "TAZ";

    private Auto autoOne;
    private Auto autoTwo;
    Auto autoOneDuplicate = new Auto(name1, type1, countOfTire1, color1);
    
    @BeforeEach
    void setUp() {
        autoOne = new Auto(name1, type1, countOfTire1, color1);
        autoTwo = new Auto(name2, type2, countOfTire2, color2);
    }

    @Test
    void testEquals() {
        assertTrue(autoOne.equals(autoOneDuplicate));
        assertFalse(autoOne.equals(autoTwo));
    }

    @Test
    void canEqual() {
        assertTrue(autoOne.canEqual(autoTwo));
        assertFalse(autoOne.canEqual("String"));
    }

    @Test
    void testHashCode() {
        assertEquals(autoOne.hashCode(), autoOneDuplicate.hashCode());
        assertNotEquals(autoOne.hashCode(), autoTwo.hashCode());
    }

    @Test
    void testToString() {
        assertEquals(autoOne.toString(), autoOneDuplicate.toString());
        assertNotEquals(autoOne.toString(), autoTwo.toString());
    }

    @Test
    void builder() {
        Auto autoByBuilder = Auto.builder()
                .model(name1)
                .type(type1)
                .countOfTire(countOfTire1)
                .color(color1)
                .build();
        assertTrue(autoByBuilder.equals(autoOne));
    }

    @Test
    void getModel() {
        assertEquals(name1, autoOne.getModel());
        assertNotEquals(name2, autoOne.getModel());
    }

    @Test
    void getType() {
        assertEquals(type1, autoOne.getType());
        assertNotEquals(type2, autoOne.getType());
    }

    @Test
    void getCountOfTire() {
        assertEquals(countOfTire1, autoOne.getCountOfTire());
        assertNotEquals(countOfTire2, autoOne.getCountOfTire());
    }

    @Test
    void getColor() {
        assertEquals(color1, autoOne.getColor());
        assertNotEquals(color2, autoOne.getColor());
    }

    @Test
    void setModel() {
        assertEquals(name1, autoOne.getModel());
        autoOne.setModel(name2);
        assertEquals(name2, autoOne.getModel());
    }

    @Test
    void setType() {
        assertEquals(type1, autoOne.getType());
        autoOne.setType(type2);
        assertEquals(type2, autoOne.getType());
    }

    @Test
    void setColor() {
        assertEquals(color1, autoOne.getColor());
        autoOne.setColor(color2);
        assertEquals(color2, autoOne.getColor());
    }
}