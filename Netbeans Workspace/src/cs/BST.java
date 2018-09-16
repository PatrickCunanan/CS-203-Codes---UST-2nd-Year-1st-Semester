package cs;

public class BST<T> extends BT {

    public void insert(T k) {
        int ctr = 0;
        if (root == null) {
            root = new BTNode(k);
            root.level = 0;
            height = ctr;
            return;
        }
        BTNode n = root;
        BTNode p = null;
        while (n != null) {
            p = n;
            if (((Comparable) k).compareTo(n.key) < 0) {
                n = n.left;
                ctr++;
            } else {
                n = n.right;
                ctr++;
            }
        }
        if (((Comparable) k).compareTo(p.key) < 0) {
            p.left = new BTNode(k);
            p.left.level = p.level + 1;
        } else {
            p.right = new BTNode(k);
            p.right.level = p.level + 1;
        }
        if (height < ctr) {
            height = ctr;
        }
    }

    public BTNode search(T k) {
        BTNode n = root;
        while (n != null) {
            if (((Comparable) k).compareTo(n.key) == 0) {
                return n;
            } else if (((Comparable) k).compareTo(n.key) < 0) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return null;
    }

    /*public BTNode findLCA(T k1, T k2) {
     if (search(k1) == null || search(k2) == null) {
     return null;
     } else {
     return findLCA(root, k1, k2);
     }
     }

     public BTNode findLCA(BTNode node, T k1, T k2) {
     if (node == null) {
     return null;
     }
     if (node.key == k1 || node.key == k2) {
     return node;
     }
     BTNode leftLCA = findLCA(node.left, k1, k2);
     BTNode rightLCA = findLCA(node.right, k1, k2);
     if (leftLCA != null && rightLCA != null) {
     return node;
     }
     if (leftLCA != null) {
     return leftLCA;
     } else {
     return rightLCA;
     }
     }*/
    
    public BTNode findLCA(T k1, T k2) {
        Stack<BTNode> s1 = new Stack<BTNode>();
        Stack<BTNode> s2 = new Stack<BTNode>();
        BTNode a = null, b = null;
        BTNode n = root;
        s1.push(n);
        while (n != null) {
            if (((Comparable) k1).compareTo(n.key) == 0) {
                a = n;
                s1.push(a);
                break;
            } else if (((Comparable) k1).compareTo(n.key) < 0) {
                n = n.left;
                s1.push(n);
            } else {
                n = n.right;
                s1.push(n);
            }
        }
        n = root;
        s2.push(n);
        while (n != null) {
            if (((Comparable) k2).compareTo(n.key) == 0) {
                b = n;
                s2.push(b);
                break;
            } else if (((Comparable) k2).compareTo(n.key) < 0) {
                n = n.left;
                s2.push(n);
            } else {
                n = n.right;
                s2.push(n);
            }
        }
        if (a == null || b == null) {
            return null;
        } else {
            while (!(s1.isEmpty() && s2.isEmpty())) {
                if ((s1.peek().level == s2.peek().level) && (s1.peek() == s2.peek())) {
                    return s1.peek();
                } else if (s1.peek().level == s2.peek().level) {
                    s1.pop();
                    s2.pop();
                } else {
                    if (s1.peek().level < s2.peek().level) {
                        s2.pop();
                    } else {
                        s1.pop();
                    }
                }
            }
        }
        return null;
    }
}
