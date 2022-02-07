package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {
	
	/**
	 * 递归
	 */
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return head;
		head.next = removeElements(head.next, val);
		return head.val == val ? head.next : head;
	}
	
	/**
	 * 迭代
	 */
	public ListNode removeElements01(ListNode head, int val) {
		ListNode dummyNode=new ListNode(0);
		dummyNode.next = head;
		ListNode temp = dummyNode;
		while (temp.next != null) {
			if(temp.next.val == val) {
				temp.next = temp.next.next;
			}else {
				temp = temp.next;
			}
		}
		return dummyNode.next;
    }
	
	public static void main(String[] args) {
		ListNode node1 =new ListNode(1);
		ListNode node2 =new ListNode(2);
		ListNode node3 =new ListNode(6);
		ListNode node4 =new ListNode(3);
		ListNode node5 =new ListNode(4);
		ListNode node6 =new ListNode(5);
		ListNode node7 =new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		System.out.println(node1.toString());
		
		_203_移除链表元素 test = new _203_移除链表元素();
		ListNode node = test.removeElements(node1,6);
		System.out.println(node.toString());
	}
}
