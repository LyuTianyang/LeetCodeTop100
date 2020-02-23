package q0406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstractionByHeight {
	/**
	假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
	其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 
	
	编写一个算法来重建这个队列。
	注意：
	总人数少于1100人。
	
	示例
	
	输入:
	[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	
	输出:
	[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
	 */
	/*
	题目大意
	给出了一个数组，数组的每个元素表示一个人的身高以及在一个队伍前面不比他矮的人的个数。现在要重新排列，使得数组是满足条件的。
	
	解题方法
	这个题怎么想出来的呢？是因为我们考虑如果先把个子高的排好序，那么在任何位置插入数据都不会对已经排好序的数组造成影响。而，与此同时，我们已经知道了个子高的排序，那么当新的数据到的时候，我们要确定它的位置也很简单，因为现在的所有数据都比他高，所以只要根据他的第二个数字确定他的位置即可。
	
	先对已有的数组进行排序。按照高度降序排列，如果高度一样，按照k的值升序排列。这样比如一开始[7，0] [7，1] [7，2]就会排好，然后比如说后面有一个[6，1]， 说明只有一个大于或等于它，又因为比6大的已经全部取出。所以把它放在位置1，这样就变成[7，0] [6，1] [7，1] [7，2].然后比如又有一个[5，0].就放在位置0，以此类推。
	[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	
	[[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
	
	[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
	 */
	public static int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length <= 1) return people;
        Arrays.sort(people, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]==o2[0] ? o1[1]-o2[1] : o2[0]-o1[0];
			}
        });
        
        List<int[]> temp = new ArrayList<int[]>();
		for (int[] p : people) {
			if (people.length == p[1]) {
				temp.add(p);
			} else {
				temp.add(p[1], p);
			}
		}
		int ans[][] = new int[people.length][2];
		for (int i = 0; i < temp.size(); i++) {
			ans[i] = temp.get(i);
		}
		return ans;
    }
	
	public static void main(String[] args) {
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		int[][] res = reconstructQueue(people);
		System.out.println(Arrays.toString(res));
	}
}
