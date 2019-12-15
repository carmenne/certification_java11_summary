package com.carmen.learn;

public class Scopes {
	static int x = 1;
	static int y = 100;
	public static void main(String[] args) {
		
		int x = 2;
		
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		
		for (int i = 0; i < 1; i++) {
			// int x = i; // COMPILATION ERROR: error: variable x is already defined in method main
			int y = i;
			System.out.println("");
			System.out.println("x=" + x);
			System.out.println("y=" + y);

		}
		
		{
			// int x = 3; // COMPILATION ERROR: error: variable x is already defined in method main
			y = 1;
			System.out.println("");
			System.out.println("x=" + x);
			System.out.println("y=" + y);
		}
		
		int y = 3;
		System.out.println("");
		System.out.println("x=" + x);
		System.out.println("y=" + y);
	}
}
