package q0338;

public class CountingBits {
	/**
	给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

	示例 1:
	
	输入: 2
	输出: [0,1,1]
	示例 2:
	
	输入: 5
	输出: [0,1,1,2,1,2]
	 */
	public static int[] countBits1(int num) {
		int[] ans = new int[num+1];
		int i = 0;
		int b = 1;
		// [0, b) is calculated
		while(b <= num){
			// generate [b, 2b) or [b, num) from [0, b)
			while(i<b && i+b<=num){
				ans[i+b] = ans[i]+1;
				++i;
			}
			i = 0; //reset i
			b = b<<1; //b = 2b
		}
		return ans;
	}
	
	
	//dp
	public static int[] countBits2(int num) {
        int[] ans = new int[num+1];
        for(int i=1; i<=num; i++){
        	ans[i] = ans[i >> 1]+(i & 1);
        }
        return ans;
    }
	
	public static int[] countBits3(int num) {
        int[] ans = new int[num+1];
        for(int i=1; i<=num; i++){
        	ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int[] ans = countBits2(5);
		for(int i : ans){
			System.out.println(i);
		}
	}
}
