import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MyArrayListMain_QuickSort {
    public static void main(String[] args) {
        final int COUNT_OF_ELEMENTS = 1000;

        List<List<Integer>> listOfTasks = new MyArrayList<>();

        List<Integer> list1 = new MyArrayList<>();
        for(int i = 0; i < COUNT_OF_ELEMENTS; i++)
            list1.add((i % 2 == 0 ? i : COUNT_OF_ELEMENTS - i));
        listOfTasks.add(list1);

        Random rnd = new Random();
        List<Integer> list2 = new MyArrayList<>();
        for(int i = 0; i < COUNT_OF_ELEMENTS; i++)
            list2.add(rnd.nextInt());
        listOfTasks.add(list2);

        List<Integer> list3 = new MyArrayList<>();
        for(int i = 0; i < COUNT_OF_ELEMENTS; i++)
            list3.add(i % 10);
        listOfTasks.add(list3);

        doSortAndPrintTasks(listOfTasks);
    }

    static public void doSortAndPrintTasks(List<List<Integer>> listOfTasks){
        final int COUNT_OF_TASKS = listOfTasks.size();
        int countOfThisTask = 0;
        for (List list : listOfTasks){
            System.out.println("------------------------------------------------------------");
            System.out.printf("Task: %d from %d%n", ++countOfThisTask, COUNT_OF_TASKS);
            System.out.println("BEFORE: " + list);
            list.sort(Comparator.naturalOrder());
            System.out.println("\nAFTER : " + list);
            System.out.println("\n\n\n\n");
        }
    }
}
