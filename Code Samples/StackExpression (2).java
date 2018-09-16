// Banting, Carl Jayson
// CS 203
// 2CSB
// Lab Exercise 5 and 6
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

    static boolean lowerPrecedence1(String op1, String op2) {
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
            case "(":
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
            case "(":
            case ")":
                value2 = 0;
            default:
                break;
        }
        return (value1 < value2);
    }
    
    static boolean lowerPrecedence2(String op1, String op2) {
        int value1 = 0, value2 = 0;
        switch (op1) {

            case "+":
            case "-":
                value1 = 1;
                break;
            case "*":
            case "/":
                value1 = 3;
                break;
            case "^":
                value1 = 6;
                break;
            case "(":
            case ")":
                value1 = 9;
            default:
                break;
        }
        switch (op2) {

            case "+":
            case "-":
                value2 = 2;
                break;
            case "*":
            case "/":
                value2 = 4;
                break;
            case "^":
                value2 = 5;
                break;
            case "(":
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
    
    static double evalPostfix(String e) {
        Stack<String> s = new Stack<String>();
        String[] X = e.split(" ");
        for (int i = 0; i < X.length; i++) {
            if (isOperator(X[i])) {
                double B = Double.parseDouble(s.pop());
                double A = Double.parseDouble(s.pop());
                String C = Double.toString(evaluate(A, B, X[i]));
                s.push(C);
            } else {
                s.push(X[i]);
            }
        }
        double value = Double.parseDouble(s.pop());
        return value;
    }

    static String infixToPostfix(String e) {
        Stack<String> s = new Stack<String>();
        String Y = "";
        String[] X = e.split(" ");
        for (int i = 0; i < X.length; i++) {
            if (isOperator(X[i])) {
                while (!(s.isEmpty()) && (lowerPrecedence2(X[i], s.peek()))) {
                    Y = Y + " " + s.pop();
                }
                if (X[i].equals(")")) {
                    String operator = s.pop();
                    while (!(operator.equals("("))) {
                        Y = Y + " " + operator;
                        operator = s.pop();
                    }
                    continue;
                }
                s.push(X[i]);
            } else {
                Y = Y + " " + X[i];
            }
        }
        while (!(s.isEmpty())) {
            Y = Y + " " + s.pop();
        }
        return Y;
    }

    static String infixToPrefix(String e) {
        String[] X = e.split(" ");
        String Y = "";
        Stack<String> optr = new Stack<String>();
        Stack<String> rev = new Stack<String>();
        for (int i = X.length - 1; i >= 0; i--) {
            if (isOperator(X[i])) {
                while (!(optr.isEmpty()) && (lowerPrecedence1(X[i], optr.peek()))) {
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
            if (k == 0) {
                Y = rev.pop();
            } else {
                Y = Y + " " + rev.pop();
            }
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
    
    static String postfixToInfix(String e) {
        Stack<String> s = new Stack<String>();
        String[] X = e.split(" ");
        for (int i = 0; i < X.length; i++) {
            if (isOperator(X[i])) {
                String B = s.pop();
                String A = s.pop();
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
        if (t == 2) {
            System.out.println("Infix: " + s);
            System.out.println("Postfix: " + infixToPostfix(s));
            System.out.println("Value: " + evalPostfix(infixToPostfix(s)));
        }
        if (t == 3) {
            System.out.println("Prefix: " + s);
            System.out.println("Infix: " + prefixToInfix(s));
            System.out.println("Value: " + evalPrefix(s));
        }
        if (t == 4) {
            System.out.println("Infix: " + s);
            System.out.println("Prefix: " + infixToPrefix(s));
            System.out.println("Value: " + evalPrefix(infixToPrefix(s)));
        }
        if (t == 5) {
            System.out.println("Postfix: " + s);
            System.out.println("Infix: " + postfixToInfix(s));
        }
    }
}
