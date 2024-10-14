// Problem: Delete-Nodes-From-Linked-List-Present-in-Array
// URL: https://leetcode.com/problems/Delete-Nodes-From-Linked-List-Present-in-Array/

import java.util.HashSet;
import java.util.Set;

// Includes arrays, hashtable, and linkedlist;
// Time complexity: O(m+n);
// Space complexity: O(n);


class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Store the values to be removed in a HashSet for quick lookup
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // Dummy node to handle edge cases and simplify removal logic
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        // Traverse the linked list
        while (curr != null) {
            if (set.contains(curr.val)) {
                // Skip the current node
                prev.next = curr.next;
            } else {
                // Move prev to current node
                prev = curr;
            }
            curr = curr.next; // Move to the next node
        }
        return dummy.next; 
    }
}