package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 */
public class _226_翻转二叉树 {
	public TreeNode invertTreePreorder(TreeNode root) {
		// 采用前序遍历
		if(root == null) return root;
		
		// 交换一下左右
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		invertTreePreorder(root.left);// 遍历左
		invertTreePreorder(root.right);// 遍历右
		return root;
    }
	
	public TreeNode invertTreeInorder(TreeNode root) {
		// 采用中序遍历
		if(root == null) return root;
		
		invertTreeInorder(root.left);
		
		// 交换一下左右
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		invertTreeInorder(root.left);// 注意这里不是right了，
		return root;
    }
	
	public TreeNode invertTreePostorder(TreeNode root) {
		// 采用后序遍历
		if(root == null) return root;
		
		invertTreePostorder(root.left);// 遍历左
		invertTreePostorder(root.right);// 遍历右
		
		// 交换一下左右
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		return root;
    }
	
	public TreeNode invertTreeLevelOrder(TreeNode root) {
		// 采用层序遍历
		if(root == null) return root;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			
			// 交换一下左右
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
			
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
		}
		return root;
	}
}
