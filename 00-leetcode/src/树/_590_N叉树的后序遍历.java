package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class _590_N叉树的后序遍历 {
	
	List<Integer> res = new ArrayList<Integer>();
	
	// 递归
	public List<Integer> postorder(Node root) {
		if(root == null) return res;
		List<Node> nodes = root.children;
		for(Node node:nodes) {
			postorder(node);
		}
		res.add(root.val);
		return res;
	}
	
	// 迭代
	public List<Integer> postorder01(Node root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) return res;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			res.add(0,node.val);
			List<Node> nodes = node.children;
			if(nodes != null) {
				for(int i =0;i<nodes.size();i++) {
					Node node1 = nodes.get(i);
					stack.push(node1);
				}
			}
		}
		return res;
	}
}
