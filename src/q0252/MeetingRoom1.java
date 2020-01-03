package q0252;

import java.util.Arrays;
import java.util.Comparator;

class Interval{
	int start;
	int end;
	Interval(){start = 0; end = 0;}
	Interval(int s, int e){
		start = s;
		end = e;
	}
}

class IntervalComparator implements Comparator<Interval>{
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}

public class MeetingRoom1 {
	/**
	Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

	For example,
	Given [[0, 30],[5, 10],[15, 20]],
	return false.
	
	给一个会议时间区间的数组，问一个人是否能参加所有的会议。就是求这些区间是否有交集，如果有就不能参加所有的会，没有交集就可以参加所有的会议。
	
	解法：先把区间按开始时间排序，然后判断每一个区间的开始时间是否比前一个会议的结束时间早，如果有，就是时间重叠。
	 */
	public static boolean canAttendMeetings(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) return false;
		Arrays.sort(intervals, new IntervalComparator());
		
		for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
		return true;
	}
	
	public static void main(String[] args) {
		Interval i1 = new Interval();
		i1.start = 0; i1.end = 30;
		Interval i2 = new Interval();
		i2.start = 5; i2.end = 10;
		Interval i3 = new Interval();
		i3.start = 15; i3.end = 20;
		Interval[] intervals = {i1, i2, i3};
		boolean res = canAttendMeetings(intervals);
		System.out.println(res);
	}
}
