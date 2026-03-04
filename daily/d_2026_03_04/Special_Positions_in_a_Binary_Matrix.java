package DSA_Diary.daily.d_2026_03_04;/*
LeetCode 1582. Special Positions in a Binary Matrix
Difficulty: Easy

Problem:
Given an m x n binary matrix mat, return the number of special positions.

A position (i, j) is called special if:
1. mat[i][j] == 1
2. All other elements in row i are 0
3. All other elements in column j are 0

Rows and columns are 0-indexed.

Example 1:
Input:
mat = [[1,0,0],
       [0,0,1],
       [1,0,0]]

Output: 1

Explanation:
(1,2) is special because mat[1][2] = 1 and all other elements
in row 1 and column 2 are 0.

Example 2:
Input:
mat = [[1,0,0],
       [0,1,0],
       [0,0,1]]

Output: 3

Explanation:
(0,0), (1,1), and (2,2) are special positions.
*/


// -----------------------------------------------------------
// APPROACH 1 : Brute Force (Check Row and Column for each 1)
// -----------------------------------------------------------

/*
Idea:
For every cell that contains 1:
1. Check if all other elements in that row are 0.
2. Check if all other elements in that column are 0.

If both conditions are satisfied → special position.

Time Complexity: O(m * n * (m + n))
Space Complexity: O(1)
*/

class Special_Positions_in_a_Binary_Matrix {

    public int numSpecial(int[][] mat) {

        int count = 0;

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){

                if(mat[i][j] == 1 && rowCheck(mat,i,j) && colCheck(mat,i,j)){
                    count++;
                }

            }
        }

        return count;
    }

    private boolean rowCheck(int[][] mat,int i,int j){

        for(int col = 0; col < mat[i].length; col++){

            if(col == j) continue;

            if(mat[i][col] == 1) return false;
        }

        return true;
    }

    private boolean colCheck(int[][] mat,int i,int j){

        for(int row = 0; row < mat.length; row++){

            if(row == i) continue;

            if(mat[row][j] == 1) return false;
        }

        return true;
    }
}



// -----------------------------------------------------------
// APPROACH 2 : Row Count + Column Count (Optimized)
// -----------------------------------------------------------

/*
Idea:
Instead of checking rows and columns repeatedly:

1. Count number of 1s in each row.
2. Count number of 1s in each column.
3. A cell is special if:
   mat[i][j] == 1
   rowCount[i] == 1
   colCount[j] == 1

Time Complexity: O(m * n)
Space Complexity: O(m + n)
*/

class Special_Positions_in_a_Binary_Matrix1 {

    public int numSpecial(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(mat[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                }

            }
        }

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1){
                    count++;
                }

            }
        }

        return count;
    }
}



// -----------------------------------------------------------
// APPROACH 3 : Optimized Without Extra Space (Editorial Trick)
// -----------------------------------------------------------

/*
Idea:
Use the first row to store column counts.

Steps:
1. Count rows with exactly one '1'.
2. Use first row to track column frequency.
3. Count valid positions.

Time Complexity: O(m * n)
Space Complexity: O(1)
*/

class Special_Positions_in_a_Binary_Matrix2 {

    public int numSpecial(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int result = 0;

        int[] col = new int[n];

        for(int i = 0; i < m; i++){

            int ones = 0;
            int colIndex = -1;

            for(int j = 0; j < n; j++){

                if(mat[i][j] == 1){
                    ones++;
                    colIndex = j;
                }

            }

            if(ones == 1){
                col[colIndex]++;
            }
        }

        for(int j = 0; j < n; j++){

            if(col[j] == 1){
                result++;
            }

        }

        return result;
    }
}