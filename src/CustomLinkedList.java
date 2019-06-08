public class CustomLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        System.out.println(linkedList.get(-1));
    }
}

class LinkedList<E> {

    private Node first;
    private Node last;
    private int size = 0;

    private class Node {
        Node next;
        E value;
    }

    public E get(int j){
        Node node = first;
        if (j < 0 || j >= size) {
            return null;
        }
        if (j == 0) {
            return node.value;
        }

        for (int i = 0; i < j; i++) {
            node = node.next;
        }
        return node.value;
    }

    public void add(E value) {
        Node node = new Node();
        node.value = value;
        if(first == null) {
            first = node;
        }
        if(last == null) {
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }
}