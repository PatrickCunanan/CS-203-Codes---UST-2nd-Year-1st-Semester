// Banting, Carl Jayson
// CS 203
// 2CSB
// Lab Exercise 5
// Stacks

import java.util.*;

public class StackExpression {

    static Scanner input = new Scanner(System.in);

    static boolean isOperator(String c) {
        switch (c) {
            case "+":
            case "-":
            case "/":
            case "*":
            case "^":
            case "(":
            case ")":
                return true;
            default:
                return false;
        }
    }

    static boolean lowerPrecedence(String op1, String op2) {
        int value1 = 0, value2 = 0;
        switch (op1) {

            case "+":
            case "-":
                value1 = 2;
                break;
            case "*":
            case "/":
                value1 = 4;
                break;
            case "^":
                value1 = 5;
                break;
            case ")":
                value1 = 9;
            default:
                break;
        }
        switch (op2) {

            case "+":
            case "-":
                value2 = 1;
                break;
            case "*":
            case "/":
                value2 = 3;
                break;
            case "^":
                value2 = 6;
                break;
            case ")":
                value2 = 0;
            default:
                break;
        }
        return (value1 < value2);
    }

    static double evaluate(double A, double B, String ope) {
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

    static double evalPrefix(String e) {
        Stack<String> s = new Stack<String>();
        String[] X = e.split(" ");
        for (int i = X.length - 1; i >= 0; i--) {
            if (isOperator(X[i])) {
                double A = Double.parseDouble(s.pop());
                double B = Double.parseDouble(s.pop());
                String C = Double.toString(evaluate(A, B, X[i]));
                s.push(C);
            } else {
                s.push(X[i]);
            }
        }
        double value = Double.parseDouble(s.pop());
        return value;
    }

    static String infixToPrefix(String e) {
        String[] X = e.split(" ");
        String Y = "";
        Stack<String> optr = new Stack<String>();
        Stack<String> rev = new Stack<String>();
        for (int i = X.length - 1; i >= 0; i--) {
            if (isOperator(X[i])) {
                while (!(optr.isEmpty()) && (lowerPrecedence(X[i], optr.peek()))) {
                    rev.push(optr.pop());
                }
                if (X[i].equals("(")) {
                    String operator = optr.pop();
                    while (!(operator.equals(")"))) {
                        rev.push(operator);
                        operator = optr.pop();
                    }
                    continue;
                }
                optr.push(X[i]);
            } else {
                rev.push(X[i]);
            }
        }
        while (!(optr.isEmpty())) {
            rev.push(optr.pop());
        }
        int k = 0;
        while (!(rev.isEmpty())) {
            if (k == 0) Y = rev.pop();
            else Y = Y + " " + rev.pop();
            k++;
        }
        return Y;
    }

    static String prefixToInfix(String e) {
        Stack<String> s = new Stack<String>();
        String[] X = e.split(" ");
        for (int i = X.length - 1; i >= 0; i--) {
            if (isOperator(X[i])) {
                String A = s.pop();
                String B = s.pop();
                s.push("(" + A + X[i] + B + ")");
            } else {
                s.push(X[i]);
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        int t;
        String s;
        System.out.print("Enter t: ");
        t = input.nextInt();
        input.nextLine();
        System.out.print("Enter s: ");
        s = input.nextLine();
        if (t == 1) {
            System.out.println("Prefix: " + s);
            System.out.println("Infix: " + prefixToInfix(s));
        }
        if (t == 4) {
            System.out.println("Infix: " + s);
            System.out.println("Prefix: " + infixToPrefix(s));
            System.out.println("Value: " + evalPrefix(infixToPrefix(s)));
        }
    }
}
