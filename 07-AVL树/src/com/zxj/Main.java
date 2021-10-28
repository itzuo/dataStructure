package com.zxj;

import com.zxj.printer.BinaryTrees;
import com.zxj.tree.AVLTree;

public class Main {

	public static void main(String[] args) {
		test();
	}
	static void test() {
		Integer data[] = {
				7,4,9,2,5,8,11,3,12,1
		};
		
		AVLTree<Integer> avl = new AVLTree<>();
		for (int i = 0; i < data.length; i++) {
			avl.add(data[i]);
		}
		BinaryTrees.print(avl);
	}
	
}
