package com.zxj.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.zxj.printer.BinaryTreeInfo;

@SuppressWarnings("unchecked")
public class BinaryTree<E> implements BinaryTreeInfo{
	protected Node<E> root;
	protected int size;
	
	// 元素的数量
	public int size() {
		return size;
	}
	
	// 是否为空
	public boolean isEmpty() {
		return size == 0; 
	}
	
	// 清空所有元素
	public void clear() {
		root = null;
		size = 0;
	}
	
	/**
	 * 前序遍历
	 */
	// 递归
	public void preorder1(Visitor<E> visitor) {
		if(visitor == null) return;
		preorder(root,visitor);
	}
	
	private void preorder(Node<E> node,Visitor<E> visitor) {
		if(node == null || visitor.stop) return;
		visitor.stop = visitor.visit(node.element);
		preorder(node.left,visitor);
		preorder(node.right,visitor);
	}
	
	// 非递归
	public void preorder(Visitor<E> visitor) {
		/*if(visitor == null || root == null) return;
		Node<E> node = root;
		Stack<Node<E>> stack = new Stack<>();
		while(true) {
			if(node != null) {
				if(visitor.visit(node.element)) return;
				// 将右子节点入栈
				if(node.right != null) {
					stack.push(node.right);
				}
				// 向左走
				node = node.left;
			}else if(stack.isEmpty()) {
				return;
			}else {
				node = stack.pop();
			}
		}*/
		if(visitor == null || root == null) return;
		Stack<Node<E>> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node<E> node = stack.pop();
			if(visitor.visit(node.element)) return;
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
	}
	
	/**
	 * 中序遍历
	 */
	// 递归
	public void inorder1(Visitor<E> visitor) {
		if(visitor == null) return;
		inorder(root,visitor);
	}
	
	private void inorder(Node<E> node,Visitor<E> visitor) {
		//这个visitor.stop是停止的递归遍历
		if(node == null || visitor.stop) return;
		inorder(node.left,visitor);
		//这个visitor.stop停止的是外界的打印
		if(visitor.stop) return;
		visitor.stop = visitor.visit(node.element);
		inorder(node.right,visitor);
	}
	
	// 非递归
	public void inorder(Visitor<E> visitor) {
		if (visitor == null || root == null) return;
		Node<E> node = root;
		Stack<Node<E>> stack = new Stack<>();
		while (true) {
			if (node != null) {
				stack.push(node);
				// 向左走
				node = node.left;
			} else if (stack.isEmpty()) {
				return;
			} else {
				node = stack.pop();
				// 访问node节点
				if (visitor.visit(node.element)) return;
				// 让右节点进行中序遍历
				node = node.right;
			}
		}
	}
	
	/**
	 * 后序遍历
	 */
	// 递归
	public void postorder1(Visitor<E> visitor) {
		if(visitor == null) return;
		postorder(root,visitor);
	}
	
	private void postorder(Node<E> node,Visitor<E> visitor) {
		if(node == null || visitor.stop) return;
		postorder(node.left,visitor);
		postorder(node.right,visitor);
		if(visitor.stop) return;
		visitor.stop = visitor.visit(node.element);
	}
	
