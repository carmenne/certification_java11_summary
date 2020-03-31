Design patterns that can can be created with lambda: strategy, template method, execute around, chain of responsability
Debugging: peek can be used for adding System.out.println debugging statements as they are not terminal operations like forEach.

Default methods. There are 3 resolution rules to follow when a classs inherits a method from multiple places (such as another class or interface):
1. Classes always win. A method declaration in the class or a superclass takes priority over any default method declaration.
2. Otherwise, sub-interfaces win: the method with the same signature in the most specific default-providing interface is selected. (If B extends A, B is more specific than A).
3. Finally, if the choice is still ambiguous, the class inheriting from multiple interfaces has to explicitly select which default method implementation to use by overriding it and calling the desired method explicitly.
In short: Most specific default-providing interface wins

Optional
Consider using flatmap when an object is wrapped into an Optional, wrapped into an Optional..etc.

The methods of the Optional class
