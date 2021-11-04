package 二叉树.遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import 二叉树.TreeNode;

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

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node5 = new TreeNode(5);
		TreeNode node10 = new TreeNode(10);
		TreeNode node12 = new TreeNode(12);
		TreeNode node11 = new TreeNode(11,node10,node12);
		TreeNode node8 = new TreeNode(8);
		TreeNode node2 = new TreeNode(2,node1,node3);
		TreeNode node9 = new TreeNode(9,node8,node11);
		TreeNode node4 = new TreeNode(4,node2,node5);
		TreeNode root = new TreeNode(7,node4,node9);
		_144_二叉树的前序遍历 test = new _144_二叉树的前序遍历();
		System.out.println(test.preorderTraversal02(root));
		
		setAIDetections(DETECT_FACE|DETECT_BODY|DETECT_FACE);
	}
	static int DETECT_HAND = 0x0001;
	static int DETECT_BODY = 0x0002;
	static int DETECT_FACE = 0x0004;
    
	public static void setAIDetections(int flag) {
		System.out.println("flag:"+flag);
		System.out.println("===="+(flag & DETECT_HAND));
		if((flag & DETECT_HAND) == DETECT_HAND) {
			System.out.println("DETECT_HAND");
		}
		if((flag & DETECT_BODY) == DETECT_BODY) {
			System.out.println("DETECT_BODY");
		}
		
		if((flag & DETECT_FACE) == DETECT_FACE) {
			System.out.println("DETECT_FACE");
		}
	}
}
