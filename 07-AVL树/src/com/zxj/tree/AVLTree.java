package com.zxj.tree;

import java.util.Comparator;

import com.zxj.tree.BinaryTree.Node;

@SuppressWarnings({"rawtypes","unchecked"})
public class AVLTree<E> extends BST<E>{

	public AVLTree() {
		this(null);
	}
	
	public AVLTree(Comparator<E> comparator){
		super(comparator);
	}
	
	@Override
	protected void afterAdd(Node<E> node) {
		while((node = node.parent) != null) {
			if(isBalanced(node)) {
				// 更新高度
				updateHeight(node);
			}else {
				// 恢复平衡
				reblalance(node);
				// 整棵树恢复平衡
				break;
			}
		}
	}
	
	@Override
	protected Node<E> createNode(E element, Node<E> parent) {
		return new AVLNode<>(element, parent);
	}
	 
	private boolean isBalanced(Node<E> node) {
		// 平衡因子的绝对值小于等于1，就表示该节点是平衡的。
		return Math.abs(((AVLNode)node).balanceFactor()) <= 1;
	}
	
	private void updateHeight(Node<E> node) {
		((AVLNode)node).updateHeight();
	}
	
	/**
	 * 恢复平衡
	 * @param node 高度最低的那个不平衡节点
	 */
	private void reblalance(Node<E> g) {
		Node<E> p = ((AVLNode)g).tallerChild();
		Node<E> n = ((AVLNode)p).tallerChild();
		if(p.isLeftChild()) {// L
			if(n.isLeftChild()) {// LL
				rotate(g, n, n.right, p, p.right, g);
			}else {// LR
				rotate(g, p, n.left, n, n.right, g);
			}
		}else {// R
			if(n.isLeftChild()) {// RL
				rotate(g, g, n.left, n, n.right, p);
			}else {// RR
				rotate(g, g, p.left, p, n.left, n);
			}
		}
	}

	private void rotate(
			Node<E> r,// 子树的根节点
			Node<E> b,Node<E> c,
			Node<E> d,
			Node<E> e,Node<E> f) {
		// 让d成为这棵树的根节点
		d.parent = r.parent;
		if(r.isLeftChild()) {
			r.parent.left = d;
		}else if(r.isRightChild()) {
			r.parent.right = d;
		}else {
			root = d;
		}
		
		// b-c
		b.right = c;
		if(c != null) c.parent = b;
		updateHeight(b);
		
		// e-f
		f.left = e;
		if(e != null) e.parent = f;
		updateHeight(f);
		
		//b-d-f
		d.left = b;
		d.right = f;
		b.parent = d;
		f.parent = d;
		updateHeight(d);
	}
	
	/**
	 * 恢复平衡
	 * @param node 高度最低的那个不平衡节点
	 */
	private void reblalance2(Node<E> g) {
		Node<E> p = ((AVLNode)g).tallerChild();
		Node<E> n = ((AVLNode)p).tallerChild();
		if(p.isLeftChild()) {// L
			if(n.isLeftChild()) {// LL
				rotateRight(g);
			}else {// LR
				rotateLeft(p);
				rotateRight(g);
			}
		}else {// R
			if(n.isLeftChild()) {// RL
				rotateRight(p);
				rotateLeft(g);
			}else {// RR
				rotateLeft(g);
			}
		}
	}
	
	private void rotateLeft(Node<E> g) {
		// 因为是左旋转，那么p节点肯定是g节点的右子树
		Node<E> p = g.right;
		Node<E> child = p.left;
		g.right = child;
		p.left = g;
		afterRotate(g,p,child);
	}
	
	private void rotateRight(Node<E> g) {
		Node<E> p = g.left;
		Node<E> child = p.right;
		g.left = child;
		p.right = g;
		afterRotate(g,p,child);
	}
	
	/**
	 * 公共代码，不管左旋转、右旋转，都要执行
	 * @param g 失衡节点
	 * @param p 失衡节点的tallerChild
	 * @param child g和p需要交换的子树(本来是p的子树，后面会变成g的子树)
	 */
	private void afterRotate(Node<E> g, Node<E> p, Node<E> child) {
		// 让p成为这棵子树的根节点
		p.parent = g.parent;
		if(g.isLeftChild()) {
			g.parent.left = p;
		}else if(g.isRightChild()) {
			g.parent.right = p;
		}else {// g是root节点
			root = p;
		}
		
		// 更新child的parent
		if(child != null) {
			child.parent = g;
		}
		
		// 更新g的parent
		g.parent = p;
		
		// 更新高度(先更新比较矮的g，再更新比较高的p)
		updateHeight(g);
		updateHeight(p);
	}
	
	private static class AVLNode<E> extends Node<E>{
		int height = 1;
		
		public AVLNode(E element, Node<E> parent) {
			super(element, parent);
		}
		
		/**
		 * 平衡因子
		 */
		public int balanceFactor() {
			int leftHeight = left == null ? 0 : ((AVLNode)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode)right).height;
			return leftHeight - rightHeight;
		}
		
		private void updateHeight() {
			int leftHeight = left == null ? 0 : ((AVLNode)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode)right).height;
			height = 1 + Math.max(leftHeight, rightHeight);
		}
		
		/**
		 * 当前节点左右子树那个比较高
		 */
		public Node<E> tallerChild() {
			int leftHeight = left == null ? 0 : ((AVLNode)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode)right).height;
			if(leftHeight > rightHeight) return left;
			if(leftHeight < rightHeight) return right;
			return isLeftChild() ? left : right;
		}
		
		@Override
		public String toString() {
			String parentString = null;
			if(parent != null) {
				parentString = parent.element.toString();
			}
			return element + "_p(" + parentString + ")_h("+height+")";
		}
	}
}
