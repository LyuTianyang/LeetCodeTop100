package q0169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	/**
	给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
	
	你可以假设数组是非空的，并且给定的数组总是存在多数元素。
	
	示例 1:
	
	输入: [3,2,3]
	输出: 3
	示例 2:
	
	输入: [2,2,1,1,1,2,2]
	输出: 2
	 */
	public static int majorityElement1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
	
	public static int majorityElement2(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		//以nums中元素为key，元素出现的次数为value
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for(int i=0; i<nums.length; i++){
        	if(!map.containsKey(nums[i])){
        		map.put(nums[i], 1);
        	}else{
        		int time = map.get(nums[i])+1;
        		map.put(nums[i], time);
        	}
        	if(map.get(nums[i]) > nums.length/2){
        		res = nums[i];
        		break;
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,2,1,1,1,2,2};
		int result = majorityElement2(nums);
		System.out.println(result);
	}
}
