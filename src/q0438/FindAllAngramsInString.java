package q0438;

import java.util.ArrayList;
import java.util.List;

public class FindAllAngramsInString {
	/**
	给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

	字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
	
	说明：
	
	字母异位词指字母相同，但排列不同的字符串。
	不考虑答案输出的顺序。
	示例 1:
	
	输入:
	s: "cbaebabacd" p: "abc"
	
	输出:
	[0, 6]
	
	解释:
	起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
	起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
	 示例 2:
	
	输入:
	s: "abab" p: "ab"
	
	输出:
	[0, 1, 2]
	
	解释:
	起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
	起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
	起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
	 */
	
	
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<Integer>();
        if(s == null || s.length() == 0) return res;
        int[] needs = new int[26];
        int[] window = new int[26];
        int left = 0;
        int right = 0;
        int total = p.length();
        for(char c : p.toCharArray()){
        	needs[c-'a']++;
        }
        while(right < s.length()){
        	char ch = s.charAt(right);
        	if(needs[ch-'a'] > 0){
        		window[ch-'a']++;
        		if(window[ch-'a'] <= needs[ch-'a']){
        			total--;
        		}
        	}
        	while(total == 0){
        		if(right-left+1 == p.length()){
        			res.add(left);
        		}
        		char ch1 = s.charAt(left);
        		if(needs[ch1-'a'] > 0){
        			window[ch1-'a']--;
        			if(window[ch1-'a'] < needs[ch1-'a']){
        				total++;
        			}
        		}
        		left++;
        	}
        	right++;
        }
        return res;
    }
	
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> res = findAnagrams(s,p);
		System.out.println(res);
	}
	
	/*
	string s, t;
	// 在 s 中寻找 t 的「最小覆盖子串」
	int left = 0, right = 0;
	string res = s;

	while(right < s.size()) {
	    window.add(s[right]);
	    right++;
	    // 如果符合要求，移动 left 缩小窗口
	    while (window 符合要求) {
	        // 如果这个窗口的子串更短，则更新 res
	        res = minLen(res, window);
	        window.remove(s[left]);
	        left++;
	    }
	}
	return res;
	*/
}
