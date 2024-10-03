//2024.10.02 zip
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTestCollection {
    private MyLinkedList<Integer> myList;
    private final int[] ARRAY_TO_TEST = new int[]{1,2,4,5,7,8,10,11,13,14,16,17,19,20,21};
    private final List<Integer> LIST_TO_TEST = Arrays.stream(ARRAY_TO_TEST).boxed().toList();
    Integer value1 = 10000;
    Integer value2 = 20000;
    Integer value3 = 30000;
    Integer value4 = 40000;
    Integer value5 = 50000;
    Integer value6 = 60000;
    Integer value7 = 70000;
    List<Integer> listOfValue1and2and3 = Arrays.asList(value1, value2, value3);
    List<Integer> listOfValue4and5 = Arrays.asList(value4, value5);
    List<Integer> listOfValue6and7 = Arrays.asList(value6, value7);
    @BeforeEach
    void setUp() {
        myList = new MyLinkedList<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void size() {
        assertEquals(0,myList.size());

        myList.add(value1);
        assertEquals(1,myList.size());

        myList.add(value1);
        assertEquals(2,myList.size());
    }

    @Test
    void isEmpty() {
        assertTrue(myList.isEmpty());

        myList.add(value1);
        assertFalse(myList.isEmpty());
    }

    @Test
    void contains() {
        myList.addAll(LIST_TO_TEST);
        assertTrue(myList.contains(LIST_TO_TEST.get(0)));
        assertTrue(myList.contains(LIST_TO_TEST.get(myList.size()/2)));
        assertTrue(myList.contains(LIST_TO_TEST.get(myList.size()-1)));
        assertFalse(myList.contains(Integer.MAX_VALUE));
        assertFalse(myList.contains(Integer.MIN_VALUE));
    }

    @Test
    void iterator() {
        myList.add(value1);
        Iterator<Integer> myIterator = myList.iterator();
        assertEquals(value1, myIterator.next());
    }

    @Test
    void iteratorRemove() {
        myList.addAll(LIST_TO_TEST);
        int sizeBegin = myList.size();

        //remove() without next()
        Iterator<Integer> myIterator = myList.iterator();
        assertThrows(IllegalStateException.class, () -> {
            myIterator.remove();
        });

        //Delete 1 element
        myIterator.next();
        myIterator.remove();
        assertEquals(sizeBegin - 1, myList.size());

        //Delete all elements
        while(myIterator.hasNext()) {
            myIterator.next();
            myIterator.remove();
        }
        assertEquals(0, myList.size());

        //There is 0 elements
        assertThrows(IllegalStateException.class, () -> {
            myIterator.remove();
        });
    }

    @Test
    void add() {
        size();
    }

    @Test
    void remove() {
        myList.add(value1);
        myList.add(value2);
        myList.add(value3);
        assertEquals(3,myList.size());

        myList.remove(value2);
        assertEquals(2,myList.size());

        myList.remove(value3);
        assertEquals(1,myList.size());

        myList.remove(value1);
        assertEquals(0,myList.size());
    }

    @Test
    void addAll() {
        assertEquals(0,myList.size());

        myList.addAll(listOfValue1and2and3);
        assertEquals(listOfValue1and2and3.size(),myList.size());

        myList.addAll(listOfValue1and2and3);
        assertEquals(listOfValue1and2and3.size() * 2,myList.size());
    }

    @Test
    void clear() {
        myList.add(value1);
        assertEquals(1,myList.size());

        myList.clear();
        assertEquals(0,myList.size());

    }

    @Test
    void retainAll() {
        myList.addAll(listOfValue4and5);
        myList.addAll(listOfValue1and2and3);
        assertEquals(listOfValue1and2and3.size() + listOfValue4and5.size(), myList.size());

        myList.retainAll(listOfValue6and7);
        assertEquals(0, myList.size());

        myList.add(value4);
        myList.addAll(listOfValue1and2and3);
        myList.add(value5);
        myList.retainAll(listOfValue4and5);
        assertEquals(listOfValue4and5.size(), myList.size());
    }

    @Test
    void removeAll() {
        myList.add(value4);
        myList.addAll(listOfValue1and2and3);
        myList.add(value5);
        assertEquals(listOfValue1and2and3.size() + 2, myList.size());

        myList.removeAll(listOfValue4and5);
        assertEquals(listOfValue1and2and3.size(), myList.size());

        myList.removeAll(listOfValue1and2and3);
        assertEquals(0, myList.size());
    }

    @Test
    void containsAll() {
        myList.add(value4);
        myList.add(value5);
        assertFalse(myList.containsAll(listOfValue1and2and3));

        myList.add(value3);
        assertFalse(myList.containsAll(listOfValue1and2and3));

        myList.add(value2);
        assertFalse(myList.containsAll(listOfValue1and2and3));

        myList.add(value1);
        assertTrue(myList.containsAll(listOfValue1and2and3));
    }

    @Test
    void toArrayAsObject() {
        myList.addAll(Arrays.stream(ARRAY_TO_TEST).boxed().toList());
        Object[] arrayFromMyList = myList.toArray();
        Object[] arrayEtalon = Arrays.stream(ARRAY_TO_TEST).boxed().toArray();

        assertEquals(arrayEtalon.length, arrayFromMyList.length);
        assertArrayEquals(arrayEtalon, arrayFromMyList);
    }

    @Test
    void toArrayAsEType() {
        myList.addAll(Arrays.stream(ARRAY_TO_TEST).boxed().toList());
        Integer[] arrayFromMyList = myList.toArray(new Integer[0]);
        Integer[] arrayEtalon = Arrays.stream(ARRAY_TO_TEST).boxed().toArray(size -> new Integer[size]);

        assertEquals(arrayEtalon.length, arrayFromMyList.length);
        assertArrayEquals(arrayEtalon, arrayFromMyList);
    }
}