package q0198_dp;

public class HouseRobber {
	/**
	你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

	给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
	
	示例 1:
	
	输入: [1,2,3,1]
	输出: 4
	解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
	     偷窃到的最高金额 = 1 + 3 = 4 。
	示例 2:
	
	输入: [2,7,9,3,1]
	输出: 12
	解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
	     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
	 */
	//func dp[n] = Math.max(dp[n - 2] + nums[n - 1], dp[n - 1] )
	public static int rob(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int n = nums.length;
		if(n == 1) return nums[0];
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = nums[0];
		for(int i=2; i<=n; i++){
			dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
		}
		return dp[n];
	}
	
	public static int rob1(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int n = nums.length;
		if(n == 1) return nums[0];
	    int pre = 0; //代替上边代码中的 nums[i - 2]
	    int cur = nums[0]; //代替上边代码中的 nums[i - 1] 和 nums[i]
	    for (int i = 2; i <= n; i++) {
	        int temp = cur;
	        cur = Math.max(pre + nums[i - 1], cur);
	        pre = temp;
	    }
	    return cur;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		int result = rob(nums);
		System.out.println(result);
	}
}
