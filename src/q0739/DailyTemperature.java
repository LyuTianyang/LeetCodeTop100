package q0739;

import java.util.Stack;

public class DailyTemperature {
	/**
	根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

	例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
	
	提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

	 */
	public static int[] dailyTemperatures1(int[] T) {
        if(T == null || T.length == 0) return T;
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=T.length-1; i>=0; --i){
        	while(!stack.isEmpty() && T[i]>=T[stack.peek()]){
        		stack.pop();
        	}
        	if(stack.isEmpty()){
        		ans[i] = 0;
        	}else{
        		ans[i] = stack.peek()-i;
        	}
        	stack.push(i);
        }
        return ans;
    }
	
	public static int[] dailyTemperatures2(int[] T) {
	    int length = T.length;
	    int[] result = new int[length];

	    for (int i = 0; i < length; i++) {
	        int current = T[i];
	        if (current < 100) {
	            for (int j = i + 1; j < length; j++) {
	                if (T[j] > current) {
	                    result[i] = j - i;
	                    break;
	                }
	            }
	        }
	    }

	    return result;
	}
	
	public static int[] dailyTemperatures3(int[] T) {
	    int length = T.length;
	    int[] result = new int[length];

	    //从右向左遍历
	    for (int i = length - 2; i >= 0; i--) {
	        // j+= result[j]是利用已经有的结果进行跳跃
	        for (int j = i + 1; j < length; j+= result[j]) {
	            if (T[j] > T[i]) {
	                result[i] = j - i;
	                break;
	            } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
	                result[i] = 0;
	                break;
	            }
	        }
	    }

	    return result;
	}
	
	public static void main(String[] args) {
		int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] ans = dailyTemperatures1(T);
		for(int i: ans){
			System.out.println(i);
		}
	}
	
	/*
	方法二：栈
	我们需要找到比当前 T[i] 温度更高的位置，那么必须要记录哪些信息？
	我们试着找到 T[0] 过后温度升高的位置。如果知道 T[10]=50，则 T[20]=50 是无效信息，因为 T[i] 在 T[20] 以前已经到达了 50。如果 t[20]=100 将是有用的信息，因为如果 t[0]=80，那么 T[20] 将有可能是它的下一个温度升高的位置，而 T[10] 则不可能是。
	因此，我们需要记住一个索引的列表，索引代表的温度严格递增。我们可以利用栈来实现这样的效果。
	算法：
	
	我们用栈记录索引，满足 T[stack[-1]] < T[stack[-2]] < ...，其中 stack[-1] 是栈的顶部，stack[-2] 是从顶部开始的第二个元素，依此类推；我们将在处理每个 T[i] 时保持 stack[-1] > stack[-2] > ...。
	我们通过当前温度和栈顶索引所代表的温度比较来找到温度升高的位置。
	举个例子：我们反向遍历处理 t=[73，74，75，71，69，72，76，73] ，通过看栈元素的变化来理解是如何工作的。为了清楚 stack 只包含索引 i，但是将把 T[i] 的值写在旁边的括号中，例如 0 (73)。
	当 i = 7，stack = [7 (73)]。ans[i] = 0。
	当 i = 6，stack = [6 (76)]。ans[i] = 0。
	当 i = 5，stack = [5 (72), 6 (76)]。ans[i] = 1。
	当 i = 4，stack = [4 (69), 5 (72), 6 (76)]。ans[i] = 1。
	当 i = 3，stack = [3 (71), 5 (72), 6 (76)]。ans[i] = 2。
	当 i = 2，stack = [2 (75), 6 (76)]。ans[i] = 4。
	当 i = 1，stack = [1 (74), 2 (75), 6 (76)]。ans[i] = 1。
	当 i = 0，stack = [0 (73), 1 (74), 2 (75), 6 (76)]。ans[i] = 1。

	 */
}
