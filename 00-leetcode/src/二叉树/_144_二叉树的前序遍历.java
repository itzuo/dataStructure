package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class _144_二叉树的前序遍历 {

	List<Integer> res = new ArrayList<Integer>();

	// 递归
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null)
			return res;
		res.add(root.val);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		return res;
	}

	// 迭代(https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-qian-zhong-hou-xu-die-dai-bia-ozsw/)
	public List<Integer> preorderTraversal01(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                res.add(cur.val); // root
                stack.push(cur); 
                cur = cur.left; // left
            }else{
                cur = stack.pop();
                cur = cur.right; // right
            }
        }
        return res;
    }
	
	// 迭代--前序遍历顺序：中-左-右，入栈顺序：中-右-左
	public List<Integer> preorderTraversal02(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
		return res;
	}

}
