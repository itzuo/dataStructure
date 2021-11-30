package com.zxj;

import com.zxj.heap.BinaryHeap;
import com.zxj.printer.BinaryTrees;

public class Main {

	static void test1() {
		BinaryHeap<Integer> heap = new BinaryHeap<>();
		heap.add(68);
		heap.add(72);
		heap.add(43);
		heap.add(50);
		heap.add(38);
		heap.add(10);
		heap.add(90);
		heap.add(65);
		BinaryTrees.println(heap);
//		heap.remove(); 		
		System.out.println(heap.replace(70));
		BinaryTrees.println(heap);
	}
	
	public static void main(String[] args) {
		Integer[] data = {88, 44, 53, 41, 16, 6, 70, 18, 85, 98, 81, 23, 36, 43, 37};
		BinaryHeap<Integer> heap = new BinaryHeap<>();
		for (int i = 0; i  < data.length; i ++) {
			heap.add(data[i]);
		}
		BinaryTrees.println(heap);
		
		data[0] = 10;
		data[1] =20;
		BinaryTrees.println(heap);
	}

}
