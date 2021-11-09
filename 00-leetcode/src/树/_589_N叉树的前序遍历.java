package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class _589_N叉树的前序遍历 {
	
	List<Integer> res = new ArrayList<Integer>();
	
	// 递归
	public List<Integer> preorder(Node root) {
		if (root == null)
			return res;
		res.add(root.val);
		List<Node> nodes = root.children;
		for(int i=0;i< nodes.size();i++) {
			Node node =nodes.get(i);
			preorder(node);
		}
		return res;
	}
	
	// 迭代
	public List<Integer> preorder01(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	Node node = stack.pop();
        	res.add(node.val);
            List<Node> nodes = node.children;
            if(nodes != null) {
	            for(int i = nodes.size() -1;i >= 0;i--) {
	            	stack.push(nodes.get(i));
	            }
            }
        }
		return res;
	}
	
	public static void main(String[] args) {
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node2 = new Node(2);
		Node node4 = new Node(4);
		List<Node> nodes3 = new ArrayList<>();
		nodes3.add(node5);
		nodes3.add(node6);
		Node node3 = new Node(3,nodes3);
		List<Node> nodes1 = new ArrayList<>();
		nodes1.add(node3);
		nodes1.add(node2);
		nodes1.add(node4);
		Node node1 = new Node(1,nodes1);
		
		_589_N叉树的前序遍历 test = new _589_N叉树的前序遍历();
		System.out.println(test.preorder01(node1));
	}
}
