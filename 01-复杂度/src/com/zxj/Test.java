package com.zxj;

public class Test {

	public static void test1(int n) {
		// 估算程序指令的执行次数（执行时间）
		// 下面if-else都算1次
		if (n > 10) { 
			System.out.println("n > 10");
		} else if (n > 5) { // 2
			System.out.println("n > 5");
		} else {
			System.out.println("n <= 5"); 
		}
		
		//int i = 0执行1次，i < 4、 i++和println都是执行4次
		// 1 + 4 + 4 + 4
		for (int i = 0; i < 4; i++) {
			System.out.println("test");
		}
		// 总共14次
		// 时间复杂度：O(1)
	}
	
	public static void test2(int n) {
		// 1 + 3n(int i = 0执行1次，i < n、i++和都是执行n次)
		for (int i = 0; i < n; i++) {
			System.out.println("test");
		}
		// 时间复杂度：O(n)
	}
	
	public static void test3(int n) {
		// 1 + 2n + n * (1 + 3n) ==>1 + 2n + n + 3n^2 ==> 3n^2 + 3n + 1
		for (int i = 0; i < n; i++) {//1 + 2n
			for (int j = 0; j < n; j++) {//n * (1 + 3n)
				System.out.println("test");//n
			}
		}
		// 时间复杂度：O(n^2)
	}
	
	public static void test4(int n) {
		// 1 + 2n + n * (1 + 45) ==> 1 + 2n + 46n ==> 48n + 1
		for (int i = 0; i < n; i++) {//1 + 2n
			for (int j = 0; j < 15; j++) {// n * (1 + 45)
				System.out.println("test");//15
			}
		}
		// 时间复杂度：O(n)
	}
	
	public static void test5(int n) {
		//假设n=16; 16 = 2^4 、 8 = 2^3 、 4 = 2^2 、 2 = 2^1 、 1 = 2^0
		// 其实就是求指数值
		// 4 = log2(16) 、 3 = log2(8) 、 2 = log2(4) 、 1 = log2(2)
		
		// 执行次数 = log2(n)
		while ((n = n / 2) > 0) {
			System.out.println("test");
		}
		// 时间复杂度：O(logn)
	}
	
	public static void test6(int n) {
		// log5(n)
		while ((n = n / 5) > 0) {
			System.out.println("test");
		}
		// 时间复杂度：O(logn)
	}
	
	public static void test7(int n) {
		// 1 + 2*log2(n) + log2(n) * (1 + 3n) ==> 1 + 3*log2(n) + 2 * nlog2(n)
		for (int i = 1; i < n; i = i * 2) {// 1 + 2*log2(n)
			for (int j = 0; j < n; j++) {//  log2(n) * (1 + 3n)
				System.out.println("test");// n
			}
		}
		// 时间复杂度：O(nlogn)
	}
	
	public static void test(int n,int k) {
		for(int i = 0;i < n;i++) {
			System.out.println("test");
		}
		for(int i = 0;i < k;i++) {
			System.out.println("test");
		}
	}
}
