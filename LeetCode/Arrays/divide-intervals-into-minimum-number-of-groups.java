// Problem:divide-intervals-into-minimum-number-of-groups
// URL: https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/


//Approach 1: Sorting 
    // Time complexity: O(N logN);
    // Space Complexity: O(N);

    class Solution {

    public int minGroups(int[][] intervals) {
        // Convert the intervals to two events
        // start as {start, 1} and end as {end + 1, -1}
        List<int[]> events = new ArrayList<>();

        for (int[] interval : intervals) {
            events.add(new int[] { interval[0], 1 }); // Start event
            events.add(new int[] { interval[1] + 1, -1 }); // End event (interval[1] + 1)
        }

        // Sort the events first by time, and then by type (1 for start, -1 for end).
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); // Sort by type (1 before -1)
            } else {
                return Integer.compare(a[0], b[0]); // Sort by time
            }
        });

        int concurrentIntervals = 0;
        int maxConcurrentIntervals = 0;

        // Sweep through the events
        for (int[] event : events) {
            concurrentIntervals += event[1]; // Track currently active intervals
            maxConcurrentIntervals = Math.max(
                maxConcurrentIntervals,
                concurrentIntervals
            ); // Update max
        }

        return maxConcurrentIntervals;
    }
}


//Approach 1:Line Sweep Algorithm 
    // Time complexity: O(N+k);
    // Space Complexity: O(k);

    // K are the numbers between rangeStart and rangeEnd

class Solution {

    public int minGroups(int[][] intervals) {
        // Find the minimum and maximum value in the intervals
        int rangeStart = Integer.MAX_VALUE;
        int rangeEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            rangeStart = Math.min(rangeStart, interval[0]);
            rangeEnd = Math.max(rangeEnd, interval[1]);
        }

        // Initialize the array with all zeroes
        int[] pointToCount = new int[rangeEnd + 2];
        for (int[] interval : intervals) {
            pointToCount[interval[0]]++; // Increment at the start of the interval
            pointToCount[interval[1] + 1]--; // Decrement right after the end of the interval
        }

        int concurrentIntervals = 0;
        int maxConcurrentIntervals = 0;
        for (int i = rangeStart; i <= rangeEnd; i++) {
            // Update currently active intervals
            concurrentIntervals += pointToCount[i];
            maxConcurrentIntervals = Math.max(
                maxConcurrentIntervals,
                concurrentIntervals
            );
        }

        return maxConcurrentIntervals;
    }
}    