package com.carmen.learn;

public class Narrowing {
	public static void main(String[] args) {
		
		final int i = 127;
		byte b1 = i;
		System.out.println("final int i = 127;");
		System.out.println("byte b1 = i;");
		System.out.println("Implicit narrowing because " +
			"i is compile time constant and i fits into b1=" + b1);
			
		final int j = 128;
		System.out.println("");
		System.out.println("final int j = 128;");
		System.out.println("byte b2 = j;");
		System.out.println("Even if j is compile time constants " +
			"j does not fit into b2, so the compiler throws " +
			"incompatible types: possible lossy conversion from int to byte");
			
		int k = 127;
		byte b3 = (byte)k;
		System.out.println("");
		System.out.println("int k = 127;");
		System.out.println("byte b3 = (byte)k;");
		System.out.println("Even if j is compile time constants " +
			"you can convince the compiler by making a promise via casting " +
			"b3 will be assgined b3="+b3);
		
		int l = 128;
		byte b4 = (byte)l;
		System.out.println("");
		System.out.println("int l = 128;");
		System.out.println("byte b4 = (byte)l;");
		System.out.println("The compiler is convinced via casting. At runtime " +
			"b4 will overflow. The value depends on the two's complement b4="+b4);
	}
}
