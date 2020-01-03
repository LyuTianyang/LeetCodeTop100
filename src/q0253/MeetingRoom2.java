package q0253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
class Interval{
	int start;
	int end;
	Interval(){start = 0; end = 0;}
	Interval(int s, int e){
		start = s;
		end = e;
	}
}

class IntervalComparator1 implements Comparator<Interval>{
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}

class IntervalComparator2 implements Comparator<Interval>{
	public int compare(Interval i1, Interval i2) {
		return i1.end - i2.end;
	}
}
public class MeetingRoom2 {
	/**
	Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
	find the minimum number of conference rooms required.
	
	Example 1:
	Input: [[0, 30],[5, 10],[15, 20]]
	Output: 2
	
	Example 2:
	Input: [[7,10],[2,4]]
	Output: 1
	
	求这个人能最多参加几个会议
	 */
	public static int minMeetingRooms1(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) return 0;
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		for(int i=0; i<intervals.length; i++){
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int room = 0;
		int tmp = 0;
		for(int i=0; i<start.length; i++){
			if(start[i]<end[tmp]){
				room ++;
			}else{
				tmp++;
			}
		}
		return room;
	}
	
	public static void main(String[] args) {
		Interval i1 = new Interval();
		i1.start = 0; i1.end = 30;
		Interval i2 = new Interval();
		i2.start = 5; i2.end = 10;
		Interval i3 = new Interval();
		i3.start = 15; i3.end = 20;
		Interval[] intervals = {i1, i2, i3};
		int res = minMeetingRooms2(intervals);
		System.out.println(res);
	}
	
	public static int minMeetingRooms2(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) return 0;
		//比较start
		IntervalComparator1 cmp1 = new IntervalComparator1();
		Arrays.sort(intervals, cmp1);
		//比较end java 1.8之后才能这样写
		IntervalComparator2 cmp2 = new IntervalComparator2();
		PriorityQueue<Interval> queue = new PriorityQueue<Interval>(cmp2);
		for (Interval interval : intervals) {
            if (!queue.isEmpty() && interval.start >= queue.peek().end) {
                queue.poll();
            }
            queue.add(interval);
        }
        return queue.size();
    }
	
}
