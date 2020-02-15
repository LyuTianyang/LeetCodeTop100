package q0238;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	/**
	给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
	
	示例:
	
	输入: [1,2,3,4]
	输出: [24,12,8,6]
	说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
	
	进阶：
	你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
	 */
	public static int[] productExceptSelf1(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        int n = nums.length;
        int[] res = new int[n];
        int left = 1;
        for(int i=0; i<n; i++){
        	res[i] = left; // left为该数左边的乘积。
        	left = left*nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
        }
        int right = 1;
        for(int i=n-1; i>=0; i--){
        	res[i] = res[i]*right; // right为该数右边的乘积。
        	right = right*nums[i]; // 此时数组等于左边的 * 该数右边的。
        }
        return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] res = productExceptSelf1(nums);
		System.out.println(Arrays.toString(res));
				 
	}
	
	public static int[] productExceptSelf2(int[] nums) {
		if(nums == null || nums.length == 0) return nums;
        int n = nums.length;
        int[] res = new int[n];
        for(int i=0; i<n; i++){
        	int tmp = 1;
        	for(int j=0; j<n; j++){
        		if(j!=i){
        			tmp = tmp*nums[j];
        		}
        	}
        	res[i] = tmp;
        }
        return res;
    }
}
