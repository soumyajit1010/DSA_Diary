package DSA_Diary.daily.d_2025_09_14;

import java.util.ArrayList;
import java.util.List;
// https://takeuforward.org/plus/dsa/problems/subsets-i

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
