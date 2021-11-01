package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class _102_二叉树的层序遍历 {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> level = new ArrayList<Integer>();
			//获取当前队列的长度，这个长度相当于 当前这一层的节点个数
			int currentLeveSize = queue.size();
			for(int i =1;i<= currentLeveSize;i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
			}
			res.add(level);
		}
		return res;
	}
}
