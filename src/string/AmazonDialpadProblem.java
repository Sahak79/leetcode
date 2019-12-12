package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AmazonDialpadProblem {
     static Map<Integer, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        list1.addAll(Arrays.asList("A", "B", "C"));
        map.put(1, list1);
        list2.addAll(Arrays.asList("D", "E", "F"));
        map.put(2, list2);
        list3.addAll(Arrays.asList("G", "I", "H"));
        map.put(3, list3);

        printAllVariants(new Integer[]{1,1,2});
    }

    private static void printAllVariants(Integer[] ints) {
        Stream.of(ints)
            .map(map::get)
            .reduce((l1,l2) -> l1.stream().flatMap(v1 -> l2.stream().map(v2 -> v1 + v2))
                .collect(Collectors.toList()))
            .ifPresent(i -> i.forEach(System.out::println));
    }


}
