package q0416;

public class PartitionEqualSubsetSum {
	/**
	给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

	注意:
	
	每个数组中的元素不会超过 100
	数组的大小不会超过 200
	示例 1:
	
	输入: [1, 5, 11, 5]
	
	输出: true
	
	解释: 数组可以分割成 [1, 5, 5] 和 [11].
	 
	
	示例 2:
	
	输入: [1, 2, 3, 5]
	
	输出: false
	 */
	public static boolean canPartition(int[] nums) {
        if(nums == null || nums.length <= 1) return false;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
        	sum += nums[i];
        }
        if(sum%2 == 1) return false;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int num : nums){
        	for(int i=target; i>=num; i--){
        		if(dp[i-num] == true){
        			dp[i] = true;
        		}
        	}
        }
        return dp[target];
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 5, 11, 5};
		boolean res = canPartition(nums);
		System.out.println(res);
	}
	
	/*
	第一步： 问题转化
	要使得两个子集元素和相等，即为从数组中挑出部分元素组成集合A，使得sumA = SUM - sumA；
	也就是sumA = SUM / 2；这便是一个经典的0 - 1背包问题。
	假如SUM为奇数，直接返回false。
	第二步： 动态规划解决0 - 1背包问题
	建立dp数组，长度target = sum + 1;
	dp[i]表示的为nums数组此时能否组成和为i的状态，dp[0] = 1;
	我们让num遍历数组nums，对于每一个num，建立内层循环i = target,当i >= num的时候，更新dp[i]
	假如dp[i - num]为true，则表示在num之前的数组可以找出和为i - num的集合，
	那么再加入了num之 后，数组也能找出和为i的集合，于是dp[i]更新为true。
	最后，返回dp[target]即可。
	 */
}
