// Problem: Flip Equivalent Binary Trees
// URL: https://leetcode.com/flip-equivalent-binary-trees/

// Approach 1:Recursion (Top-down Traversal)

class Solution {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Both trees are empty
        if (root1 == null && root2 == null) {
            return true;
        }
        // Just one of the trees is empty
        if (root1 == null || root2 == null) {
            return false;
        }
        // Corresponding values differ
        if (root1.val != root2.val) {
            return false;
        }

        // Check if corresponding subtrees are flip equivalent
        boolean noSwap =
            flipEquiv(root1.left, root2.left) &&
            flipEquiv(root1.right, root2.right);
        // Check if opposite subtrees are flip equivalent
        boolean swap =
            flipEquiv(root1.left, root2.right) &&
            flipEquiv(root1.right, root2.left);

        return noSwap || swap;
    }
}


// Approach 2: Iterative DFS (using a Stack)
class Solution {

    // Checks whether the given pair of nodes should be examined -
    // be pushed into the stack
    public boolean checkNodeValues(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (
            node1 != null && node2 != null && node1.val == node2.val
        ) return true;
        return false;
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Initialize stack to store pairs of nodes
        Stack<TreeNode[]> nodePairStack = new Stack<>();
        nodePairStack.push(new TreeNode[] { root1, root2 });

        // While the stack is not empty:
        while (!nodePairStack.isEmpty()) {
            TreeNode[] current = nodePairStack.pop();
            TreeNode node1 = current[0];
            TreeNode node2 = current[1];

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;

            // Check both configurations: no swap and swap
            if (
                checkNodeValues(node1.left, node2.left) &&
                checkNodeValues(node1.right, node2.right)
            ) {
                nodePairStack.push(new TreeNode[] { node1.left, node2.left });
                nodePairStack.push(new TreeNode[] { node1.right, node2.right });
            } else if (
                checkNodeValues(node1.left, node2.right) &&
                checkNodeValues(node1.right, node2.left)
            ) {
                nodePairStack.push(new TreeNode[] { node1.left, node2.right });
                nodePairStack.push(new TreeNode[] { node1.right, node2.left });
            } else {
                return false;
            }
        }
        return true;
    }
}
