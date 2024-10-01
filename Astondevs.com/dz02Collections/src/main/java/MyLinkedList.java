//2024.10.01 zip
public class MyLinkedList <E>{
    private Node head = new Node();
    private Node tail = new Node().setPrevious(head);;
    private int size;

    public MyLinkedList(){
        head = new Node();
        tail = new Node().setPrevious(head);;
        head.setNext(tail);
    }

    private class Node <E>{
        E value;
        private Node previous;
        private Node next;

        private Node(E value) {
            this.value = value;
        }
        private Node() {
        }

        private Node setPrevious(Node previous){
            this.previous = previous;
            return this;
        }

        private Node getPrevious(){
            return this.previous;
        }

        private Node setNext(Node next){
            this.next = next;
            return this;
        }

        private Node getNext(){
            return this.next;
        }

        private Node setValue(E newValue){
            this.value = newValue;
            return this;
        }

        private E getValue(){
            return value;
        }
    }

    //Извлечение ноды из цепочки, возвращем предыдущую ноду
    private Node withdrawNode(Node node){
        Node originalPrevious = node.getPrevious();
        Node originalNext = node.getNext();

        originalPrevious.setNext(originalNext);
        originalNext.setPrevious(originalPrevious);

        node.setPrevious(null).setNext(null);
        return originalPrevious;
    }
    //Вставка ноды после ноды, возвращаем всталвенную ноду
    private Node insertNodeAfterNode(Node what, Node afterNode){
        what.setNext(afterNode.getNext()).setPrevious(afterNode);
        what.getNext().setPrevious(what);
        afterNode.setNext(what);
        return what;
    }

    //Перемена местами нод
    private void swapNodes(Node node1, Node node2){
        Node whereWasNode1 = this.withdrawNode(node1);
        Node whereWasNode2 = this.withdrawNode(node2);
        this.insertNodeAfterNode(node2, whereWasNode1);
        this.insertNodeAfterNode(node1, whereWasNode2);


    }



}
