Design patterns that can can be created with lambda: strategy, template method, execute around, chain of responsability
Debugging: peek can be used for adding System.out.println debugging statements as they are not terminal operations like forEach.

Default methods. There are 3 resolution rules to follow when a classs inherits a method from multiple places (such as another class or interface):
1. Classes always win. A method declaration in the class or a superclass takes priority over any default method declaration.
2. Otherwise, sub-interfaces win: the method with the same signature in the most specific default-providing interface is selected. (If B extends A, B is more specific than A).
3. Finally, if the choice is still ambiguous, the class inheriting from multiple interfaces has to explicitly select which default method implementation to use by overriding it and calling the desired method explicitly.
In short: Most specific default-providing interface wins

Optional
Consider using flatmap when an object is wrapped into an Optional, wrapped into an Optional..etc.

The methods of the Optional class:

|Method|Description|
| ------------- | ------------- |
|empty |Returns an empty Optional instance|
|filter| If the value is present and matches the given predicate, returns this Optional; otherwise returns the empty one|
|flatMap|If a value is present, returns the Optional resulting from the application of the provided mapping function to it; otherwise returns the empty Optional|
|get|Returns the value wrapped by this Optional if present; otherwise throws a NoSuchElementException|
|ifPresent| If a value is present, invokes the specified consumer with the value; otherwise does nothing|
|isPresent| Returns true if there is a value present; otherwise false|
|map| If a value is present, applies the provided mapping function to it|
|of| Returns an Optional wrapping the given value or throws a NullPointerException if this value is null|
|ofNullable| Returns an Optional wrapping the given value or the empty Optional if this value is null|
|orElse |Returns the value if present or the given default value otherwise|
|orElseGet Returns the value if present or the one provided by the given Supplier otherwise|
|orElseThrow| Returns the value if present or throws the exception created by the given Supplier otherwise|
