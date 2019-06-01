package search_in_array;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()((()))"));
    }

    public static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    int j = i - 1;
                    while (j >= 0 ) {
                        if (charArray[j] == '(') {
                            charArray[j] = ' ';
                            charArray[i] = ' ';
                            break;
                        }
                        j--;
                    }
                }
            }
        }
        int max = 0;
        int maxValidParentheses = 0;
        for (char c : charArray) {
            if (c == '(' || c == ')') {
                max = 0;
            } else {
                max++;
                if (max > maxValidParentheses) {
                    maxValidParentheses = max;
                }
            }
        }
        return maxValidParentheses;
    }

}
