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
		ensureCapacity(size +1);
		
		elements[index(size)] = element;
		size++;
	}
	
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if(oldCapacity >= capacity) return;
		
		// 新容量为旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[index(i)];
		}
		elements = newElements;
		
		// 重置front
		front = 0;
		
		System.out.println(oldCapacity + "扩容为" + newCapacity);	
	}
	
	public E deQueue() {
		E frontElement = elements[front];
		elements[front] = null;
		front = index(1);
		size--;
		return frontElement;
	}
	
	private int index(int index) {
		return (front + index) % elements.length;
	}
	
	public E front() {
		return elements[front];
	}
	
	@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("capcacity=").append(elements.length)
			.append(",size=").append(size).append(",front=").append(front)
			.append(",[");
			for(int i = 0;i < elements.length;i++) {
				if(i != 0)
					sb.append(",");
				sb.append(elements[i]);
			}
			sb.append("]");
			return sb.toString();
		}
}
