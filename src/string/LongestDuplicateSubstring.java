package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LongestDuplicateSubstring {

    public static void main(String[] args) {
        System.out.println(longestDupSubstring("asdsahjasdsahj"));
    }
    public static String longestDupSubstring(String S) {
        String result = "";
        if (2 <= S.length() && S.length() > 100000) {
            return result;
        }
        char[] arr = S.toCharArray();

        // check if given string contains substring containing same
        // characters with length greater the half of input string
        int startIndex = 0;
        char previousChar = arr[0];
        int substringLength = 0;
        for (int i = 1; i < arr.length; i++) {
            if (previousChar == arr[i]) {
                substringLength++;
                continue;
            }else {
                startIndex = i;
            }
            if (substringLength < i - startIndex) {
                substringLength = i - startIndex;
            }
        }
        if (substringLength > S.length() / 2) {
            return S.substring(startIndex, substringLength);
        }

        // check if input string contains exact half substring
        if (S.substring(0,S.length() / 2).equals(S.substring(S.length() / 2))) {
            return S.substring(0,S.length() / 2);
        }

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            String key = arr[i] + "" + arr[i + 1];
            String str = addToMap(map, key, i);
            if (!str.isEmpty() && result.isEmpty()) {
                result = str;
            }
        }
        Map<String, List<Integer>> map1 = new HashMap<>();
        return alterMap(map, map1, S, result);
    }

    public static String alterMap(Map<String, List<Integer>> map,
                           Map<String, List<Integer>> map1,
                           String S,
                           String result) {
        String str = "";
        for (String key : map.keySet()) {
            List<Integer> integers = map.get(key);
            if (integers.size() == 1) {
                continue;
            }
            for (Integer integer : integers) {
                int index = integer + key.length();
                if (index < S.length()) {
                    String s = addToMap(map1, key + S.charAt(index), integer);
                    if (str.isEmpty() && !s.isEmpty()) {
                        str = s;
                    }
                }
            }
        }
        if (str.length() > result.length()) {
            map.clear();
            map.putAll(map1);
            map1.clear();
            return alterMap(map, map1, S, str);
        }
        return result;
    }

    public static String addToMap(Map<String, List<Integer>> map, String key, int i) {
        if (map.containsKey(key)) {
            map.get(key).add(i);
            return key;
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            map.put(key, list);
        }
        return "";
    }

}
