public class LinkedListDeque<T>{
    private class Node {
        T item;
        Node next;
        Node prev;

        Node(T value, Node next, Node prev) {
            this.item = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public T getRecursive(int index) {
        if (index + 1 > size){
            return null;
        }

        return getRecursive(index, sentinel.next);
    }

    private T getRecursive(int index, Node node){
        if (index == 0){
            return node.item;
        }

        return getRecursive(index-1, node.next);
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel.next, sentinel);
        sentinel.next = newNode;
        if (size == 0) {
            sentinel.prev = newNode;
        }
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, sentinel, sentinel.prev);
        sentinel.prev = newNode;
        if (size == 0) {
            sentinel.next = newNode;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node curr = sentinel.next;
        if (curr != sentinel){
            System.out.print(curr.item);
        }
        curr = curr.next;
        while(curr != sentinel){
            System.out.print(" " + curr.item);
        }
    }

    public T removeFirst() {
        if (isEmpty()){
            return null;
        }

        T res = sentinel.next.item;
        size --;
        Node first = sentinel.next;
        sentinel.next = first.next;
        first.next = null;
        first.prev = null;
        if (size == 0){
            sentinel.prev = sentinel;
        }
        return res;
    }

    public T removeLast() {
        if (isEmpty()){
            return null;
        }

        T res = sentinel.prev.item;
        size --;
        Node last = sentinel.prev;
        sentinel.prev = last.prev;
        last.next = null;
        last.prev = null;
        if (size == 0){
            sentinel.next = sentinel;
        }
        return res;
    }

    public T get(int index) {
        if (index + 1 > size){
            return null;
        }
        Node curr = sentinel.next;

        while(index > 0){
            curr = curr.next;
            index --;
        }

        return curr.item;
    }
}
