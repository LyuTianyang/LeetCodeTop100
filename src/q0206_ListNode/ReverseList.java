package q0206_ListNode;
import q0148_ListNode.SortListNode;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
    	val=x;
    }
}
public class ReverseList {
	/**
	反转一个单链表。
	示例:
	
	输入: 1->2->3->4->5->NULL
	输出: 5->4->3->2->1->NULL
	
	3 -> 4 -> 5
	h    t
	
	3 -> pre(null) 4 -> 5
				   h
	3	4 -> 5
	pre h
	 */
	public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        while(head != null){
        	ListNode tmp = head.next;
        	head.next = pre;
        	pre = head;
        	head = tmp;
        }
        return pre;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(4);
		head.next.next = new ListNode(5);
		//head.next.next.next= new ListNode(4);
		//head.next.next.next.next= new ListNode(5);
        ListNode res = reverseList(head);
        System.out.println(res);
    }
}
