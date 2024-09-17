// Problem: Minimum time difference
// URL: https://leetcode.com/problems/minimum-time-difference/

// Approach 1: Sort
class Solution {

    public int findMinDifference(List<String> timePoints) {
        // Convert time points to minutes
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            minutes[i] = h * 60 + m;  // Convert hours and minutes to total minutes
        }

        // Sort the time points in ascending order
        Arrays.sort(minutes);

        // Find the minimum difference between adjacent time points
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length - 1; i++) {
            ans = Math.min(ans, minutes[i + 1] - minutes[i]);
        }

        // Handle circular difference between the last and first time points
        return Math.min(ans, 24 * 60 - minutes[minutes.length - 1] + minutes[0]);
    }
}

// Approach 2: Bucket Sort
class SolutionOptimized {

    public int findMinDifference(List<String> timePoints) {
        // Create a boolean array representing each minute in a day (24 * 60)
        boolean[] minutes = new boolean[24 * 60];
        for (String time : timePoints) {
            int min = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3)); // Convert time to minutes
            if (minutes[min]) return 0;  // Duplicate time point, return 0
            minutes[min] = true;
        }

        int prev = Integer.MAX_VALUE, first = Integer.MAX_VALUE, last = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;

        // Traverse the minutes array to find the smallest difference
        for (int i = 0; i < 24 * 60; i++) {
            if (minutes[i]) {
                if (prev != Integer.MAX_VALUE) {
                    ans = Math.min(ans, i - prev);
                }
                prev = i;
                if (first == Integer.MAX_VALUE) first = i;
                last = i;
            }
        }

        // Consider the circular difference between the last and first time points
        return Math.min(ans, 24 * 60 - last + first);
    }
}