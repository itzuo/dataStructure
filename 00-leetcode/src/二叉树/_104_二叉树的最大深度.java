package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class _104_二叉树的最大深度 {
	
	//递归方法
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	// 迭代
	public int maxDepth01(TreeNode root) {
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
	
	// 广度优先搜索(https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/)
	public int maxDepth02(TreeNode root) {
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int height = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size > 0) {
				TreeNode node = queue.poll();
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
				size--;
			}
			height++;
		}
		return height;
	}
}
