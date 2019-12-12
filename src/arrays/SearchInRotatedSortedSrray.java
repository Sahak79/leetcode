package arrays;

public class SearchInRotatedSortedSrray {
    public static void main(String[] args) {
        //System.out.println(search(new int[]{4,5,6,7,0,1,2}, 2));
        //System.out.println(getRotationIndex(new int[]{6,7,8,9,10,11,12,13,1,2,3,4}, 0, 11));
        System.out.println(search(new int[]{1,3}, 0));
    }

    static int search(int[] nums, int target) {
        int rotationIndex = getRotationIndex(nums, 0, nums.length - 1);
        if (target > nums[nums.length - 1]) {
            return binarySearch(nums, 0, rotationIndex - 1, target);
        } else {
            return binarySearch(nums, rotationIndex, nums.length - 1, target);
        }
    }

    static int getRotationIndex(int[] nums, int left, int right) {
        int middle = (right - left) / 2 + left;
        if (nums[middle] > nums[right]) {
            return getRotationIndex(nums, middle + 1, right);
        } else if (nums[middle] < nums[right]) {
            if (middle - 1 < 0 || nums[middle - 1] > nums[middle]) {
                return middle;
            }
            return getRotationIndex(nums, left, middle - 1);
        }
        return middle;
    }

    static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            return arr[mid] == x ? mid : arr[mid] > x ? binarySearch(arr, l, mid - 1, x) :
                    binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
}
