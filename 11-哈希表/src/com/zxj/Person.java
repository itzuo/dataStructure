package com.zxj;

import java.util.Objects;

public class Person {

	private int age;
	private float height;
	private String name;
	
	public Person(int age, float height, String name) {
		super();
		this.age = age;
		this.height = height;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, height, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Float.floatToIntBits(height) == Float.floatToIntBits(other.height)
				&& Objects.equals(name, other.name);
	}
	
}
