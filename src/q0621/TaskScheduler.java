package q0621;

import java.util.Arrays;

public class TaskScheduler {
	/**
	给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

	然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
	
	你需要计算完成所有任务所需要的最短时间。
	
	示例 1：
	
	输入: tasks = ["A","A","A","B","B","B"], n = 2
	输出: 8
	执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
	注：
	
	任务的总个数为 [1, 10000]。
	n 的取值范围为 [0, 100]。
	 */
	public static int leastInterval(char[] tasks, int n) {
		if(tasks == null || tasks.length == 0) return 0;
        int[] nums = new int[26];
        for(char c : tasks){
        	nums[c - 'A']++;
        }
        Arrays.sort(nums);
        int time = 0;
        while(nums[25]>0){
        	int i = 0;
        	while(i<=n){
        		if(nums[25] == 0){
        			break;
        		}
        		if(i<26 && nums[25-i]>0){
        			nums[25-i]--;
        		}
        		time++;
        		i++;
        	}
        	Arrays.sort(nums);
        }
        return time;
    }
	
	public static void main(String[] args) {
		char[] tasks = {'A','B','C','A','A','D','E','A','A','A'};
		int n = 2;
		int res = leastInterval(tasks, n);
		System.out.println(res);
	}
}