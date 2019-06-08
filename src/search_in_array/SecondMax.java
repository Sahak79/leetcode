package search_in_array;

public class SecondMax {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,7,3,4,9,6};
        getSecondMax(arr);
    }

    public static void getSecondMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(secondMax);
    }
}
