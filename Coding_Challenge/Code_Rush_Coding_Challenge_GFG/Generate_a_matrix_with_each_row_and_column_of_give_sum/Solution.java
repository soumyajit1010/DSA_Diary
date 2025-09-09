package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Generate_a_matrix_with_each_row_and_column_of_give_sum;/*
Generate a matrix with each row and column of given sum
Difficulty: Easy
Accuracy: 84.53%
Points: 2

Given two integer arrays rowSum[] of size n and colSum[] of size m, 
construct a 2D matrix of size n × m such that:
- Sum of matrix elements in i-th row = rowSum[i]
- Sum of matrix elements in j-th column = colSum[j]

Note: Multiple answers are possible, return any one of them.
It is guaranteed that an answer always exists.

Example 1:
Input: rowSum[] = [5, 7, 10], colSum[] = [8, 6, 8]
Output: true
Explanation: One possible matrix:
[[0, 5, 0],
 [6, 1, 0],
 [2, 0, 8]]

Example 2:
Input: rowSum[] = [1, 0], colSum[] = [1]
Output: true
Explanation: One possible matrix:
[[1],
 [0]]

Expected Time Complexity: O(n * m)
Expected Auxiliary Space: O(n * m)
*/

class Solution {
    public int[][] generateMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] matrix = new int[n][m];
        
        int i = 0, j = 0;
        while (i < n && j < m) {
            int val = Math.min(rowSum[i], colSum[j]);
            matrix[i][j] = val;
            rowSum[i] -= val;
            colSum[j] -= val;

            // Move to next row or column when sum becomes 0
            if (rowSum[i] == 0) {
                i++;
            }
            if (colSum[j] == 0) {
                j++;
            }
        }
        
        return matrix;
    }
}

/*
Time Complexity: O(n * m)  — we may visit each cell at most once
Space Complexity: O(n * m) — for storing the output matrix
*/
