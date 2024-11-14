//2024.11.13

import java.util.Comparator;
/**
 * Этот класс представляет собой утилитарный для организации бытсрой сортировки
 * из моего класса MyArrayList.
 *
 * Методы НЕ статические!
 *
 * <p>Пример использования:</p>
 * <pre>
 *     MyQuickSort myQuickSort = new MyQuickSort();
 *     myQuickSort.sort(arrayToSort);
 * </pre>
 *
 * @version 1.0
 */
public class MyQuickSort {
    Comparator comparator;

    /**
     * Сортировка массива.
     *
     * @param array - массив для сортировки, к сортировке принимается весь массив полностью
     * @return void, манипуляция происходит над переданным массивом
     * @throws ClassCastException если элементы не имплиментируют Comparable
     */
    public <E> void sort(E[] array){
        sort(array, array.length);

    }


    /**
     * Сортировка массива.
     *
     * @param array - массив для сортировки
     * @param size - количество элементов, от начала массива которые должны быть отсортированны
     * @return void, манипуляция происходит над переданным массивом
     * @throws ClassCastException если элементы не имплиментируют Comparable
     */
    public <E> void sort(E[] array, int size){
        sort(array, (E x, E y) -> ((Comparable) x).compareTo(y));
    }

    /**
     * Сортировка массива.
     *
     * @param array - массив для сортировки, к сортировке принимается весь массив полностью
     * @param comparator - переденнаый для сортировки
     * @return void, манипуляция происходит над переданным массивом
     */
    public <E> void sort(E[] array, Comparator<? extends E> comparator){
        sort(array, array.length, comparator);
    }

    /**
     * Сортировка массива.
     *
     * @param array - массив для сортировки
     * @param size - количество элементов, от начала массива которые должны быть отсортированны
     * @param comparator - переденнаый для сортировки
     * @return void, манипуляция происходит над переданным массивом
     */
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