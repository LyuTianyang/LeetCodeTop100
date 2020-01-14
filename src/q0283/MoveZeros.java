package q0283;

public class MoveZeros {
	/**
	给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

	示例:
	
	输入: [0,1,0,3,12]
	输出: [1,3,12,0,0]
	说明:
	
	必须在原数组上操作，不能拷贝额外的数组。
	尽量减少操作次数。
	
	遍历数组，无为0的元素移动数组前方，用index下标记录。
	遍历结束，对index值后的元素统一设为0
	 */
	public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int index = 0;
        for(int i=0 ;i<nums.length; i++){
        	if(nums[i] != 0){
        		nums[index] = nums[i];
        		index++;
        	}
        }
        while(index < nums.length){
        	nums[index] = 0;
        	index++;
        }
    }
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
		for(int num : nums){
			System.out.println(num);
		}
	}
}
