package leetcode20;

import java.util.Stack;

class Solution {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < length) {
            Character character = s.charAt(i++);
            if (stack.isEmpty()) {
                stack.push(character);
                continue;
            }
            switch (stack.peek()) {
            case '(':
                if (character == ')') {
                    stack.pop();
                    continue;
                }
                break;
            case '{':
                if (character == '}') {
                    stack.pop();
                    continue;
                }
                break;

            case '[':
                if (character == ']') {
                    stack.pop();
                    continue;
                }
                break;
            }
            stack.push(character);
        }
        if (stack.isEmpty() && i == length) {
            return true;
        }

        return false;
    }
    public static void main (String[] args) {
        String string = "{()}";
        System.out.println(isValid(string));
    }
}