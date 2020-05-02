#### Rules for identifiers
- Identifiers must begin with a letter, a $ symbol or a _ symbol;
- Identifiers can include numbers but not start with them;
- Since Java 9, a single underscore _ is not allowed as an identifier;
- You cannot use the same name as a aJava reserved word;

#### Variable declaration
- You can declare many variables in the same declaration as long as they are of the same type

#### Classpath
-cp
-classpath
--clash-path 

#### Imports
java.lang is automatically imported. 

#### Modules names
Module names look a lot like package names. Each segment is separated by a period (.) 
and uses characters valid in Java identifiers.

#### Modules
opens is for reflection and uses declares an API that consumes a service. 
module-info.java file can be completely empty. 
Modules are required to have a module-info.java file at the root directory of the module.

#### Exceptions
Any Java type, including Exception and RuntimeException, can be declared as the return type. However, this will simply return the object rather than throw an exception.
Classes listed in the throws part of a method declaration must extend java.lang.Throwable. This includes Error, Exception, and RuntimeException
Arbitrary classes such as String can’t be declared in a throws clause

#### main method
`public static void main(String[] args)` is the canonical main() method signature.  
- main() method must be public. 
- the main() method must have a void return type. 
- main() method must be static. 
- he main() method must be named main.
- the parameter type matters `String[] or String...`, not the parameter name.
- can have throws

#### single-file source-code launcher
To use this launcher, programs can only reference classes built into the JDK. Therefore, `java MyProgram.java` :
- 	MyProgram can reference classes in the package java.lang.
- 	MyProgram can reference classes in the package java.util.


#### Exceptions
```
public void method throws IOException {
	//
}
```
A method that declares an exception isn’t required to throw one.
Unchecked exceptions can be thrown in any method.
A broader Exception cannot be thrown.

Both runtime and checked exceptions can be declared, although only checked exceptions must be handled or declared
Legally, you can handle java.lang.Error subclasses, which are not subclasses of Exception, but it’s not a good idea
Finally, it is true that all exceptions are subclasses of Throwable
Only checked exceptions are required to be handled or declared.
An Error is intended to be thrown by the JVM and never caught by the programmer.
While a programmer could throw or catch an Error, this would be a horrible practice.
`catch (Exception | RuntimeException e)` does not compile as RuntimeException is a subclass of Exception in the multi-catch block, making it redundant. 

#### Multi catch blocks
Subclasses (narrower exceptions) should be declared in a block before
the broader exceptions when having more catch blocaks


#### public class and filenames
Java allows at most one public class in the same file.

#### Arrays
`public static int mismatch​(boolean[] a, boolean[] b)`
Finds and returns the index of the first mismatch between two boolean arrays, otherwise return -1 if no mismatch is found.

#### Constructors
Since there is no explicit call to the parent constructor, the compiler inserts super()as the first line of the constructor;
```
class Test2 {
	
	public Test2() {
		System.out.println("Default constructor");
	}
	
	public Test2(int score) {
		System.out.println("Test2 (int score)");
	}

}

public class Test extends Test2 {

	public Test(int score) {
		//~ super(score);
		System.out.println("Test (int score)");
	}
	
	public static void main(String ... var) {
		
		Test2 test2 = new Test(7);
	}
}
```

#### Strings
`intern` method: When the intern method is invoked, if the pool already contains a string equal 
to this String object as determined by the equals(Object) method, 
then the string from the pool is returned. Otherwise, this String object is added to the pool 
and a reference to this String object is returned.













