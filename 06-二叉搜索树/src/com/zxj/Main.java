package com.zxj;

public class Main {

	public static void main(String[] args) {
		Integer data[] = {
				7,4,9,2,5,8,11,3
		};
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		for(int i =0;i<data.length;i++) {
			bst.add(i); 
		}

	}

}
