// Problem: separate-black-and-white-balls
// URL: https://leetcode.com/problems/separate-black-and-white-balls/

// Time complexity: O(n);
// Space complexity: O(1);

// Approach 1 - Two Pointer
class Solution {

    public long minimumSteps(String s) {
        int whitePosition = 0;
        long totalSwaps = 0;

        // Iterate through each ball (character) in the string
        for (int currentPos = 0; currentPos < s.length(); currentPos++) {
            if (s.charAt(currentPos) == '0') {
                // Calculate the number of swaps needed
                // to move it to leftmost available position
                totalSwaps += currentPos - whitePosition;

                // Move the next available position for a white ball one step to the right
                whitePosition++;
            }
        }

        return totalSwaps;
    }
}




// Approach 1 - counter
class Solution {

    public long minimumSteps(String s) {
        long totalSwaps = 0;
        int blackBallCount = 0;

        // Iterate through each ball (character) in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                // Swap with all black balls to its left
                totalSwaps += (long) blackBallCount;
            } else {
                // Increment the count
                blackBallCount++;
            }
        }

        return totalSwaps;
    }
}