package Aud5.Stack;

import java.util.Scanner;

public class Postfix {

    public static int resultPostfix(char[] expression) {
        ArrayStack<Integer> stack = new ArrayStack<>(1000);
        int number = 0;
        for (int i = 0; i < expression.length; i++) {
            if (Character.isDigit(expression[i]) && Character.isDigit(expression[i + 1])) {
                number = number * 10 + Character.getNumericValue(expression[i]);
            }
            if (Character.isDigit(expression[i]) && !Character.isDigit(expression[i + 1])) {
                number = number * 10 + Character.getNumericValue(expression[i]);
                stack.push(number);
                number = 0;
            }
            if (expression[i] == '+' || expression[i] == '-' || expression[i] == '*' || expression[i] == '/') {
                int num1 = stack.pop();
                int num2 = stack.pop();

                if (expression[i] == '+')
                    stack.push(num1 + num2);
                else if (expression[i] == '-')
                    stack.push(num2 - num1);
                else if (expression[i] == '*')
                    stack.push(num1 * num2);
                else if (expression[i] == '/')
                    stack.push(num2 / num1);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        char[] c = s1.toCharArray();
        int result = Postfix.resultPostfix(c);
        System.out.println(result);
    }
}