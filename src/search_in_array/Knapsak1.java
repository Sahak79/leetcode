package search_in_array;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Knapsak1 {
    public static void main(String[] args) {
        AtomicInteger totalWeight = new AtomicInteger(50);
        Map<Integer, Integer> data = new HashMap<>();
        data.put(10, 60);
        data.put(20, 100);
        data.put(30, 120);
        ValueComparator comparator = new ValueComparator(data);
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(data);

        sortedMap.forEach((key, value) -> {
            int weightLeft = totalWeight.get() % key;
            if (weightLeft >= 0) {
                int amount = (totalWeight.get() - weightLeft) / key;
                if (amount > 0) {
                    System.out.println(value + " - " + amount);
                }
                totalWeight.set(weightLeft);
            }
        });
    }
}

class ValueComparator implements Comparator<Integer> {
    private Map<Integer, Integer> base;

    ValueComparator(Map<Integer, Integer> base) {
        this.base = base;
    }

    public int compare(Integer a, Integer b) {
        return Float.compare((float)base.get(b)/b, (float)base.get(a)/a);
    }
}
