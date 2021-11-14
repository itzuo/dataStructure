package com.zxj.tree;

import java.util.Comparator;

import com.zxj.tree.BinaryTree.Node;

/**
 * RedBlackTree
 */
@SuppressWarnings("unused")
public class RBTree<E> extends BBST<E>{
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	public RBTree() {
		this(null);
	}
	
	public RBTree(Comparator<E> comparator){
		super(comparator);
	}
	
	@Override
	protected void afterAdd(Node<E> node) {
		Node<E> parent = node.parent;
		
		// 添加的是根节点或者上溢到达了根节点
		if(parent == null) {
			black(node);
			return;
		}
		
		// 如果父节点是黑色，直接返回
		if(isBlack(parent)) return;
		
		// 叔父节点
		Node<E> uncle = parent.sibling();
		// 祖父节点
		Node<E> grand = red(parent.parent);
		if(isRed(uncle)) {// 叔父节点是红色【B树节点上溢】
			black(parent);
			black(uncle);
			// 把祖父节点当做是新添加的节点
			afterAdd(grand);
			return;
		}
		
		// 叔父节点不是红色 
		if (parent.isLeftChild()) {// L
			if(node.isLeftChild()) {// LL
				black(parent);
			}else {// LR
				black(node);
				rotateLeft(parent);
			}
			rotateRight(grand);
		}else {// R
			if(node.isLeftChild()) {// RL
				black(node);
				rotateRight(parent);
			}else {// RR
				black(parent);
			}
			rotateLeft(grand);
		}
	}
	
	@Override
	protected void afterRemove(Node<E> node,Node<E> replacement) {
		// 如果删除的节点是红色
		if(isRed(node)) return;
		
		// 用以取代node的子节点是红色
		if(isRed(replacement)) {
			black(replacement);
			return;
		}
		
		Node<E> parent = node.parent;
		// 删除的是根节点
		if(parent == null) return;
		
		// 删除的是黑色叶子节点
		Node<E> sibling = node.sibling();
		boolean left = parent.left == null;
		
		
	}
	
	private RBNode<E> color(Node<E> node,boolean color){
		if(node != null) {
			((RBNode<E>)node).color = color;
		}
		return (RBNode<E>)node;
	}
	
	private RBNode<E> red(Node<E> node){
		return color(node, RED);
	}
	
	private RBNode<E> black(Node<E> node){
		return color(node, BLACK);
	}
	
	private boolean colorOf(Node<E> node) {
		return node == null ? BLACK : ((RBNode<E>)node).color;
	}
	
	private boolean isBlack(Node<E> node) {
		return colorOf(node) == BLACK;
	}
	
	private boolean isRed(Node<E> node) {
		return colorOf(node) == RED;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Node<E> createNode(E element, Node<E> parent) {
		return new RBNode(element, parent);
	}
	
	private static class RBNode<E> extends Node<E>{
		boolean color = RED;
		public RBNode(E element, Node<E> parent) {
			super(element, parent);
		}
		
		@Override
		public String toString() {
			String str = "";
			if (color == RED) {
				str = "R_";
			}
			return str + element.toString();
		}
	}
}
