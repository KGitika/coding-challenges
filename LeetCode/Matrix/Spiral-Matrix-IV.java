// Problem: Spiral Matrix IV
// URL: https://leetcode.com/problems/Spiral-Matrix-IV/


// Time complexity: O(n⋅m);
// Space complexity: O(1);

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Initialize the result matrix with -1
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }
        
        // Directions: right, down, left, up
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0, j = 0, dirIndex = 0; 
        
        while (head != null) {
            res[i][j] = head.val; 
            head = head.next; 
            
            // Calculate the next position based on the current direction
            int nextI = i + dir[dirIndex][0];
            int nextJ = j + dir[dirIndex][1];
            
            // Check if the next position is out of bounds or already filled
            if (nextI >= m || nextJ >= n || nextI < 0 || nextJ < 0 || res[nextI][nextJ] != -1) {
                dirIndex = (dirIndex + 1) % 4;
            }
            
            // Update to the new position based on the direction
            i += dir[dirIndex][0];
            j += dir[dirIndex][1];
        }
        
        return res; // Return the filled matrix
    }
}