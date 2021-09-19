package com.zxj;

/**
 * 有动态缩容
 *
 */
public class ArrayList2<E> extends AbstractList<E> {

	/**
	 * 所有的元素
	 */
	private E[] elements;

	private static final int DEFAULT_CAPACITY = 10;

	@SuppressWarnings("unchecked")
	public ArrayList2(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
		elements = (E[]) new Object[capaticy];
	}

	public ArrayList2() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * 清除所有元素
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	/**
	 * 获取index位置的元素
	 * 
	 * @param index
	 * @return
	 */
	public E get(int index) {// O(1)
		rangeCheck(index);
		return elements[index];
	}

	/**
	 * 设置index位置的元素
	 * 
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public E set(int index, E element) {// O(1)
		rangeCheck(index);

		E old = elements[index];
		elements[index] = element;
		return old;
	}

	/**
	 * 在index位置插入一个元素
	 * 
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		/**
		 * 最好：O(1) 最坏：O(n) 平均：(1+2+...+n)/n = n/2 ==> O(n)
		 */
		rangeCheckForAdd(index);

		ensureCapacity(size + 1);

		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = element;
		size++;
	}

	/**
	 * 删除index位置的元素
	 * 
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		/**
		 * 最好：O(1) 最坏：O(n) 平均：(1+2+...+n)/n = n/2 ==> O(n)
		 */
		rangeCheck(index);

		E old = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}
		elements[--size] = null;

		trim();
		return old;
	}

	private void trim() {
		int oldCapacity = elements.length;
		int newCapacity = oldCapacity >> 1;
		if (size >= newCapacity || oldCapacity <= DEFAULT_CAPACITY) return;
//		if(size > newCapacity || oldCapacity <= DEFAULT_CAPACITY) return;// Test
		System.out.println("缩容->size:"+size+",旧容量"+oldCapacity+"，新容量_"+newCapacity);

		// 剩余空间还很多
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity+"缩容为"+newCapacity);
	}

	/**
	 * 查看元素的索引
	 * 
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {
		if (element == null) { // 1
			for (int i = 0; i < size; i++) {
				if (elements[i] == null)
					return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i]))
					return i; // n
			}
		}
		return ELEMENT_NOT_FOUND;
	}

//	public int indexOf2(E element) {
//		for (int i = 0; i < size; i++) {
//			if (valEquals(element, elements[i])) return i; // 2n
//		}
//		return ELEMENT_NOT_FOUND;
//	}
//	
//	private boolean valEquals(Object v1, Object v2) {
//		return v1 == null ? v2 == null : v1.equals(v2);
//	}

	/**
	 * 保证要有capacity的容量
	 * 
	 * @param capacity
	 */
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity)
			return;

		// 新容量为旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		// 新容量为旧容量的2倍 Test
//		int newCapacity = oldCapacity << 1;
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
	}

	@Override
	public String toString() {
		// size=3, [99, 88, 77]

		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}

			string.append(elements[i]);

//			if (i != size - 1) {
//				string.append(", ");
//			}
		}
		string.append("]");
		return string.toString();
	}
}
