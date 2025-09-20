package DSA_Diary.daily.d_2025_09_20;

import java.util.Arrays;

public class LeetCode_88_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x=0;
        for(int i=m; i<m+n; i++){
            nums1[i]=nums2[x];
            x++;
        }
        Arrays.sort(nums1);

    }//not Optimal


    public void merge_Optimal(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       // last index of nums1's valid elements
        int j = n - 1;       // last index of nums2
        int k = m + n - 1;   // last index of nums1 (total size)

        // merge nums1 and nums2 from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // copy remaining nums2 elements (if any)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
