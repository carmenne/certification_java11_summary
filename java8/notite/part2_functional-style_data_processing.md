Streams API
-----------------------
Streams API lets you write code that is:
	*declarative (more concise and readable)
	*composable (greater flexibility)
	*parallelizable (better performance)
Definition: a sequence of elements from a source that supports data processing operations
	* sequence of elements: collections are about data, streams are about computations
	* source: streams consume from a data-providing source such as collections,
	arrays, I/O resources (Note: generating a stream from an ordered collection
	preserves the ordering)
	* data processing operations: filter, map, reduce, find, match, sort etc.
Characteristics:
    * pipelining (intermediate operations)
    * internal iteration
Streams are traversable only once (you can consume a stream only once)
Working with streams involves three items:
	* a data source (such as collections)
	* a chain of intermediate operations (they return Stream<T>)
	* a terminal operations that executes the stream pipeline 
	and produces a result (the execution of streams is deferred)
	
Streams API operations
-----------------------	

* Bullet list
              * Nested bullet
                  * Sub-nested bullet etc
          * Bullet list item 2
	
