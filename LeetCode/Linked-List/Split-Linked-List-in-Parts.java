// Problem: Split Linked List in Parts
// URL:https://leetcode.com/problems/split-linked-list-in-parts


// Time Complexity: O(N);
// Space Complexity: O(1);

// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;

        // Count the total number of nodes in the list
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        int width = count / k;    // Base width of each part
        int rem = count % k;      // Extra nodes to distribute

        ListNode[] parts = new ListNode[k];
        cur = head;

        for (int i = 0; i < k; i++) {
            ListNode newHead = cur;
            // Traverse to the end of the current part
            for (int j = 1; j < width + (i < rem ? 1 : 0); j++) {
                if (cur != null) cur = cur.next;
            }
            // Disconnect the current part from the rest of the list
            if (cur != null) {
                ListNode nextPart = cur.next;
                cur.next = null;
                cur = nextPart;
            }
            parts[i] = newHead;
        }

        return parts;
    }
}


