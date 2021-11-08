package 二叉树;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 */
public class _662_二叉树最大宽度 {
	//  第一思路：广度优先遍历，思路可行，开搞
	// 搞完一波发现思路好像不太行，因为它中间空的位置也要计算
	// 看了看评论发现一个很吊的思路：因为每个节点原本的值是没有用处的，所以我们可以用其来保存节点的位置信息
	// 所用的算法知识点（完全二叉树的性质）：对于一颗完全二插树，如果按照从上至下，从左往右对所有节点从零开始顺序编号
	// 则父节点的左孩子节点的序号：2*i+1   父节点的左孩子节点的序号：2*i+2;
	// 所以每层的宽度就可以使用：每层最后一个节点的值减去最后一个节点的值+1
	public int widthOfBinaryTree(TreeNode root) {
		if(root == null) return 0;
		// 创建一个队列来进行广度优先遍历,注意这个地方就不要使用Queue<TreeNode> queue=new LinkedList<TreeNode>();
        // 因为父类不能调用子类的方法：getLast getFirst
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        // 改变根结点的值
        root.val=0;
		queue.offer(root);//将根节点放入队列中，然后不断遍历队列
		int maxWidth = 0;// 创建一个变量来保存最大宽度
		while (!queue.isEmpty()) {
			//获取当前队列的长度，这个长度相当于 当前这一层的节点个数
			int currentLeveSize = queue.size();
			//创建一个变量来计算每层的宽度
			int width = queue.getLast().val - queue.getFirst().val+1;
			System.out.println("width:"+width);
			for(int i =1;i<= currentLeveSize;i++) {
				TreeNode node = queue.poll();
				if(node.left != null) {
					node.left.val = 2*node.val+1;
					queue.offer(node.left);
				}
				if(node.right != null) {
					node.right.val = 2*node.val+2;
					queue.offer(node.right);
				}
			}
			// 求出每一层的宽度
			if(width > maxWidth) {
				maxWidth = width;
			}
		}
		return maxWidth;
	}
	
	public static void main(String[] args) {
		TreeNode node6 = new TreeNode(6);
		TreeNode node5 = new TreeNode(5,node6,null);
		TreeNode node3 = new TreeNode(3,node5,null);
		TreeNode node7 = new TreeNode(7);
		TreeNode node9 = new TreeNode(9,null,node7);
		TreeNode node2 = new TreeNode(2,null,node9);
		TreeNode node1 = new TreeNode(1,node3,node2);
		
		_662_二叉树最大宽度 test = new _662_二叉树最大宽度();
		System.out.println(test.widthOfBinaryTree(node1));
	}
}
