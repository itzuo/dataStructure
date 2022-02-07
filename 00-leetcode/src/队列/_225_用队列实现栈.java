package 队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class _225_用队列实现栈 {

	class MyStack {
		private Queue<Integer> queue;
	    public MyStack() {
	    	queue = new LinkedList<>();
	    }
	    
	    public void push(int x) {
	    	queue.offer(x);
	    	int size = queue.size();
	    	while (size > 1) {
				queue.offer(queue.poll());
				size--;
			}
	    }
	    
	    public int pop() {
	    	return queue.poll();
	    }
	    
	    public int top() {
	    	return queue.peek();
	    }
	    
	    public boolean empty() {
	    	return queue.isEmpty();
	    }
	}
	
	class MyStack01 {
		private Queue<Integer> q1;
		private Queue<Integer> q2;
	    public MyStack01() {
	    	q1 = new LinkedList<>();
	    	q2 = new LinkedList<>();
	    }
	    
	    public void push(int x) {
	    	q2.offer(x);
	    	while(!q1.isEmpty()) {
	    		q2.offer(q1.remove());
	    	}
	    	Queue<Integer> temp = q1;
	    	q1 = q2;
	    	q2 = temp;
	    }
	    
	    public int pop() {
	    	return q1.poll();
	    }
	    
	    public int top() {
	    	return q1.peek();
	    }
	    
	    public boolean empty() {
	    	return q1.isEmpty();
	    }
	}
}
