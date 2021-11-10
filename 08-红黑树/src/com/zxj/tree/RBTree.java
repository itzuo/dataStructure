package com.zxj.tree;

import java.util.Comparator;

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
		
		// 添加的是根节点
		if(parent == null) {
			black(node);
			return;
		}
		
		// 如果父节点是黑色，直接返回
		if(isBlack(parent)) return;
		
		// 叔父节点
		Node<E> uncle = parent.sibling();
		// 祖父节点
		Node<E> grand = parent.parent;
		if(isRed(uncle)) {// 叔父节点是红色
			black(parent);
			black(uncle);
			// 把祖父节点当做是新添加的节点
			afterAdd(red(grand));
			return;
		}
		
		// 叔父节点不是红色 
		if (parent.isLeftChild()) {// L
			red(grand);
			if(node.isLeftChild()) {// LL
				black(parent);
			}else {// LR
				black(node);
				rotateLeft(parent);
			}
			rotateRight(grand);
		}else {// R
			red(grand);
			if(node.isLeftChild()) {// RL
				black(node);
				rotateRight(parent);
			}else {// RR
				black(parent);
				red(grand);
			}
			rotateLeft(grand);
		}
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
	
	private static class RBNode<E> extends Node<E>{
		boolean color = RED;
		public RBNode(E element, Node<E> parent) {
			super(element, parent);
		}
		
	}
}
