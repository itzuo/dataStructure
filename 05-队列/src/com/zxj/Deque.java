package com.zxj;

import com.zxj.list.LinkedList;
import com.zxj.list.List;

/**
 * 双端队列
 */
public class Deque<E> {
	private List<E> list = new LinkedList<>();
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * 从队尾入队
	 * @param element
	 */
	public void enQueueRear(E element) {
		list.add(element);
	}
	
	/**
	 * 从队头入队
	 * @param element
	 */
	public void enQueueFront(E element) {
		list.add(0,element);
	}
	
	/**
	 * 从队尾出队
	 * @return
	 */
	public E deQueueRear() {
		return list.remove(size() -1);
	}
	
	/**
	 * 从队头出队
	 * @return
	 */
	public E deQueueFront() {
		return list.remove(0);
	}
	
	/**
	 * 获取队列的头元素
	 * @return
	 */
	public E front() {// 官方的是peekFirst()
		return list.get(0);
	}
	
	/**
	 * 获取队列的尾元素
	 * @return
	 */
	public E rear() {// 官方的是peekLast()
		return list.get(size() -1);
	}
	
	public void clear() {
		list.clear();
	}
}
