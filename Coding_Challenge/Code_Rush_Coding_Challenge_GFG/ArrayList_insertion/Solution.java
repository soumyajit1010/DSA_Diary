package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.ArrayList_insertion;// Question:
// ArrayList insertion
// Difficulty: Basic     Accuracy: 76.48%     Submissions: 7K+     Points: 1
//
// Given an array arr[] containing integers. 
// The task is to insert elements of the given array into an ArrayList and return that ArrayList.
//
// Examples:
// Input: arr[] = [1, 2, 3, 4]
// Output: 1 2 3 4
// Explanation: Simply insert into ArrayList and return it.
//
// Input: arr[] = [3, 2, 1]
// Output: 3 2 1 
// Explanation: Simply insert into ArrayList and return it.

import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> fillArrayList(int arr[]) {
        // Your code here
        ArrayList<Integer> array = new ArrayList<>();
        for (int i : arr) {
            array.add(i); // Inserting each element into the ArrayList
        }
        return array;
    }
}
