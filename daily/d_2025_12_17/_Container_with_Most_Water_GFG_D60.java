package DSA_Diary.daily.d_2025_12_17;

public class _Container_with_Most_Water_GFG_D60 {
    static int maxWater(int[] arr) {
        int n =  arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int amount = Math.min(arr[i], arr[j])*(j-i);
                res = Math.max(amount, res);
            }
        }
        return res;
    }
    static int maxWater2(int[] arr) {
        int left = 0, right = arr.length - 1;
        int res = 0;
        while (left < right) {

            // find the water stored in the container between
            // arr[left] and arr[right]
            int water = Math.min(arr[left], arr[right]) * (right - left);
            res = Math.max(res, water);

            if (arr[left] < arr[right])
                left += 1;
            else
                right -= 1;
        }

        return res;
    }

}
