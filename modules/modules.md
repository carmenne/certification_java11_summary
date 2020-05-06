<pre>
-- mods
-- out
-- src
	-- com.learning
		--- module-info.java
		-- com
		-- learning
			-- datastructures
			--- MyStack.java
<pre>

#### module name
The module name must match the name of the directory containing the module descriptor.
Otherwise, the compiler refuses to compile and reports the mismatch.

### empty module-info.java
By default, all packages are strongly encapsulated.
Even though there’s no dependency information (yet) in this declaration, 
remember that this module implicitly depends on the java.base platform module.

#### module-path
module-path is similar to -classpath (-cp, --class-path). It is used to express dependencies.
If the code does not use any dependency, it can be omitted.

#### Compile
`javac --module-source-path src/ -d out src/com.learning/module-info.java src/com.learning/com/learning/datastructures/MyStack.java`

#### Run
`java -p out -m com.learning/com.learning.datastructures`
<modulename>/<classname>

#### Package
`jar -cfve com.learning.jar com.learning.datastructures.MyStack -C out/com.learning/ .`

