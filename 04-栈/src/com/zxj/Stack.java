package com.zxj;

import com.zxj.list.*;

public class Stack<E>{
	private List<E> list = new ArrayList<>();
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public void push(E element) {
		list.add(element);
	}

	public E pop() {
		return list.remove(size() -1);
	}

	public E top() {// 官方的是peek()
		return list.get(size() -1);
	}
	
	public void clear() {
		list.clear();
	}
}
