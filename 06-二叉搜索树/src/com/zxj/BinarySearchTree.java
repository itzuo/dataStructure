package com.zxj;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

import com.zxj.printer.BinaryTreeInfo;

/**
 * 二叉搜索树
 */
@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements BinaryTreeInfo{
	
	private Node<E> root;
	private int size;
	private Comparator<E> comparator;
	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Comparator<E> comparator){
		this.comparator = comparator;
	}

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
		
	}
	
	// 添加元素
	public void add(E element) {
		elementNotNullCheck(element);
		
		// 添加第一个节点
		if(root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}
		
		// 添加的不是第一个节点
		Node<E> node = root;//找到父节点
		Node<E> parent = null;
		int cmp = 0;
		while(node != null) {
			cmp = compare(element,node.element);
			parent = node;
			if(cmp > 0) {
				node = node.right;
			}else if(cmp < 0) {
				node = node.left;
			}else {// 相等
				node.element = element;
				return;
			}
		}
		
		// 看看插入到父节点的哪个位置
		Node<E> newNode = new Node<>(element,parent);
		if(cmp > 0) {
			parent.right = newNode;
		}else {
			parent.left = newNode;
		}
		size++;
	}

	// 删除元素
	public void remove(E element) {
		
	}

	 // 是否包含某元素
	public boolean contains(E element) {
		return false;
	}
	
	/**
	 * 前序遍历
	 */
	/*public void preorderTraversal() {
		preorderTraversal(root);
	}
	
	private void preorderTraversal(Node<E> node) {
		if(node == null) return;
		System.out.println(node.element);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}*/
	
	public void preorder(Visitor<E> visitor) {
		if(visitor == null) return;
		preorder(root,visitor);
	}
	
	private void preorder(Node<E> node,Visitor<E> visitor) {
		if(node == null || visitor.stop) return;
		visitor.stop = visitor.visit(node.element);
		preorder(node.left,visitor);
		preorder(node.right,visitor);
	}
	
	/**
	 * 中序遍历
	 */
	/*public void inorderTraversal() {
		inorderTraversal(root);
	}
	
	private void inorderTraversal(Node<E> node) {
		if(node == null) return;
		inorderTraversal(node.left);
		System.out.println(node.element);
		inorderTraversal(node.right);
	}*/
	
	public void inorder(Visitor<E> visitor) {
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
	
	/**
	 * 后序遍历
	 */
	/*public void postorderTraversal() {
		postorderTraversal(root);
	}
	
	private void postorderTraversal(Node<E> node) {
		if(node == null) return;
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.println(node.element);
	}*/
	
	public void postorder(Visitor<E> visitor) {
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
	
	/**
	 * 层序遍历
	 */
	/*public void levelOrderTraversal() {
		if(root == null) return;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node<E> node = queue.poll();
			System.out.println(node.element);
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
		}
	}*/
	
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
	 * 
	 * @param e1
	 * @param e2
	 * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
	 */
	private int compare(E e1,E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	private void elementNotNullCheck(E element) {
		if(element == null)
			throw new IllegalArgumentException("element must not be null !");
	}
	
	public static abstract class Visitor<E> {
		boolean stop;
		/**
		 * @return 如果返回true，就代表停止遍历
		 */
		public abstract boolean visit(E element);
	}
	
	/**
	 * 是否是完成二叉树
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
	
	private Node<E> predecessor(Node<E> node){
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
	
	private static class Node<E> {
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

	@Override
	public Object string(Object node) {
		// 如何打印每个节点
		return ((Node<E>)node).element;
	}
}
