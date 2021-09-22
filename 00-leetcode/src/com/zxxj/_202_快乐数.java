package com.zxxj;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * https://leetcode-cn.com/problems/happy-number/
 *
 */
public class _202_快乐数 {

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		while(n != 1 && !set.contains(n)) {
			set.add(n);
			n = getNext(n);
		}
		return n == 1;
    }
	
	private int getNext(int n) {// 19 82
		int totalSum = 0;
		while(n > 0) {
			int temp = n % 10;// 9 2
			n = n / 10;// 1 8
			totalSum += temp * temp;
			System.out.println("n:"+n+",temp:"+temp+",totalSum:"+totalSum);
		}
		return totalSum;
	}
	
	public boolean isHappy1(int n) {
		int slow = n;
		int fast = n;
//		while(fast != 1 && slow != fast) {
//			slow = getNext(slow);
//			fast = getNext(getNext(fast));
//		}
//		return fast ==1;
		
		do {
			slow = getNext(slow);
			fast = getNext(getNext(fast));
			System.out.println("slow:"+slow+",fast:"+fast);
		}while(fast != 1&& slow != fast);
		return fast == 1;
	}
	
	public static void main(String[] args) {
		_202_快乐数 test_= new _202_快乐数();
		
		System.out.println(test_.isHappy(19));
	}
}
