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
			
		int m = Integer.MIN_VALUE;
		float f1 = m;
		System.out.println("");
		System.out.println("int m = Integer.MAX_VALUE;");
		System.out.println("float f1 = m;");
		System.out.println("Implicit narrowing is ok. It is allowed, " +
		"but it may loose precision.");
		System.out.println("m=" + m);
		System.out.println("f1=" + f1);
		boolean equal = m == f1;
		System.out.println("m == f1=" + equal);
		
		int n = 1234567890;
		float f2 = n;
		
		System.out.println(n);
		System.out.println(f2);
		System.out.println("Should print n  - (int)f2 = 0");
		int result = n  - (int)f2;
		float result2 = n - f2;
		System.out.println("n  - (int)f2 = " + result);
		System.out.println("n  - f2 = " + result2);
		
	}
}
