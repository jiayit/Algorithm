package leetcode79;

import java.util.LinkedList;

class Solution {
    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        LinkedList<Character> list = null;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    list = new LinkedList<>();
                    boolean[][] visited = new boolean[row][col];
                    search(board, visited, i, j, word, list);
                    if (list.size() == word.length()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static void search (char[][] board, boolean[][] visited, int i, int j, String word, LinkedList<Character> list) {
        if (list.size() == word.length()) {
            return;
        }
        Character ch = word.charAt(list.size());
        if (board[i][j] == ch) {
            visited[i][j] = true;
            list.add(ch);
        }
        if (board[i][j] == ch || list.size() == 0) {
            if (i + 1 < board.length && !visited[i + 1][j]) {
                search(board, visited, i + 1, j, word, list);
            }
            if (j + 1 < board[0].length && !visited[i][j + 1]) {
                search(board, visited, i, j + 1, word, list);
            }
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                search(board, visited, i - 1, j, word, list);
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                search(board, visited, i, j - 1, word, list);
            }
        }
        if (list.size() == word.length()) {
            return;
        }
        if (visited[i][j]) {
            list.remove(list.size() - 1);
        }
    }
    public static boolean exist1(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[][] visited = new boolean[row][col];
                if (board[i][j] == word.charAt(0) && search(board, visited, i, j, word, 0)) {
                    return true;

                }
            }
        }
        return false;
    }
    public static boolean search (char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (search(board, visited, i + 1, j, word, index + 1) || search(board, visited, i - 1, j, word, index + 1)
                || search(board, visited, i, j + 1, word, index + 1) || search(board, visited, i, j - 1, word, index + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;

    }
    public static void main (String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board1 = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        char[][] board2 = {{'a','b'},{'c','d'}};
        String string = "bacd";
        System.out.println(exist1(board2, string));
    }
}
