package com.zxj;

import com.zxj.map.HashMap;
import com.zxj.map.Map;
import com.zxj.map.Map.Visitor;

public class Main {

	public static void main(String[] args) {
		String string = "jack";
		int hashCode =0;
		int len = string.length();
		for(int i = 0;i < len;i++) {
			char c = string.charAt(i);
			hashCode = (hashCode << 5) - hashCode + c;
		}
		
		Person p1 = new Person(10,1.67f,"jack");
		Person p2 = new Person(10,1.67f,"jack");
		Map<Object,Integer> map = new HashMap<>();
		map.put(p1, 1);
		map.put(p2,3);
		map.put("jack", 1);
		map.put("rose", 1);
		map.put("jack", 3);
		System.out.println(map.size());
		System.out.println(map.containsKey("jack"));
		System.out.println(map.containsValue(2));
		map.traversal(new Visitor<Object, Integer>() {
			@Override
			public boolean visit(Object key, Integer value) {
				System.out.println(key+"--"+value);
				return false;
			}
		});
		
//		System.out.println(map.get("jack"));
//		System.out.println(map.get("rose"));
//		System.out.println(map.get("jack1"));
		
//		System.out.println(map.remove("jack"));
//		System.out.println(map.size());
	}

}
