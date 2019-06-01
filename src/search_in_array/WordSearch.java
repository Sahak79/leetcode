package search_in_array;

import java.util.Arrays;
import java.util.Stack;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]
            {
                {'A','S','B'},
                {'A','M','D'},
                {'A','A','T'}
            };
        System.out.println(exist(board, "ASMDT"));
        new AA();
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (doSearch(0, board, word, i, j) != 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int doSearch(int cursor, char[][] board, String word, int i, int j) {
        cursor++;
        int result;
        if (cursor == word.length()) {
            return cursor;
        }
        char tmp = board[i][j];
        board[i][j] = '~';
        if (i + 1 < board.length && board[i + 1][j] == word.charAt(cursor)) {
            result = doSearch(cursor, board, word, i + 1, j);
            if (result == word.length()) {
                return result;
            }
        }
        if (i - 1 >= 0 && board[i - 1][j] == word.charAt(cursor)) {
            result = doSearch(cursor, board, word, i - 1, j);
            if (result == word.length()) {
                return result;
            }
        }
        if (j + 1 < board[i].length && board[i][j + 1] == word.charAt(cursor)) {
            result = doSearch(cursor, board, word, i, j + 1);
            if (result == word.length()) {
                return result;
            }
        }
        if (j - 1 >= 0 && board[i][j - 1] == word.charAt(cursor)) {
            result = doSearch(cursor, board, word, i, j - 1);
            if (result == word.length()) {
                return result;
            }
        }
        board[i][j] = tmp;
        return 0;
    }
}
 class AA{
    AA a;

    AA(){
        a = new AA();
    }
 }