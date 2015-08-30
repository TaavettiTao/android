package com.android;

import java.io.Serializable;

public class MyData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyData(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "MyData [name=" + name + ", age=" + age + "]";
	}
}
