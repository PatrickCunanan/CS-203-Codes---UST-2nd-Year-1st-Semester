// Banting, Carl Jayson
// CS 203
// 2CSB
// Lab Exercise 7
// CHUGGA chugga chugga CHUGGA chugga chugga QUEUEEE QUEUEEEEEEE

import java.util.*;

public class QueueGame {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int t, s, n;
        Queue<Character> q = new Queue<Character>();
        System.out.print("Enter t: ");
        t = input.nextInt();
        System.out.print("Enter s: ");
        s = input.nextInt();
        System.out.print("Enter n: ");
        n = input.nextInt();
        input.nextLine();
        if (t == 1) {
            System.out.println("Children:");
            for (int i = 65; i < (65 + n); i++) {
                System.out.print((char) i + " ");
                q.enqueue((char) i);
            }
            System.out.println();
            System.out.println("Eliminated Order:");
            while (!(q.isEmpty())) {
                for (int i = 0; i < s; i++) {
                    char temp = q.dequeue();
                    if (i != s - 1) {
                        q.enqueue(temp);
                    } else {
                        System.out.print(temp + " ");
                    }
                }
            }
        }
    }
}
