// Problem: 4Sum
// URL: https://leetcode.com/problems/4sum/


import java.util.HashMap;
import java.util.Map;

//Brute Force Approach-
    // Time complexity: O(N^3);
    // Space Complexity: O(n);

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        long average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (
            nums[start] > average_value || average_value > nums[nums.length - 1]
        ) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(
                    nums,
                    target - nums[i],
                    i + 1,
                    k - 1
                )) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;

        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (
                currSum > target ||
                (hi < nums.length - 1 && nums[hi] == nums[hi + 1])
            ) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }

        return res;
    }
}




// Optimized(Two pass Hashtable solutiob)-
    // Time complexity: O(N^3);
    // Space Complexity: O(N);

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        long average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (
            nums[start] > average_value || average_value > nums[nums.length - 1]
        ) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(
                    nums,
                    target - nums[i],
                    i + 1,
                    k - 1
                )) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Long> s = new HashSet<>();

        for (int i = start; i < nums.length; ++i) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]) {
                if (s.contains(target - nums[i])) {
                    res.add(Arrays.asList((int) target - nums[i], nums[i]));
                }
            }
            s.add((long) nums[i]);
        }

        return res;
    }
}