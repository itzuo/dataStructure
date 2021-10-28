package com.zxj.tree;

import java.util.Comparator;

@SuppressWarnings({"unused","rawtypes","unchecked"})
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
	
	private void rotateLeft(Node<E> node) {
		
	}
	
	private void rotateRight(Node<E> node) {
		
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
	}
}
