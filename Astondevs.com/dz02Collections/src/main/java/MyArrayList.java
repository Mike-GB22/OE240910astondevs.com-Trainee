//2024.09.30 zip
import java.util.*;

public class MyArrayList <E> implements Collection<E>, List<E> {
    private int beginSize = 10;
    private int size = 0;
    private Object[] listArray;
    private final double COEFFICIENT = 0.8D;
    private final double MULTIPLIER = 1.5D;

    public MyArrayList(){
        listArray = new Object[beginSize];
    }

    public MyArrayList(Collection<? extends E> c){
        listArray = new Object[(int)(c.size() * MULTIPLIER)];
        this.addAll(c);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size < 1) return true;
        return false;
    }

    public int indexOf(Object o){
        for(int count = 0; count < size; count++){
            if(listArray[count].equals(o)) return count;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int index = size - 1; index >= 0; index--){
            if(listArray[index].equals(o)) return index;
        }
        return -1;
    }

    @Override //May TODO MyArrayLink listIterator
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override //May TODO MyArrayLink listIterator
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        checkToBoundsException(fromIndex);
        checkToBoundsExceptionForInsert(toIndex);
        List<E> newList = new MyArrayList<>();
        for(int index = fromIndex; index < toIndex; index++){
            newList.add((E) listArray[index]);
        }
        return newList;
    }

    @Override
    public boolean contains(Object o) {
        if(indexOf(o)>=0) return true;
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(listArray, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if(a.length < size){
            return (T[]) Arrays.copyOf(listArray, size, a.getClass());
        } else {
            System.arraycopy(listArray,0,a,0,size);
            if(a.length > size){ //Пишут над для спецификации
                a[size] = null;
            }
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        if(isNeedToExpand()) expand();
        listArray[size] = e;
        size++;
        return true;
    }


    public E remove(int index) {
        checkToBoundsException(index);
        if(size > listArray.length) return null;
        Object objectToReturn = listArray[index];
        for(; index < size - 1; index++){
            listArray[index] = listArray[index + 1];
        }
        size--;
        return (E) objectToReturn;
    }

    @Override //TODO remove(null);
    public boolean remove(Object o) {
        int index = indexOf(o);
        if(index < 0) return false;
        if(remove(index).equals(o)) return true;
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element: c) {
            if(!contains(element)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if(!c.iterator().hasNext()) return false;
        for (Object element: c) {
            add((E) element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkToBoundsExceptionForInsert(index);
        if(!c.iterator().hasNext()) return false;
        if(isNeedToExpand()) expand();
        Object[] listArrayToAdd = c.toArray();
        int sizeOfArrayToAdd = listArrayToAdd.length;

        Object[] newListArray = new Object[listArray.length + sizeOfArrayToAdd];
        if(index > 0){
            System.arraycopy(listArray, 0, newListArray, 0, index);
        }
        if(index < size){
            System.arraycopy(listArray, index
                    , newListArray, index + sizeOfArrayToAdd, size - index);
        }
        System.arraycopy(listArrayToAdd,0,newListArray,index, sizeOfArrayToAdd);

        listArray = newListArray;
        size += listArrayToAdd.length;

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = false;
        for (Object element: c) {
            while (remove(element)){
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = false;
        int[] indexElementsToDelete = new int[size];
        int count = 0;
        //Находим что удалить надо, запоминаем индексы
        for (int index = 0; index < size; index++){
            if(!c.contains(listArray[index])){
                indexElementsToDelete[count] = index;
                count++;
            }
        }
        //Удаляем по иднексам
        for (int index = count - 1; index >= 0; index--){
            remove(indexElementsToDelete[index]);
        }
        if(count > 0) return true;
        return false;

    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public E get(int index) {
        checkToBoundsException(index);
        return (E) listArray[index];
    }

    @Override
    public E set(int index, E element) {
        checkToBoundsException(index);
        listArray[index] = element;
        return (E) listArray[index];
    }

    @Override
    public void add(int index, E element) {
        checkToBoundsExceptionForInsert(index);
        if(isNeedToExpand()) expand();
        Object[] newListArray = new Object[listArray.length + 1];
        if(index > 0){
            System.arraycopy(listArray,0,newListArray,0, index + 1);
        }
        if(index < size){
            System.arraycopy(listArray,index,newListArray,index + 1, size - index);
        }
        newListArray[index] = element;
        listArray = newListArray;
        size++;
    }

    //Проверяем нужно ли раширять хранилище
    boolean isNeedToExpand(){
        double arrayIsFullPercent = (double) size/listArray.length;
        if(arrayIsFullPercent > COEFFICIENT) return true;
        return false;
    }

    //Расширяем хранилище
    void expand(){
        Object[] newListArray = new Object[(int) (listArray.length*MULTIPLIER)];
        for(int index = 0; index < size; index++){
            newListArray[index] = listArray[index];
        }
        listArray = newListArray;
    }

    int getArrayLength(){
        return listArray.length;
    }

    private class MyIterator<E> implements Iterator<E>{
        private int indexOfIterator = 0;

        @Override
        public boolean hasNext() {
            return indexOfIterator < size;
        }

        @Override
        public E next() {
            return (E) listArray[indexOfIterator++];
        }
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOf(listArray, size));
    }

    private void checkToBoundsException(int index){
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
    }
    private void checkToBoundsExceptionForInsert(int index){
        if(index > size || index < 0) throw new IndexOutOfBoundsException();
    }
}
