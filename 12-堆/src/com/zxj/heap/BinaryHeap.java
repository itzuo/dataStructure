package com.zxj.heap;

import java.util.Comparator;

import com.zxj.printer.BinaryTreeInfo;

/**
 * 二叉堆（Binary Heap)最大堆
 */
public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo{
	private E[] elements;
	private static final int DEFAULt_CAPACITY = 10;
	
	public BinaryHeap(Comparator<E> comparator) {
		super(comparator);
		this.elements = (E[]) new Object[DEFAULt_CAPACITY];
	}
	 
	public BinaryHeap() {
		this(null);
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	@Override
	public void add(E element) {
		 elementNotNullCheck(element);
		 ensureCapacity(size + 1);
		 elements[size++] = element;
		 siftUp(size - 1);
	}

	@Override
	public E get() {
		emptyCheck();
		return elements[0];
	}

	@Override
	public E remove() {
		emptyCheck();
		E root = elements[0];
		int lastIndex = --size;
		elements[0] = elements[lastIndex];
		elements[lastIndex] = null;
		
		siftDown(0);
		return root;
	}

	@Override
	public E replace(E element) {
		elementNotNullCheck(element);
		
		E root = null;
		if (size == 0) {
			elements[0] = element;
			size++;
		}else {
			root = elements[0];
			elements[0] = element;
			siftDown(0);
		}
		return root;
	}
	
	/**
	 * 让index位置的元素上滤
	 * @param index
	 */
	private void siftUp(int index) {
		/*E e = elements[index];
		while (index > 0) {
			int pindex = (index - 1) >> 1;// 性质：floor( (i - 1)/2 )
			E p = elements[pindex];
			if(compare(e, p) <= 0) return;
			// 交换index、pindex位置的内容
			E tmp = elements[index];
			elements[index] = elements[pindex];
			elements[pindex] = tmp;
			
			// 重新赋值index
			index = pindex;
		}*/
		E element = elements[index];
		while (index > 0) {
			int parentIndex = (index - 1) >> 1;// 性质：floor( (i - 1)/2 )
			E parent = elements[parentIndex];
			if(compare(element, parent) <= 0) break;
			
			// 将父元素存储在index位置
			elements[index] = parent;
			
			// 重新赋值index
			index = parentIndex;
		}
		elements[index] = element;
	}
	
	/**
	 * 让index位置的元素下滤
	 * @param index
	 */
	private void siftDown(int index) {
		E element = elements[index];
		int half = size >> 1; // floor(n / 2)
		// 第一个叶子节点的索引 == 非叶子节点的数量
		// index < 第一个叶子节点的索引
		while(index < half) {// 必须保证index位置是非叶子节点
			// index的节点有2种情况
			// 1.只有左子节点
			// 2.同时有左右子节点
			
			// 默认为左子节点跟它进行比较
			int childIndex = (index << 1) + 1;// 2i + 1
			E child = elements[childIndex];
			
			// 右子节点
			int rightIndex = childIndex + 1; 
			
			// 选出左右子节点最大的那个
			if (rightIndex < size && compare(elements[rightIndex], child) > 0) {
				child = elements[childIndex = rightIndex];
			}
			
			if (compare(element, child) >= 0) break;

			// 将子节点存放到index位置
			elements[index] = child;
			// 重新设置index
			index = childIndex;
		}
		elements[index] = element;
	}
	
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		// 新容量为旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
	}
	
	private void emptyCheck() {
		if(size == 0) {
			throw new IndexOutOfBoundsException("Heep is empty");
		}
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}

	@Override
	public Object root() {
		return 0;// 这里返回的是索引
	}

	@Override
	public Object left(Object node) {
		int index = ((int)node << 1) + 1;// 性质：左索引 2i + 1
		return index >= size ? null : index;
	}

	@Override
	public Object right(Object node) {
		int index = ((int)node << 1) + 2;// 性质：左索引 2i + 2
		return index >= size ? null : index;
	}

	@Override
	public Object string(Object node) {
		return elements[(int)node];
	}
}
