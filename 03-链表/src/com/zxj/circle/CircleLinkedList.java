package com.zxj.circle;

import com.zxj.AbstractList;

/**
 * 双向循环链表
 */
public class CircleLinkedList<E> extends AbstractList<E>{

	private Node<E> first;
	private Node<E> last;
	
	private static class Node<E>{
		E element;
		Node<E> prev;
		Node<E> next;
		public Node(Node<E> prev,E element, Node<E> next) {
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			if (prev != null) {
				sb.append(prev.element);
			} else {
				sb.append("null");
			}
			
			sb.append("_").append(element).append("_");

			if (next != null) {
				sb.append(next.element);
			} else {
				sb.append("null");
			}
			
			return sb.toString();
		}
	}

	@Override
	public E get(int index) {
		return findNode(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = findNode(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		
		if(index == size) {// 往最后面添加元素
			Node<E> oldLast = last;
			last = new Node<>(oldLast,element,first);
			// 如果最开始链表是空的，就是什么结点都没有
			if(oldLast == null) {
				first = last;
				first.next = first;
				first.prev = first;
			}else {
				oldLast.next = last;
				first.prev = last;
			}
		}else {
			Node<E> next = findNode(index);//新添加结点的下一个结点
			Node<E> prev = next.prev;//新添加结点的上一个结点
			Node<E> node = new Node<>(prev,element,next);
			next.prev = node;
			prev.next = node;
			
			if(next == first) {//index ==0 在0的位置插入结点
				first = node;
			}
		}
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);//如果链表中没有数据
		
		Node<E> node = first;
		if(size == 1) {
			first = null;
			last = null;
		}else {
			node = findNode(index);
			Node<E> prev = node.prev;
			Node<E> next = node.next;
			prev.next = next;
			next.prev = prev;
			
			if(node == first) {//index == 0 删除0位置的结点
				first = next;
			}
			
			if(node == last) {//index == size - 1 删除最后一个结点
				last = prev;
			}
		}
		
		size--;
		return node.element;
	}

	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	@Override
	public int indexOf(E element) {
		if (element == null) {  // 1
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i; 
				node = node.next;
			}
		} else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) return i; // n
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
		last = null;
	}
	
	/**
	 * 获取index位置对应的节点对象
	 * @param index
	 * @return
	 */
	private Node<E> findNode(int index){
		rangeCheck(index);
		Node<E> node;
		if(index < (size >> 1)) {//小于size的一半
			node = first;
			for(int i=0;i < index;i++) {
				node = node.next;
			}
		}else {//大于size的一半
			node = last;
			for(int i = size - 1;i > index;i--) {
				node = node.prev;
			}
		}
		return node;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			
			string.append(node);
			
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
}
