package com.carmen.learn.ex1;

import com.teodor.learn.ex1.Second;
import static com.teodor.learn.ex1.Second.overThirty;

public class First {
	
	public static int myAge = 32;

	public static void main(String[] args) {
		Second s = new Second();
		System.out.println(overThirty(myAge));
		System.out.println(s.older());
	}
}
