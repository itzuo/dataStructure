package 二叉树;

import java.util.LinkedList;
import java.util.Queue;


/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class _110_平衡二叉树 {
	public boolean isBalanced(TreeNode root) {
		if(root == null ) return true;
		return Math.abs(balanceFactor(root)) <=1 && isBalanced(root.left) && isBalanced(root.right);
	}
	public int balanceFactor(TreeNode node) {
		int leftHeight = node.left == null ? 0 : maxDepth(node.left);
		int rightHeight = node.right == null ? 0 : maxDepth(node.right);
		return leftHeight - rightHeight;
	}
	
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		//树的高度
		int height = 0;
		// 存储着每一层的元素数量
		int levelSize = 1;
				
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			levelSize--;//levelSize减为0，代表这一层就访问完了。
			
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);
			
			if(levelSize == 0) {//意味着即将要访问下一层
				levelSize = queue.size();
				height++;
			}
		}
		return height;
	}
}
