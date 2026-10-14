import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Initialize the dp array with amount + 1 (representing infinity)
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        
        // Base case: 0 coins are needed to make an amount of 0
        dp[0] = 0;
        
        // Build the dp table from 1 up to the target amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is greater than amount, it cannot be made up
        return dp[amount] > amount ? -1 : dp[amount];
    }
}