package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Remove_Half_Nodes;/*
Problem: Remove Half Nodes
------------------------------------------
You are given a binary tree and you need to remove all the half nodes (which have only one child). 
Return the root node of the modified tree after removing all the half-nodes.

Note: A node is a half node if it has exactly one child. The output should be the inorder traversal 
of the resultant tree.

Examples:

Input: 
        5
       / \
      7   8
     / 
    2

Output: 2 5 8

Explanation: 
Node 7 is a half node (has only one child). So it is removed and its child 2 is linked to its parent. 
The final tree becomes: 2 <- 5 -> 8

Inorder traversal of the new tree: 2 5 8

Input:
       2
      / \
     7   5

Output: 7 2 5

Explanation:
No half node exists. So the tree remains unchanged.
*/

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    // Function to remove all half nodes from the binary tree
    public Node RemoveHalfNodes(Node root) {
        // Base case
        if (root == null) return null;

        // Recursively process left and right subtrees
        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);

        // If it's a half node with only left child
        if (root.left != null && root.right == null) {
            return root.left;
        }

        // If it's a half node with only right child
        if (root.left == null && root.right != null) {
            return root.right;
        }

        // If it's a full node or leaf, return it
        return root;
    }

    // Optional: Inorder traversal to verify result
    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// Optional: Driver code to test the function
class Main {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(7);
        root.right = new Node(8);
        root.left.left = new Node(2);

        Solution sol = new Solution();
        Node newRoot = sol.RemoveHalfNodes(root);

        // Print inorder traversal of the modified tree
        sol.inorder(newRoot);  // Output: 2 5 8
    }
}
