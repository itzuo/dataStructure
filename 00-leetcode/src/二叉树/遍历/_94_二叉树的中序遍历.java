package 二叉树.遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import 二叉树.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class _94_二叉树的中序遍历 {
	List<Integer> res = new ArrayList<Integer>();

	// 递归
	public List<Integer> inorderTraversal01(TreeNode root) {
		if (root == null)
			return res;
		inorderTraversal(root.left);
		res.add(root.val);
		inorderTraversal(root.right);
		return res;
	}
	
	// 迭代(https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-qian-zhong-hou-xu-die-dai-bia-ozsw/)
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
//		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur!= null || !stack.isEmpty()) {
			//不断往左子树方向走，每走一次就将当前节点保存到栈中
			//这是模拟递归的调用
			if(cur != null) {
				stack.push(cur);
				cur = cur.left;
			//当前节点为空，说明左边走到头了，从栈中弹出节点并保存
			//然后转向右边节点，继续上面整个过程
			}else {
				cur = stack.pop();
				res.add(cur.val);
				cur = cur.right;
			}
		}
		return res;
	}
	
	
}
