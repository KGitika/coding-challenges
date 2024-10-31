// Problem: Longest Square Streak in an Array
// URL: https://leetcode.com/longest-square-streak-in-an-array/

// Approach 1: HashMap

// Time complexity: O(nlogn)
// Space complexity: O(n)


class Solution {

    public int longestSquareStreak(int[] nums) {
        // Map to store the length of square streak for each number
        Map<Integer, Integer> streakLengths = new HashMap<>();

        Arrays.sort(nums);

        for (int number : nums) {
            int root = (int) Math.sqrt(number);

            // Check if the number is a perfect square and its square root is in the map
            if (root * root == number && streakLengths.containsKey(root)) {
                // If so, extend the streak from its square root
                streakLengths.put(number, streakLengths.get(root) + 1);
            } else {
                // Otherwise, start a new streak
                streakLengths.put(number, 1);
            }
        }

        // Find the maximum streak length
        int longestStreak = 0;
        for (int streakLength : streakLengths.values()) {
            longestStreak = Math.max(longestStreak, streakLength);
        }

        // Return -1 if no valid streak found, otherwise return the longest streak
        return longestStreak == 1 ? -1 : longestStreak;
    }
}


// Problem: Longest Square Streak in an Array
// URL: https://leetcode.com/longest-square-streak-in-an-array/

// Approach 2: Set

// Time complexity: O(nlogn)
// Space complexity: O(n)

class Solution {

    public int longestSquareStreak(int[] nums) {
        int longestStreak = 0;

        // Create a Set to store all unique numbers from the input array
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : nums) {
            uniqueNumbers.add(num);
        }

        // Iterate through each number in the input array
        for (int startNumber : nums) {
            int currentStreak = 0;
            long current = startNumber;

            // Continue the streak as long as we can find the next square in the set
            while (uniqueNumbers.contains((int) current)) {
                currentStreak++;

                // Break if the next square would be larger than 10^5 (problem constraint)
                if (current * current > 1e5) break;

                current *= current;
            }

            // Update the longest streak if necessary
            longestStreak = Math.max(longestStreak, currentStreak);
        }

        // Return -1 if no valid streak found, otherwise return the longest streak
        return longestStreak < 2 ? -1 : longestStreak;
    }
}
