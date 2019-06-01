package search_in_array;

public class TickTack1 {

    public static void main(String[] args) {
        int[] a = {4,5,7,5,2,3,8,3,1};

        for (int i = 0; i < a.length; i++) {
            if(a[i+1]<0){
                System.out.println(-a[i+1]+" is duplicated");
                break;
            }
            a[a[i]] = -a[i];
        }
    }
}
