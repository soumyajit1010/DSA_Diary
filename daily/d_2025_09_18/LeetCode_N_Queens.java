package DSA_Diary.daily.d_2025_09_18;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, board, res, n);
        return res;
    }

    private void solve(int col, char[][] board, List<List<String>> res, int n) {
        if (col == n) {
            res.add(construct(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, res, n);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {
        int r = row, c = col;

        // upper-left diagonal
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false;
            r--;
            c--;
        }

        // left side
        r = row;
        c = col;
        while (c >= 0) {
            if (board[r][c] == 'Q') return false;
            c--;
        }

        // lower-left diagonal
        r = row;
        c = col;
        while (r < n && c >= 0) {
            if (board[r][c] == 'Q') return false;
            r++;
            c--;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
