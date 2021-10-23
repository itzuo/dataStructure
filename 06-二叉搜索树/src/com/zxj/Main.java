package com.zxj;

import java.util.Comparator;

import com.zxj.BinarySearchTree.Visitor;
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
//				7,4,2,1,3,5,9,8,11,10,12
//				7,4,9,2,5
				7,4,9,2,1
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		BinaryTrees.print(bst);
		System.out.println("\n");
		System.out.println("树的高度："+bst.height());
		System.out.println("是否是完全二叉树："+bst.isComplete());
		System.out.println("\n");
		
//		bst.preorderTraversal();
//		bst.inorderTraversal();
//		bst.postorderTraversal();
//		bst.levelOrderTraversal();
		bst.preorder(new Visitor<Integer>() {
			@Override
			public boolean visit(Integer element) {
				System.out.print(element+" ");
				return element == 2 ? true:false;
			}
		});
		System.out.println();
		bst.inorder(new Visitor<Integer>() {
			@Override
			public boolean visit(Integer element) {
				System.out.print(element+" ");
				return element == 4 ? true:false;
			}
		});
		System.out.println();
		bst.postorder(new Visitor<Integer>() {
			@Override
			public boolean visit(Integer element) {
				System.out.print(element+" ");
				return element ==2 ? true:false;
			}
		});
		System.out.println();
		bst.levelOrder(new Visitor<Integer>() {
			@Override
			public boolean visit(Integer element) {
				System.out.print(element+" ");
				return element ==2 ? true:false;
			}
		});
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
