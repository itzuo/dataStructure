package com.zxj;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		Integer data[] = {
				7,4,9,2,5,8,11,3
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		for(int i =0;i<data.length;i++) {
			bst.add(i); 
		}
		
		BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst1.add(new Person(data[i]));
		}
		
		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new PersonComparator());
		for (int i = 0; i < data.length; i++) {
			bst2.add(new Person(data[i]));
		}

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
