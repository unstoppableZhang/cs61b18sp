public class LinkedListDeque<T> implements Deque<T> {
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
        if (index + 1 > size) {
            return null;
        }

        return getRecursive(index, sentinel.next);
    }

    private T getRecursive(int index, Node node) {
        if (index == 0) {
            return node.item;
        }

        return getRecursive(index - 1, node.next);
    }

    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node curr = sentinel.next;
        while (curr != sentinel) {
            System.out.print(curr.item + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T res = sentinel.next.item;
        size--;
        Node first = sentinel.next;
        Node newFirst = first.next;
        sentinel.next = newFirst;
        newFirst.prev = sentinel;
        if (size != 0) {
            first.next = null;
            first.prev = null;
        }
        return res;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T res = sentinel.prev.item;
        size--;
        Node last = sentinel.prev;
        Node newLast = last.prev;
        newLast.next = sentinel;
        sentinel.prev = newLast;
        if (size != 0) {
            last.next = null;
            last.prev = null;
        }

        return res;
    }

    @Override
    public T get(int index) {
        if (index + 1 > size) {
            return null;
        }
        Node curr = sentinel.next;

        while (index > 0) {
            curr = curr.next;
            index--;
        }

        return curr.item;
    }
}
