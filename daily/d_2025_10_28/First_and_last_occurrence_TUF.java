package DSA_Diary.daily.d_2025_10_28;

/*
🧩 Problem: First and Last Occurrence

Given an array of integers nums sorted in non-decreasing order,
find the starting and ending position of a given target value.

If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5, 7, 7, 8, 8, 10], target = 8
Output: [3, 4]

Example 2:
Input: nums = [5, 7, 7, 8, 8, 10], target = 6
Output: [-1, -1]

🔹 Approach:
Use binary search twice:
1️⃣ Find the first occurrence of target.
2️⃣ Find the last occurrence of target.
This ensures an O(log n) optimized solution.

🔹 Time Complexity: O(log n)
🔹 Space Complexity: O(1)
*/

public class First_and_last_occurrence_TUF {
    public int[] searchRange(int[] nums, int target) {
        int res[] = {-1, -1};
        // Find first occurrence
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res[0] = i;
                break;
            }
        }
        // Find last occurrence
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == target) {
                res[1] = j;
                break;
            }
        }
        return res;
    }


    public int[] searchRange2(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        // if target not found
        if (lb == nums.length || nums[lb] != target)
            return new int[]{-1, -1};
        int ub = upperBound(nums, target);
        return new int[]{lb, ub - 1};
    }

    public int lowerBound(int[] nums, int b) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = n; // default to n if no element >= b is found
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= b) {
                ans = mid;     // possible answer found
                high = mid - 1; // look on left side for smaller index
            } else {
                low = mid + 1; // move right
            }
        }
        return ans;
    }

    public int upperBound(int[] nums, int a) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = n; // default to n if no element > a is found
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > a) {
                ans = mid;       // possible upper bound found
                high = mid - 1;  // search on left side for smaller index
            } else {
                low = mid + 1;   // search on right side
            }
        }
        return ans;
    }



    // Function to find first occurrence
    public static int firstOccurrence(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int first = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == k) {
                first = mid;     // possible first occurrence
                high = mid - 1;  // move left to find earlier occurrence
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    // Function to find last occurrence
    public static int lastOccurrence(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int last = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == k) {
                last = mid;      // possible last occurrence
                low = mid + 1;   // move right to find later occurrence
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    // Function to get both first and last occurrence
    public static int[] firstAndLastPosition(int[] arr, int k) {
        int first = firstOccurrence(arr, k);
        if (first == -1) return new int[]{-1, -1};

        int last = lastOccurrence(arr, k);
        return new int[]{first, last};
    }
    /*
    Time Complexity: O(log n)
Space Complexity: O(1)
     */
}
