//2024.10.03 zip
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class MyLinkedListTestList {
    private List<Integer> myList;
    private final int[] ARRAY_TO_TEST = new int[]{1,2,4,5,7,8,10,11,13,14,16,17,19,20,21};
    private final List<Integer> LIST_TO_TEST = Arrays.stream(ARRAY_TO_TEST).boxed().toList();
    private final Integer value1 = 10000;
    private final Integer value2 = 20000;
    private final Integer value3 = 30000;
    private final Integer value4 = 40000;

    @BeforeEach
    void setUp(){
         myList = new MyLinkedList<>();
    }
    @Test
    void getByIndex(){
        assertEquals(0, myList.size());

        myList.add(value1);
        myList.add(value2);
        myList.add(value3);
        assertEquals(3, myList.size());
        assertEquals(value1, myList.get(0));
        assertEquals(value2, myList.get(1));
        assertEquals(value3, myList.get(2));
    }

    @Test
    void setByIndex() {
        assertEquals(0, myList.size());

        myList.add(value3);
        myList.add(value3);
        myList.add(value1);
        assertEquals(3, myList.size());
        myList.set(0, value1);
        myList.set(1, value2);
        myList.set(2, value3);
        assertEquals(value1, myList.get(0));
        assertEquals(value2, myList.get(1));
        assertEquals(value3, myList.get(2));
    }

    @Test
    void addByIndex() {
        assertEquals(0, myList.size());

        myList.add(0,value1);
        assertEquals(1, myList.size());
        assertEquals(value1, myList.get(0));

        myList.add(1,value2);
        assertEquals(2, myList.size());
        assertEquals(value2, myList.get(1));

        myList.add(0,value3);
        assertEquals(3, myList.size());
        assertEquals(value3, myList.get(0));
    }

    @Test
    void removeByIndex() {
        assertEquals(0, myList.size());

        myList.add(value1);
        myList.add(value2);
        myList.add(value3);
        assertEquals(3, myList.size());

        myList.remove(0);
        assertEquals(2, myList.size());
        assertEquals(value2, myList.get(0));
        assertEquals(value3, myList.get(1));

        myList.remove(1);
        assertEquals(1, myList.size());
        assertEquals(value2, myList.get(0));
    }

    @Test
    void indexOf() {
        assertEquals(0, myList.size());

        myList.add(value1);
        myList.add(value2);
        myList.add(value1);
        myList.add(value3);
        myList.add(value1);
        myList.add(value4);
        myList.add(value1);
        assertEquals(7, myList.size());
        assertEquals(0, myList.indexOf(value1));

        myList.remove(0);
        assertEquals(1, myList.indexOf(value1));

        myList.remove(1);
        assertEquals(2, myList.indexOf(value1));
    }

    @Test
    void lastIndexOf() {
        assertEquals(0, myList.size());

        myList.add(value1);
        myList.add(value2);
        myList.add(value1);
        myList.add(value3);
        myList.add(value1);
        myList.add(value4);
        myList.add(value1);
        assertEquals(7, myList.size());
        assertEquals(6, myList.lastIndexOf(value1));

        myList.remove(6);
        assertEquals(4, myList.lastIndexOf(value1));

        myList.remove(4);
        assertEquals(2, myList.lastIndexOf(value1));
    }

    @Test //TODO listIterator
    void listIterator() {
    }

    @Test //TODO listIterator
    void listIteratorByIndex() {
    }

    @Test
    void subList() {
        assertEquals(0, myList.size());

        myList = new MyLinkedList<>(LIST_TO_TEST);
        int sourceSize = LIST_TO_TEST.size();
        assertEquals(sourceSize, myList.size());

        List<Integer> sub;
        sub = myList.subList(0,2);
        assertEquals(2, sub.size());
        assertEquals(LIST_TO_TEST.get(0), sub.get(0));
        assertEquals(LIST_TO_TEST.get(1), sub.get(1));

        sub = myList.subList(sourceSize-2,sourceSize);
        assertEquals(2, sub.size());
        assertEquals(LIST_TO_TEST.get(sourceSize - 2), sub.get(0));
        assertEquals(LIST_TO_TEST.get(sourceSize - 1), sub.get(1));

        sub = myList.subList(sourceSize/2 - 2,sourceSize/2 + 2);
        assertEquals(4, sub.size());
        assertEquals(LIST_TO_TEST.get(sourceSize/2 - 2), sub.get(0));
        assertEquals(LIST_TO_TEST.get(sourceSize/2 - 1), sub.get(1));
    }
}
