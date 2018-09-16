package cs;

public class BTBottomUp {
    public static void main(String[] args) {
        BTNode a = new BTNode(2);
        BTNode b = new BTNode (4);
        BTNode c = new BTNode (1, null, a);
        BTNode d = new BTNode (5, b, null);
        BTNode e = new BTNode (3, c, d);
        BT T = new BT();
        T.setRoot(e);
        T.computeLevels();
        System.out.println(T);
    }
}
