package q0234_ListNode;
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
    	val=x;
    }
}
public class PalindromeLinkedList {
	/**
	 请判断一个链表是否为回文链表。

	示例 1:
	
	输入: 1->2
	输出: false
	示例 2:
	
	输入: 1->2->2->1
	输出: true
	 */
	public static boolean isPalindrome1(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = reverse(slow);
		//注意退出条件是p1 != slow
        for(ListNode p1 = head, p2 = fast; p1 != slow; p1 = p1.next, p2 = p2.next){
        	if(p1.val != p2.val) return false;
        }
        return true;
    }
	
	public static ListNode reverse(ListNode head){
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while(head != null){
			ListNode next = head.next;
			head.next = cur.next;
			cur.next = head;
			head = next;
		}
		return dummy.next;
	}
	
	public static boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null) {
            slow = slow.next;
        }
        while(pre != null && slow != null) {
            if(pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		boolean res = isPalindrome1(head);
		System.out.println(res);
	}
}
