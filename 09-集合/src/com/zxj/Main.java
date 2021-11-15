package com.zxj;

import com.zxj.Times.Task;
import com.zxj.file.FileInfo;
import com.zxj.file.Files;
import com.zxj.set.ListSet;
import com.zxj.set.Set;
import com.zxj.set.Set.Visitor;
import com.zxj.set.TreeSet;

public class Main {

	static void testListSet() {
		Set<Integer> listSet = new ListSet<>();
		listSet.add(10);
		listSet.add(11);
		listSet.add(12);
		listSet.add(10);
		listSet.add(14);
		
		listSet.traversal(new Visitor<Integer>() {
			@Override
			public boolean visit(Integer element) {
				System.out.println(element);
				return false;
			}
		});
	}
	
	static void testTreeSet() {
		Set<Integer> treeSet = new TreeSet<>();
		treeSet.add(14);
		treeSet.add(11);
		treeSet.add(12);
		treeSet.add(10);
		treeSet.add(9);
		treeSet.add(12);
		treeSet.add(7);
		
		treeSet.traversal(new Visitor<Integer>() {
			@Override
			public boolean visit(Integer element) {
				System.out.println(element);
				return false;
			}
		});
	}
	
	static void test() {
		FileInfo fileInfo = Files.read("D:\\src\\java\\util", 
				new String[]{"java"});
		
		System.out.println("文件数量：" + fileInfo.getFiles());
		System.out.println("代码行数：" + fileInfo.getLines());
		String[] words = fileInfo.words();
		System.out.println("单词数量：" + words.length);
		
		Times.test("ListSet", new Task() {
			public void execute() {
				testSet(new ListSet<>(), words);
			}
		});
		
		Times.test("TreeSet", new Task() {
			public void execute() {
				testSet(new TreeSet<>(), words);
			}
		});
	}
	
	static void testSet(Set<String> set, String[] words) {
		for (int i = 0; i < words.length; i++) {
			set.add(words[i]);
		}
		for (int i = 0; i < words.length; i++) {
			set.contains(words[i]);
		}
		for (int i = 0; i < words.length; i++) {
			set.remove(words[i]);
		}
	}
	
	public static void main(String[] args) {
		test();
	}
}
