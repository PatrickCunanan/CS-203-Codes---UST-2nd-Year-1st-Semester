package cs;

public class Queue<T> {

    private int maxQsize = 100;
    private int front = -1, rear = -1;
    private Object[] que;

    public Queue() {
        que = new Object[maxQsize];
    }

    public Queue(int n) {
        if (n > 0) {
            maxQsize = n;
        }
        que = new Object[maxQsize];
    }

    public void clear() {
        front = rear = -1;
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public boolean isFull() {
        return ((rear + 1) % maxQsize == front);
    }

    public int enqueue(T el) {
        if (isFull()) {
            return -999;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % maxQsize;
        que[rear] = el;
        return 1;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T el = (T) que[front];
        if (front == rear) {
            clear();
        } else {
            front = (front + 1) % maxQsize;
        }
        return el;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        T el = (T) que[front];
        return el;
    }
}
