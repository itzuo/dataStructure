package com.zxj;

import com.zxj.map.Map;
import com.zxj.map.Map.Visitor;
import com.zxj.map.TreeMap;

public class Main {

	static void test() {
		Map<String,Integer> map = new TreeMap<>();
		map.put("c",2);
		map.put("a",5);
		map.put("b",6);
		map.put("a",8);
		
		map.traversal(new Visitor<String, Integer>() {
			
			@Override
			public boolean visit(String key, Integer value) {
				System.out.println(key+"_"+value);
				return false;
			}
		});
	}
	
	public static void main(String[] args) {
		test();
	}

}
