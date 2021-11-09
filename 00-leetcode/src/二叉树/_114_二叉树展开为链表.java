package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class _114_二叉树展开为链表 {
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		List<TreeNode> list = new ArrayList<>();
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node);

			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}

		for (int i = 1; i < list.size(); i++) {
			TreeNode prev = list.get(i - 1);
			TreeNode curr = list.get(i);
			prev.left = null;
			prev.right = curr;
		}
	}

	/**
	 * 使用方法一的前序遍历，由于将节点展开之后会破坏二叉树的结构而丢失子节点的信息，因此前序遍历和展开为单链表分成了两步。能不能在不丢失子节点的信息的情况下，将前序遍历和展开为单链表同时进行？
	 * 之所以会在破坏二叉树的结构之后丢失子节点的信息，是因为在对左子树进行遍历时，没有存储右子节点的信息，在遍历完左子树之后才获得右子节点的信息。只要对前序遍历进行修改，在遍历左子树之前就获得左右子节点的信息，并存入栈内，子节点的信息就不会丢失，就可以将前序遍历和展开为单链表同时进行。
	 * 该做法不适用于递归实现的前序遍历，只适用于迭代实现的前序遍历。修改后的前序遍历的具体做法是，每次从栈内弹出一个节点作为当前访问的节点，获得该节点的子节点，如果子节点不为空，则依次将右子节点和左子节点压入栈内（注意入栈顺序）。
	 * 展开为单链表的做法是，维护上一个访问的节点 prev，每次访问一个节点时，令当前访问的节点为 curr，将 prev 的左子节点设为 null 以及将
	 * prev 的右子节点设为 curr，然后将 curr 赋值给 prev，进入下一个节点的访问，直到遍历结束。 需要注意的是，初始时 prev 为
	 * null，只有在 prev 不为 null 时才能对 prev 的左右子节点进行更新。
	 */
	public void flatten01(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		TreeNode prev = null;
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (prev != null) {
				prev.left = null;
				prev.right = node;
			} else
				prev = node;
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}
	
	/* https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
	 *      1
		   / \
		  2   5
		 / \   \
		3   4   6
		
		//将 1 的左子树插入到右子树的地方
		    1
		     \
		      2         5
		     / \         \
		    3   4         6        
		//将原来的右子树接到左子树的最右边节点
		    1
		     \
		      2          
		     / \          
		    3   4  
		         \
		          5
		           \
		            6
		            
		 //将 2 的左子树插入到右子树的地方
		    1
		     \
		      2          
		       \          
		        3       4  
		                 \
		                  5
		                   \
		                    6   
		        
		 //将原来的右子树接到左子树的最右边节点
		    1
		     \
		      2          
		       \          
		        3      
		         \
		          4  
		           \
		            5
		             \
		              6         
		  
		  ......
	 */
	public void flatten02(TreeNode root) {
	    while (root != null) { 
	        //左子树为 null，直接考虑下一个节点
	        if (root.left == null) {
	            root = root.right;
	        } else {
	            // 找左子树最右边的节点
	            TreeNode pre = root.left;
	            while (pre.right != null) {
	                pre = pre.right;
	            } 
	            //将原来的右子树接到左子树的最右边节点
	            pre.right = root.right;
	            // 将左子树插入到右子树的地方
	            root.right = root.left;
	            root.left = null;
	            // 考虑下一个节点
	            root = root.right;
	        }
	    }
	}

	public static void main(String[] args) {
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node6 = new TreeNode(6);
		TreeNode node5 = new TreeNode(5, null, node6);
		TreeNode node2 = new TreeNode(2, node3, node4);
		TreeNode node1 = new TreeNode(1, node2, node5);

		_114_二叉树展开为链表 test = new _114_二叉树展开为链表();
		test.flatten(node1);
	}
}
