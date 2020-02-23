package q0394;

import java.util.LinkedList;

public class DecodeString {
	/**
	给定一个经过编码的字符串，返回它解码后的字符串。

	编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
	
	你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
	
	此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
	
	示例:
	
	s = "9[a]2[bc]", 返回 "aaabcbc".
	s = "3[a2[c]]", 返回 "accaccacc".
	s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
	 */
	public static String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder res = new StringBuilder();
        int num = 0;
        LinkedList<Integer> stack_num = new LinkedList<Integer>();
        LinkedList<String> stack_res = new LinkedList<String>();
        for(int i=0; i<s.length(); i++){
        	if(s.charAt(i) == '['){
        		stack_num.addLast(num);
        		stack_res.addLast(res.toString());;
        		num = 0;
        		res = new StringBuilder();
        	}else if(s.charAt(i) == ']'){
        		StringBuilder tmp = new StringBuilder();
        		int cur = stack_num.removeLast();
        		for(int j=0; j<cur; j++){
        			tmp.append(res);
        		}
        		res = new StringBuilder(stack_res.removeLast() + tmp);
        	}else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
        		num = num*10 + Integer.parseInt(s.charAt(i) + "");
        	}else{
        		res.append(s.charAt(i));
        	}
        }
        return res.toString();
    }
	
	public static String decodeString1(String s) {
		if(s == null || s.length() == 0) return s;
		StringBuilder res = new StringBuilder();
		LinkedList<Integer> stack_num = new LinkedList<Integer>();
		LinkedList<String> stack_res = new LinkedList<String>();
		int num = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '['){
				stack_num.addLast(num);
				stack_res.addLast(res.toString());
				num = 0;
				res = new StringBuilder();
			}else if(s.charAt(i) == ']'){
				StringBuilder tmp = new StringBuilder();
				int cur = stack_num.removeLast();
				for(int j=0; j<cur;j++){
					tmp.append(res);
				}
				res = new StringBuilder(stack_res.removeLast()+tmp);
			}else if(s.charAt(i) >= '0' && s.charAt(i)<='9'){
				num = num*10 + Integer.parseInt(s.charAt(i)+"");
			}else{
				res.append(s.charAt(i));
			}
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		String s = "3[a2[c]]";
		String res = decodeString1(s);
		System.out.println(res);
	}
}
