package com.zxj;

import java.util.Comparator;

/**
 * 二叉搜索树
 */
@SuppressWarnings("unchecked")
public class BinarySearchTree<E> {
	
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
	
	private static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
		
	}
}
