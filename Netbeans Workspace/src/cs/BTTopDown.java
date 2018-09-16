package cs;
public class BTTopDown {

    public static void main(String[] args) {
        BST bst1 = new BST();
        String[] BSTkey = {"G", "T", "D", "P", "B", "L", "E", "N", "S", "M", "H"};
        String[] BSTsearchk = {"A", "D", "H", "G", "P", "R", "V"};
        String[] BSTPair1 = {"B", "B", "S", "M", "T", "L"};
        String[] BSTPair2 = {"Z", "S", "B", "S", "N", "L"};
        for (int i = 0; i < BSTkey.length; i++) {
            bst1.insert(BSTkey[i]);
        }
        System.out.println(bst1);
        System.out.println();
        for (int i = 0; i < BSTsearchk.length; i++) {
            BTNode a = bst1.search(BSTsearchk[i]);
            if (a != null) {
                System.out.println(a + " level = " + a.level);
            } else {
                System.out.println("K=" + BSTsearchk[i] + " is not in the tree.");
            }
        }
        System.out.println();
        for (int i = 0; i < BSTPair1.length; i++) {
            BTNode c = bst1.findLCA(BSTPair1[i], BSTPair2[i]);
            if (c != null) {
                System.out.println(c + " level = " + c.level);
            } else {
                System.out.println("K1=" + BSTPair1[i] + " and K2=" + BSTPair2[i] + " don't have a common ancestor");
            }
        }
    }
}
