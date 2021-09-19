package 链表;

public class _206_反转链表 {

	public static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
    }
	
public static ListNode reverseList1(ListNode head) {
	ListNode newHead = null;
	while(head != null) {
		ListNode temp = head.next;
		head.next = newHead;
		newHead = head;
		head = temp;
	}
	return newHead;
}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		System.out.println(node1);
		System.out.println(reverseList1(node1));
	}
}
