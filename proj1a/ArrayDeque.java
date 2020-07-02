public class ArrayDeque<T> implements Deque<T> {
    private T[] array;
    private int size;
    private int CAPACITY;
    private int front;
    private int end;

    public ArrayDeque() {
        CAPACITY = 8;
        array = (T[]) new Object[CAPACITY + 1];
        size = 0;
        front = end = 0;
    }


    @Override
    public void addFirst(T item) {
        size++;
        if (size + 1 == CAPACITY) {
            resize(CAPACITY * 2);
        }

        if (size == 0) {
            array[front] = item;
        } else {
            front = minusOne(front);
            array[front] = item;
        }
    }

    @Override
    public void addLast(T item) {
        size++;
        if (size + 1 == CAPACITY) {
            resize(CAPACITY * 2);
        }
        if (size == 0) {
            array[end] = item;
        } else {
            end = plusOne(end);
            array[end] = item;
        }

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
        if (isEmpty()) {
            return;
        }

        for (int i = front; i != end; i += plusOne(i)) {
            System.out.print(array[i] + " ");
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = array[front];
        front = plusOne(front);
        size--;
        if (size == 0) {
            end = front;
        }

        if (size <= (int) (0.25 * CAPACITY) && CAPACITY / 2 > 0) {
            resize(CAPACITY / 2);
        }
        return res;
    }

    @Override
    public T removeLast() {
        if (isEmpty()){
            return null;
        }
        T res = array[end];
        end = minusOne(end);
        size --;
        if (size==0){
            end = front;
        }

        if (size <= (int) (0.25 * CAPACITY) && CAPACITY / 2 > 0) {
            resize(CAPACITY / 2);
        }
        return null;
    }

    @Override
    public T get(int index) {
        if (index > size){
            return null;
        }
        int i = front;
        while (index > 0){
            front = plusOne(front);
            index--;
        }
        return null;
    }

    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        if (front <= end) {
            System.arraycopy(array, front, newArray, 0, size);
        } else {
            System.arraycopy(array, front, newArray, 0, size - front);
            System.arraycopy(array, 0, newArray, size - front, end + 1);
        }
        front = 0;
        end = size - 1;
        CAPACITY = newCapacity;
    }

    private int minusOne(int index) {
        return (index + CAPACITY - 1) % CAPACITY;
    }

    private int plusOne(int index) {
        return (index + CAPACITY + 1) % CAPACITY;
    }
}
