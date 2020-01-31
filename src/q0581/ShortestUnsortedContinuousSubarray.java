package q0581;

import java.util.Arrays;
import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {
	/**
	给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

	你找到的子数组应是最短的，请输出它的长度。
	
	示例 1:
	
	输入: [2, 6, 4, 8, 10, 9, 15]
	输出: 5
	解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
	 */
	public static int findUnsortedSubarray1(int[] nums) {
		Stack<Integer> stack = new Stack<Integer>();
		int l = nums.length;
		int r = 0;
		for(int i=0; i<nums.length; i++){
			while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
				l = Math.min(l, stack.pop());
			}
			stack.push(i);
		}
		stack.clear();
		for(int i=nums.length-1; i>=0; i--){
			while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
				r = Math.max(r, stack.pop());
			}
			stack.push(i);
		}
		if(r-l>0){
			return r-l+1;
		}else{
			return 0;
		}
    }
	
	public static int findUnsortedSubarray2(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return end - start >= 0 ? end - start + 1 : 0;
    }
	
	public static void main(String[] args) {
		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		int res = findUnsortedSubarray2(nums);
		System.out.println(res);
	}
}
