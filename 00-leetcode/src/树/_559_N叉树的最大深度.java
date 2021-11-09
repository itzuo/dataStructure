package 树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class _559_N叉树的最大深度 {
	
	public int maxDepth(Node root) {
		if (root == null) return 0;
		int result = 1;
		for (Node node : root.children) {
			result = Math.max(result, 1 + maxDepth(node));
		}
		return result;
	}
	
	public int maxDepth01(Node root) {
		if(root == null) return 0;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		//树的高度
		int height = 0;
		// 存储着每一层的元素数量
		int levelSize = 1;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			levelSize--;
			List<Node> nodes = node.children;
	
			if(nodes != null) {
				for(Node node1:nodes) {
					queue.offer(node1);
				}
			}
			if(levelSize == 0) {
				levelSize = queue.size();
				height++;
			}
		}
		return height;
	}
	
	public int maxDepth02(Node root) {
		if(root == null) return 0;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		int height = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size > 0) {
				Node node = queue.poll();
				List<Node> nodes = node.children;
				if(nodes != null) {
					for(Node node1:nodes) {
						queue.offer(node1);
					}
				}
				size--;
			}
			height++;
		}
		return height;
	}
}
