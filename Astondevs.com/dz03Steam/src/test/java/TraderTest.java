//2024.10.05 zip
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraderTest {
    Trader traderOne;
    Trader traderOneDublet;
    Trader traderTwo;
    String name1 = "Ivan";
    String name2 = "Petr";
    String city1 = "Moskau";
    String city2 = "Rostov";

    @BeforeEach
    void setUp() {
        traderOne = new Trader(name1, city1);
        traderOneDublet = new Trader(name1, city1);
        traderTwo = new Trader(name2, city2);
    }

    @Test
    void constructor() {
        assertEquals(Trader.class, traderOne.getClass());
        assertEquals(name1, traderOne.getName());
        assertNotEquals(name2, traderOne.getName());

        assertEquals(city1, traderOne.getCity());
        assertNotEquals(city2, traderOne.getCity());
    }

    @Test
    void getName() {
        assertEquals(name1, traderOne.getName());
    }

    @Test
    void getCity() {
        assertEquals(city1, traderOne.getCity());
    }

    @Test
    void setCity() {
        assertEquals(city1, traderOne.getCity());
        traderOne.setCity(city2);
        assertEquals(city2, traderOne.getCity());
    }

    @Test
    void testHashCode() {
        assertTrue(traderOne.hashCode() == traderOneDublet.hashCode());
        assertFalse(traderOne.hashCode() == traderTwo.hashCode());

        traderOneDublet.setCity(city2);
        assertFalse(traderOne.hashCode() == traderOneDublet.hashCode());
    }

    @Test
    void testEquals() {
        assertTrue(traderOne.equals(traderOneDublet));
        assertFalse(traderOne.equals(traderTwo));

        traderOneDublet.setCity(city2);
        assertFalse(traderOne.equals(traderOneDublet));
    }

    @Test
    void testToString() {
        assertEquals(traderOneDublet.toString(), traderOne.toString());
        assertNotEquals(traderTwo.toString(), traderOne.toString());

        traderOneDublet.setCity(city2);
        assertNotEquals(traderOneDublet.toString(), traderOne.toString());
   }
}