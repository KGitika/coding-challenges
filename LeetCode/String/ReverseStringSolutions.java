// Problem: Reverse String 
// URL: https://leetcode.com/problems/reverse-string/


public class ReverseStringSolutions {

    // Solution 1: Two-pointer approach
    // Time Complexity: O(n), Space Complexity: O(1)
    public void reverseStringTwoPointers(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    // Solution 2: Recursion
    // Time Complexity: O(n), Space Complexity: O(n) due to recursion stack
    public void reverseStringRecursion(char[] s) {
        reverseHelper(s, 0, s.length - 1);
    }

    private void reverseHelper(char[] s, int i, int j) {
        if (i >= j) return;
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        reverseHelper(s, i + 1, j - 1);
    }

    // Solution 3: Iterative with Stack (extra space)
    // Time Complexity: O(n), Space Complexity: O(n)
    public void reverseStringStack(char[] s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : s) {
            stack.push(c);
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
    }

    // Solution 4: StringBuilder (extra space)
    // Time Complexity: O(n), Space Complexity: O(n)
    public void reverseStringStringBuilder(char[] s) {
        StringBuilder sb = new StringBuilder(new String(s));
        sb.reverse();
        char[] reversed = sb.toString().toCharArray();
        for (int i = 0; i < s.length; i++) {
            s[i] = reversed[i];
        }
    }
}