package search_in_array;

public class PossiblePairs {

    public static void main(String[] args) {
        System.out.println(getPairs(2, 2, 2, 0, 2, 0));
    }

    public static String getPairs(int U, int L, int ... A) {
        int[] arrU = new int[A.length];
        int[] arrL = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            switch (A[i]){
                case 2:
                    arrU[i] = 1;
                    arrL[i] = 1;
                    U--;
                    L--;
                    break;
                case 1:
                    if (U > L) {
                        arrU[i] = 1;
                        U--;
                    } else {
                        arrL[i] = 1;
                        L--;
                    }
            }
        }
        if (U > 0 || L > 0) {
            return "IMPOSSIBLE";
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i : arrU) {
                builder.append(i);
            }
            builder.append(",");
            for (int i : arrL) {
                builder.append(i);
            }
            return builder.toString();
        }
    }

}
