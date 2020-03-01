Streams API
-----------------------
Streams API lets you write code that is:
* declarative (more concise and readable)
* composable (greater flexibility)
* parallelizable (better performance)
#### Definition: 
Stream is a sequence of elements from a source that supports data processing operations
* sequence of elements: collections are about data, streams are about computations
* source: streams consume from a data-providing source such as collections,
	arrays, I/O resources (Note: generating a stream from an ordered collection
	preserves the ordering)
* data processing operations: filter, map, reduce, find, match, sort etc.
#### Characteristics:
* pipelining (intermediate operations)
* internal iteration
#### Streams are traversable only once (you can consume a stream only once)
#### Working with streams involves three items:
* a data source (such as collections)
* a chain of intermediate operations (they return Stream<T>)
* a terminal operations that executes the stream pipeline 
	and produces a result (the execution of streams is deferred)
	
Streams API operations
-----------------------	
|Operation|Type|Return Type|Type/functional interface used|Function descriptor|
| ------------- | ------------- | ------------- | ------------- | ------------- |
|filter|intermediate|Stream<T>|Predicate<T>|T->boolean|
|distinct|intermediate<br>(stateful-unbounded)|Stream<T>|||
|skip|intermediate<br>(stateful-bounded)|Stream<T>|long||
|limit|intermediate<br>(stateful-bounded)|Stream<T>|long||
|peek|intermidiate|Stream<T>|<Consumer<T>|T->void|
|map|intermediate|Stream<R>|<Function<T,R>|T->R|
|flatMap|intermediate|Stream<R>|Function<T,Stream<R>>|T->Stream<R>|
|sorted|intermediate<br>(stateful-unbounded)|Stream<T>|Comparator<T>|(T,T)->int|
|anyMatch|Terminal|boolean|Predicate<T>|T->boolean|
|noneMatch|Terminal|boolean|Predicate<T>|T->boolean|
|anyMatch|Terminal|boolean|Predicate<T>|T->boolean|
|allMatch|Terminal|boolean|Predicate<T>|T->boolean|
|findAny|Terminal|Optional<T>|||
|findFirst|Terminal|Optional<T>|||
|forEach|Terminal|void|Consumer<T>|T->void|
|collect|Terminal|R|Collector<T,A,R>||
|reduce|Terminal(stateful-bounded)|Optional<T>|BinaryOperator<T>|(T,T)->T|
|count|Terminal|long|||







	
