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
