package foo;

import static foo.bar.Other.say;
import foo.bar.Other;

public class Test {
	public static void main(String[] args) {
		System.out.println("TEST");
		System.out.println(say());
		System.out.println(Other.say());
		System.out.println(foo.bar.Other.say());
	}
}
