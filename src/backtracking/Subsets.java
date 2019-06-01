package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {

    public static void main(String[] args) {
        //System.out.println(permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        getAllPermutations(result, numsList, new ArrayList(nums.length));

        return result;
    }

    public static void getAllPermutations(List<List<Integer>> result, List<Integer> nums, List<Integer> list) {
        if (nums.size() == 0) {
            result.add(list);
        } else {
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> rem = new ArrayList<>(nums.size());
                rem.addAll(nums.subList(0, i));
                rem.addAll(nums.subList(i + 1, nums.size()));
                List<Integer> list1 = new ArrayList<>(nums.size());
                list1.addAll(list);
                list1.add(nums.get(i));
                getAllPermutations(result, rem, list1);
            }
        }
    }

}
