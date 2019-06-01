package string;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class StringPalindromic {

    public static void main(String[] args) {
        doPalindrome("banana");
    }

    private static void doPalindrome(String str) {
        char[] strCharArray = str.toCharArray();
        for (int i = 0; i < strCharArray.length; i++) {
            StringJoiner stringJoiner = new StringJoiner("-");
            int j = i;
            int k = i;
            if(i>0) {
                StringBuilder stringBuilder = new StringBuilder();
                while (k>0
                        && (j<strCharArray.length-1)
                        && (k<=strCharArray.length/2+1)) {
                    stringJoiner = new StringJoiner("-");
                    if(strCharArray[--k] == strCharArray[++j]) {
                        stringBuilder.append(String.valueOf(strCharArray[k]));

                        String palindrome =
                            stringBuilder.reverse().toString()+
                            strCharArray[i]+
                            stringBuilder.reverse();

                        for(int p = 0; p < strCharArray.length; p++){
                            if(p>k&&p<i || p>i&&p<j)
                                continue;

                            if(p!=i&&p!=k&&p!=j){
                                stringJoiner.add(String.valueOf(strCharArray[p]));
                            }else{
                                if(!"".equals(palindrome)){
                                    stringJoiner.add(palindrome);
                                    palindrome = "";
                                }
                            }
                        }
                        System.out.println(stringJoiner);
                    }
                }
            }else {
                for (char ch : strCharArray) {
                    stringJoiner.add(String.valueOf(ch));
                }
                System.out.println(stringJoiner);
            }
        }
    }
}
