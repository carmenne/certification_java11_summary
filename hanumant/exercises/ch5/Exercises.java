public class Exercises {
	public static void main(String[] args) {
		
		// Write code to determine wether the toString and substring 
		// methods of StringBuilder and String class return an interned 
		// string or not
		System.out.println("Exercise 1");
		exercise1();
		System.out.println("_".repeat(80));
		
		// "12345678" -> XXXX5678 (last 4 the original char, rest X)
		if (args.length > 0) {
			System.out.println("Exercise 2");
			exercise2(args[0]);
			System.out.println("_".repeat(80));
		}
	}
	
	static void exercise1() {
		
		
		// String -> toString()
		String stringObject = new String("hello");
		System.out.printf("is toString method of String interned? %b-%b\n",  
			stringObject.toString() == "hello",
			stringObject.toString() == stringObject.intern()); // false
		
		// String -> substring(start, end);
		String subStringObject = stringObject.substring(0,2);
		System.out.printf("is substring method of String interned? %b-%b\n",  
			subStringObject == "he",
			subStringObject == subStringObject.intern());
		System.out.printf("is subStringObject.intern() equal to literal string? %b\n", subStringObject.intern()=="he");

		// String -> toString()
		String literal = "hello";
		System.out.printf("is toString method of literal interned? %b-%b\n",  
			literal.toString() == "hello",
			literal == literal.intern()); // true
		String literalSubstring = literal.substring(0,2);
		System.out.printf("is substring method of literal interned? %b-%b\n",  
			literalSubstring == "he",
			literalSubstring == literalSubstring.intern());
		
		StringBuilder stringBuilder = new StringBuilder("hello");
		System.out.printf("is toString method of StringBuilder interned? %b-%b\n", 
			stringBuilder.toString() == "hello", 
			stringBuilder.toString() == stringBuilder.toString().intern()); // false
		
		String subStringBuilder = stringBuilder.substring(0,2);
		System.out.printf("is substring method of StringBuilder interned? %b-%b\n", 
			subStringBuilder.toString() == "he", 
			subStringBuilder.toString() == subStringBuilder.toString().intern());
	}

	static void exercise2(String input) {
		char[] chars = input.toCharArray();
		int len = chars.length - 4;
		char[] x = new char[len + 4];
		for (int i = 0; i < len; i++) {
			x[i]= 'X';
		}
		for (int i = 0; i < 4; i++) {
			x[len + i] = chars[len + i];
		}
		System.out.println(String.valueOf(x));
	}
}
