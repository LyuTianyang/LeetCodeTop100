package q0322;

import java.util.Arrays;

public class CoinChange {
	/**
	金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

	示例 1:
	
	输入: coins = [1, 2, 5], amount = 11
	输出: 3 
	解释: 11 = 5 + 5 + 1
	示例 2:
	
	输入: coins = [2], amount = 3
	输出: -1
	 */
	
	
	public static int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        for(int i=0; i<dp.length; i++){
        	dp[i] = -1;
        }
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
        	for(int j=0; j<coins.length; j++){
        		if(i-coins[j] >= 0 && dp[i-coins[j]] >= 0){
        			int k = dp[i-coins[j]] + 1;
        			if(dp[i] > 0){
        				dp[i] = Math.min(dp[i], k);
        			}else{
        				dp[i] = k;
        			}
        		}
        	}
        }
        return dp[amount];
    }
	
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		int res = coinChange(coins, amount);
		System.out.println(res);
	}
}
