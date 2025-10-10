package DSA_Diary.daily.d_2025_10_10;

import Practice.zzz.Generics_Collections_Revise222.Pair;

import java.util.Arrays;

public class Count_Pairs_whose_sum_is_less_than_target_DAY52_GFG160 {

    //[Naive Approach] - By Generating all the pairs- O(n^2) Time and O(1) Space
    int countPairs(int arr[], int target) {
        // Your code here
        int c=0;

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]+arr[j]<target){
                    c++;
                }
            }
        }

        return c;
// not optimal  tc=O(n^2)  sc=O(1)
    }


//[Better Approach] - Using Binary Search - O(2*nlogn) Time and O(1) Space
    static int binarySearch(int[] arr, int complement) {
        int lo = 0, hi = arr.length - 1;
        int res = arr.length;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] >= complement) {
                res = mid;
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return res;
    }


    int countPairs2(int arr[], int target) {
        Arrays.sort(arr);
        int c=0;
        for (int i = 0; i < arr.length; i++) {
            int com=target-arr[i];
            int ind = binarySearch(arr, com);
            c+=ind;
            if (ind>i){
                c--;
            }

        }
        return c/2;
    }


    //[Expected Approach] - Using Two Pointers Technique - O(n*logn+n) Time and O(1) Space
    static int countPairs3(int[] arr, int target) {

        // Sort the array to use two pointer technique
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int cnt = 0;

        // Two pointer technique
        while (left < right) {
            int sum = arr[left] + arr[right];

            // If the sum is less than target, then arr[left]
            // will form a valid pair with every element
            // from index left + 1 to right.
            if (sum < target) {
                cnt += right - left;
                left++;
            }
            else {
                right--;
            }
        }

        return cnt;
    }




}


