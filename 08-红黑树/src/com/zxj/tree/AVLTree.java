package com.zxj.tree;

import java.util.Comparator;

@SuppressWarnings({"rawtypes","unchecked"})
public class AVLTree<E> extends BBST<E>{

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
	protected void afterRemove(Node<E> node,Node<E> replacement) {
		while((node = node.parent) != null) {
			if(isBalanced(node)) {
				// 更新高度
				updateHeight(node);
			}else {
				// 恢复平衡
				reblalance(node);
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
	
	@Override
	protected void afterRotate(Node<E> g, Node<E> p, Node<E> child) {
		super.afterRotate(g, p, child);
		// 更新高度(先更新比较矮的g，再更新比较高的p)
		updateHeight(g);
		updateHeight(p);
	}
	
	@Override
	protected void rotate(Node<E> r, Node<E> b, Node<E> c, Node<E> d, Node<E> e, Node<E> f) {
		super.rotate(r, b, c, d, e, f);
		updateHeight(b);
		updateHeight(f);
		updateHeight(d);
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
