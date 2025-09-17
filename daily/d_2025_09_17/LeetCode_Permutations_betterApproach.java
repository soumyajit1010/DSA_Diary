package DSA_Diary.daily.d_2025_09_17;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_Permutations_betterApproach {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0, nums, ans);
        return ans;
    }

    private void f(int ind, int[]nums, List<List<Integer>> ans){
        List<Integer> ds = new ArrayList<>();
        if (ind== nums.length) {
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = ind; i < nums.length; i++) {
            swap(i, ind, nums);
            f(ind+1, nums, ans);
            swap(i, ind, nums);
        }
    }
    private void swap(int i, int j, int[]nums){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
