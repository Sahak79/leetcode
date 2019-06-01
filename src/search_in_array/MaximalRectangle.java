package search_in_array;

import java.util.Stack;

public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    int v = i;
                    int h = j;
                    while (v < matrix.length && h < matrix[0].length) {
                        v++;


                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        //System.out.println(maximalRectangle(matrix));
        //System.out.println(histagram(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(histagramStack(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public static int histagram(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            int val = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] >= val) {
                    count += val;
                } else {
                    if (count == 0)
                        continue;
                    if (max < count)
                        max = count;
                    count = 0;
                }
            }
            if (count == 0)
                continue;
            if (max < count)
                max = count;
        }
        return max;
    }

    public static int histagramStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackTmp = new Stack<>();
        int max = stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int head = !stack.isEmpty() ? stack.pop() : 0;
            if (head >= arr[i]) {
                stack.push(arr[i]);
                if (arr[i] > max) {
                    max = arr[i];
                }
                int arg = 2;
                while (!stack.isEmpty()) {
                    int val = stack.pop();
                    if (val <= arr[i] && arr[i] * arg > max) {
                        max = arr[i] * arg;
                    } else {
                        stackTmp.push(val);
                        break;
                    }
                    stackTmp.push(val);
                    arg++;
                }
                while (!stackTmp.isEmpty()) {
                    int val = stackTmp.pop();
                    stack.push(val);
                }
            } else {
                stack.push(head);
                if (arr[i] > max) {
                    max = arr[i];
                }
                int arg = 2;
                while (!stack.isEmpty()) {
                    int val = stack.pop();
                    if (val * arg > max) {
                        max = val * arg;
                    }
                    stackTmp.push(val);
                    arg++;
                }
                while (!stackTmp.isEmpty()) {
                    int val = stackTmp.pop();
                    stack.push(val);
                }
                stack.push(arr[i]);
            }
        }
        return max;
    }
}
