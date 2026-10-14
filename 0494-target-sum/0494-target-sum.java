class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Check if subset sum is invalid
        if (target > totalSum || target < -totalSum) {
            return 0;
        }
        if ((target + totalSum) % 2 != 0) {
            return 0;
        }
        
        int p = (target + totalSum) / 2;
        
        int[] dp = new int[p + 1];
        dp[0] = 1; // Base case: 1 way to get sum 0 (empty subset)
        
        for (int num : nums) {
            for (int j = p; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[p];
    }
}