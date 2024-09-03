// Problem: Two Sum
// URL: https://leetcode.com/problems/two-sum/


import java.util.HashMap;
import java.util.Map;

//Brute Force Approach-
    // Time complexity: O(N^2);
    // Space Complexity: O(1);

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
}




// Optimized(Two pass Hashtable solutiob)-
    // Time complexity: O(N);
    // Space Complexity: O(N);

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] {numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[] {};
    }
}