package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    public static void main(String[] args) {
        findAndReplacePattern(new String[]{"t","k","g","n","k"}, "v");
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        Map<Character, List<Integer>> patternMap = getCharMap(pattern);
        for (String word : words) {
            match: {
                Map<Character, List<Integer>> map = getCharMap(word);
                if (map.size() == patternMap.size()) {
                    Iterator<List<Integer>> it = map.values().iterator();
                    Iterator<List<Integer>> patternIt = patternMap.values().iterator();
                    while (it.hasNext()) {
                        List<Integer> first = patternIt.next();
                        List<Integer> second = it.next();
                        if (first.size() == second.size()) {
                            for (int i = 0; i < first.size(); i++) {
                                if (!first.get(i).equals(second.get(i))) {
                                    break match;
                                }
                            }
                        } else {
                            break match;
                        }
                    }
                    result.add(word);
                }
            }
        }
        return result;
    }

    public static Map<Character, List<Integer>> getCharMap( String s) {
        Map<Character, List<Integer>> map = new LinkedHashMap<>();
        char[] patternChars = s.toCharArray();
        for (int i = 0; i < patternChars.length; i++) {
            char c = patternChars[i];
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            }
        }
        return map;
    }

}
