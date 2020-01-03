package q0136;

public class SingleNumber {
	/**
	给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
	说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
	输入: [2,2,1]
	输出: 1
	
	输入: [4,1,2,1,2]
	输出: 4
	
	^ 异或，相同返回0，不同返回1
	1 1 : 0
	0 0 : 0
	1 0 : 1
	思路
	标签：位运算
	本题根据题意，线性时间复杂度 O(n)O(n)，很容易想到使用 Hash 映射来进行计算，遍历一次后结束得到结果，但是在空间复杂度上会达到 O(n)O(n)，需要使用较多的额外空间
	既满足时间复杂度又满足空间复杂度，就要提到位运算中的异或运算 XOR，主要因为异或运算有以下几个特点：
	一个数和 0 做 XOR 运算等于本身：a⊕0 = a
	一个数和其本身做 XOR 运算等于 0：a⊕a = 0
	XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
	故而在以上的基础条件上，将所有数字按照顺序做抑或运算，最后剩下的结果即为唯一的数字
	时间复杂度：O(n)O(n)，空间复杂度：O(1)O(1)
	 */
	public static int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int ans = 0;
        for(int i=0; i<nums.length; i++){
        	ans = ans ^ nums[i];
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,2,2,3,4,4,5,5};
		int result = singleNumber(nums);
		System.out.println(result);
	}
}
