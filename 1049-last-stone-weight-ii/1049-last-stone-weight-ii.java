class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for (int stone : stones) {
            totalSum += stone;
        }
        
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: a sum of 0 is always possible
        
        int maxReachableSum = 0;
        
        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
                if (dp[j]) {
                    maxReachableSum = Math.max(maxReachableSum, j);
                }
            }
        }
        
        // Total sum minus two times the closest subset sum to half the total
        return totalSum - 2 * maxReachableSum;
    }
}