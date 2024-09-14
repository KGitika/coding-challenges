// Problem: Path Sum
// URL: https://leetcode.com/problems/path-sum/

//Brute Force Approach-
    // Time complexity: O(n);
    // Space Complexity: O(n);


class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: if the tree is empty, there's no path
        if (root == null) return false;

        // Check if it's a leaf node and if the path sum equals targetSum
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }

        // Recursively check left and right subtrees, reducing the targetSum
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        return left || right; // Return true if any subtree has the path
    }
}
