package q0494;

public class TargetSum {
	/**
	给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

	返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
	
	示例 1:
	
	输入: nums: [1, 1, 1, 1, 1], S: 3
	输出: 5
	解释: 
	
	-1+1+1+1+1 = 3
	+1-1+1+1+1 = 3
	+1+1-1+1+1 = 3
	+1+1+1-1+1 = 3
	+1+1+1+1-1 = 3
	
	一共有5种方法让最终目标和为3。
	注意:
	
	数组非空，且长度不会超过20。
	初始的数组的和不会超过1000。
	保证返回的最终结果能被32位整数存下。
	 */
	
	
	public static int findTargetSumWays1(int[] nums, int S) {
		if(nums == null || nums.length == 0 || S > 1000) return 0;
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0]+1000] = 1;
        dp[0][-nums[0]+1000] += 1;
        for(int i=1; i<nums.length; i++){
        	for(int sum=-1000; sum <= 1000; sum++){
        		if(dp[i-1][sum+1000]>0){
        			dp[i][sum+nums[i]+1000] += dp[i-1][sum+1000];
        			dp[i][sum-nums[i]+1000] += dp[i-1][sum+1000];
        		}
        	}
        }
        return dp[nums.length-1][S+1000];
    }
	
	public static int findTargetSumWays2(int[] nums, int S) {
		if(nums == null || nums.length == 0 || S > 1000) return 0;
		int[] dp = new int[2001];
		dp[nums[0]+1000] = 1;
		dp[-nums[0]+1000] += 1;
		for(int i=1; i<nums.length; i++){
			int[] next = new int[2001];
			for(int sum = -1000; sum <= 1000; sum++){
				if(dp[sum+1000] > 0){
					next[sum+nums[i]+1000] += dp[sum+1000];
					next[sum-nums[i]+1000] += dp[sum+1000];
				}
			}
			dp = next;
		}
		return dp[S+1000];
	}
	
	public static int findTargetSumWays3(int[] nums, int target) {
		if(nums == null || nums.length == 0 || target > 1000) return 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum < target || (sum+target)%2 == 1){
            return 0;
        }
        target = (target + sum) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];

            }
        }
        return dp[target];
    }
	
	//DFS
	public int findTargetSumWays(int[] nums, int S) {
	    return findTargetSumWays(nums, 0, S);
	}

	private int findTargetSumWays(int[] nums, int start, int S) {
	    if (start == nums.length) {
	        return S == 0 ? 1 : 0;
	    }
	    return findTargetSumWays(nums, start + 1, S + nums[start])
	            + findTargetSumWays(nums, start + 1, S - nums[start]);
	}
	
	
	public static void main(String[] args) {
		int[] nums = {2,2,2,2,2};
		int S = 7;
		int res = findTargetSumWays1(nums, S);
		System.out.println(res);
	}
	
	/*
	我们用 dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数。考虑第 i 个数 nums[i]，它可以被添加 + 或 -，因此状态转移方程如下：
	
	dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
	或
	dp[i][j + nums[i]] += dp[i - 1][j]
	dp[i][j - nums[i]] += dp[i - 1][j]
	
	由于数组中所有数的和不超过 1000，那么 j 的最小值可以达到 -1000。在很多语言中，是不允许数组的下标为负数的，因此我们需要给 dp[i][j] 的第二维预先增加 1000，即：

	dp[i][j + nums[i] + 1000] += dp[i - 1][j + 1000]
	dp[i][j - nums[i] + 1000] += dp[i - 1][j + 1000]
	
	
	该问题可以转换为 Subset Sum 问题，从而使用 0-1 背包的方法来求解。

	可以将这组数看成两部分，P 和 N，其中 P 使用正号，N 使用负号，有以下推导：
	
	              sum(P) - sum(N) = target
	sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
	2 * sum(P) = target + sum(nums)
	
	因此只要找到一个子集，令它们都取正号，并且和等于 (target + sum(nums))/2，就证明存在解。
	
	
	 */
}
