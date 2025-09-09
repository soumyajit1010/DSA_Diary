package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Difference_between_highest_and_lowest_occurrence_OldP;/*
Difference between highest and lowest occurrence OldP
Difficulty: Basic
Accuracy: 85.71%

Given an array, find the difference between the highest occurrence
and lowest occurrence count of any number in the array.

Input:
The first line of input contains an integer T (number of test cases).
Each test case consists of:
- An integer N (size of array)
- N space-separated integers (array elements)

Output:
For each test case, print the difference in a new line.

Constraints:
1 <= T <= 100
1 <= N <= 10^5
1 <= A[i] <= 10^5

Example:
Input:
2
3
1 2 2
6
1 2 2 3 3 3
Output:
1
2

Time Complexity:
- Counting frequencies: O(N)
- Finding min and max frequency: O(K) where K ≤ N
Overall: O(N) per test case

Space Complexity: O(K) for frequency map
*/

import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            Map<Integer, Integer> freqMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                int num = sc.nextInt();
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            int maxFreq = Integer.MIN_VALUE;
            int minFreq = Integer.MAX_VALUE;

            for (int freq : freqMap.values()) {
                if (freq > maxFreq) maxFreq = freq;
                if (freq < minFreq) minFreq = freq;
            }

            System.out.println(maxFreq - minFreq);
        }

        sc.close();
    }
}
