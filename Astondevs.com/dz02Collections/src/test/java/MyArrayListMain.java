//2024.10.01 zip
import java.util.List;

public class MyArrayListMain {
    public static void main(String[] args) {
        System.out.println("¬ставка в центр списка еще одного списка: addByIndex(index, element), addAllByIndex(index, Collection extends E");
        Integer[] array1 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] array2 = new Integer[]{100, 200, 300, 400, 500, 600, 700, 800};
        List<Integer> list1 = List.of(array1);
        List<Integer> list2 = List.of(array2);

        List<Integer> list = new MyArrayList<>(list1);
        System.out.println(list);
        list.add(5, Integer.valueOf(1000));
        System.out.println(list);
        System.out.println(list2);
        list.addAll(5, list2);
        System.out.println(list);

        System.out.println();
        list = new MyArrayList<>();
        list.addAll(0, list1);
        System.out.println(list);
        list.addAll(list.size(), list2);
        System.out.println(list);

        //
        System.out.println();
        list.set(0, 1001);
        list.set(1, 1002);
        list.set(2, 1003);
        System.out.printf("get 0: %d, 1: %d, 2: %d%n", list.get(0), list.get(1), list.get(2));
        System.out.println(list);

    }
}
