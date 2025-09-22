package DSA_Diary.daily.d_2025_09_22;

import java.util.ArrayList;
import java.util.*;

/*
Rat in a Maze Problem - I
Difficulty: Medium
---------------------------------
Consider a rat placed at position (0, 0) in an n x n square matrix mat[][].
The rat's goal is to reach the destination at position (n-1, n-1).
The rat can move in four possible directions: 'U'(up), 'D'(down), 'L'(left), 'R'(right).

The matrix contains only two possible values:
0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.

Your task is to find all possible paths the rat can take to reach the destination,
starting from (0, 0) and ending at (n-1, n-1), under the condition that
the rat cannot revisit any cell along the same path. Furthermore, the rat can
only move to adjacent cells that are within the bounds of the matrix and not blocked.

If no path exists, return an empty list.
Return the final result list in lexicographically smallest order.

---------------------------------
Examples:

Input:
mat[][] = [[1, 0, 0, 0],
           [1, 1, 0, 1],
           [1, 1, 0, 0],
           [0, 1, 1, 1]]

Output: ["DDRDRR", "DRDDRR"]

Explanation:
The rat can reach the destination at (3, 3) from (0, 0) by two paths:
DRDDRR and DDRDRR. Sorted order gives DDRDRR, DRDDRR.


Input:
mat[][] = [[1, 0],
           [1, 0]]

Output: []

Explanation:
No path exists as the destination cell is blocked.


Input:
mat = [[1, 1, 1],
       [1, 0, 1],
       [1, 1, 1]]

Output: ["DDRR", "RRDD"]
---------------------------------
*/
public class Rat_in_a_Maze_Problem {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        int[][] vis = new int[n][n];

        if (m[0][0] == 1) {
            solve(0, 0, m, n, ans, "", vis);
        }

        Collections.sort(ans); // ensure lexicographic order
        return ans;
    }

    private static void solve(int i, int j, int[][] a, int n,
                              ArrayList<String> ans, String move, int[][] vis) {
        // base case: destination reached
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        // mark visited
        vis[i][j] = 1;

        // Down
        if (i + 1 < n && vis[i + 1][j] == 0 && a[i + 1][j] == 1) {
            solve(i + 1, j, a, n, ans, move + "D", vis);
        }

        // Left
        if (j - 1 >= 0 && vis[i][j - 1] == 0 && a[i][j - 1] == 1) {
            solve(i, j - 1, a, n, ans, move + "L", vis);
        }

        // Right
        if (j + 1 < n && vis[i][j + 1] == 0 && a[i][j + 1] == 1) {
            solve(i, j + 1, a, n, ans, move + "R", vis);
        }

        // Up
        if (i - 1 >= 0 && vis[i - 1][j] == 0 && a[i - 1][j] == 1) {
            solve(i - 1, j, a, n, ans, move + "U", vis);
        }

        // backtrack
        vis[i][j] = 0;
    }

    // Driver code for testing
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        int n = mat.length;

        ArrayList<String> paths = findPath(mat, n);
        System.out.println(paths); // Output: [DDRDRR, DRDDRR]
    }


    private static void solve2(int i, int j, int[][] a, int n,
                               ArrayList<String> ans, String move,
                               int[][] vis, int[] di, int[] dj, char[] dir) {
        // base case
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        // explore all 4 directions
        for (int ind = 0; ind < 4; ind++) {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];

            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n &&
                    vis[nexti][nextj] == 0 && a[nexti][nextj] == 1) {

                vis[i][j] = 1;
                solve2(nexti, nextj, a, n, ans, move + dir[ind], vis, di, dj, dir);
                vis[i][j] = 0; // backtrack
            }
        }
    }

    public static ArrayList<String> findPath2(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        int[][] vis = new int[n][n];

        // movement arrays for D, L, R, U
        int[] di = {+1, 0, 0, -1};
        int[] dj = {0, -1, +1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};

        if (m[0][0] == 1) {
            solve2(0, 0, m, n, ans, "", vis, di, dj, dir);
        }

        Collections.sort(ans); // sort lexicographically
        return ans;
    }
}



