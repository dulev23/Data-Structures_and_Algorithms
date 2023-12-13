package Aud5.Stack;

import Aud5.Stack.ArrayStack;

public class Brackets {
    public static boolean matching(char leftBracket, char rightBracket) {
        if (leftBracket == '(' && rightBracket == ')') return true;
        if (leftBracket == '[' && rightBracket == ']') return true;
        return (leftBracket == '{' && rightBracket == '}');
    }

    public static boolean isCorrect(String expression) {
        ArrayStack<Character> brackets = new ArrayStack<>(expression.length());
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                brackets.push(current);
            }

            if (current == ')' || current == ']' || current == '}') {
                if (brackets.isEmpty()) return false;
                char leftBracket = brackets.pop();
                if (!matching(leftBracket, current)) return false;
            }
        }
        return brackets.isEmpty();
    }

    public static void main(String[] args) {
        String expression = "s * [(s - a) * (s - b)]";
        System.out.println(isCorrect(expression));
    }
}