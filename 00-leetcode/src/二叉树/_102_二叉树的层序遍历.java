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
		queue.offer(root);//将根节点放入队列中，然后不断遍历队列
		while(!queue.isEmpty()) {
			List<Integer> level = new ArrayList<Integer>();
			//获取当前队列的长度，这个长度相当于 当前这一层的节点个数
			int currentLeveSize = queue.size();
			//将队列中的元素都拿出来(也就是获取这一层的节点)，放到level的list中
			//如果节点的左/右子树不为空，也放入队列中
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
			res.add(level);//将level的list加入最终返回结果中
		}
		return res;
	}
}
