//2024.10.02 zip
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

public class MyLinkedListMain {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        System.out.println("\n   /** Interface: Collection **/");
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

        System.out.println("\n    /** interface: List **/\n");
        System.out.println("list.add(1, 50); list.add(1, 40); list.add(1, 30); list.add(0, 10); list.add(0, 0);");
        list.add(1, 50);
        list.add(1, 40);
        list.add(1, 30);
        list.add(0, 10);
        list.add(0, 0);
        System.out.println("list: " + list + ", size: " + list.size());

        System.out.printf("%nlist.get(1): %d, list.get(2): %d, list.get(3): %d%n"
                , list.get(1), list.get(2), list.get(3));
        System.out.println("list.set(1, 1000), list.set(2, 2000), list.set(3, 3000)");
        list.set(1, 1000); list.set(2, 2000); list.set(3, 3000);
        System.out.println("list: " + list + ", size: " + list.size());



        System.out.println("\nlist.remove(4)x5; list.remove(0);");
        for(int i = 0; i < 5; i++) list.remove(4);
        list.remove(0);
        System.out.println("list: " + list + ", size: " + list.size());

        list.add(1,99);
        list.add(3,99);
        list.add(5,99);
        list.add(6,999);
        System.out.println("list: " + list + ", size: " + list.size());

        System.out.printf("list.indexOf(99): %d, list.lastIndexOf(99): %d%n",list.indexOf(99), list.lastIndexOf(99));

        System.out.printf("%nlist.subList(0,2): %s, list.subList(2,5): %s, list.subList(5,7): %s%n", list.subList(0,2)
                , list.subList(2,5)
                , list.subList(5,7));
    }
}
