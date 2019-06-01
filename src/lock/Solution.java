package lock;

public class Solution {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        String result = "";
        if (s.isEmpty()) {
            return "";
        }
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            int j = i;
            int k = i;
            String str1 = "";
            String str2 = "";
            while((2 * i - j + 1 < arr.length && j >= 0 && arr[j] == arr[2 * i - j + 1]) || (2 * i - j + 2 < arr.length && j >= 0 && arr[j] == arr[2 * i - j + 2])) {
                str1 = arr[j] + str1 + arr[2 * i - j + 1];
                if(str2.isEmpty()) {
                    str2 += arr[2 * i - j + 1];
                }
                str2 = arr[j] + str2 + arr[2 * i - j + 2];
                --j;
            }
            if(str1.length() > result.length()) {
                result = str1;
            }
            if(str2.length() > result.length()) {
                result = str2;
            }

            /*str = "";
            while(2 * i - k + 2 < arr.length && k >= 0 && arr[k] == arr[2 * i - k + 2]) {
                if(str.isEmpty()) {
                    str += arr[2 * i - k + 1];
                }
                str = arr[k] + str + arr[2 * i - k + 2];
                --k;
            }
            if(str.length() > result.length()) {
                result = str;
            }*/
        }
        if (result.isEmpty()) {
            return "" + s.charAt(0);
        }
        return result;
    }
}
