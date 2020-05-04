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

