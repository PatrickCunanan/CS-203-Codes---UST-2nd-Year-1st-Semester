package cs;

public class BT<T> {

     BTNode<T> root;
    int height;

    public BT() {
        root = null;
        height = -1;
    }

    public void setRoot(BTNode<T> n) {
        root = n;
    }

    public void computeLevels() {
        int ht = 0;
        Queue<BTNode> q = new Queue<BTNode>();
        BTNode p = root;
        if (p != null) {
            q.enqueue(p);
            p.level = 0;
            while (!(q.isEmpty())) {
                p = q.dequeue();
                System.out.println("K=" + p.key + " level=" + p.level);
                if (p.left != null) {
                    q.enqueue(p.left);
                    p.left.level = p.level + 1;
                    height = p.left.level;
                }
                if (p.right != null) {
                    q.enqueue(p.right);
                    p.right.level = p.level + 1;
                    height = p.right.level;
                }
            }
        }
    }
    
    public String toString(){
        if (root == null)
            return "ht=undefined";
        return ("ht="+height+"["+root.toString()+"]");
    }
}
