package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.TreeSet_Operations;// Question:
// You are given an integer array arr[]. You need to insert the elements of arr into a TreeSet and display the results. 
// Also, you need to erase a given element x from the TreeSet and print "erased x" if successfully erased, else print "not found".
// Note: Don't add a new line in any function.

// Example Input 1: arr[] = [9, 8, 7, 4, 4, 2, 1, 1, 9, 8], x = 1
// Output:
// 1 2 4 7 8 9
// erased 1
// 2 4 7 8 9

// Example Input 2: arr[] = [4, 2, 3, 3], x = 1
// Output:
// 2 3 4
// not found
// 2 3 4

import java.util.*;

class Solution {
    
    // Inserts elements of the array into a TreeSet and returns the TreeSet
    public static TreeSet<Integer> insert(int arr[]) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return set;
    }

    // Displays the elements of the TreeSet in ascending order without newline
    public static void display(TreeSet<Integer> s) {
        for (int num : s) {
            System.out.print(num + " ");
        }
    }

    // Erases x from the TreeSet. Prints "erased x" if successful, else prints "not found"
    public static void erase(TreeSet<Integer> s, int x) {
        if (s.contains(x)) {
            s.remove(x);
            System.out.print("erased " + x);
        } else {
            System.out.print("not found");
        }
    }
}
