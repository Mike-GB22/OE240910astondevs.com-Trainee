//2024.11.13

import java.util.Comparator;
/**
 * ���� ����� ������������ ����� ����������� ��� ����������� ������� ����������
 * �� ����� ������ MyArrayList.
 *
 * ������ �� �����������!
 *
 * <p>������ �������������:</p>
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
     * ���������� �������.
     *
     * @param array - ������ ��� ����������, � ���������� ����������� ���� ������ ���������
     * @return void, ����������� ���������� ��� ���������� ��������
     * @throws ClassCastException ���� �������� �� �������������� Comparable
     */
    public <E> void sort(E[] array){
        sort(array, array.length);

    }


    /**
     * ���������� �������.
     *
     * @param array - ������ ��� ����������
     * @param size - ���������� ���������, �� ������ ������� ������� ������ ���� ��������������
     * @return void, ����������� ���������� ��� ���������� ��������
     * @throws ClassCastException ���� �������� �� �������������� Comparable
     */
    public <E> void sort(E[] array, int size){
        sort(array, (E x, E y) -> ((Comparable) x).compareTo(y));
    }

    /**
     * ���������� �������.
     *
     * @param array - ������ ��� ����������, � ���������� ����������� ���� ������ ���������
     * @param comparator - ����������� ��� ����������
     * @return void, ����������� ���������� ��� ���������� ��������
     */
    public <E> void sort(E[] array, Comparator<? extends E> comparator){
        sort(array, array.length, comparator);
    }

    /**
     * ���������� �������.
     *
     * @param array - ������ ��� ����������
     * @param size - ���������� ���������, �� ������ ������� ������� ������ ���� ��������������
     * @param comparator - ����������� ��� ����������
     * @return void, ����������� ���������� ��� ���������� ��������
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