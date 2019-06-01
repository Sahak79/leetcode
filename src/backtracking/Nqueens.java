package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueens {

    public static void main(String[] args) {
        System.out.println(solveNQueens(8));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        String[][] arr = new String[n][n];
        for (String[] row : arr)
            Arrays.fill(row, ".");

        return result;
    }

    public void collectAllDistinctSolutions(List<List<String>> result,
                                            String[][] arr,
                                            List<String> list,
                                            int i,
                                            int j) {

        

    }

}
