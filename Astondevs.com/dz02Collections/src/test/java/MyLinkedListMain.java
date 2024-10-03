//2024.10.02 zip
import java.time.LocalDateTime;
import java.util.*;

public class MyLinkedListMain {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(2));
        list.add(Integer.valueOf(3));
        list.add(Integer.valueOf(4));
        list.add(Integer.valueOf(5));
        System.out.println(LocalDateTime.now());
        System.out.println("list.size(): " + list.size());
        System.out.println("list.toString: " + list);

        list.remove(Integer.valueOf(1));
        list.remove(Integer.valueOf(3));
        list.remove(Integer.valueOf(2));
        System.out.println("list.remove(1, 3, 2): " + list);

        list.addAll(Arrays.asList(10, 20, 30, 40));
        System.out.println("list.addAll(newList: 10, 20, 30, 40): " + list);

        list.removeAll(Arrays.asList(20, 30));
        System.out.println("list.addAll(newList: 20, 30): " + list);

        Iterator<Integer> myIterator = list.iterator();
            while (myIterator.hasNext()){
                myIterator.next();
            }
        myIterator.remove();
        System.out.println("list.iterator().remove() lastElement: " + list);

        MyLinkedList<Integer> listToRemove = new MyLinkedList<>(Arrays.asList(list.toArray(new Integer[0])));
        listToRemove.addAll(Arrays.asList(100,200,300,400,500));
        System.out.println("\nlistToRemove: " + listToRemove);

        list.addAll(Arrays.asList(10,20,30,40,50,60));
        System.out.println("list: " + list);
        list.removeAll(listToRemove);
        System.out.println("list.removeAll(listToRemove): " + list);

        MyLinkedList<Integer> listToRetain = new MyLinkedList<>();
        listToRetain.addAll(Arrays.asList(20, 50,100,200,300,400,500));
        System.out.println("\nlistToRetain: " + listToRetain);

        list.addAll(Arrays.asList(199,200,201,202,203,500,501));
        System.out.println("list: " + list);
        list.retainAll(listToRetain);
        System.out.println("list.retainAll(listToRetain): " + list);


    }
}
