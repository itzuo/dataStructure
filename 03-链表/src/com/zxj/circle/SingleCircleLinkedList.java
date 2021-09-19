package com.zxj.circle;

import com.zxj.AbstractList;

/**
 * 单向循环链表
 */
public class SingleCircleLinkedList<E> extends AbstractList<E>{

	private Node<E> first;
	
	private static class Node<E>{
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(element).append("_").append(next.element);
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
		if(index == 0) {
			Node<E> newFirst = new Node<E>(element, first);
			
			//(size == 0)->表示链表中没有任何结点，findNode(size - 1)->寻找最后一个元素
			Node<E> last = (size == 0) ? newFirst : findNode(size - 1);
			last.next = newFirst;
			first = newFirst;
		}else {
			Node<E> prev = findNode(index - 1);
			prev.next = new Node<E>(element, prev.next);
		}
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);//如果链表中没有结点
		Node<E> node = first;
		if(index == 0) {
			if(size == 1) {//如果链表中只有一个结点
				first = null;
			}else {
				//这一句必须在first = first.next;上面执行
				Node<E> last = findNode(size - 1);
				first = first.next;
				last.next = first;
			}
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
			
			string.append(node);
			
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
