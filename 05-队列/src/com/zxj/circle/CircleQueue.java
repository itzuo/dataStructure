package com.zxj.circle;

/**
 * 循环队列
 */
public class CircleQueue<E> {
	
	private static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;
	private int front;
	
	public CircleQueue() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enQueue(E element) {
		elements[(front + size) % elements.length] = element;
		size++;
	}
	
	public E deQueue() {
		E frontElement = elements[front];
		elements[front] = null;
		front = (front + 1) % elements.length;
		size--;
		return frontElement;
	}
	
	public E front() {
		return elements[front];
	}
	
	@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("capcacity=").append(elements.length)
			.append(",size=").append(size).append(",[");
			for(int i = 0;i < elements.length;i++) {
				if(i != 0)
					sb.append(",");
				sb.append(elements[i]);
			}
			sb.append("]");
			return sb.toString();
		}
}
