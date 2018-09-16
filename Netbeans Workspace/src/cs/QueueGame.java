package cs;

import java.util.*;

public class QueueGame {

    static Scanner Scan = new Scanner(System.in);

    public static void main(String[] args) {
        int t, s, n;
        Queue<Character> Que = new Queue<Character>();
        do {
            System.out.print("Input t: ");
            t = Scan.nextInt();
        } while (t < 1 || t > 3);
        do {
            System.out.print("Input s: ");
            s = Scan.nextInt();
        } while (s < 1);
        do {
            System.out.print("Input n: ");
            n = Scan.nextInt();
        } while (n < 1 || n > 26);
        if (t == 1) {
            System.out.println("Children:");
            for (int i = 65; i < (65 + n); i++) {
                System.out.print((char) i + " ");
                Que.enqueue((char) i);
            }
            System.out.println("\nEliminated Order:");
            while (!(Que.isEmpty())) {
                for (int i = 0; i < s; i++) {
                    char temp = Que.dequeue();
                    if (i != s - 1) {
                        Que.enqueue(temp);
                    } else {
                        System.out.print(temp + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}
