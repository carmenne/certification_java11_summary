Functional Interface (43)
-----------------------
A interface that has exactky one abstract method. 
Methods with the same signature as the ones from objects are excluded.

Function Descriptor (45)
-----------------------
The signature of the abstract method of a functional interface

Execute around pattern (47)
-----------------------
A recurrent pattern in resource processing: 
- (1) open the resource;
- (2) do some processing on it;
- (3) close the resource.
Lambda expressions can be used to pass behaviour as parameter (for (2))

Primitive specializations (52)
-----------------------
Functional interfaces have primitive specializations to avoid the 
expensive boxing operations.
In general, the name of the functional interfaces that have primitive
specializations ae preceded by the appropriate primitive type, 
for example, DoublePredicate, IntConsumer, LongBinaryOperator, IntFunction 
The function interface has also variats for the output type parameter:
ToIntFunction<T>m IntoToDoubleFunction etc

|Functional Interface|Function descriptor|Primitive specialization|
| ------------- | ------------- | ------------- |
|Predicate<T>|T->boolean|IntPredicate, LongPredicate, DoublePredicate|
|Consumer<T>|T->void|IntConsumer,LongConsumer,DoubleConsumer|
|Function<T,R>|T->R|IntFunction<R>,IntToDoubleFunction,IntToLongFunction,LongFunction<R>,<br>LongToIntFunction,LongToDoubleFunction,DoubleFunction<R>,<br>ToIntFunction<R>,ToDoubleFunction<R>, ToLongFunction<R>|
|Supplier<T>|()->T|BooleanSupplier,IntSupplier,LongSupplier,DoubleSupplier|
|UnaryOperator<T>|T->T|IntUnaryOperator,LongUnaryOperator,DoubleBinaryOperator|
|BinaryOperator|(T,T)->T|IntBinaryOperator,LongBinaryOperator,DoubleBinaryOperator|
|BiPredicate<T,U>|(T,U)->boolean|
|BiConsumer<T,U>|(T,U)->void|ObjIntConsumer<T>,ObjLongConsumer<T>,ObjDoubleConsumer<T>|
|BiFunction<T,U,R>|(T,U)->R|ToIntBiFunction<T,U>,ToDoubleBiFunction<T,U>,ToLongBiFunction<T,U>|

Restrictions on local variables
-----------------------
Lambdas are allowed to capture (that is, to reference in their bodies), instance variables and static
variables without restrictions. But local variables have to be explicitly declared final or are effectively final

Type inference in lamdas expressions
-----------------------

Method reference
-----------------------
- a method reference to a static method;
- a method reference to an instance method of an arbitrary type
- a method reference to an instance method of an existing object

|lamda|method reference|
| ------------- | ------------- |
|(args)->ClassName.staticMethod(args)|ClassName::staticMethod|
|(args0,rest)->arg0.instanceMethod(rest)|ClassName::instanceMethod<br>arg0 is of type ClassName|
|(args)->expr.instanceMethod(args)|expr::instanceMethod|

Constructor reference
-----------------------
|number of arguments|example|
| ------------- | ------------- |
|constructor with no argument| `Supplier<Apple> apple = Apple:new; apple.get();`|
|constructor with one argument| `Function<Integer, Apple> apple = Apple::new; apple.apply(100) // 100g`|
|constructor with teow arguments|`BiFunction<Integer, String, Apple> apple = Apple::new; apple.apply("Jonatan", 100);`|
  
Useful methods to compose lamda expressions
-----------------------
#### Composing comparators
`Comparator<Apple> c = Comparator.comparing(Apple::getWeight);`
#### Reversed order
`inventory.sort(comparing(Apple::getWeight).reversed());`
#### Chaining comparators
```java
inventory.sort(comparing(Apple::getWeight)
            .reversed());
            .thenBy(Apple::getCountry));
```
#### Composing Predicates
It used three methods: negate, and, or.
```java
Predicate<Apple> redApple = a -> "red".equals(a.getColor());
Predicate<Apple> notRedApple = redApple.negate();
Predicate<Apple> redAndHeavyApple = redApple.and(a -> a.getWeight()>150);
Predicate<Apple> redAndHeavyAppleOrGreen = redApple.and(a -> a.getWeight()>150)
                                                   .or(a -> "green".equals(a.getColor());
```
Precendence of methods: and, or is managed from left to right.
So a.or(b).and(c) can be seen as (a||b)&&c
#### Composing Functions
Methods: andThen, compose.
                                                










