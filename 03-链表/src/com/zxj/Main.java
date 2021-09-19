package com.zxj;

public class Main {

	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();

//		list.add(null);
//		list.add("张三");
//		list.add("李四");
//		list.add(1,"王五");
//		System.out.println("list.toString:"+list.toString());
		
		List<Integer> list1 = new ArrayList2<Integer>();
		for(int i =0;i<50;i++) {
			list1.add(i);
		}
		
		for(int i = 0;i < 50;i++) {
			list1.remove(0);
		}
		
		System.out.println(list1);
	}

}
