package com.staticexample;

public class Person {
	public String name;
	public static String companyName;

	static {
		System.out.println("Inside static block1"); // loaded first
		companyName = "Infosys";
	}
	static {
		System.out.println("Inside static block2"); // loaded second
	}
	static {
		System.out.println("Inside static block3"); // loaded third
	}

	public Person(String name, String companyName) {
		super();
		System.out.println("Inside constructor");// after static block
		this.companyName = companyName; // override company name value with local variable
		this.name = name;
		System.out.println(name + " " + companyName);
	}
}