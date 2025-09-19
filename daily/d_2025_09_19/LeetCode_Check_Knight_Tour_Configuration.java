package DSA_Diary.daily.d_2025_09_19;

/*
2596. Check Knight Tour Configuration
Medium

There is a knight on an n x n chessboard. In a valid configuration, the knight
starts at the top-left cell of the board and visits every cell on the board
exactly once.

You are given an n x n integer matrix `grid` consisting of distinct integers
from the range [0, n * n - 1] where grid[row][col] indicates that the cell
(row, col) is the grid[row][col]-th cell that the knight visited. The moves
are 0-indexed.

Return true if grid represents a valid configuration of the knight's movements
or false otherwise.

A valid knight move consists of moving two squares vertically and one square
horizontally, or two squares horizontally and one square vertically (i.e. the
eight L-shaped moves).

Examples:

Example 1:
Input:
grid = [
  [0,11,16, 5,20],
  [17,4,19,10,15],
  [12,1, 8,21, 6],
  [3,18,23,14, 9],
  [24,13, 2, 7,22]
]
Output: true
Explanation: The grid can be followed step by step with valid knight moves starting at (0,0).

Example 2:
Input:
grid = [
  [0,3,6],
  [5,8,1],
  [2,7,4]
]
Output: false
Explanation: Some consecutive moves are not valid knight moves.

Constraints:
- n == grid.length == grid[i].length
- 1 <= n <= 25
- 0 <= grid[i][j] < n * n
- All values in grid are distinct.

Hint / Notes:
- One easy approach: precompute the (row,col) coordinates for each step value 0..n*n-1,
  then verify for each k from 0 to n*n-2 that the move from position of k to position
  of k+1 is a valid knight move (|dr|,|dc|) == (1,2) or (2,1).
*/
public class LeetCode_Check_Knight_Tour_Configuration {

    // Recursive approach
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;  // must start at (0,0)
        return function(grid, 0, 0, 0);
    }

    public boolean function(int[][] grid, int r, int c, int count) {
        if (count == grid.length * grid.length - 1) {
            return true; // visited all cells
        }

        int nextR = -1, nextC = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == count + 1) { // look for next number
                    nextR = i;
                    nextC = j;
                }
            }
        }

        int dx = Math.abs(r - nextR);
        int dy = Math.abs(c - nextC);

        if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) return false;

        return function(grid, nextR, nextC, count + 1);
    }
/*
✅ So the final complexity is:
Time: O(n^4)
Space: O(n²)
 */




    // iterative approach
    public boolean checkValidGrid2(int[][] grid) {
        int n = grid.length;

        // Step 1: Start check
        if (grid[0][0] != 0) return false;

        // Step 2: Precompute positions
        int[][] pos = new int[n * n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = grid[i][j];
                pos[k][0] = i; // row
                pos[k][1] = j; // col
            }
        }

        // Step 3: Verify knight moves
        for (int k = 0; k < n * n - 1; k++) {
            int r1 = pos[k][0], c1 = pos[k][1];
            int r2 = pos[k + 1][0], c2 = pos[k + 1][1];

            int dx = Math.abs(r1 - r2);
            int dy = Math.abs(c1 - c2);

            // Step 4: check knight condition
            if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) {
                return false;
            }
        }

        // Step 5: all moves valid
        return true;
    }
    /*
TC: O(n²)
SC: O(n²)
     */

}


/*
public boolean checkValidGrid(int[][] grid) {
        boolean[][] board = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                board[i][j] = false;
            }
        }
        board[0][0] = true;
        function(board, 0, 0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void function(boolean[][] board, int r, int c) {

        if (board[r+2][c+1]==false){
            board[r+2][c+1]=true;
            function(board, r+2, c+1);
            board[r+2][c+1]=false;
        }
        else if (board[r+1][c+2]==false){
            board[r+1][c+2]=true;
            function(board, r+1, c+2);
            board[r+1][c+2]=false;
        }
        else if (board[r-1][c-2]==false){
            board[r-1][c-2]=true;
            function(board, r-1, c-2);
            board[r-1][c-2]=false;
        }
        else if (board[r-1][c-2]==false){
            board[r-1][c-2]=true;
            function(board, r-1, c-2);
            board[r-1][c-2]=false;
        }else {
            return;
        }

    }

 */