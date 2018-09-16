
package cs;

import java.util.*;

public class StackExpression {

    static Scanner Scan = new Scanner(System.in);

    static String prefixToInfix(String e) {
        Stack<String> s = new Stack<String>();
        String[] X = e.split(" ");
        for (int i = X.length - 1; i >= 0; i--) {
            if ((X[i].equals("*")) || (X[i].equals("/")) || (X[i].equals("+")) || (X[i].equals("-")) || (X[i].equals("^"))) {
                String A = s.pop();
                String B = s.pop();
                s.push("(" + A + X[i] + B + ")");
            } else {
                s.push(X[i]);
            }
        }
        return s.pop();
    }
    
    static boolean isOperator(String c) {
        switch (c) {
            case "+":
            case "-":
            case "/":
            case "*":
            case "^":
                return true;
            default:
                return false;
        }
    }
    static double evaluate (double A, double B, String ope){
        switch (ope) {
            case "+":
                return (A + B);
            case "-":
                return (A - B);
            case "/":
                return (A / B);
            case "*":
                return (A * B);
            case "^":
                return Math.pow(A, B);
            default:
                return 0;
        }
    }
    static double evalPrefix (String e){
        Stack<String> s = new Stack<String>();
        String[] X = e.split(" ");
        for (int i = X.length - 1; i >= 0; i--) {
            if (isOperator(X[i])) {
                double A = Double.parseDouble(s.pop());
                double B = Double.parseDouble(s.pop());
                String C = Double.toString (evaluate(A, B, X[i]));
                s.push(C);
            } else {
                s.push(X[i]);
            }
        }
        double value =  Double.parseDouble(s.pop());
        return value;
    }

    public static void main(String[] args) {
        int t;
        String s;
        System.out.print("Input t: ");
        t = Scan.nextInt();
        Scan.nextLine();
        System.out.print("Input s: ");
        s = Scan.nextLine();
        if (t == 1) {
            System.out.println("Prefix: " + s);
            System.out.println("Infix: " + prefixToInfix(s));
        }
        else if (t == 3) {
            System.out.println("Prefix: " + s);
            System.out.println("Infix: " + prefixToInfix(s));
            System.out.println("Value: " + evalPrefix(s));
        }
    }
}
