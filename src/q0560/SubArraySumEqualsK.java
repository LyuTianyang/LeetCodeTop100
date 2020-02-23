package q0560;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
	/**
	给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

	示例 1 :
	
	输入:nums = [1,1,1], k = 2
	输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
	 */
	
	public static int subarraySum1(int[] nums, int k) {
		if(nums == null || nums.length == 0) return 0;
        int count = 0;
        for(int start = 0; start < nums.length; start++){
        	int sum = 0;
        	for(int end = start; end < nums.length; end++){
        		sum += nums[end];
        		if(sum == k) count++;
        	}
        }
        return count;
    }
	
	public static int subarraySum2(int[] nums, int k) {
		if(nums == null || nums.length == 0) return 0;
        int count = 0, sum = 0;
        Map <Integer, Integer> map = new HashMap <Integer, Integer> ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)){
            	count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k = 9;
		int res = subarraySum2(nums, k);
		System.out.println(res);
	}
}
