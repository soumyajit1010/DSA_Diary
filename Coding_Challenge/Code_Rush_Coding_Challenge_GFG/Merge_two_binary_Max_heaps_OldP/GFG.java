package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Merge_two_binary_Max_heaps_OldP;/*
Merge two binary Max heaps OldP
Difficulty: Easy
Accuracy: 28.02%
Points: 2

Given two binary max heaps as arrays, merge the given heaps:
1. First, append all elements of the first heap, then all elements of the second heap into one array.
2. Then, rearrange the combined array so it satisfies the Max Heap property.

Input:
First line: T (number of test cases)
For each test case:
    First line: N M (sizes of two heaps)
    Second line: N integers (max heap 1)
    Third line: M integers (max heap 2)

Output:
Print the merged max heap in array representation.

Constraints:
1 <= T <= 100
1 <= N, M <= 100

Example:
Input:
1
4 3
10 5 6 2
12 7 9
Output:
12 10 9 2 5 7 6

Explanation:
Merged array before heapify: [10, 5, 6, 2, 12, 7, 9]
After building max heap: [12, 10, 9, 2, 5, 7, 6]

Expected Time Complexity: O((N + M) log(N + M))
Expected Space Complexity: O(1) (in-place heapify)
*/

import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] arr1 = new int[N];
            int[] arr2 = new int[M];

            for (int i = 0; i < N; i++) arr1[i] = sc.nextInt();
            for (int i = 0; i < M; i++) arr2[i] = sc.nextInt();

            // Step 1: Merge arrays
            int[] merged = new int[N + M];
            System.arraycopy(arr1, 0, merged, 0, N);
            System.arraycopy(arr2, 0, merged, N, M);

            // Step 2: Build max heap
            buildMaxHeap(merged);

            // Step 3: Print result
            for (int val : merged) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    // Function to build max heap
    private static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        // Start from last non-leaf node and heapify each
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // Heapify a subtree rooted at index i
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}

/*
Time Complexity:
- Merging two arrays: O(N + M)
- Building a max heap: O(N + M)  (heapify from bottom up is linear)
Overall: O(N + M)

Space Complexity:
- O(1) extra space (heap built in-place, ignoring input storage)
*/
