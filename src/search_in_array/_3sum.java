package search_in_array;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class _3sum {

    public static void main(String[] args) {
        /*LocalDateTime fromDateTime = LocalDateTime.now();
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
        LocalDateTime toDateTime = LocalDateTime.now();

        LocalDateTime tempDateTime = LocalDateTime.from( fromDateTime );
        long seconds = tempDateTime.until( toDateTime, ChronoUnit.SECONDS);
        System.out.println(arr.length);
        System.out.println(seconds + " seconds.");*/

        System.out.println(binarySearch(0, 6, 12, new int[]{2, 3, 4, 8, 9, 11, 12}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        int min = 0;
        int max = 0;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        if (min == 0 && min == max) {
            result.add(Arrays.asList(0,0,0));
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int pair = nums[i] + nums[j];
                if (map.containsKey(pair)) {
                    List<Integer> list = map.get(pair);
                    list.add(i);
                    list.add(j);
                    map.put(pair, list);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    map.put(pair, list);
                }
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int res = 0 - nums[i];
            List<Integer> list = map.get(res);
            for (int j = 0; list != null && j < list.size(); j+=2) {
                if (list.get(j) != i && list.get(j + 1) != i) {
                    int[] arr = new int[] {nums[list.get(j)], nums[list.get(j + 1)], nums[i]};
                    Arrays.sort(arr);
                    String str = "" + arr[0] + arr[1] + arr[2];
                    if (!set.contains(str)) {
                        result.add(Arrays.asList(nums[list.get(j)], nums[list.get(j + 1)], nums[i]));
                        set.add(str);
                    }
                }
            }
        }
        return result;
    }

    public static int binarySearch(int start, int end, int val, int[] arr) {
        int index = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < val) {
                start = mid + 1;
            } else if (arr[mid] > val) {
                end = mid -1;
            } else {
                index = mid;
                break;
            }
        }
        return index;

        /*int middle = (end + start) / 2;
        if (arr[middle] < val) {
            if (middle + 1 > arr.length - 1) {
                return -1;
            }
            return binarySearch(middle + 1, end, val, arr);
        } else if (arr[middle] > val) {
            if (middle - 1 < 0) {
                return -1;
            }
            return binarySearch(start, middle - 1, val, arr);
        } else {
            return middle;
        }*/
    }
}
