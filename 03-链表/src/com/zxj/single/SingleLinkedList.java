package com.zxj.single;

import com.zxj.AbstractList;

public class SingleLinkedList<E> extends AbstractList<E>{

	
	private Node<E> first;
	
	private static class Node<E>{
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}

	@Override
	public E get(int index) {
		//最好：O(1)、最坏：O(n)、平均：O(n)
		return findNode(index).element;
	}

	@Override
	public E set(int index, E element) {
		//最好：O(1)、最坏：O(n)、平均：O(n)
		Node<E> node = findNode(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		//最好：O(1)、最坏：O(n)、平均：O(n)
		rangeCheckForAdd(index);
		if(index == 0) {
			first = new Node<E>(element, first);
		}else {
			Node<E> prev = findNode(index - 1);
			prev.next =new Node<E>(element, prev.next);
		}
		size++;
	}

	@Override
	public E remove(int index) {
		//最好：O(1)、最坏：O(n)、平均：O(n)
		rangeCheck(index);//如果链表中没有数据
		Node<E> node = first;
		if(index == 0) {
			first = first.next;
		}else {
			Node<E> prev = findNode(index - 1);
			node = prev.next;
			prev.next = node.next;
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
		first = null;
		size =0;
	}
	
	/**
	 * 获取index位置对应的节点对象
	 * @param index
	 * @return
	 */
	private Node<E> findNode(int index){
		rangeCheck(index);
		
		Node<E> node = first;
		for(int i=0;i < index;i++) {
			node = node.next;
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
			
			string.append(node.element);
			
			node = node.next;
		}
		
		/*while(node != null){
			if (node != first) {
				string.append(", ");
			}
			
			string.append(node.element);
			node = node.next;
		}*/
		
		string.append("]");
		return string.toString();
	}
}
