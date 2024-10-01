//2024/09/30
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTestCollection {
    private MyArrayList<Integer> myList;
    private final int[] ARRAY_TO_TEST = new int[]{1,2,4,5,7,8,10,11,13,14,16,17,19,20,21};
    private final List<Integer> LIST_TO_TEST = Arrays.stream(ARRAY_TO_TEST)
            .boxed()
            .toList();


    @BeforeEach
    void setUp() {
        myList = new MyArrayList<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void size() {
        assertEquals(myList.size(),0);
        myList.add(0);
        assertEquals(myList.size(),1);
    }

    @Test
    void isEmpty() {
        assertTrue(myList.isEmpty());
        myList.add(0);
        assertFalse(myList.isEmpty());
    }

    @Test
    void indexOf() {
        assertEquals(myList.indexOf(1000),-1);
        myList.add(1000);
        assertEquals(myList.indexOf(1000),0);
    }

    @Test
    void contains() {
        assertFalse(myList.contains(Integer.valueOf(1000)));
        myList.add(1000);
        assertTrue(myList.contains(Integer.valueOf(1000)));
    }

    @Test
    void iterator() {
        Iterator<Integer> iterator1 = myList.iterator();
        assertFalse(iterator1.hasNext());

        myList.add(1234);
        Iterator<Integer> iterator2 = myList.iterator();
        assertTrue(iterator2.hasNext());
        assertEquals(iterator2.next(), 1234);
    }

    @Test
    void toArrayAsObject() {
        assertTrue(myList.addAll(LIST_TO_TEST));
        assertEquals(myList.size(), LIST_TO_TEST.size());
        Object[] objectsArray = myList.toArray();
        Object[] testArray = LIST_TO_TEST.toArray();

        assertEquals(LIST_TO_TEST.size(), objectsArray.length);
        assertArrayEquals(testArray, objectsArray);
    }

    @Test
    void toArrayAsInteger() {
        assertTrue(myList.addAll(LIST_TO_TEST));
        assertEquals(myList.size(), LIST_TO_TEST.size());
        Integer[] integersArray = myList.toArray(new Integer[0]);
        Integer[] testArray = LIST_TO_TEST.toArray(new Integer[0]);

        assertEquals(LIST_TO_TEST.size(), integersArray.length);
        assertArrayEquals(testArray, integersArray);
    }


    @Test
    void add() {
        myList.add(1234);
        Iterator<Integer> iterator = myList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), 1234);
    }

    @Test
    void removeByIndex() {
        assertEquals(myList.indexOf(1000),-1);
        myList.add(1000);
        assertEquals(myList.indexOf(1000),0);
        myList.remove(0);
        assertEquals(myList.indexOf(1000),-1);
    }

    @Test
    void removeByObject() {
        assertEquals(myList.indexOf(1111),-1);
        myList.add(1111);
        assertEquals(myList.indexOf(1111),0);
        myList.remove(Integer.valueOf(1111));
        assertEquals(myList.indexOf(1111),-1);
    }

    @Test
    void containsAll() {
        myList.add(1000);
        assertFalse(myList.containsAll(LIST_TO_TEST));
        myList.addAll(LIST_TO_TEST);
        assertTrue(myList.containsAll(LIST_TO_TEST));
    }

    @Test
    void addAll() {
        assertTrue(myList.addAll(LIST_TO_TEST));
        assertEquals(myList.size(), LIST_TO_TEST.size());
        Iterator<Integer> myListIterator = myList.iterator();
        Iterator<Integer> testListIterator = LIST_TO_TEST.iterator();
        while (myListIterator.hasNext()){
            assertEquals(myListIterator.next(), testListIterator.next());
        }
    }

    @Test
    void removeAll() {
        assertTrue(myList.addAll(LIST_TO_TEST));
        assertEquals(LIST_TO_TEST.size(), myList.size());
        assertTrue(myList.removeAll(LIST_TO_TEST));
        assertEquals(myList.size(), 0);

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.addAll(LIST_TO_TEST);
        assertTrue(myList.removeAll(LIST_TO_TEST));
        assertEquals(1, myList.size());

        Iterator myListIterator = myList.iterator();
        assertEquals(myListIterator.next(), 3);
    }

    @Test
    void retainAll() {
        assertFalse(myList.retainAll(LIST_TO_TEST));
        myList.add(1);
        myList.add(2);
        myList.add(3);
        assertEquals(myList.size(), 3);
        assertTrue(myList.retainAll(LIST_TO_TEST));
        assertEquals(myList.size(), 2);

        Iterator myListIterator = myList.iterator();
        assertEquals(myListIterator.next(), 1);
        assertEquals(myListIterator.next(), 2);
    }

    @Test
    void clear() {
        myList.add(1);
        myList.add(2);
        myList.add(3);
        assertEquals(myList.size(), 3);
        myList.clear();
        assertEquals(myList.size(), 0);
    }

    @Test
    void isNeedToExpand() {
        MyArrayListWrapper<Integer> myListWrapper = new MyArrayListWrapper();
        boolean flagIsNeedToExpand = false;

        //заполняем по элементно и проверяем, достигли ли мы лимита
        for(int count = 0; count < 1000; count++){
            if(myListWrapper.isNeedToExpand()){
                flagIsNeedToExpand = true;
                //System.out.println(count);
                break;
            }
            myListWrapper.myList.add(count);
        }
        assertTrue(flagIsNeedToExpand);
    }

    @Test
    void expand() {
        MyArrayListWrapper<Integer> myListWrapper = new MyArrayListWrapper();
        int beginLength =  myListWrapper.length();
        assertTrue(beginLength > 0);
        myListWrapper.myList.addAll(LIST_TO_TEST);
        myListWrapper.myList.addAll(LIST_TO_TEST);
        myListWrapper.myList.addAll(LIST_TO_TEST);
        myListWrapper.myList.addAll(LIST_TO_TEST);
        myListWrapper.myList.addAll(LIST_TO_TEST);
        //System.out.println(myListWrapper.length());
        //System.out.println(myListWrapper.myList.size());
        assertTrue(myListWrapper.length() > (LIST_TO_TEST.size() * 5));
    }
}