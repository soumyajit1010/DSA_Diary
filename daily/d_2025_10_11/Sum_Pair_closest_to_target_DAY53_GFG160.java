package DSA_Diary.daily.d_2025_10_11;

import java.util.ArrayList;
import java.util.Arrays;

public class Sum_Pair_closest_to_target_DAY53_GFG160 {

    public ArrayList<Integer> sumClosest(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();

        if (arr.length < 2) return result; // no pair possible

        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int a = -1, b = -1;

        while (l < r) {
            int sum = arr[l] + arr[r];
            int diff = Math.abs(target - sum);

            // 1️⃣ If found closer pair
            if (diff < minDiff) {
                minDiff = diff;
                a = arr[l];
                b = arr[r];
            }

            // 2️⃣ If same closeness, prefer max absolute difference pair
            else if (diff == minDiff) {
                if (Math.abs(arr[l] - arr[r]) > Math.abs(a - b)) {
                    a = arr[l];
                    b = arr[r];
                }
            }

            // 3️⃣ Move pointers
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else { // exact match
                break;
            }
        }

        if (a != -1) {
            result.add(a);
            result.add(b);
        }

        return result;

        /*
        ⚡ Time & Space Complexity
Time: O(n log n) (sorting + single pass)
Space: O(1) (constant extra space)
         */
    }

    public static void main(String[] args) {
        Sum_Pair_closest_to_target_DAY53_GFG160 obj = new Sum_Pair_closest_to_target_DAY53_GFG160();
        int[] arr = {5, 2, 7, 1, 4};
        int target = 10;
        System.out.println(obj.sumClosest(arr, target)); // [2, 7]
    }
}
