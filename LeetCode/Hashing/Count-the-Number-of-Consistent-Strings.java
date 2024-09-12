// Problem: count-the-number-of-consistent-strings
// URL: https://leetcode.com/problems/count-the-number-of-consistent-strings/

// Time complexity: O(m+n⋅k);
// Space complexity: O(m);

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Store allowed characters in a set for quick lookup
        HashSet<Character> allowedSet = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            allowedSet.add(ch);
        }

        int count = 0; // Initialize count for consistent strings

        // Check each word in the array
        for (String word : words) {
            if (isConsistent(word, allowedSet)) {
                count++;
            }
        }

        return count;
    }
}