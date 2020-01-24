package q0448;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllNumbersDisappeardInAnArray {
	/**
	给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

	找到所有在 [1, n] 范围之间没有出现在数组中的数字。
	
	您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
	
	示例:
	
	输入:
	[4,3,2,7,8,2,3,1]
	
	输出:
	[5,6]
	 */
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length == 0) return res;
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for(int i=0; i<nums.length; i++){
			map.put(nums[i], true);
		}
		for(int i=1; i<=nums.length; i++){
			if(!map.containsKey(i)){
				res.add(i);
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> res = findDisappearedNumbers(nums);
		System.out.println(res);
	}
}
