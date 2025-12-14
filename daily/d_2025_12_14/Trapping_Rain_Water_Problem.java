package DSA_Diary.daily.d_2025_12_14;

public class Trapping_Rain_Water_Problem {
    static int maxWater(int[] arr) {
        int res = 0;

        for (int i = 1; i < arr.length; i++) {
            int left = arr[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[i]);
            }
            int right = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                right = Math.max(right, arr[j]);
            }
            res += Math.min(left, right) - arr[i];
        }
        return res;
    }

    static int maxWater2(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int res = 0;

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            int minOf2 = Math.min(left[i], right[i]);
            res += minOf2 - arr[i];
        }
        return res;

    }

    static int maxWater3(int[] arr) {
        int left = 1;
        int right = arr.length - 2;

        // lMax : Maximum in subarray arr[0..left-1]
        // rMax : Maximum in subarray arr[right+1..n-1]
        int lMax = arr[left - 1];
        int rMax = arr[right + 1];

        int res = 0;
        while (left <= right) {

            // If rMax is smaller, then we can decide
            // the amount of water for arr[right]
            if (rMax <= lMax) {

                // Add the water for arr[right]
                res += Math.max(0, rMax - arr[right]);

                // Update right max
                rMax = Math.max(rMax, arr[right]);

                // Update right pointer as we have decided the amount of water for this
                right -= 1;
            } else {

                // Add the water for arr[left]
                res += Math.max(0, lMax - arr[left]);

                // Update left max
                lMax = Math.max(lMax, arr[left]);

                // Update left pointer as we have
                // decided water for this
                left += 1;
            }
        }
        return res;
    }

}
