// Subsets (https://leetcode.com/problems/subsets/)

// Time Complexity: O(n!)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

import java.util.ArrayList;
import java.util.List;

public class nQueens {
    static List<List<String>> res;

    public static List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        res = new ArrayList<List<String>>();
        backtracking(board, 0, n);
        return res;
    }
    
    private static void backtracking(boolean[][] board, int row, int n) {
        // base
        if(row == n) {
            List<String> li = new ArrayList<>();
            
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(board[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            res.add(li);
            return;
        }
        
        // logic
        for(int j = 0; j < n; j++) {
            if(isValidPlace(board, row, j, n)){
                //action
                board[row][j] = true;

                // recurse
                backtracking(board, row + 1, n);

                // backtrack
                board[row][j] = false;
            }
        }
    }
    
    private static boolean isValidPlace(boolean[][] board, int row, int col, int n) {
        // Up Col
        for(int i = 0; i < row; i++) {
            if(board[i][col]) return false;
        }
        
        // up left
        int i = row, j = col;
        while(i >= 0 && j >= 0) {
            if(board[i][j]) return false;
            i--; j--;
        }
        
        // up right
        i = row; j = col;
        while(i >= 0 && j < n) {
            if(board[i][j]) return false;
            i--; j++;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println((solveNQueens(n)));
        // output: [[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]
    }
}
