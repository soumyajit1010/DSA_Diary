package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Equals_Method;// Equals Method
// Difficulty: Basic | Accuracy: 85.74% | Submissions: 2K+ | Points: 1

// Given two integer arrays a[] and b[], you need to find if both the arrays 
// contain the same elements in the same order or not.

// Example 1:
// Input: a[] = [1, 2, 3, 4], b[] = [4, 3, 2, 1]
// Output: false
// Explanation: Both arrays are not same as they don't contain elements in the same order.

// Example 2:
// Input: a[] = [5, 6, 7, 8, 9], b[] = [5, 6, 7, 8, 9]
// Output: true
// Explanation: Both arrays are same as they contain the same elements and in same order.

// User function Template for Java
class Solution {
    public static boolean areEqual(int a[], int b[]) {
        // Check if lengths are different
        if (a.length != b.length)
            return false;

        // Compare each element
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }

        // All elements matched
        return true;
    }
}
