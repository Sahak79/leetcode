package search_in_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

public class _4Sum {
    public static void main(String[] args) {
        //System.out.println(fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
//        char[] charr = new char[]{'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'};
//        System.out.println(charr);
//        reverseString(charr);
//        System.out.println(charr);



    }

    public int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            sum = sum*10 + x%10;
            x = x/10;
        }
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return 0;
        }
        return 31>>>sum;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<Integer[]>> pairs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (pairs.containsKey(sum)) {
                    pairs.get(sum).add(new Integer[]{i, j});
                } else{
                    List<Integer[]> list = new ArrayList<>();
                    list.add(new Integer[]{i, j});
                    pairs.put(sum, list);
                }
            }
        }
        Set<Pair> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = target - (nums[i] + nums[j]);
                if (pairs.containsKey(key)) {
                    for (Integer[] k : pairs.get(key)) {
                        if (k[0] != i && k[1] != i && k[0] != j && k[1] != j) {
                            set.add(new Pair(k[0], k[1], i, j, nums));
                        }
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < set.toArray().length; i++) {
            Pair pair = (Pair)set.toArray()[i];
            result.add(Arrays.asList(nums[pair.first], nums[pair.second], nums[pair.third], nums[pair.fourth]));
        }
        return result;
    }


    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = tmp;
        }
    }

    static class Pair {
        int first;
        int second;
        int third;
        int fourth;
        int[] nums;

        Pair(int first, int second, int third, int fourth, int[] nums) {
            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.nums = nums;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            HashSet<Integer> set1 = new HashSet<>(Arrays.asList(pair.first, pair.second, pair.third, pair.fourth));
            HashSet<Integer> set2 = new HashSet<>(Arrays.asList(first, second, third, fourth));

            if (!set1.equals(set2)) {
                HashSet<Integer> set3 = new HashSet<>(Arrays.asList(nums[pair.first], nums[pair.second], nums[pair.third], nums[pair.fourth]));
                HashSet<Integer> set4 = new HashSet<>(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                return  set3.equals(set4);
            }
            return true;
        }

        @Override
        public int hashCode() {
            List<Integer> list = Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]);
            Collections.sort(list);
            return Objects.hash(list.toArray());
        }
    }

}

class Solution {

    public static void main(String[] args) {
        //System.out.println(firstUniqChar("aadadaad"));
        //System.out.println(isAnagram("anagrum", "nagaram"));
        //System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                stringBuilder.append(c);
            }
        }
        if (stringBuilder.length() == 1) {
            return true;
        }
        s = stringBuilder.toString();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static int firstUniqChar(String s) {
        char[] chararr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < chararr.length; i++) {
            if (set.contains(chararr[i])) {
                map.remove(chararr[i]);
            } else {
                map.put(chararr[i], i);
                set.add(chararr[i]);
            }
        }
        return map.isEmpty() ? -1 : map.values().iterator().next();
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
        }
        return false;
    }
}