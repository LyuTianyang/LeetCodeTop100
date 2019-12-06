package q0075;

public class SortColors {
	/**
	给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
	此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
	
	注意: 不能使用代码库中的排序函数来解决这道题。
	
	示例:
	输入: [2,0,2,1,1,0]
	输出: [0,0,1,1,2,2]
	
	0,0,1,2,0,1,0,2,2
	先从前面找到第一个不是0的下标，再从后面找到第一个不是2的下标
	 */
	public static void sortColors(int[] nums) {
        if(nums == null || nums.length<=1) return;
        int colFirst = 0;
        while(colFirst<nums.length && nums[colFirst]==0){
        	colFirst++;
        }
        int colLast = nums.length - 1;
        while(colLast>=0 && nums[colLast]==2){
        	colLast--;
        }
        //start from first non-0 index
        int index = colFirst;
        while(index <= colLast){
        	if(nums[index]==1){
        		index++;
        	}else if(nums[index]==0){
        		switchColor(nums, colFirst, index);
        		colFirst++;
        		index++;
        	}else if(nums[index]==2){
        		switchColor(nums, colLast, index);
        		colLast--;
        	}
        }
    }

	public static void switchColor(int[] nums, int colFirst, int index) {
		int tmp = nums[colFirst];
		nums[colFirst] = nums[index];
		nums[index] = tmp;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,0,1,2,0,1,0,2,2};
		sortColors(nums);
		for(int num: nums){
			System.out.println(num);
		}
	}
}
