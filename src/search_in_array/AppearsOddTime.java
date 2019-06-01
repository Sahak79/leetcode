package search_in_array;

public class AppearsOddTime {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 9, 1, 5, 1, 8, 2, 8};
        searchOddNumber(array);
    }

    private static void searchOddNumber(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
           if(array[i]>max){
               max = array[i];
           }
        }

        for (int i = 1; i <= max; i++){
            int numberAppearAmount = 0;
            for(int j = 0; j < array.length; j++){
                if(array[j]==i){
                    numberAppearAmount++;
                }
            }
            if(numberAppearAmount%2!=0){
                System.out.println(i);
            }
        }
    }
}
