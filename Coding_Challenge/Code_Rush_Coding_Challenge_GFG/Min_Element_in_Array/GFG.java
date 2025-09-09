package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Min_Element_in_Array;/*
Min Element in Array  
Difficulty: Basic  
Given an array A[] of size n. The task is to find the smallest element in it.

Example 1:
Input: 
 n = 5
 A[] = {1,10,12,14,2} 
Output: 
 1

Example 2:
Input: 
 n = 4
 A[] = {100,10,1,14} 
Output: 
 1

Task:
Your task is to write a complete program which takes input of the array and then prints the minimum element in the array.
*/

import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input the size of the array
		int n = sc.nextInt();
		int[] A = new int[n];

		// Input array elements
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}

		// Find minimum element
		int min = A[0];
		for (int i = 1; i < n; i++) {
			if (A[i] < min) {
				min = A[i];
			}
		}

		// Output the result
		System.out.println(min);
	}
}
