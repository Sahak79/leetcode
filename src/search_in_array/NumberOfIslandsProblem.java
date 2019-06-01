package search_in_array;

import java.util.StringJoiner;

public class NumberOfIslandsProblem {

    public static void main(String[] args) {
        int array[][] = new int[][]{
                {0,1,1,1,1,0,0,0,0,0},
                {0,1,0,0,0,0,0,0,0,0},
                {0,1,0,1,1,1,1,0,0,0},
                {0,1,0,0,0,0,0,0,0,0},
                {0,1,1,1,1,0,0,0,0,0}};
        findIsland(array);

    }

    private static void findIsland(int array[][]) {
        if(array.length == 0 || array[0].length == 0)
            throw new RuntimeException("Hey dude, can you add some elements into array?");
        int height = array.length;
        int length = array[0].length;
        int visitedIndices[][] = new int[height][length];
        StringJoiner islandJoiner = new StringJoiner(", ");
        for (int i=0; i < array.length; i++) {
            for (int j=0; j < array[i].length; j++) {
                if(visitedIndices[i][j]==1)
                    continue;
                if(array[i][j]==1){
                    visitedIndices[i][j]=1;
                    islandJoiner.add("Island: ["+i+"]["+j+"]");
                    searchWithIndex(i, j, array, visitedIndices, islandJoiner);

                }
            }
        }
        System.out.println(islandJoiner);
    }

    private static void searchWithIndex(int i, int j, int array[][],int visitedIndices[][], StringJoiner islandJoiner){
        int neighbors[][] = new int[][]{{i,j-1},{i,j+1},{i-1,j},{i+1,j},{i-1,j+1},{i+1,j-1},{i-1,j-1},{i+1,j+1}};
        for (int[] neighbor : neighbors) {
            lookForElement(neighbor[0], neighbor[1], array, visitedIndices, islandJoiner);
        }
    }

    private static void lookForElement(int i, int j, int array[][], int visitedIndices[][], StringJoiner islandJoiner){
        int index = i<array.length && i>-1 && j<array[i].length && j>-1 && visitedIndices[i][j]!=1 ? array[i][j] : -1;
        if(index!=-1){
            visitedIndices[i][j] = 1;
        }
        if(index==1){
            islandJoiner.add("["+i+"]["+j+"]");
            searchWithIndex(i, j, array, visitedIndices, islandJoiner);
        }
    }

}

