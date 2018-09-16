// Banting, Carl Jayson
// CS 203
// 2CSB
// Lab Exercise 8
// Linked List

import java.util.*;

public class SLLTest {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int t;
        String s1, s2;
        String[] a1, a2;
        System.out.print("Enter t: ");
        t = input.nextInt();
        input.nextLine();
        System.out.print("Enter s1: ");
        s1 = input.nextLine();
        System.out.print("Enter s2: ");
        s2 = input.nextLine();
        a1 = s1.split(" ");
        a2 = s2.split(" ");
        if (t == 1) {
            SLL<Integer> slist1 = new SLL<Integer>();
            SLL<Integer> slist2 = new SLL<Integer>();
            System.out.println("First Linked List Contents: ");
            for (int i = 0; i < a1.length; i++) {
                String w = a1[i];
                slist1.insertDesc(Integer.valueOf(w));
                System.out.println(slist1.toString());
            }
            System.out.println("Second Linked List Contents: ");
            for (int i = 0; i < a2.length; i++) {
                String w = a2[i];
                slist2.insertDesc(Integer.valueOf(w));
                System.out.println(slist2.toString());
            }
        }
    }
}
