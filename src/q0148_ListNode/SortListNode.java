package q0148_ListNode;
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
    	val=x;
    }
}
public class SortListNode {
	/**
	在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

	示例 1:
	
	输入: 4->2->1->3
	输出: 1->2->3->4
	示例 2:
	
	输入: -1->5->3->4->0
	输出: -1->0->3->4->5
	分治
	 */
	public ListNode sortList(ListNode head) {
	    return mergeSort(head);
	}
	private ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) return head;
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode fast = dummy;
	    ListNode slow = dummy;
	    //快慢指针找中点
	    while (fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    ListNode head2 = slow.next;
	    slow.next = null;
	    head = mergeSort(head);
	    head2 = mergeSort(head2);
	    return merge(head, head2);
	}

	private ListNode merge(ListNode head1, ListNode head2) {
	    ListNode dummy = new ListNode(0);
	    ListNode tail = dummy;
	    while (head1 != null && head2 != null) {
	        if (head1.val < head2.val) {
	            tail.next = head1;
	            tail = tail.next;
	            head1 = head1.next;
	        } else {
	            tail.next = head2;
	            tail = tail.next;
	            head2 = head2.next;
	        }

	    }
	    if (head1 != null) {
	        tail.next = head1;
	    }
	    if (head2 != null) {
	        tail.next = head2;
	    }
	    return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(9);
		head.next.next = new ListNode(5);
		head.next.next.next= new ListNode(3);
		head.next.next.next.next= new ListNode(7);
        SortListNode s = new SortListNode();
        ListNode sortList = s.sortList(head);
        System.out.println(sortList);
    }
}
