package q0215_quickSelect;

public class KthLargeElementInArray {
	/**
	在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
	
	示例 1:
	
	输入: [3,2,1,5,6,4] 和 k = 2
	输出: 5
	示例 2:
	
	输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
	输出: 4
	
	不返回下标，返回元素的值
	 */
	//quick select(从快速排序截取)
	public static int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length-1;
        while(true){
        	int pos = partition(nums, left, right);
        	if(pos+1==k){
        		return nums[pos];
        	}else if(pos+1>k){
        		right = pos - 1;
        	}else{
        		left = pos+1;
        	}
        }
    }
	
	/*
	 *  3,2,1,5,6,4 k=3
	 *  0 1 2 3 4 5
	 pivot:3 [3,2,1,5,6,4] 3作为中心点，大于3的放在左边，小于3放在右边
	 [3,4,6,5,1,2]	3
	 
	 pivot:5 [5,4,6,3,1,2]
	 [5,6,4,3,1,2]	1
	 
	 pivot:6 [6,5,4,3,1,2]
	 [6,5,4,3,1,2]	2
	 */
	
	private static int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		int l = left+1;
		int r = right;
		while(l <= r){
			if(nums[l]<pivot && nums[r]>pivot){
				swap(nums, l++, r--);
			}
			if(nums[l]>=pivot) l++;
			if(nums[r]<=pivot) r--;
		}
		swap(nums, left, r);
		return r;
	}
	
	private static void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int result = findKthLargest(nums, 3);
		System.out.println(result);
	}
	
}
