package 链表;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class _876_链表的中间结点 {
	/**
	 * 集合 
	 */
	public ListNode middleNode01(ListNode head) {
		ListNode node = head;
		List<ListNode> list = new ArrayList<>();
		while (node != null) {
			list.add(node);
			node = node.next;
		}
		int m = list.size()/2;
		return list.get(m);
    }
	
	/**
	 * 快慢指针法
	 */
	public ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
