package q0160_ListNode;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
    	val=x;
    }
}
public class IntersectionNode {
	/**
	编写一个程序，找到两个单链表相交的起始节点。
	
	输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
	输出：Reference of the node with value = 8
	输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
	
	输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
	输出：Reference of the node with value = 2
	输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
	
	输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
	输出：null
	输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
	解释：这两个链表不相交，因此返回 null。
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        if(lenA > lenB){
        	while(lenA != lenB){
        		headA = headA.next;
        		lenA--;
        	}
        }else if(lenA < lenB){
        	while(lenA != lenB){
        		headB = headB.next;
        		lenB--;
        	}
        }
        while(headA.val != headB.val){
        	headA = headA.next;
        	headB = headB.next;
        }
        return headA;
    }
	
	public static int getLen(ListNode head){
		int len = 1;
		while(head != null){
			head = head.next;
			len++;
		}
		return len;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(0);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(1);
		l2.next.next.next= new ListNode(2);
		l2.next.next.next.next= new ListNode(4);
		
		ListNode result = getIntersectionNode(l1,l2);
		System.out.println(result.val);
	}
}
