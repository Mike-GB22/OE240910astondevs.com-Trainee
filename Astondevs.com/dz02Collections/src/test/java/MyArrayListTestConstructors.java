//2024/09/30
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTestConstructors {
    private MyArrayList<Integer> myList;
    private final int[] ARRAY_TO_TEST = new int[]{1,2,4,5,7,8,10,11,13,14,16,17,19,20,21};
    private final List<Integer> LIST_TO_TEST = Arrays.stream(ARRAY_TO_TEST)
            .boxed()
            .toList();

    @Test
    void emptyConstructor(){
        myList = new MyArrayList<Integer>();
        assertNotNull(myList);
        assertEquals(0, myList.size());

    }
    @Test
     void listInConstructor(){
        myList = new MyArrayList<Integer>(LIST_TO_TEST);
        assertNotNull(myList);
        assertEquals(LIST_TO_TEST.size(), myList.size());
    }
}
