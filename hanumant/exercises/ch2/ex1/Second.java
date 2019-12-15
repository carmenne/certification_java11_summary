package com.teodor.learn.ex1;

import static com.carmen.learn.ex1.First.myAge;

public class Second {

	public static int age = 34;
	public static boolean overThirty(int age) {
		return age > 30;
	}
	public static boolean older() {
		return age > myAge;
	}
	
}
