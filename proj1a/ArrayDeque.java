public class ArrayDeque<T> {
    private T[] array;
    private int CAPACITY;
    //front是队首元素的index
    private int front;
    //end是addLast要插入的元素的index
    private int end;

    public ArrayDeque() {
        CAPACITY = 8;
        array = (T[]) new Object[CAPACITY];
        front = end = 0;
    }


    public void addFirst(T item) {
        front = minusOne(front);
        array[front] = item;
        if (front == end) {
            doubleCapacity();
        }
    }

    public void addLast(T item) {
        array[end] = item;
        end = plusOne(end);
        if (front == end) {
            doubleCapacity();
        }
    }

    public boolean isEmpty() {
        return front == end;
    }

    public int size() {
        return (end - front + CAPACITY) % CAPACITY;
    }

    public void printDeque() {
        if (isEmpty()) {
            return;
        }

        for (int i = front; i != end; i += plusOne(i)) {
            System.out.print(array[i] + " ");
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = array[front];
        front = plusOne(front);

        if (size() <= (int) (0.25 * CAPACITY) && CAPACITY  >= 16) {
            halfCapacity();
        }
        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        end = minusOne(end);
        T res = array[end];
        if (size() <= (int) (0.25 * CAPACITY) && CAPACITY >= 16) {
            halfCapacity();
        }
        return res;
    }

    public T get(int index) {
        if (index >= size()) {
            return null;
        }
        int i = front;
        while (index > 0) {
            i = plusOne(i);
            index--;
        }
        return array[i];
    }

    private void doubleCapacity() {
        int newCapacity = CAPACITY * 2;
        T[] newArray = (T[]) new Object[newCapacity];

        //head == tail
        System.arraycopy(array, front, newArray, 0, array.length - front);
        System.arraycopy(array, 0, newArray, array.length - front, front);
        front = 0;
        end = array.length;
        array = newArray;
        CAPACITY = newCapacity;
    }

    private void halfCapacity(){
        int newCapacity = CAPACITY / 2;
        T[] newArray = (T[]) new Object[newCapacity];
        if (front <= end){
            System.arraycopy(array,front,newArray,0,end - front);
        }else {
            System.arraycopy(array, front, newArray, 0, array.length - front);
            System.arraycopy(array, 0, newArray, array.length - front, end);
        }
        front = 0;
        end = array.length;
        array = newArray;
        CAPACITY = newCapacity;
    }

    private int minusOne(int index) {
        return (index + CAPACITY - 1) % CAPACITY;
    }

    private int plusOne(int index) {
        return (index + CAPACITY + 1) % CAPACITY;
    }
}
