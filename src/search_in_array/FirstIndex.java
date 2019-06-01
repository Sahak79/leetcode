package search_in_array;

public class FirstIndex {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,4,4,4,4,4,4,4,4};
        System.out.println(doSearch(4, array));
    }

    private static int doSearch(int val, int[] array) {
        int start = 0;
        int end = array.length-1;

        while (start <= end) {
            int middle = (start+end)/2;
            if(array[middle] == val && (middle == 0 || array[middle] != array[middle-1])){
                return middle;
            }else if (val <= array[middle]) {
                end = middle-1;
            }else {
                start = middle+1;
            }
        }
        return -1;
    }
}
