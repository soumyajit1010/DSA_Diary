package DSA_Diary.daily.d_2025_11_26;

import java.util.Arrays;

public class Count_the_number_of_possible_triangles_GFG {

    /*
     =====================================================================
       ❓ PROBLEM STATEMENT – Count the number of possible triangles
       -------------------------------------------------------------------
       Given an integer array arr[], find the number of triangles that can
       be formed using 3 different array elements as sides.

       A triangle is valid only if:
            sum of any two sides > third side

       Example:
       Input:  arr = [4, 6, 3, 7]
       Output: 3
       Valid triangles → (3,4,6), (3,6,7), (4,6,7)

       -------------------------------------------------------------------
       ✔ Brute Force: O(n³)
       ✔ Better (Binary Search): O(n² log n)
       ✔ Optimal (Two Pointers): O(n²)
     =====================================================================
    */

    // ---------------------------------------------------------------
    // 1️⃣ BRUTE FORCE APPROACH — O(n³)
    // ---------------------------------------------------------------
    public int countTriangles(int arr[]) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (isPossible(arr[i], arr[j], arr[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // Triangle validity checker
    public boolean isPossible(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }


    // ---------------------------------------------------------------
    // 2️⃣ BETTER APPROACH — SORT + BINARY SEARCH (O(n² log n))
    // ---------------------------------------------------------------
    static int countTriangles2(int[] arr) {
        int res = 0;

        Arrays.sort(arr);  // sorting

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                int lo = j + 1, hi = arr.length;
                int target = arr[i] + arr[j];

                // Binary search to find max valid k
                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;

                    if (arr[mid] < target) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }

                // valid triangles count
                res += (lo - j - 1);
            }
        }
        return res;
    }


    // ---------------------------------------------------------------
    // 3️⃣ OPTIMAL APPROACH — TWO POINTERS (O(n²))
    // ---------------------------------------------------------------
    static int countTriangles3(int[] arr) {
        int res = 0;
        Arrays.sort(arr);

        // fix the largest side at arr[i]
        for (int i = 2; i < arr.length; i++) {

            int left = 0, right = i - 1;

            while (left < right) {

                if (arr[left] + arr[right] > arr[i]) {

                    // all pairs between left and right are valid
                    res += right - left;

                    right--;  // shrink from right
                } else {
                    left++;   // increase sum
                }
            }
        }
        return res;
    }

}
