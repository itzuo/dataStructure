package com.zxj;

import java.util.Comparator;

import com.zxj.file.Files;
import com.zxj.printer.BinaryTrees;

public class Main {

	public static void main(String[] args) {
		
		testPreorderTraversal();
	}
	
	static void test() {
		Integer data[] = {
				7,4,9,2,5,8,11,3
		};
		
		BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst1.add(new Person("name"+data[i],data[i]));
		}
		BinaryTrees.print(bst1);
	}

	static void test01() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < 80; i++) {
			bst.add((int)(Math.random() * 100));
		}
		// BinaryTrees.print(bst);
		String str = BinaryTrees.printString(bst);
		Files.writeToFile("D:/1.txt", str,true);
	}
	
	static void testPreorderTraversal() {
		Integer data[] = {
				7,4,2,1,3,5,9,8,11,10,12
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.print(bst);
		System.out.println("\n");
		
//		bst.preorderTraversal();
//		bst.inorderTraversal();
//		bst.postorderTraversal();
		bst.levelOrderTraversal();
	}
	
	private static class PersonComparator implements Comparator<Person> {
		public int compare(Person e1, Person e2) {
			return e1.getAge() - e2.getAge();
		}
	}
	
	private static class PersonComparator2 implements Comparator<Person> {
		public int compare(Person e1, Person e2) {
			return e2.getAge() - e1.getAge();
		}
	}
}
