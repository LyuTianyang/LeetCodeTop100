package q0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	/**
	给出一个区间的集合，请合并所有重叠的区间。

	示例 1:
	输入: [[1,3],[2,6],[8,10],[15,18]]
	输出: [[1,6],[8,10],[15,18]]
	解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
	
	示例 2:
	输入: [[1,4],[4,5]]
	输出: [[1,5]]
	解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
	
	1 2 8  15
	3 6 10 18
	 */
	public static List<List<Integer>> merge(int[][] intervals) {
		List<List<Integer>> tmps = new ArrayList<List<Integer>>();
		if(intervals == null || intervals.length == 0) return tmps;
		int n = intervals.length;
		//放每个interval的起始点
		int[] start = new int[n];
		int[] end = new int[n];
		for(int i=0; i<n; i++){
			start[i] = intervals[i][0];
			end[i] = intervals[i][intervals[i].length-1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int i=0;
		while(i<n){
			int st = start[i];
			//用第1个区间的终点和第2个区间的起点比较，比如用3和2比较
			while(i < n-1 && end[i]>=start[i+1]){
				i++;
			}
			int ed = end[i];
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(st);
			tmp.add(ed);
			tmps.add(tmp);
			i++;
		}
		return tmps;
	}
	
	public static int[][] merge1(int[][] intervals) {
		List<List<Integer>> tmps = new ArrayList<List<Integer>>();
		if(intervals==null || intervals.length==0) return intervals;
		//放每个interval的起始点
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		for(int i=0; i<intervals.length; i++){
			start[i] = intervals[i][0];
			end[i] = intervals[i][intervals[i].length-1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int i=0;
		while(i<intervals.length){
			int st = start[i];
			//用第1个区间的终点和第2个区间的起点比较，比如用3和2比较
			while(i<intervals.length-1 && start[i+1] <= end[i]){
				i++;
			}
			int ed = end[i];
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(st);
			tmp.add(ed);
			tmps.add(tmp);
			i++;
		}
		System.out.println(tmps);
		int[][] results = new int[tmps.size()][2];
		for(int j=0; j<results.length; j++){
			int st = tmps.get(j).get(0);
			int ed = tmps.get(j).get(tmps.get(j).size()-1);
			int[] result = {st, ed};
			results[j] = result;
		}
		return results;
    }
	
	public static void main(String[] args) {
		int[][] intervals = new int[4][2];
		//[[1,3],[2,6],[8,10],[15,18]]
		intervals[0]=new int[]{1,3};
		intervals[1]=new int[]{2,6};
		intervals[2]=new int[]{8,10};
		intervals[3]=new int[]{15,18};
		List<List<Integer>> res = merge(intervals);
		//int[][] res = merge1(intervals);
		System.out.println(res);
	}
	
}
