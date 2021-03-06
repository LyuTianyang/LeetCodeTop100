package q0155_design;

import java.util.Stack;

/**
设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。

示例:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 */
public class MinStack {
	/** initialize your data structure here. */
	int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    
    public MinStack() {
        
    }
    
    public void push(int x) {
    	//当前值更小
    	if(x <= min){
    		//将之前最小值入栈保存
    		stack.push(min);
    		//更新最小值
    		min=x;
    	}
    }
    
    public void pop() {
        //如果弹出的值是最小值，那么将下一个元素更新为最小值
    	if(stack.pop() == min){
    		min = stack.pop();
    	}
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
