import java.util.*;

//2024.10.01 zip
public class MyLinkedList <E> implements Collection<E>, List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList(){
        head = new Node<E>(null);
        tail = new Node<E>(null).setPrevious(head);
        head.setNext(tail);
        size = 0;
    }

    public MyLinkedList(Collection<? extends E> c) {
        this();
        this.addAll(c);
    }

    /** Interface: Collection **/
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(Object element : this){
            if(element.equals(o)) return true;
        }
        return false;
    }

    @Override
    public MyIterator<E> iterator() {
        return new MyIterator<E>();
    }

    @Override
    public boolean add(E o) {
        Node<E> node = new Node<>((E) o);
        insertNodeAfterNode(node, tail.getPrevious());
        return true;
    }

    @Override
    public boolean remove(Object o) {
        MyIterator<E> myIterator = new MyIterator<>();
        while (myIterator.hasNext()){
            Node<E> node = myIterator.nextNode();
            Object value = node.getValue();
            if(Objects.equals(value, o)) {
                this.withdrawNode(node);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if(c.size() < 1) return false;
        for(E element : c){
            this.add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        head = new Node<E>(null);
        tail = new Node<E>(null).setPrevious(head);
        head.setNext(tail);
    }

    @Override
    public boolean retainAll(Collection c) {
        int sizeBegin = size;
        Iterator<E> myIterator = this.iterator();
        while (myIterator.hasNext()){
            if(!c.contains(myIterator.next()))
                myIterator.remove();
        }
        return sizeBegin != size;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = false;
        for(Object element : c){
            while (remove(element)){
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean containsAll(Collection c) {
        for(Object element : c){
            if(!contains(element)) return false;
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] elements = new Object[size];
        int index = 0;
        for(Object element : this){
            if(index >= size) break;;
            elements[index++] = element;
        }
        return elements;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Object[] arrayObjects = toArray();
        if(a.length < size){
            return (T[]) Arrays.copyOf(arrayObjects,size, a.getClass());
        } else {
            System.arraycopy(arrayObjects, 0, a, 0, arrayObjects.length);
            if(a.length > size) a[size] = null; //Нужно по спецификации, разделитель - если новый массив больше чем оригинал
        }
        return a;
    }

    @Override
    public String toString(){
        return Arrays.toString(this.toArray());
    }

    /** interface: List **/
    @Override
    public E get(int index) {
        Node<E> node = getNodeByIndex(index);
        return node.getValue();
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNodeByIndex(index);
        node.setValue(element);
        return node.getValue();
    }

    @Override
    public void add(int index, E element) {
        Node<E> node = null;
        if(index == size) node = tail;
        else node = getNodeByIndex(index);
        insertNodeAfterNode(new Node<>(element), node.getPrevious());
    }

    @Override
    public E remove(int index) {
        Node<E> node = getNodeByIndex(index);
        withdrawNode(node);
        return node.getValue();
    }

    @Override
    public int indexOf(Object o) {
        MyIterator<E> myIterator = iterator();
        while (myIterator.hasNext()){
            if(Objects.equals(myIterator.next(), o)) return myIterator.getIndex();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int indexOfLastObject = -1;
        MyIterator<E> myIterator = iterator();
        while (myIterator.hasNext()){
            if(Objects.equals(myIterator.next(), o)) indexOfLastObject = myIterator.getIndex();
        }
        return indexOfLastObject;
    }

    @Override //TODO listIterator
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override //TODO listIterator
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkIndex(toIndex - 1);

        List<E> subList = new MyLinkedList<>();
        MyIterator<E> myIterator = iterator();
        while (myIterator.hasNext()){
            E value = myIterator.next();
            int index = myIterator.getIndex();
            if(index >= fromIndex) subList.add(value);
            if(index >= toIndex - 1) break;
        }
        return subList;
    }

    /***********************/
    /** Node **/
    private static class Node<E>{
        E value;
        private Node<E> previous;
        private Node<E> next;

        private Node(E value) {
            this.value = value;
        }

        private Node<E> setPrevious(Node<E> previous){
            this.previous = previous;
            return this;
        }

        private Node<E> getPrevious(){
            return this.previous;
        }

        private Node<E> setNext(Node<E> next){
            this.next = next;
            return this;
        }

        private Node<E> getNext(){
            return this.next;
        }

        private Node<E> setValue(E newValue){
            this.value = newValue;
            return this;
        }

        private E getValue(){
            return value;
        }
        @Override
        public String toString(){
            return String.format("Node: %s", this.getValue());
        }
    }

    /***********************/
    /** Service **/
    //Извлечение ноды из цепочки, возвращем предыдущую ноду
    private Node<E> withdrawNode(Node<E> node){
        Node<E> originalPrevious = node.getPrevious();
        Node<E> originalNext = node.getNext();

        originalPrevious.setNext(originalNext);
        originalNext.setPrevious(originalPrevious);

        node.setPrevious(null).setNext(null);
        size--;
        return originalPrevious;
    }
    //Вставка ноды после ноды, возвращаем всталвенную ноду
    private Node<E> insertNodeAfterNode(Node<E> what, Node<E> afterNode){
        what.setNext(afterNode.getNext()).setPrevious(afterNode);
        what.getNext().setPrevious(what);
        afterNode.setNext(what);
        size++;
        return what;
    }

    //Перемена местами нод
    private void swapNodes(Node<E> node1, Node<E> node2){
        Node<E> whereWasNode1 = this.withdrawNode(node1);
        Node<E> whereWasNode2 = this.withdrawNode(node2);
        this.insertNodeAfterNode(node2, whereWasNode1);
        this.insertNodeAfterNode(node1, whereWasNode2);
    }

    private Node<E> getNodeByIndex(int index){
        checkIndex(index);
        MyIterator<E> myIterator = this.iterator();
        while (myIterator.hasNext()){
            Node<E> node = myIterator.nextNode();
            if(myIterator.getIndex() == index) return node;
        }
        throw new IllegalStateException();
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }
    /***********************/
    /** Iterator **/
    private class MyIterator<E> implements Iterator<E>{
        Node currentElement = head;
        int index = -1;

        @Override
        public boolean hasNext() {
            if(currentElement.getNext() != null
                    & index + 1 < size) return true;
            return false;
        }

        @Override
        public E next() {
            nextService();
            return (E) currentElement.getValue();
        }

        public Node<E> nextNode() {
            nextService();
            return currentElement;
        }

        private void nextService(){
            index++;
            checkIndex(new IndexOutOfBoundsException());
            currentElement = currentElement.getNext();
        }
        public void remove(){
            checkIndex(new IllegalStateException());
            Node elementToDelete = currentElement;
            currentElement = currentElement.getPrevious();
            withdrawNode(elementToDelete);
            index--;
        }

        private void checkIndex(RuntimeException e){
            if(index < 0 || index >= size) throw e;
        }

        public int getIndex(){
            return index;
        }
    }
}
