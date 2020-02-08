public class Test {
	public static void main(String[] args) {
		
		// Implicit narrowwing (put a larger bucket in a smaller one)
		// is allowed if the variable that is assigned to a smaller type
		// is a compile-time constant and the compiler can assess if it can fit
		
		// Can fit -> Compilation OK
		final int n1 = 127;
		byte shouldCompile = n1;
		System.out.println(shouldCompile);

		// Cannot fit -> Compilation NOK
		final int n2 = 128;
		// byte shouldNotCompile = n2; incompatible types: possible lossy conversion from int to byte
		// byte shouldNotCompile = 128; incompatible types: possible lossy conversion from int to byte

		// The narrowing can be forced through explicit narrowing (casting)
		// However overflowing appears (see 2-complements)
		byte b = (byte) 128;
		System.out.println("byte b = (byte) 128; b=" + b);
		
		// short, byte vs. char and vice-versa
		
		char c = 'a'; // 97
		short s = (short) c;
		System.out.println("char c = 'a'; short s = (short) c; s=" + s);
		
		// short s = c; incompatible types: possible lossy conversion from char to short
		// char c2 = s; incompatible types: possible lossy conversion from short to char
		
		// float to int
		// float f1 = 4;
		// int i = f1; incompatible types: possible lossy conversion from float to int
		
		// int to float
		int i = Integer.MAX_VALUE;
		float f = i;
		System.out.println("Integer.MAX_VALUE=" + i);
		System.out.println("int i = Integer.MAX_VALUE; float f = i; i == f is " + (i == f));
		
		// long to double
		long l = Long.MAX_VALUE;
		double d = l;
		
		System.out.println("Integer.MAX_VALUE=" + l);
		System.out.println("long l = Long.MAX_VALUE; double d = l; l == d is " + (l == d));
	}
}
