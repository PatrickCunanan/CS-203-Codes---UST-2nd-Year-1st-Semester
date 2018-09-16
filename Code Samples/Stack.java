// Banting, Carl Jayson
// CS 203
// 2CSB
// Lab Exercise 5
// Stacks

public class Stack<T> {

    private int maxStkSize = 100;
    private int top = -1;
    private Object[] stk;

    public Stack() {
        stk = new Object[maxStkSize];
    }

    public Stack(int n) {
        if (n > 0) {
            maxStkSize = n;
        }
        stk = new Object[maxStkSize];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxStkSize);
    }

    public int push(T el) {
        if (isFull()) {
            return -999;
        }
        stk[++top] = el;
        return 1;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T el = (T) stk[top--];
        return el;
    }
}
