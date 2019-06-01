package string;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abba"));
    }

    public static int countSubstrings(String s) {
        int result = s.length();
        char[] charr = s.toCharArray();
        for (int i = 0; i < charr.length; i++) {
            result += getPalindroms(s.length(), charr, i, 2);
            result += getPalindroms(s.length(), charr, i, 3);
        }
        return result;
    }

    public static int getPalindroms(int length, char[] charr, int i, int k) {
        int result = 0;
        if (i + k - 1 < length && charr[i + k - 1] == charr[i]) {
            result++;
            int j = i - 1;
            int m = i + k;
            while (j > -1 && m < length && charr[m++] == charr[j--]) {
                result++;
            }
        }
        return result;
    }

}
