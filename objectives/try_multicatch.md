#### Try-with-resources

##### Statements in try
In `try ()` you can only have statments that are variable declaration and initialization.
The variable shuould be declared in the try statement. In cannot be declared outside the try statement and initialized inside the try statement.
The variables inside try-with-resources must implement [AutoCloseable](https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html)

```
NOK
error: the try-with-resources resource must either be a variable declaration or 
an expression denoting a reference to a final or effectively final variable

Path path = Paths.get("Test.java");
File file = path.toFile();
BufferedReader reader;
try (reader = new BufferedReader(new FileReader(file))) {
}
```
```
OK
BufferedReader reader = new BufferedReader(new FileReader(file));
try (var insideReader = reader) {
}
```

##### Order
The final blockes close in reverse order (the resources are closed in the reverse order in which they were created) immediately after the try block finishes. So the resources are closed before the catch statement. This is because the resources belong to the try block in try-with-resources. They are closed in reverse order because the resources can be dependent on each other.

##### Surpressed exceptions

#### Autoclosable resource with try-with-resources
```
try (Reader reader = new BufferedReader(new FileReader(file)) {

} catch (IOException) {

}
```
The resource used in try-with-resources mush implement Autoclosable.
Autoclosable is a superinterface of closable.

##### Differences between AutoClosable and Closable
Closable close method throws only IOExceptions and RuntimeException.
Autoclosable close method throws aby Exception.
|    |      AuotClosable      |  Closable |
|----------|-------------|------|
|extends|none|AutoClosable|
|throws|Exception|IOException|
|idemponcy|No, but recommended|Yes|


#### Multi-catch

##### Syntax
Syntax is `catch (Exception1 | Exception2 e)`, you can have any number of Exceptions.
The exception classes in the multi-catch statement should not be sublasses of the others.
`catch (FileNotFound | IOException e)` does not compile
</br></br>
Altough bad practice, it legal to re-assign the e variable in the traditional catch
```
try {
 ...
}  catch (IOException e) {
  e = new Exception();
}
```
##### Variable defined in multi-catch is final
It is illegal to re-assing the variable e in multi-catch (e is final)
```
try {

} catch (SQLException | IOException e) {
  e = new Exception();  // compilation error
}
```

##### Rethrow an exception
'handle and declare' could refer to catching an exception, logging it and then throwing it again.

```
public void rethrow() throws SQLException, IOException {
try {

} catch (SQLException | IOException e) {
  log(e);
  throw e;
}
```
Multi-catch statement can be replaced with `catch (Exception e)`. It is not bad practice because we are not really catching all the *checked* exceptions. It catches all *checked* Exception subclasses that allows the code to compile. Implicitly it also catches all "unchecked" exceptions.

Exception in thread "main" java.lang.RuntimeException

```
	public static void main(String[] args) {
		
		try {
			exception();
		} catch (SQLException | IOException e) {
			System.out.println("END");
		}
			
	}
	
	private static void exception() throws SQLException, IOException {
	
		try {
			example();	
		} catch (SQLException | IOException e) {
		}
	}
	
	private static void example() throws SQLException, IOException {
		throw new RuntimeException();
	}
 ```
 
Returns CAUGHT because the runtime exception is caught 
```
	public static void main(String[] args) {
		
		try {
			exception();
		} catch (SQLException | IOException e) {
			System.out.println("END");
		}
			
	}
	
	private static void exception() throws SQLException, IOException {
	
		try {
			example();	
		} catch (Exception e) { // Catches the subclasses defined in throws + all the unchecked exception
			System.out.println("CAUGHT");
		}
	}
	
	private static void example() throws SQLException, IOException {
		throw new RuntimeException();
	}
```
