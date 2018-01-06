package leetcode36;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col= board[0].length;
        int i;
        for (i = 0; i < row; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> colums = new HashSet<>();
            int j;
            for (j = 0; j < col; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !colums.add(board[j][i])) {
                    return false;
                }
            }
        }
        //        int m;
        //        for (m = 0; m < col; m++) {
        //            Set<Character> colums = new HashSet<>();
        //            int j;
        //            for (j = 0; j < row; j++) {
        //                if (board[j][m] == '.') {
        //                    continue;
        //                }
        //                if (colums.contains(board[j][m])) {
        //                    break;
        //                }
        //                colums.add(board[j][m]);
        //            }
        //            if (j != row) {
        //                return false;
        //            }
        //        }

        int n;
        int count;
        for (n = 0, count = 0; n < row;) {
            Set<Character> set = new HashSet<>();
            int j;
            int count1;
            for (j = 0, count1 = 0; j < col;) {
                if (set.contains(board[n + count][j + count1])) {
                    break;
                }
                if (board[n + count][j + count1] != '.') {
                    set.add(board[n + count][j + count1]);
                }
                if ((count1 + 1) % 3 == 0 && (count + 1) % 3 == 0) {
                    j += 3;
                    count = 0;
                    count1 = 0;
                    set.clear();
                    continue;
                }
                else if ((count1 + 1) % 3 == 0) {
                    count++;
                    count1 = 0;
                    continue;
                }
                count1++;
            }
            if (j != col) {
                return false;
            }
            else {
                n += 3;
                count = 0;
            }
        }
        return true;
    }
    public static void main (String[] args) {
        char[][] board = {{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(board));
    }
}