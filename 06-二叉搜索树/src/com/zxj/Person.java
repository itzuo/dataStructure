package com.zxj;

public class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	public Person(String name,int age) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
//		if (age > o.age) return 1;
//		if (age < o.age) return -1;
//		return 0;
		return age - o.age;
	}
	
	@Override
	public String toString() {
		return name + "_" + age;
	}
}
