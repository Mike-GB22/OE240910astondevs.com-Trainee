//2024.10.01
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class MyArrayListTestList  {
    private MyArrayList<Integer> myList;
    private final int[] ARRAY_TO_TEST = new int[]{1,2,4,5,7,8,10,11,13,14,16,17,19,20,21};
    private final List<Integer> LIST_TO_TEST = Arrays.stream(ARRAY_TO_TEST)
            .boxed()
            .toList();

    @BeforeEach
    void setUp() {
        myList = new MyArrayList<>();
    }

    @Test
    void get() {
        myList.addAll(LIST_TO_TEST);
        assertEquals(ARRAY_TO_TEST[0], myList.get(0));
        assertEquals(ARRAY_TO_TEST[2], myList.get(2));
        assertEquals(ARRAY_TO_TEST[3], myList.get(3));
        assertEquals(ARRAY_TO_TEST[4], myList.get(4));
        assertEquals(ARRAY_TO_TEST[7], myList.get(7));
    }

    @Test
    void set() {
        myList.addAll(LIST_TO_TEST);
        myList.set(0, 2);
        assertEquals(2, myList.get(0));
        myList.set(2, 4);
        assertEquals(4, myList.get(2));
        myList.set(3, 6);
        assertEquals(6, myList.get(3));
        myList.set(4, 8);
        assertEquals(8, myList.get(4));
        myList.set(7, 14);
        assertEquals(14, myList.get(7));
    }

    @Test
    void addByIndex() {
        myList.addAll(LIST_TO_TEST);
        myList.add(0, 2);
        assertEquals(2, myList.get(0));
        myList.add(2, 4);
        assertEquals(4, myList.get(2));
        myList.add(3, 6);
        assertEquals(6, myList.get(3));
        myList.add(4, 8);
        assertEquals(8, myList.get(4));
        myList.add(7, 14);
        assertEquals(14, myList.get(7));
    }

    @Test
     void addAllByIndex() {
        myList.addAll(LIST_TO_TEST);
        assertEquals(LIST_TO_TEST.size(), myList.size());

        myList.addAll(5, LIST_TO_TEST);
        assertEquals(LIST_TO_TEST.size()*2, myList.size());

        assertEquals(ARRAY_TO_TEST[0], myList.get(0+5));
        assertEquals(ARRAY_TO_TEST[2], myList.get(2+5));
        assertEquals(ARRAY_TO_TEST[3], myList.get(3+5));
        assertEquals(ARRAY_TO_TEST[4], myList.get(4+5));
        assertEquals(ARRAY_TO_TEST[7], myList.get(7+5));
    }

    @Test
    void lastIndexOf() {
        myList.addAll(LIST_TO_TEST);
        assertEquals(7, myList.lastIndexOf(LIST_TO_TEST.get(7)));
        assertEquals(9, myList.lastIndexOf(LIST_TO_TEST.get(9)));
        assertEquals(11, myList.lastIndexOf(LIST_TO_TEST.get(11)));
        assertEquals(15, myList.lastIndexOf(LIST_TO_TEST.get(15)));
        myList.add(LIST_TO_TEST.get(7));
        assertEquals(myList.size(), myList.lastIndexOf(LIST_TO_TEST.get(7)));
    }

    @Test
    void listIterator() {
    }

    @Test
    void listIteratorByIndex() {
        //listIterator(int index) {
    }

    @Test
    void subList() {
        //subList(int fromIndex, int toIndex) {
        myList.addAll(LIST_TO_TEST);
        MyArrayList<Integer> subList = (MyArrayList<Integer>) myList.subList(5, myList.size());
        assertEquals(LIST_TO_TEST.size() - 5, myList.size());

        assertEquals(ARRAY_TO_TEST[0+5], subList.get(0));
        assertEquals(ARRAY_TO_TEST[2+5], subList.get(2));
        assertEquals(ARRAY_TO_TEST[3+5], subList.get(3));
        assertEquals(ARRAY_TO_TEST[4+5], subList.get(4));
        assertEquals(ARRAY_TO_TEST[7+5], subList.get(7));
    }
}
