package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.BST_Tripling_2;/*
    ✅ Question:
    Given a Binary Search Tree (BST), and two integers n (number of nodes in BST) 
    and tripletSum, write a function to determine whether there exists a triplet 
    of nodes in the BST such that the sum of the values of the three nodes is equal 
    to tripletSum.

    ✔ Constraints:
    - The tree is a BST (left < root < right).
    - Use efficient approach (inorder + 3-pointer).
    - Return true if such a triplet exists, otherwise false.

    🔄 Example:
    Input:
         5
        / \
       3   7
      / \   \
     2   4   8
    n = 6, tripletSum = 15

    Output: true  (because 2 + 5 + 8 = 15)
*/

/*
class GfG {
    public static boolean findTriplet(Node root, int n, int tripletSum) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr); // Convert BST to sorted array

        // Try every triplet (i, left, right)
        for (int i = 0; i < arr.size() - 2; i++) {
            int left = i + 1;
            int right = arr.size() - 1;

            while (left < right) {
                int sum = arr.get(i) + arr.get(left) + arr.get(right);

                if (sum == tripletSum)
                    return true;
                else if (sum < tripletSum)
                    left++;
                else
                    right--;
            }
        }
        return false;
    }

    private static void inorder(Node root, List<Integer> arr) {
        if (root == null) return;
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }
}

 */