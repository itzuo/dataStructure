package 链表;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目链接： https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class _142_环形链表_II {

	public ListNode detectCycle(ListNode head) {
		Set<ListNode> set = new HashSet<ListNode>();
		while(head != null) {
			if(set.add(head)) {
				head = head.next;
			}else {
				return head;
			}
		}
		return null;
	}
}
