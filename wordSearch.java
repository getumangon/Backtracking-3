// Word Search(https://leetcode.com/problems/word-search/)

// Time Complexity: O(mn*3^L) // L is len of string of depth of the tree
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


public class wordSearch {
    static private int[][] dirs;
    static int m;
    static int n;

    public static boolean exist(char[][] board, String word) {
        // null
        if (board == null || board.length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (backtrack(board, i, j, word, 0))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, int i, int j, String word, int index) {
        // base
        if (index == word.length())
            return true;
        if (i < 0 || j < 0 || i == m || j == n || board[i][j] == '#')
            return false;

        // logic
        if (board[i][j] == word.charAt(index)) {
            for (int[] dir : dirs) {
                int r = i + dir[0];
                int c = j + dir[1];

                // action
                board[i][j] = '#';

                // recurse
                if (backtrack(board, r, c, word, index + 1))
                    return true;

                // backtrack
                board[i][j] = word.charAt(index);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println((exist(board, word)));
        // output: true
    }
}
