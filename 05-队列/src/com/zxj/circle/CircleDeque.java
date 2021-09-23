package com.zxj.circle;

/**
 * 循环双端队列
 */
public class CircleDeque<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;
	private int front;
	
	public CircleDeque() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 从队尾入队
	 * @param element
	 */
	public void enQueueRear(E element) {
		ensureCapacity(size +1);
		
		elements[index(size)] = element;
		size++;
	}
	
	/**
	 * 从队头入队
	 * @param element
	 */
	public void enQueueFront(E element) {
		ensureCapacity(size +1);
		
		front = index(-1);
		elements[front] = element;
		size++;
	}
	
	/**
	 * 从队尾出队
	 * @return
	 */
	public E deQueueRear() {
		int rearIndex = index(size -1);
		E rear = elements[rearIndex];
		elements[rearIndex] = null;
		size--;
		return rear;
	}
	
	/**
	 * 从队头出队
	 * @return
	 */
	public E deQueueFront() {
		E frontElement = elements[front];
		elements[front] = null;
		front = index(1);
		size--;
		return frontElement;
	}
	
	/**
	 * 获取队列的头元素
	 * @return
	 */
	public E front() {// 官方的是peekFirst()
		return elements[front];
	}
	
	/**
	 * 获取队列的尾元素
	 * @return
	 */
	public E rear() {// 官方的是peekLast()
		return elements[index(size -1)];
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
	
	//索引映射分装
	private int index(int index) {
		index += front;
		if(index < 0) {
			return index + elements.length;
		}
		return index % elements.length;
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
