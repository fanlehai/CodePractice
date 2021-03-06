package com.fanlehai.java.generics;

class Building {
}

class House extends Building {
}

public class ClassTypeCapture<T> {
	Class<T> kind;

	public ClassTypeCapture(Class<T> kind) {
		this.kind = kind;
	}

	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}
	
	public boolean h(Object arg) {
		return kind.isAssignableFrom(arg.getClass());
	}

	public static void main(String[] args) {
		ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);
		System.out.println(ctt1.f(new Building()));
		System.out.println(ctt1.f(new House()));
		ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);
		System.out.println(ctt2.f(new Building()));
		System.out.println(ctt2.f(new House()));
		System.out.println(ctt2.h(new House()));
		String string = "22";
		string.intern();
	}
} 


/* Output:
true
true
false
true
true
*///:~
