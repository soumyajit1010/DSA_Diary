package DSA_Diary.daily.d_2025_10_17;/*
LeetCode 274. H-Index
----------------------
Given an array of integers citations where citations[i] is the number of citations 
a researcher received for their ith paper, return the researcher's h-index.

Definition:
The h-index is defined as the maximum value h such that the researcher has published 
at least h papers that have each been cited at least h times.

Example:
Input: citations = [3,0,6,1,5]
Output: 3

Time Complexity: O(n log n)  // due to sorting
Space Complexity: O(1)
*/

import java.util.*;

public class H_Index_LeetCode274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations); // sort ascending
        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {
            int papers = n - i; // number of papers with >= citations[i]
            if (citations[i] >= papers) {
                h = papers;
                break;
            }
        }

        return h;
    }
}
