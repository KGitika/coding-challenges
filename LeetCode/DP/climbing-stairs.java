//Problem: Climbing-Stairs
// URL: https://leetcode.com/problems/climbing-stairs/


//Approach-1-
    // Time complexity: O(N);
    // Space Complexity: O(N);
  public int climbStairs(int n) {
      if(n < 3) return n;
      int dp[] = new int[n];
      int ans = 0;
      dp[0] = 1;
      dp[1] = 2;
      
      for(int i=2; i<n; i++){
          dp[i] = dp[i-1] + dp[i-2];
      }
      return dp[n-1];
  }

//Approach-2-
    // Time complexity: O(N);
    // Space Complexity: O(1);
  public int climbStairs(int n) {
      if(n < 2) return n;
      int a = 1;
      int b = 2;
      for(int i=3; i<=n; i++){
          int c = a+b;
          a = b; 
          b = c;
      }
      return b;
  }
