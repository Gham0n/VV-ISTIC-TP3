package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c != ' ' && c != '\t' && c != '\n' && c != '\r' && c >= 32 && c <= 90) {
                // Ignore non-grouping symbols and whitespaces
                return false; // Return false for invalid characters
            }
        }

        // The string is balanced if the stack is empty at the end
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isBalanced("{[(xy)]}"));

    }

}