	// 非递归
	public void postorder(Visitor<E> visitor) {
		/*if (visitor == null || root == null) return;
		Stack<Node<E>> stack = new Stack<>();
		stack.push(root);
		Node<E> prev = null;// 记录上一次弹出访问的节点
		while(!stack.isEmpty()) {
			Node<E> top =stack.peek();
			if(top.isLeaf() || (prev != null && prev.parent == top) ) {
				prev = stack.pop();
				if (visitor.visit(prev.element)) return;
			}else {
				if(top.right != null) {
					stack.push(top.right);
				}
				if(top.left != null) {
					stack.push(top.left);
				}
			}
		}*/
		if (visitor == null || root == null) return;
		Stack<E> resStack = new Stack<>();
		Stack<Node<E>> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node<E> node = stack.pop();
			resStack.push(node.element);
			if(node.left != null) {
				stack.push(node.left);
			}
			if(node.right != null) {
				stack.push(node.right);
			}
		}
		while (!resStack.isEmpty()) {
			E element = resStack.pop();
			if (visitor.visit(element)) return;
		}
	}
	
	/**
	 * 层序遍历
	 */
	public void levelOrder(Visitor<E> visitor) {
		if(root == null || visitor == null) return;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if(visitor.visit(node.element)) return;
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
		}
	}
	
	/**
	 * 是否是完全二叉树
	 */
	public boolean isComplete() {
		if(root == null) return false;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		boolean leaf = false;
		while(!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if(leaf && !node.isLeaf()) {
				//如果要求你是叶子结点，但是你不是叶子结点
				return false;
			}
			
			if(node.left != null) {
				queue.offer(node.left);
			}else if(node.right != null) {
				// node.left == null && node.right != null
				return false;
			}
			
			if(node.right != null) {
				queue.offer(node.right);
			}else {// node.right == null
				leaf = true;
			}
		}
		return true;
	}
	
	/*public boolean isComplete() {
		if(root == null) return false;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		boolean leaf = false;
		while(!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if(leaf && !node.isLeaf()) {
				//如果要求你是叶子结点，但是你不是叶子结点
				return false;
			}
			
			if(node.hasTwoChildren()) {
				queue.offer(node.left);
				queue.offer(node.right);
			}else if (node.left == null && node.right != null) {
				return false;
			}else {// 后面遍历的结点都必须是叶子结点
				leaf = true;
				if(node.left != null) {
					queue.offer(node.left);
				}
			}
		}
		return true;
	}*/
	
	public int height() {
		if(root == null) return 0;
		
		//树的高度
		int height = 0;
		// 存储着每一层的元素数量
		int levelSize = 1;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node<E> node = queue.poll();
			levelSize--;//levelSize减为0，代表这一层就访问完了。
			
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
			
			if(levelSize == 0) {//意味着即将要访问下一层
				levelSize = queue.size();
				height++;
			}
		}
		return height;
	}
	
	/**
	 * 递归方法
	 * @return
	 */
	public int height2() {
		return height(root);
	}
	
	private int height(Node<E> node) {
		if(node == null) return 0;
		return 1 + Math.max(height(node.left),height(node.right));
	}
	
	/**
	 * 前驱节点(predecessor)
	 */
	protected Node<E> predecessor(Node<E> node){
		if(node == null) return null;
		
		// 前驱节点在左子树当中(left.right.right.right...)
		Node<E> p = node.left;
		if(p != null) {
			while (p.right != null) {
				p = p.right;
			}
			return p;
		}
		
		// 从父节点、祖父节点中寻找前驱节点
		while(node.parent != null && node == node.parent.left) {
			//该节点的父节点不为空，并且该节点是父节点的左孩子
			node = node.parent;
		}
		// 第一种情况：node.parent == null
		// 第二种情况：node == node.parent.right
		return node.parent;
	}
	
	/**
	 * 后继节点(successor)
	 */
	protected Node<E> successor(Node<E> node){
		if(node == null) return null;
		
		// 后继节点在右子树当中(right.left.left.left...)
		Node<E> p = node.right;
		if(p != null) {
			while (p.left != null) {
				p = p.left;
			}
			return p;
		}
		
		// 从父节点、祖父节点中寻找后继节点
		while(node.parent != null && node == node.parent.right) {
			//该节点的父节点不为空，并且该节点是父节点的右孩子
			node = node.parent;
		}
		// 第一种情况：node.parent == null
		// 第二种情况：node == node.parent.left
		return node.parent;
	}
	
	public static abstract class Visitor<E> {
		boolean stop;
		/**
		 * @return 如果返回true，就代表停止遍历
		 */
		public abstract boolean visit(E element);
	}
	
	protected static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
		
		// 是否是叶子结点
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		// 是否有左右两个结点
		public boolean hasTwoChildren() {
			return left != null && right != null;
		}
	}
	
	@Override
	public Object root() {
		// 根节点是谁
		return root;
	}

	@Override
	public Object left(Object node) {
		// 如何查找左节点
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		// 如何查找右节点
		return ((Node<E>)node).right;
	}

	/*@Override
	public Object string(Object node) {
		// 如何打印每个节点
		return ((Node<E>)node).element;
	}*/
	
	@Override
	public Object string(Object node) {
		Node<E> myNode = (Node<E>)node;
		String parentString = null;
		if(myNode.parent != null) {
			parentString = myNode.parent.element.toString();
		}
		return myNode.element + "_p(" + parentString + ")";
	}
}
