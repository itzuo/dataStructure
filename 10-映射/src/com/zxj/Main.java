package com.zxj;

import com.zxj.file.FileInfo;
import com.zxj.file.Files;
import com.zxj.map.Map;
import com.zxj.map.Map.Visitor;
import com.zxj.map.TreeMap;
import com.zxj.set.Set;
import com.zxj.set.TreeSet;

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
	
	static void testFiles() {
		FileInfo fileInfo = Files.read("D:\\ProjectWork\\eclipse-workspace\\数据结构\\09-集合\\src", 
				new String[]{"java"});
		
		System.out.println("文件数量：" + fileInfo.getFiles());
		System.out.println("代码行数：" + fileInfo.getLines());
		String[] words = fileInfo.words();
		System.out.println("单词数量：" + words.length);
		
		Map<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < words.length; i++) {
			Integer count = map.get(words[i]);
			count = (count == null) ? 1 : (count + 1);
			map.put(words[i], count);
		}
		
		map.traversal(new Visitor<String, Integer>() {
			public boolean visit(String key, Integer value) {
				System.out.println(key + "_" + value);
				return false;
			}
		});
	}
	
	static void testTreeSet() {
		Set<String> set = new TreeSet<>();
		set.add("c");
		set.add("b");
		set.add("c");
		set.add("c");
		set.add("a");
		
		set.traversal(new Set.Visitor<String>() {
			public boolean visit(String element) {
				System.out.println(element);
				return false;
			}
		});
	}
	public static void main(String[] args) {
		testFiles();
	}

}
