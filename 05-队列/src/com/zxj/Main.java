package com.zxj;

import com.zxj.circle.CircleQueue;

public class Main {

	public static void main(String[] args) {
		testCircleQeque();
	}
	
	public static void testCircleQeque() {
		CircleQueue<Integer> queue = new CircleQueue<Integer>();
		for(int i = 0;i< 10;i++) {
			queue.enQueue(i);
		}
		
		for(int i = 0;i< 5;i++) {
			queue.deQueue();
		}
		System.out.println(queue);
		
		for(int i = 15;i< 23;i++) {
			queue.enQueue(i);
		}
		
		System.out.println(queue);
		while(!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
		System.out.println(queue);
	}
	
	public static void testDeque() {
		Deque<Integer> queue = new Deque<Integer>();
		queue.enQueueFront(11);
		queue.enQueueFront(22);
		queue.enQueueRear(33);
		queue.enQueueRear(44);
		
		while(!queue.isEmpty()) {
			System.out.print(queue.deQueueRear()+" ");
		}
	}
	
	public static void testQueue() {
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
