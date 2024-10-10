// Problem: maximum-width-ramp
// URL: https://leetcode.com/problems/maximum-width-ramp/

// Time Complexity: O(n^2);
// Space Complexity: O(1);
// Approach 1:  Brute Force (Time Limit Exceeded)

class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i=0; i<n; i++){
            int start = nums[i];
            for(int j=n-1; j>i; j--){
                if(start <= nums[j]){
                    res = Math.max(res, j-i);
                    break;
                }
            }
        }
        return res;
    }
}

// Time Complexity: O(n);
// Space Complexity: O(n);
// Approach 2:  Stack

class Solution {

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> indicesStack = new Stack<>();

        // Fill the stack with indices in increasing order of their values
        for (int i = 0; i < n; i++) {
            if (indicesStack.isEmpty() || nums[indicesStack.peek()] > nums[i]) {
                indicesStack.push(i);
            }
        }

        int maxWidth = 0;

        // Traverse the array from the end to the start
        for (int j = n - 1; j >= 0; j--) {
            while (
                !indicesStack.isEmpty() && nums[indicesStack.peek()] <= nums[j]
            ) {
                maxWidth = Math.max(maxWidth, j - indicesStack.peek());
                // Pop the index since it's already processed
                indicesStack.pop();
            }
        }

        return maxWidth;
    }
}