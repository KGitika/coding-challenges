// Problem: Maximum Swap
// URL: https://leetcode.com/problems/maximum-swap/


// Approach 1:  Brute Force

// Time Complexity: O(n^2);
// Space Complexity: O(n);

class Solution {

    public int maximumSwap(int num) {
        String numStr = Integer.toString(num); // Convert num to string for easy manipulation
        int n = numStr.length();
        int maxNum = num; // Track the maximum number found

        // Try all possible swaps
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                char[] numeral = numStr.toCharArray(); // Convert string to char array for swapping

                // Swap digits at index i and j
                char temp = numeral[i];
                numeral[i] = numeral[j];
                numeral[j] = temp;

                int tempNum = Integer.parseInt(new String(numeral)); // Convert the char array back to integer

                maxNum = Math.max(maxNum, tempNum); // Update maxNum if the new number is larger
            }
        }

        return maxNum; // Return the largest number after all possible swaps
    }
}


// Approach 2:  Greedy

// Time Complexity: O(n);
// Space Complexity: O(n);

class Solution {

    public int maximumSwap(int num) {
        char[] numStr = Integer.toString(num).toCharArray();
        int n = numStr.length;
        int maxDigitIndex = -1, swapIdx1 = -1, swapIdx2 = -1;

        // Traverse the string from right to left, tracking the max digit and
        // potential swap
        for (int i = n - 1; i >= 0; --i) {
            if (maxDigitIndex == -1 || numStr[i] > numStr[maxDigitIndex]) {
                maxDigitIndex = i; // Update the index of the max digit
            } else if (numStr[i] < numStr[maxDigitIndex]) {
                swapIdx1 = i; // Mark the smaller digit for swapping
                swapIdx2 = maxDigitIndex; // Mark the larger digit for swapping
            }
        }

        // Perform the swap if a valid swap is found
        if (swapIdx1 != -1 && swapIdx2 != -1) {
            char temp = numStr[swapIdx1];
            numStr[swapIdx1] = numStr[swapIdx2];
            numStr[swapIdx2] = temp;
        }

        return Integer.parseInt(new String(numStr)); // Return the new number or the original if no
        // swap occurred
    }
}