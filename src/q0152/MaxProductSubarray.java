package q0152;

public class MaxProductSubarray {
	/**
	给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
	示例 1:
	
	输入: [2,3,-2,4]
	输出: 6
	解释: 子数组 [2,3] 有最大乘积 6。
	示例 2:
	
	输入: [-2,0,-1]
	输出: 0
	解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
	
	动态规划
	dpMax[i] = max(dpMin[i-1] * nums[i], dpMax[i-1] * nums[i], nums[i]);
	dpMin[i] = min(dpMin[i-1] * nums[i], dpMax[i-1] * nums[i], nums[i]);
	 */
	public static int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dpMax = new int[n];
        dpMax[0] = nums[0];
        int[] dpMin = new int[n];
        dpMin[0] = nums[0];
        int max = nums[0];
        for(int i=1; i<n; i++){
        	dpMax[i] = Math.max(dpMin[i-1]*nums[i], Math.max(dpMax[i-1]*nums[i], nums[i]));
        	dpMin[i] = Math.min(dpMin[i-1]*nums[i], Math.min(dpMax[i-1]*nums[i], nums[i]));
        	max = Math.max(max, dpMax[i]);
        }
        return max;
    }
	
	public static int maxProduct1(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
	    int dpMax = nums[0];
	    int dpMin = nums[0];
	    int max = nums[0];
	    for (int i = 1; i < n; i++) {
	        //更新 dpMin 的时候需要 dpMax 之前的信息，所以先保存起来
	        int preMax = dpMax;
	        dpMax = Math.max(dpMin * nums[i], Math.max(dpMax * nums[i], nums[i]));
	        dpMin = Math.min(dpMin * nums[i], Math.min(preMax * nums[i], nums[i]));
	        max = Math.max(max, dpMax);
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,-2,4};
		int result = maxProduct(nums);
		System.out.println(result);
	}
}
