package DSA_Diary.daily.d_2026_01_28;/*
Q2. How Many Numbers Are Smaller Than the Current Number

Problem Statement:
Given an integer array nums, for each element nums[i], count how many numbers
in the array are smaller than nums[i]. The index j must satisfy j != i and
nums[j] < nums[i].

Return an array ans where ans[i] is the count of numbers smaller than nums[i].

Example:
Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
*/

class Smaller_than_current_number {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int l = nums.length;        // length of input array
        int ans[] = new int[l];     // output array to store result

        int x = 0;                  // index for ans array

        // Outer loop: pick each element nums[i]
        for (int i = 0; i < l; i++) {
            int count = 0;          // count of smaller elements for nums[i]

            // Inner loop: compare nums[i] with every nums[j]
            for (int j = 0; j < l; j++) {

                // if nums[j] is smaller than nums[i], increment count
                if (nums[i] > nums[j])
                    count++;
            }

            // store count in answer array
            ans[x] = count;
            x++;
        }

        return ans;                 // return final result array
    }
}
