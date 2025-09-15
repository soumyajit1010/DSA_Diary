package DSA_Diary.daily.d_2025_09_14;

import java.util.ArrayList;
import java.util.List;
// https://takeuforward.org/plus/dsa/problems/subsets-i
/*
Subsets I
Medium
Given an array nums of n integers. Return array of sum of all subsets of the array nums.
Output can be returned in any order.
Examples:
Input : nums = [2, 3]
Output : [0, 2, 3, 5]

Explanation :
When no elements is taken then Sum = 0.
When only 2 is taken then Sum = 2.
When only 3 is taken then Sum = 3.
When element 2 and 3 are taken then sum = 2+3 = 5.

Input : nums = [5, 2, 1]
Output : [0, 1, 2, 3, 5, 6, 7, 8]

Explanation :
When no elements is taken then Sum = 0.
When only 5 is taken then Sum = 5.
When only 2 is taken then Sum = 2.
When only 1 is taken then Sum = 1.
When element 2 and 1 are taken then sum = 2+1 = 3.
 */

public class TakeUforward_SubsetSum_I {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};

        System.out.println(subsetSums(nums));
    }

    public static List<Integer> subsetSums(int[] nums) {
        //your code goes here
        List<Integer> list = new ArrayList<>();
        f(0, nums.length, 0, list, nums);
        return list;

    }
    public static void f(int i, int n, int sum, List<Integer> list, int[] nums){
        // ✅ Base condition: if we've considered all elements
        if (i == n) {
            list.add(sum);
            return;
        }

        // take current element
        f(i + 1, n, sum + nums[i], list, nums);

        // not take current element
        f(i + 1, n, sum, list, nums);
    }

}
