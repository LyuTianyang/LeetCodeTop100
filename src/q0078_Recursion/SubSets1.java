package q0078_Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSets1 {
	/**
	给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
	说明：解集不能包含重复的子集。
	
	输入: nums = [1,2,3]
	输出:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
	 */
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) return res;
		int index = 0;
		List<Integer> curr = new ArrayList<Integer>();
		helper(nums, index, res, curr);
		return res;
    }

	public static void helper(int[] nums, int index, List<List<Integer>> res, List<Integer> curr) {
		//如果currIdx超出nums的下标，跳出递归
		if(index > nums.length-1){
			res.add(new ArrayList<Integer>(curr));
		}else{
			//分支1：curr里面不加上nums[currIdx]
			helper(nums, index+1, res, curr);
			//分支2：curr里面加上nums[currIdx]
			curr.add(nums[index]);
			helper(nums, index+1, res, curr);
			curr.remove(curr.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> res = subsets(nums);
		System.out.println(res);
	}
	
	
}
