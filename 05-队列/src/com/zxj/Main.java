package com.zxj;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enQueue(11);
		queue.enQueue(22);
		queue.enQueue(33);
		queue.enQueue(44);
		
		while(!queue.isEmpty()) {
			System.out.print(queue.deQueue()+" ");
		}
	}
}
