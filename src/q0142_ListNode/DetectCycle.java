package q0142_ListNode;

import java.util.HashSet;
import java.util.Set;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
    	val=x;
    }
}
public class DetectCycle {
	/**
	给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
	为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 
	如果 pos 是 -1，则在该链表中没有环。
	说明：不允许修改给定的链表。
	
	示例 1：
	输入：head = [3,2,0,-4], pos = 1
	输出：tail connects to node index 1
	解释：链表中有一个环，其尾部连接到第二个节点。
	
	示例 2：
	输入：head = [1,2], pos = 0
	输出：tail connects to node index 0
	解释：链表中有一个环，其尾部连接到第一个节点。
	
	示例 3：
	输入：head = [1], pos = -1
	输出：no cycle
	解释：链表中没有环。
	 */
	public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode current = head;
        while(current != null){
        	if(set.contains(current)){
        		return current;
        	}
        	set.add(current);
        	current = current.next;
        }
        return null;
    }
	
	/**
	https://www.cnblogs.com/hiddenfox/p/3408931.html
	
	第一次相遇时slow走过的距离：a+b，fast走过的距离：a+b+c+b。
	因为fast的速度是slow的两倍，所以fast走的距离是slow的两倍，有 2(a+b) = a+b+c+b，可以得到a=c（这个结论很重要！）。
	我们发现L=b+c=a+b，也就是说，从一开始到二者第一次相遇，循环的次数就等于环的长度。
	
	2. 我们已经得到了结论a=c，那么让两个指针分别从X和Z开始走，每次走一步，那么正好会在Y相遇！也就是环的第一个节点。
	
	3. 在上一个问题的最后，将c段中Y点之前的那个节点与Y的链接切断即可。
	
	4. 如何判断两个单链表是否有交点？先判断两个链表是否有环，如果一个有环一个没环，肯定不相交；如果两个都没有环，判断两个列表的尾部是否相等；如果两个都有环，判断一个链表上的Z点是否在另一个链表上。
	
	如何找到第一个相交的节点？求出两个链表的长度L1,L2（如果有环，则将Y点当做尾节点来算），假设L1<L2，用两个指针分别从两个链表的头部开始走，长度为L2的链表先走(L2-L1)步，然后两个一起走，直到二者相遇。
	 */
	public static ListNode detectCycle1(ListNode head) {
	    ListNode slow = head;
	    ListNode fast = head;

	    while (true) {
	        if (fast == null || fast.next == null) {
	            return null;    //遇到null了，说明不存在环
	        }
	        slow = slow.next;
	        fast = fast.next.next;
	        if (fast == slow) {
	            break;    //第一次相遇在Z点
	        }
	    }

	    slow = head;    //slow从头开始走，
	    while (slow != fast) {    //二者相遇在Y点，则退出
	        slow = slow.next;
	        fast = fast.next;
	    }
	    return slow;
	}
}
