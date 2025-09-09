package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.ArrayList_Operations;/*
Question:
ArrayList Operations
Difficulty: Basic | Accuracy: 76.48% | Submissions: 7K+ | Points: 1

You are given an empty ArrayList and some queries. Each query will be of the following types:

'a x' : Add x to the ArrayList
'b'   : Sort the ArrayList in ascending order
'c'   : Reverse the ArrayList
'd'   : Print the size of the ArrayList
'e'   : Sort the ArrayList in descending order
'f'   : Print the ArrayList

Example Input:
a 4 a 7 a 6 b c e

Output:
7 6 4

Explanation:
Insert 4, 7, 6 → List becomes [4, 7, 6]
Sort ascending → [4, 6, 7]
Reverse → [7, 6, 4]
Sort descending → [7, 6, 4]
Print → 7 6 4
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {

    // Add element x to the ArrayList
    public static void add_to_ArrayList(ArrayList<Integer> A, int x) {
        A.add(x);
    }

    // Sort ArrayList in ascending order
    public static void sort_ArrayList_Asc(ArrayList<Integer> A) {
        Collections.sort(A);
    }

    // Reverse the ArrayList
    public static void reverse_ArrayList(ArrayList<Integer> A) {
        Collections.reverse(A);
    }

    // Return the size of the ArrayList
    public static int size_Of_ArrayList(ArrayList<Integer> A) {
        return A.size();
    }

    // Sort the ArrayList in descending order using Comparator
    public static void sort_ArrayList_Desc(ArrayList<Integer> A) {
        Collections.sort(A, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
    }

    // Print the ArrayList elements in one line
    public static void print_ArrayList(ArrayList<Integer> A) {
        for (int i : A) {
            System.out.print(i + " ");
        }
    }
}
