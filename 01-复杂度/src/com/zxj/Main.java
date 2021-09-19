package com.zxj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Main {

	/**
	 * 0 2 3 4 5 6 7 8 
	 * 0 1 1 2 3 5 8 13 ......
	 */
	public static void main(String[] args) {
		/*System.out.println(fib1(10));
		
		Set<String> set = new HashSet<>();
		boolean b = set.add("123");
		System.out.println("add is succ:"+b);
		
		boolean b1 = set.add("123");
		System.out.println("add is succ:"+b1);
		
		label: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.println("j="+j);
                if (j % 2 != 0) {
                    break label;
                }
            }
            System.out.println("i="+i);
        }*/
		
		
	}
	
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> resSet = new HashSet<Integer>();
		
		for(int num : nums1) {//遍历数组1
			set1.add(num);
		}
		
		for(int num: nums2) { //遍历数组2的过程中判断哈希表中是否存在该元素
			if(set1.contains(num)) {
				resSet.add(num);
			}
		}
		
		int[] arr = new int[resSet.size()];
		int index = 0;
		for(int num :resSet) {//将结果几何转为数组
			arr[index++] = num;
		}
		return arr;
    }

	public static int fib1(int n) {
		if (n <= 1) return n;
		return fib1(n - 1) + fib1(n - 2);
	}

	public static int fib2(int n) {
		if (n <= 1) return n;
		int first = 0;
		int second = 1;
		for (int i = 0; i < n - 1; i++) {
			int sum = first + second;
			first = second;
			second = sum;
		}
		return second;
	}
	
	// 计算a跟b的和
	public static int plus(int a,int b) {
		return a + b;
	}

	// 计算1+2+3+...+n的和
	public static int sum1(int n) {
		int result =0;
		for(int i = 1;i <= n;i++) {
			result += 1;
		}
		return result;
	}
	
	// 计算1+2+3+...+n的和
	public static int sum21(int n) {
		return (1 + n) * n / 2;
	}
}
