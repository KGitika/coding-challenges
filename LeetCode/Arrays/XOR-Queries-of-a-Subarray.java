// Problem: xor-queries-of-a-subarray
// URL: https://leetcode.com/problems/xor-queries-of-a-subarray/

//Brute Force Approach-
    // Time complexity: O(n+q);
    // Space Complexity: O(n);


class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXOR = new int[n + 1];

        // Build prefix XOR array
        for (int i = 0; i < n; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }
        System.out.println(Arrays.toString(prefixXOR));
        int[] result = new int[queries.length];
        // Process each query using prefix XOR
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            result[i] = prefixXOR[q[1] + 1] ^ prefixXOR[q[0]];
        }
        return result;
    }
}