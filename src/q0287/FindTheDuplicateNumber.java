package q0287;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {
	/**
	给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

	示例 1:
	
	输入: [1,3,4,2,2]
	输出: 2
	示例 2:
	
	输入: [3,1,3,4,2]
	输出: 3
	说明：
	
	不能更改原数组（假设数组是只读的）。
	只能使用额外的 O(1) 的空间。
	时间复杂度小于 O(n2) 。
	数组中只有一个重复的数字，但它可能不止重复出现一次。
	 */
	public static int findDuplicate1(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0 ;i<nums.length ;i++){
        	if(set.contains(nums[i])){
        		return nums[i];
        	}
        	set.add(nums[i]);
        }
        return -1;
    }
	
	public static int findDuplicate2(int[] nums) {
        int min = 1, max = nums.length - 1;

        while (min < max) {
            int mid = (min + max) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            /*
             * 如果count>mid，说明元素个数count比桶数mid还大，则可以肯定重复的数在[1,mid]中
             * 但是count<=mid就能确定重复的数肯定不在[1,mid]中么？不一定吧，接下来推理一下：
             * 我们看右边的一半，[mid+1,n]区间的数有n+1-count个，可见元素有n+1-count个，桶有n-mid个，而count<=mid等价于count-1<mid，
             * 因此元素个数大于桶数，右区间一定有重复的数，由于题目已经限定只有一个重复数，因此只能在右区间
             */
            if (count > mid) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }
	
	public static void main(String[] args) {
		
	}
}	
