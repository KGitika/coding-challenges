// Problem: Insert Greatest Common Divisors in Linked List
// URL: https://leetcode.com/problems/Insert Greatest Common Divisors in Linked List/

    // Time complexity: 0(n.log(min(a,b)));
    // Space Complexity: O(1);


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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode pre = head;
        ListNode forw = head.next;
        
        // Traverse the linked list
        while (forw != null) {
            // Create a new node with GCD of the current and next node values
            ListNode newNode = new ListNode(gcd(pre.val, forw.val));
            
            // Insert the new node between current and next
            pre.next = newNode;
            newNode.next = forw;
            
            // Move pointers forward
            pre = forw;
            forw = pre.next;
        }
        return head;
    }

    // Helper method to calculate GCD of two numbers
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
