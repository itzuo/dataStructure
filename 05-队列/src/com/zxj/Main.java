package com.zxj;

import com.zxj.circle.CircleDeque;
import com.zxj.circle.CircleQueue;

public class Main {

	public static void main(String[] args) {
		int n = 19;
		int m = 10;
		if(n >=m) {
			System.out.println(n - m);
		}else {
			System.out.println(n);
		}
		
		//需要满足：m >0,n >=0,n < 2m
		System.out.println(n - (n >= m ? m :0));
		
		System.out.println(n % m);
	}
	
	public static void testCircleDeque() {
		CircleDeque<Integer> queue = new CircleDeque<Integer>();
		for(int i = 0;i< 10;i++) {
			queue.enQueueFront(i + 1);
			queue.enQueueRear(i + 100);
		}
		
		for(int i = 0;i< 3;i++) {
			queue.deQueueFront();
			queue.deQueueRear();
		}
		System.out.println(queue);
		
		queue.enQueueFront(11);
		queue.enQueueFront(12);
		System.out.println(queue);
		while(!queue.isEmpty()) {
			System.out.print(queue.deQueueFront()+" ");
		}
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
