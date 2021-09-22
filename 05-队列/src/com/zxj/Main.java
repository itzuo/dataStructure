package com.zxj;

public class Main {

	public static void main(String[] args) {
		/*Queue<Integer> queue = new Queue<Integer>();
		queue.enQueue(11);
		queue.enQueue(22);
		queue.enQueue(33);
		queue.enQueue(44);
		
		while(!queue.isEmpty()) {
			System.out.print(queue.deQueue()+" ");
		}*/
		
		Deque<Integer> queue = new Deque<Integer>();
		queue.enQueueFront(11);
		queue.enQueueFront(22);
		queue.enQueueRear(33);
		queue.enQueueRear(44);
		
		while(!queue.isEmpty()) {
			System.out.print(queue.deQueueRear()+" ");
		}
	}
}
