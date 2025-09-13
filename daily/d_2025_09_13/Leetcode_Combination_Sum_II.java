package DSA_Diary.daily.d_2025_09_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            f(0, candidates, target, res, new ArrayList<>());
            return res;
    }

    private void f(int i, int[]arr, int t, List<List<Integer>> res, List<Integer> ds){
            if(t==0){
                    res.add(new ArrayList<>(ds));
                    return;
            }

            for (int j = 0; j < arr.length; j++) {
                    if (j>i&&arr[j]==arr[j-1]){
                            continue;
                    }
                    if (arr[j]>t){
                            break;
                    }
                    ds.add(arr[j]);
                    f(i+1, arr, t-arr[j], res, ds);
                    ds.remove(ds.size()-1);
            }
    }
}
