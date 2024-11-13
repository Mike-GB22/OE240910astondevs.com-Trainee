import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MyQuickSortMain {

    public static void main (String[] args){
        List<Map.Entry<Object[], Comparator>> listOfTasks= new ArrayList<>();

        Integer[] array1 = {10,1,9,2,8,3,7,4,6,5};
        Comparator<Integer> comparator1 = ((x, y) -> x-y);
        listOfTasks.add(new AbstractMap.SimpleEntry(
                array1, comparator1
        ));

        listOfTasks.add(new AbstractMap.SimpleEntry<>(
                new Integer[]{-10,-1,-9,-2,-8,-3,-7,-4,-6,-5}, comparator1
        ));

        doSortAndPrintOfTasks(listOfTasks);
    }

    public static void doSortAndPrintOfTasks(List<Map.Entry<Object[], Comparator>> listOfTasks) {
        int countOfTasks = 0;
        for (Map.Entry<Object[], Comparator> arrayAndComparator : listOfTasks) {
            Object[] array = arrayAndComparator.getKey();
            Comparator comparator = arrayAndComparator.getValue();

            System.out.println("Task: " + ++countOfTasks);
            System.out.println("Before: " + Arrays.toString(array));
            new MyQuickSort().sort(array, comparator);

            System.out.println("After : " + Arrays.toString(array));
        }
    }
}
