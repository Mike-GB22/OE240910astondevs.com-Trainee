//2024.10.05 zip
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    Transaction transactionOne;
    Transaction transactionOneDublet;
    Transaction transactionTwo;
    String traderName1 = "Ivan";
    String traderName2 = "Petr";
    String traderCity1 = "Moskau";
    String traderCity2 = "Rostov";
    Trader traderOne = new Trader(traderName1, traderCity1);
    Trader traderTwo = new Trader(traderName2, traderCity2);

    int year1 = 2023;
    int year2 = 2024;

    int value1 = 1000;
    int value2 = 9999;
    @BeforeEach
    void setUp() {
        transactionOne = new Transaction(traderOne, year1, value1);
        transactionOneDublet = new Transaction(traderOne, year1, value1);
        transactionTwo = new Transaction(traderTwo, year2, value2);
    }

    @Test
    void constructor() {
        assertEquals(Transaction.class, transactionOne.getClass());
        assertEquals(traderName1, transactionOne.getTrader());
        assertNotEquals(traderName2, transactionOne.getTrader());

        assertEquals(year1, transactionOne.getYear());
        assertNotEquals(year2, transactionOne.getYear());

        assertEquals(value1, transactionOne.getValue());
        assertNotEquals(value2, transactionOne.getValue());
    }

    @Test
    void getTrader() {
        assertEquals(traderName1, transactionOne.getTrader());
    }

    @Test
    void getYear() {
        assertEquals(year1, transactionOne.getYear());
    }

    @Test
    void getValue() {
        assertEquals(value1, transactionOne.getValue());
    }

    @Test
    void testHashCode() {
        assertTrue(transactionOneDublet.hashCode() == transactionOne.hashCode());
        assertFalse(transactionTwo.hashCode() == transactionOne.hashCode());

        transactionOneDublet = new Transaction(traderOne, year2, value1);
        assertFalse(transactionOneDublet.hashCode() == transactionOne.hashCode());
        assertFalse(transactionOneDublet.hashCode() == transactionTwo.hashCode());
    }

    @Test
    void testEquals() {
        assertTrue(transactionOneDublet.equals(transactionOne));
        assertFalse(transactionTwo.equals(transactionOne));

        transactionOneDublet = new Transaction(traderOne, year2, value1);
        assertFalse(transactionOneDublet.equals(transactionOne));
        assertFalse(transactionOneDublet.equals(transactionTwo));
    }

    @Test
    void testToString() {
    }
}