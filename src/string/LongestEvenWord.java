package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LongestEvenWord {
    static int[] A = new int[]{};

    public static void main(String[] args) {
        //System.out.println(longestEvenWord("It is a pleasat day today"));
        /*List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("jk");
        list1.add("abb");
        list1.add("mn");
        list1.add("abc");
        List<String> list2 = new ArrayList<>();
        list2.add("bb");
        list2.add("kj");
        list2.add("bbc");
        list2.add("op");
        list2.add("def");
        System.out.println(getMinimumDifference(list1, list2));*/

        System.out.println(maxDifference(Arrays.asList(2, 5, 8, 10, 1, 8, 6)));
    }

    public static double find(int x, int y) {
        double ans = 0;
        if(x>y) return 1;
        ans = Math.pow(A[x],find(x+1,y));
        return ans;
    }

    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            map1.clear();
            if (a.get(i).length() == b.get(i).length()) {
                int count = 0;
                char[] arr1 = a.get(i).toCharArray();
                char[] arr2 = b.get(i).toCharArray();
                for (char item : arr1) {
                    if (map1.containsKey(item)) {
                        map1.put(item, map1.get(item) + 1);
                    } else {
                        map1.put(item, 1);
                    }
                }
                for (char c : arr2) {
                    if (map1.containsKey(c)) {
                        map1.put(c, map1.get(c) - 1);
                    }
                }
                for (Integer value : map1.values()) {
                    if (value > 0) {
                        count += value;
                    }
                }
                result.add(count);
            } else {
                result.add(-1);
            }
        }
        return result;
    }

    public static int maxDifference(List<Integer> a) {
        int max = -1;
        int min = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) < min) {
                min = a.get(i);
            }
            if (a.get(i) - min > max ) {
                max = a.get(i) - min;
            }
        }
        return max;
    }

    public static String longestEvenWord(String sentence) {
        String result = "00";
        String[] arr = sentence.split(" ");
        for (String s : arr) {
            if (s.length() %2 == 0 && s.length() > result.length()) {
                result = s;
            }
        }
        return result;
    }
}
