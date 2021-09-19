package com.zxj.single;

import com.zxj.AbstractList;

/**
 * 增加一个虚拟头结点
 *
 */
public class SingleLinkedList2<E> extends AbstractList<E>{

	private Node<E> first;
	
	public SingleLinkedList2() {
		first = new Node<>(null,null);
	}
	
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
		
		Node<E> prev = index == 0 ? first : findNode(index - 1);
		prev.next =new Node<E>(element, prev.next);
		
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
	
		Node<E> prev = index == 0 ? first : findNode(index - 1);
		Node<E> node = prev.next;
		prev.next = node.next;
		
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
		
		Node<E> node = first.next;
		for(int i=0;i < index;i++) {
			node = node.next;
		}
		return node;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first.next;
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
