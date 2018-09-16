package cs;

public class BTNode<T> {

    public T key;
    public BTNode<T> left, right;
    public int level;

    public BTNode() {
        this (null, null, null);
    }

    public BTNode(T el) {
        this (el, null, null);
    }

    public BTNode(T el, BTNode<T> l, BTNode<T> r) {
        key = el;
        left = l;
        right = r;
    }

    public String toString() {
        String s = "";
        if (this != null) {
            s = "K=" + key;
            if (left != null) {
                s = s + "L=[" + left.toString() + "]";
            }
            if (right != null) {
                s = s + "R=[" + right.toString() + "]";
            }
        }
        return s;
    }
}
