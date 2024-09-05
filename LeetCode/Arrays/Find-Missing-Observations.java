// Problem: Find Missing Observations
// URL:https://leetcode.com/problems/find-missing-observations


// Time complexity: O(max(m,n));
// Space complexity: O(1);


public int[] missingRolls(int[] rolls, int mean, int n) {
    int totalRolls = rolls.length + n; 
    int existingSum = 0; 

    for (int roll : rolls) {
        existingSum += roll; // Calculate sum of existing rolls
    }

    int requiredSum = totalRolls * mean; 
    int missingSum = requiredSum - existingSum; 

    // Check if the missing sum is possible with valid dice rolls
    if (missingSum < n || missingSum > 6 * n) {
        return new int[0]; 
    }

    int avgRoll = missingSum / n; 
    int extra = missingSum % n; 

    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
        result[i] = avgRoll + (i < extra ? 1 : 0); // Distribute the remainder
    }

    return result;
}