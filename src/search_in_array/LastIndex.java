package search_in_array;

public class LastIndex {
    public static void main(String[] args) {
        int array[] = {0, 1, 2, 2, 4, 4, 4, 4};
        int num = 2;
        //System.out.println(getIndex(num, array));
        System.out.println(searchElementWithLoop(4, array));

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        //System.out.println(searchElement(9, 0, arr.length-1, arr));

        //System.out.println(searchElementWithLoop(2, 0, arr.length - 1, arr));
    }

    private static int getIndex(int num, int[] array){
        int tmp_num = -1;
        for (int i=0;i<array.length;i++) {
            if(array[i]!=num){
                continue;
            }
            if(array[i]!=array[i+1]){
                break;
            }else{
                tmp_num = i+1;
            }
        }
        return tmp_num;
    }

    private static int searchElement(int val, int low, int high, int[] array){
        int middle = (low+high)/2;
        if(val == array[middle] && (middle == high || array[middle] != array[middle+1])){
            return middle;
        }else if(val < array[middle]) {
            return searchElement(val, low, middle-1, array);
        }else {
            return searchElement(val, middle+1, high, array);
        }
    }

    private static int searchElementWithLoop(int val, int[] array){
        int low = 0;
        int high = array.length-1;

        while(low <= high){
            int middle = (low+high)/2;
            if(array[middle] == val && (middle == high || array[middle] != array[middle+1])){
                return middle;
            }else if(val < array[middle]) {
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
