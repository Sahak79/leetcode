package string;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcda"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? s : s.substring(0,1);
        }
        char[] arr = s.toCharArray();
        String strMaxLength = "";
        for (int i = 0; i < arr.length - 1; i++) {
            int j = arr.length;
            while (j > 1 && j > i + 1) {
                String str = s.substring(i, j);
                boolean isPalindrome = true;
                for (int k = 0; k < str.length() / 2; k++) {
                    if (str.charAt(k) != str.charAt(str.length() -1 - k)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome && s.substring(i, j).length() > strMaxLength.length()) {
                    strMaxLength = s.substring(i, j);
                }
                j--;
            }
        }
        return strMaxLength.isEmpty() && s.length() > 0 ? s.substring(0,1) : strMaxLength;
    }

}
