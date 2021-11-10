package com.zxj.tree;

import java.util.Comparator;

public class BBST<E> extends BST<E> {
	
	public BBST() {
		this(null);
	}
	
	public BBST(Comparator<E> comparator){
		super(comparator);
	}
	
	protected void rotateLeft(Node<E> g) {
		// 因为是左旋转，那么p节点肯定是g节点的右子树
		Node<E> p = g.right;
		Node<E> child = p.left;
		g.right = child;
		p.left = g;
		afterRotate(g,p,child);
	}
	
	protected void rotateRight(Node<E> g) {
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
	protected void afterRotate(Node<E> g, Node<E> p, Node<E> child) {
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
		
		
	}
	
	protected void rotate(
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
		
		// e-f
		f.left = e;
		if(e != null) e.parent = f;
		
		//b-d-f
		d.left = b;
		d.right = f;
		b.parent = d;
		f.parent = d;
	}
}
