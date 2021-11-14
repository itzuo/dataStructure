package com.zxj;

import com.zxj.printer.BinaryTrees;
import com.zxj.tree.AVLTree;
import com.zxj.tree.RBTree;

public class Main {

	public static void main(String[] args) {
		testRBTreeRemove();
	}
	static void test() {
		Integer data[] = {
				85,19,69,3,7,99,95,2,1,70,44,58,11,21,14,93,57,4,56
		};
		
		AVLTree<Integer> avl = new AVLTree<>();
		for (int i = 0; i < data.length; i++) {
			avl.add(data[i]);
		}
		BinaryTrees.print(avl);
	}
	
	static void testRBTreeRemove() {
		Integer data[] = {
				55,87,56,74,96,22,62,20,70,68,90,50
		};
		
		RBTree<Integer> rbTree = new RBTree<>();
		for (int i = 0; i < data.length; i++) {
			rbTree.add(data[i]);
		}
		BinaryTrees.println(rbTree);
		System.out.println("----------------------------");
		for (int i = 0; i < data.length; i++) {
			rbTree.remove(data[i]);
			System.out.println("【"+data[i]+"】");
			BinaryTrees.println(rbTree);
			System.out.println("----------------------------");
		}
	}
	
	static void testRBTree() {
		Integer data[] = {
				55,87,56,74,96,22,62,20,70,68,90,50
		};
		
		RBTree<Integer> rbTree = new RBTree<>();
		for (int i = 0; i < data.length; i++) {
			rbTree.add(data[i]);
		}
		BinaryTrees.print(rbTree);
	}
}
