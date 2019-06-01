package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> options = new ArrayList<>();
        char[] buf = new char[n * 2];
        populateOptions(n, n, buf, 0, options);
        return options;
    }

    private static void populateOptions(int count1, int count0, char[] buf, int i, List<String> options) {
        if (i == buf.length) {
            options.add(new String(buf));
            return;
        }
        if (count1 > 0 && count1 <= count0) {
            buf[i] = '(';
            populateOptions(count1 - 1, count0, buf, i + 1, options);
        }
        if (count0 > 0) {
            buf[i] = ')';
            populateOptions(count1, count0 - 1, buf, i + 1, options);
        }
    }

}
