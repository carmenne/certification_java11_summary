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

#### findFirst vs. findAny
findFirst is constraining when used in parallel streams
#### Reducing
There are more overloaded methods:
 * reduce(0, Integer::sum) returns an int
 * reduce(Integer::sum) returns an Optional<Integer> (optional is needed because the stream can be empty)
```diff
- * reduce(0, accumulator, combiner) -> for parallel streams
```
	
#### Reduce in parallel
To sum all the elements in the stream, theres is little modification to the sequential version:
```java
int sum = numbers.parallelStream().reduce(0, Integer::sum);
```
But there is a price to pay to execute this code in parallel: the lambda passed to reduce can't change state (for example
instance variables), and the operation needs to be associative to it can be executed in any order.

#### Stream operations: stateless vs. stateful
Operations like map and filter don't have an internal state (assuming the user supplied lambda or method reference has no internam mutable state).
Operations like reduce, sum, and max need to have internal state to accumulate the result.The internal state is of bounded size (e.g. integer, double) no matter how many elements are in the stream being processed.
Operations like sorted, distinct require knowing the previous history. For example, sorting requires all the elements to be buffered before a single item can be added to the output stream: the storage requirement of this operation is unbounded.

Numeric streams
-----------------------	
Primitive stream specializations are: IntStream, LongStream, DoubleStream (they are avoiding hidden boxing costs)
#### Mapping to a numeric stream
The most common methods are: mapToInt, mapToDouble, mapToLong.
e.g.
```
int calories = menu.stream()
		.mapToInt(Dish::getCalories()
		.sum();
```
#### Converting back to a stream og objects
`Stream<Integer> stream = intStream.boxed()`
#### OptionalInt
```
OptionalInt maxCalories = menu().stream()
				.mapToInt(Dish::getCalories)
				.max();
int max = maxCalories.orElse(1);				
```
#### Numeric ranges
`IntStream numbers = IntStream.rangeClosed(1, 100);`

Building streams
-----------------------	
#### Streams from values
` Stream<String> stream = Stream.of("Carmen", "Teodor");`
#### Streams from arrays
```
int[] numbers = {1, 2, 3}
int sum = Arrays.stream(numbers).sum(); // 6
```
#### Streams from files
```
long uniqueWords = 0;
try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
	uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
			   .distinct()
			   .count();	
} catch (IOException e) {
}
```
#### Streams from function
  * Iterate - static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
  ```
  Stream.iterate(0, n -> n + 2)
  	.limit(10)
	.forEach(System.out::println);
  ```
  * Generate - static <T> Stream<T> generate(Supplier<T> s)
    ```
  Stream.generate(Math::random)
  	.limit(10)
	.forEach(System.out::println);
  ```
	
