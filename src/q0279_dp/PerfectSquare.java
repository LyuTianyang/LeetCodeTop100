package q0279_dp;

public class PerfectSquare {
	/**
	给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

	示例 1:
	
	输入: n = 12
	输出: 3 
	解释: 12 = 4 + 4 + 4.
	示例 2:
	
	输入: n = 13
	输出: 2
	解释: 13 = 4 + 9.
	 */
	public static int numSquares(int n) {
        int[] dp = new int[n+1]; // 默认初始化值都为0
        for(int i=1; i<=n; i++){
        	dp[i] = i; // 最坏的情况就是每次+1
        	for(int j=1; j*j<=i; j++){
        		dp[i] = Math.min(dp[i], dp[i-j*j]+1); //动态转移方程
        	}
        }
        return dp[n];
    }
	// 动态转移方程为：dp[i] = MIN(dp[i], dp[i - j * j] + 1)，i表示当前数字，j*j表示平方数
	public static void main(String[] args) {
		int res = numSquares(13);
		System.out.println(res);
	}
}
