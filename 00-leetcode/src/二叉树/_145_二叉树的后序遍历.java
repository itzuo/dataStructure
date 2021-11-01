package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class _145_二叉树的后序遍历 {
	List<Integer> res = new ArrayList<Integer>();

	// 递归
	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null)
			return res;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		res.add(root.val);
		return res;
	}
	
	// 迭代(https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/jian-dan-yi-dong-javac-pythonjs-er-cha-s-btwx/)
	public List<Integer> postorderTraversal01(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
			if(node.left != null) {
				stack.push(node.left);
			}
			if(node.right != null) {
				stack.push(node.right);
			}
		}
		Collections.reverse(res);
		return res;
	}
	
	// 前序遍历顺序为：根 -> 左 -> 右
    // 后序遍历顺序为：左 -> 右 -> 根
    // 所以, 我们可以把前序遍历的稍作修改: 根 -> 右 -> 左, 
    // 然后结果存放到栈里进行倒序, 之后再遍历结果栈就可以输出后序遍历了
	public List<Integer> postorderTraversal02(TreeNode root) {
		 Stack<TreeNode> s = new Stack<>();
	        Stack<TreeNode> resStack = new Stack<>();
	        TreeNode cur = root;
	        while(cur != null || !s.isEmpty()){
	            if(cur != null){
	                resStack.push(cur); // root
	                s.push(cur); 
	                cur = cur.right; // right
	            }else{
	                cur = s.pop();
	                cur = cur.left; // left
	            }
	        }

	        List<Integer> res = new ArrayList<>();
	        while(!resStack.isEmpty()){
	            res.add(resStack.pop().val);
	        }
	        return res;
	}
}
