package search_in_array;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int val = nums[0];
        int count = 1;
        int cursor = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = 0;
            } else {
                nums[cursor] = nums[i];
                cursor++;
                val = nums[i];
                count++;
            }
        }
        return count;
    }
}
