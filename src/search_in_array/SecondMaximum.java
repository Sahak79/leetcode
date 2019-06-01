package search_in_array;

import java.util.Objects;

public class SecondMaximum {
    public static void main(String[] args) {
        int[] array = new int[]{1,8,4,3,5,2,7};
        System.out.println(searchSecondMaximum(array));
    }

    private static int searchSecondMaximum(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                secondMax = max;
                max = array[i];
            }else if(secondMax<array[i]){
                secondMax = array[i];
            }
        }
        Objects.equals("", "");
        return secondMax;
    }
}
