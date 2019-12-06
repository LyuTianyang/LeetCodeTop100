package q0139;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	/**
	给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

	拆分时可以重复使用字典中的单词。
	你可以假设字典中没有重复的单词。
	示例 1：
	
	输入: s = "leetcode", wordDict = ["leet", "code"]
	输出: true
	解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
	示例 2：
	
	输入: s = "applepenapple", wordDict = ["apple", "pen"]
	输出: true
	解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
	     注意你可以重复使用字典中的单词。
	示例 3：
	
	输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
	输出: false
	 */
	/*
	s = s'(0,j)+s'(j+1,i)
	把字符串s拆分成 s.substring(0,j) s.substring(j+1,i)
	 */
	public static boolean wordBreak(String s, List<String> wordDict) {
		if(s == null || s.length() == 0) return false;
		if(wordDict == null || wordDict.size() ==0) return false;
		//state
		boolean[] dp = new boolean[s.length()+1];
		//init
		dp[0] = true;
		//function s = s'(0,j)+s'(j+1,i) s=s.substring(0,j)+s.substring(j+1,i)
		for(int i=1; i<= s.length(); i++){
			for(int j=0; j<i; j++){
				if(dp[j] && wordDict.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}
			}
		}
		//result
		return dp[s.length()];
    }
	
	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("apple");
		wordDict.add("pen");
		boolean result = wordBreak("applepenapple",wordDict);
		System.out.println(result);
		
	}
}
