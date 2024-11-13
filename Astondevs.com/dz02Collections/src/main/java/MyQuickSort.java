//2024.11.13

import java.util.Arrays;
import java.util.Comparator;

public class MyQuickSort {
    Comparator comparator;

    public <E extends Comparable> void sort(E[] array){
        sort(array, array.length);
    }

    public <E extends Comparable> void sort(E[] array, int size){
        sort(array, (E x, E y) -> x.compareTo(y));
    }

    public <E> void sort(E[] array, Comparator<? extends E> comparator){
        sort(array, array.length, comparator);
    }

    public <E> void sort(E[] array, int size, Comparator<? extends E> comparator){
        if(array.length < 2) return;
        this.comparator = comparator;

        sortOnlyPartOfArray(array, 0, size);
    }
    private <E> void sortOnlyPartOfArray(E[] array, int from, int to){
        if(to - from < 2) return;
        int pivotIndex = to - 1;
        int wallIndex = from;
        for (int i = from; i < pivotIndex; i++){
            if (comparator.compare(array[i], array[pivotIndex]) < 0){
                //if(wallIndex < i){
                    E tmp = array[wallIndex];
                    array[wallIndex] = array[i];
                    array[i] = tmp;
                    wallIndex++;
                //}
            }
        }
        if (wallIndex < pivotIndex){
            E tmp = array[wallIndex];
            array[wallIndex] = array[pivotIndex];
            array[pivotIndex] = tmp;
        }

        sortOnlyPartOfArray(array, from, wallIndex);
        sortOnlyPartOfArray(array, wallIndex + 1, to);
    }
}
