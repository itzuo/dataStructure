package 链表;

public class ListNode {
	int val;
	ListNode next;
	public ListNode(int x) {
		val = x;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("[");
		ListNode node = this;
		
		
		while(node != null){
			string.append(node.val);
			node = node.next;
			if(node != null) {
				string.append(", ");
			}
		}
		
		string.append("]");
		return string.toString();
	}
}
