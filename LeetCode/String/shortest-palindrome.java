// Problem: Shortest Palindrome
// URL: https://leetcode.com/problems/shortest-palindrome/

// Solution 1: KMP Algorithm-Based Approach

// Time Complexity: O(n), where n is the length of the input string.
// Space Complexity: 0(n);

class Solution {
    public String shortestPalindrome(String s) {
        // Concatenate the string with a separator and its reverse
        String concat = new StringBuilder(s)
                            .append('.')
                            .append(new StringBuilder(s).reverse())
                            .toString();
        
        // KMP: Build the 'next' array
        int[] next = new int[concat.length()];
        for (int i = 0, ptr = -1; i < next.length; ptr = next[i], i++) {
            while (ptr > -1 && concat.charAt(ptr + 1) != concat.charAt(i)) {
                ptr = next[ptr];
            }
            next[i] = i > 0 && concat.charAt(ptr + 1) == concat.charAt(i) ? ptr + 1 : -1;
        }

        // Add characters to the front to make the string a palindrome
        return new StringBuilder(s.substring(next[next.length - 1] + 1))
                   .reverse()
                   .append(s)
                   .toString();
    }
}




// Solution 2: Simple String Matching Approach

// Time Complexity: O(n^2), where n is the length of the input string.
// Space Complexity: 0(n);

class Solution2 {
    public String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int l = s.length();

        // Find the longest prefix that is a palindrome
        for (int i = 0; i < l; i++) {
            if (s.substring(0, l - i).equals(reverse.substring(i))) {
                // Add the necessary characters from reverse to make it a palindrome
                return new StringBuilder(reverse.substring(0, i)).append(s).toString();
            }
        }
        return "";
    }
}