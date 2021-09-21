package com.zxj;

import com.zxj.list.LinkedList;
import com.zxj.list.List;

public class Queue<E> {

	private List<E> list = new LinkedList<>();
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void enQueue(E element) {// 官方的是offer(E e)
		list.add(element);
	}
	
	public E deQueue() {// 官方的是poll()
		return list.remove(0);
	}
	
	public E front() {// 官方的是peek()
		return list.get(0);
	}
	
	public void clear() {
		list.clear();
	}
}
