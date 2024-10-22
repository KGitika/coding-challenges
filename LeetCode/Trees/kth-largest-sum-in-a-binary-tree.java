// Problem: Kth Largest Sum in a Binary Tree
// URL: https://leetcode.com/kth-largest-sum-in-a-binary-tree/

// Approach 1:  Level Order Traversal + Max Heap

class Solution {

    public long kthLargestLevelSum(TreeNode root, int k) {
        // max heap
        PriorityQueue<Long> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            //level order traversal
            int size = bfsQueue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poppedNode = bfsQueue.remove();
                sum += poppedNode.val;
                if (poppedNode.left != null) {
                    //add left child
                    bfsQueue.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    // add right child
                    bfsQueue.add(poppedNode.right);
                }
            }
            pq.add(sum);
        }
        if (pq.size() < k) return -1;
        for (int i = 0; i < k - 1; i++) pq.remove();
        return pq.peek();
    }
}


// Approach 1:  Level Order Traversal + Min Heap


class Solution {

    public long kthLargestLevelSum(TreeNode root, int k) {
        // min heap of size k
        // at the end, top element is kth largest
        PriorityQueue<Long> pq = new PriorityQueue<>();

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            //level order traversal
            int size = bfsQueue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poppedNode = bfsQueue.remove();
                sum += poppedNode.val;
                if (poppedNode.left != null) {
                    //add left child
                    bfsQueue.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    // add right child
                    bfsQueue.add(poppedNode.right);
                }
            }
            pq.add(sum);
            if (pq.size() > k) {
                // evict top element
                pq.remove();
            }
        }
        if (pq.size() < k) return -1;
        return pq.peek();
    }
}