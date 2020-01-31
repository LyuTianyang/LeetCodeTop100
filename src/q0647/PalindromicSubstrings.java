package q0647;

public class PalindromicSubstrings {
	/**
	给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

	具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
	
	示例 1:
	
	输入: "abc"
	输出: 3
	解释: 三个回文子串: "a", "b", "c".
	示例 2:
	
	输入: "aaa"
	输出: 6
	说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".

	 */
	public static int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int ans = 0;
        for(int center = 0; center <= 2*n-1; center++){
        	int left = center/2;
        	int right = left+center%2;
        	while(left >= 0 && right < n && s.charAt(left)==s.charAt(right)){
        		ans++;
        		left--;
        		right++;
        	}
        }
        return ans;
    }
	
	public static void main(String[] args) {
		String s = "acabade";
		int ans = countSubstrings(s);
		System.out.println(ans);
	}
	
	/*
	思路

	在长度为 N 的字符串中，可能的回文串中心位置有 2N-1 个：字母，或两个字母中间。
	
	从每一个回文串中心开始统计回文串数量。回文区间 [a, b] 表示 S[a], S[a+1], ..., S[b] 是回文串，根据回文串定义可知 [a+1, b-1] 也是回文区间。
	
	算法
	
	对于每个可能的回文串中心位置，尽可能扩大它的回文区间 [left, right]。当 left >= 0 and right < N and S[left] == S[right] 时，扩大区间。此时回文区间表示的回文串为 S[left], S[left+1], ..., S[right]。

	 */
}
