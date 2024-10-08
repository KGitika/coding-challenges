// Problem: minimum-number-of-swaps-to-make-the-string-balanced
// URL: https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/

// Approach 1:Stack
// Time Complexity: O(n);
// Space Complexity: O(n);

class Solution {

    public int minSwaps(String s) {
        Stack<Character> stack = new Stack();
        int unbalanced = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If an opening bracket is encountered, push it in the stack.
            if (ch == '[') stack.push(ch);
            else {
                // If the stack is not empty, pop it.
                if (!stack.isEmpty()) stack.pop();
                // Otherwise increase the count of unbalanced brackets.
                else unbalanced++;
            }
        }
        return (unbalanced + 1) / 2;
    }
}

// Approach 2:Space-Optimized Stack
// Time Complexity: O(n);
// Space Complexity: O(1);

class Solution {

    public int minSwaps(String s) {
        int stackSize = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If character is opening bracket, increment the stack size.
            if (ch == '[') stackSize++;
            else {
                // If the character is closing bracket, and we have an opening bracket, decrease
                // the stack size.
                if (stackSize > 0) stackSize--;
            }
        }
        return (stackSize + 1) / 2;
    }
}