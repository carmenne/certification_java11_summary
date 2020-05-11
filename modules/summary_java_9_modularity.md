#### Single module mode vs. multi module mode
#### Compilation
Prior java 9
```
javac -d out src/com/foo/Class1.java src/com/foo/Class2.java
```
Java 9 and after
```
javac -d out/<modulename> src/<module_name>/folder_structure_for_packages/Class1.java
         out/<modulename> src/<module_name>/folder_structure_for_packages/Class2.java
         <modulename> module-info.java
```
`module-source-path` tells javac where to look for other modules in source format during compilation. It is mandatory to provide a destination directory (`-d`) when compiling in multimodule mode. This output directory can then be used as an element on the module path when running modules (e.g. `java --module-path...`)

#### Packaging
```
jar -cfe mods/name.jar FQCN -C out/<modulename> .
```
FQCN = fully qualified class name withouth .class extention

#### Running
##### Run the exploded module format
```
java --module-path out --module <modulename>/<FQCN>
```
##### Run the modular jar (manifest file from jar contains an exntry Main-Class with the main class that will be run 
when the executable jar will be started
```
java --module-path mods --module <modulename>
```
`--module` can be replaced with `-m`
`--module` can be replaced with `-p`

#### Exploded module format vs. modular JAR
#### Module-path (classpath). Flags --module-path (-p)
`module-path` is a list of paths to ondividual modules and directories containing modules. Each directory on the module path can contains zero or more module definitions, where a module definition can be an exploded module or a modular JAR file

#### Module resolution (--show-module-resolution, --limit-modules)
Missing dependencies are noticed at compile-time.
`--limit-modules`
```
java -p out --show-module-resolution --limit-modules java.base -m com.javamodularity/com.javamodularity.helloworld.HelloWorld

output:
root com.javamodularity file:///home/carmen/projects/certification_java11_summary/modules/out/com.javamodularity/
Hello Modular World!

```
```diff 
- Without `--limit-modules` flag, the resolution list will resolve the jdk modules as well and the list will be much higher
```

#### Cyclic readability
<pre>
No cyclic dependencies are allowed at compile time, however at runtime because frameworks are using refelction and because reflection frameworks are automatically creating a readability relation at run-time, cyclic dependency is allowed.
For instance the application package has a dependency on spring, however spring also needs a dependency on the application module because it needs to invoke reflection on it.
</pre>

#### Exports, qualified exports and a word on reflection
`exports <packagename> to <modulename>` exports the package only to a target module. During compilation, the target module of a qualified export must be on the module path or be compiled at the same time.
       
### Services
#### provides with
`provides api(service) with implementation`
<pre>
Both service type (after provide) and implementation class (after with) must be fully qualified names.
Most important the package conatining the implementation class is not exported from the provider module.
Services allow a module to provide implementations to other modules without exporting the concrete implementation class.
The module system has special privileges to reach into the provider module to instantiate the non exported implementation class on behalf of the consumer.
A service consumer does not know which module provides an implementation.
`uses` is used in the module descriptor to s[ecify which service (API) the service consumer wants to use.It instructs the ServiceLoader that this module wants to use implementation of the API (interface).
`ServiceLoader.load(Type.class)` is the syntax for instantiating implementations of the interface. The ServiceLoader instantiates the classes lazily.
</pre>

<pre>
A class appearing after `with` must have a public no-args constructor or a static provider method.
If there's no static provider method, the class is assumed to be the service implementation itself and must have a no-args public constructor. The compiler will complain when this is not the case.
</pre>

### Relfection
Deep reflection (using setAccesibility on private fields) is disallowed with modules. In order to allow frameworks to keep using reflection `opens` clause can be used. In this way the framework will have access to the private and public fields for reflection at runtime but not at compile time (as it is not needed).
`opens` can be qualified `to` (`opens demo to jackson.databind`, where demo = package name, jackson.databind is an automatic module)</br>
For a class to able to read another class from another module, the following needs be true:
- the class needs to be public (except for the deep reflection case);
- the package from the other module has to be exported, or open in case of deep reflection;
- the consuming module needs a requires to the other module (needs to have a readability relation)

### Migration
#### Top-down
Move the application ode in a module
#### Automatic modules
Automatic modules can be created by moving an existing JAR (a traditional JAR) from classpath to modulepath without changing its contents. This turns the JAR into a module with a module descriptor generated on the fly by th emodule system.</br>
In contrast explicit modules must always have a module descriptor generated by the user.
An automatic module has the following characteristics:
- It does not contain module-info.class.
- It has a module name specified in META-INF/MANIFEST.MF or derived from its filename.
- It requires transitive all other resolved modules.
- It exports all its packages.
- It reads the classpath (or more precisely, the unnamed module as discussed later).
- It cannot have split packages with other modules.

The name of an automatic module can be specified in the newly introduced Automatic-Module-Name field of a META-INF/MANIFEST.MF file. If no name is specified, the module name is derived from the JAR’s filename:
- dashes are replaced by dots;
- versions are omitted

#### jdpes
`jdeps <options> <path ...>`, path can be a pathname to a .class file, a directory, a JAR file.
jdeps analyzes bytecode (not source code). The jdeps command shows the package-level or class-level dependencies of Java class files. The input class can be a path name to a .class file, a directory, a JAR file, or it can be a fully qualified class name to analyze all class files. The options determine the output. By default, jdeps outputs the dependencies to the system output. It can generate the dependencies in DOT language (see the -dotoutput option).

#### Unamed module
- The unamed module is created when code is loaded from the classpath. Code is loeaded from the classpath when the code is not in a module.
- The unamed module reads all the modules
- The unamed module exports all packages in order to allow for a plefixle migration. It does not, however, mean that code in a named module can access types in the unnamed module.
- A named module cannot delcare a dependency on the unamed module
- If a package is defined in bhttp://openjdk.java.net/projects/jigsaw/spec/sotms/#compatibility--migrationoth a named module and the unnamed module then the package in the unnamed module is ignored. 

#### [Automatic module](http://openjdk.java.net/projects/jigsaw/spec/sotms/#compatibility--migration)
- By placing, unmodified,  a traditional JAR on the module path instead of classpath, we can create an automatic module.
- An automatic module is a named module defined implicitly (it does not have a module-info.java)
- There is no practical way to tell, in advance, which other modules an automatic module might depend upon. After a module graph is resolved, therefore, an automatic module is made to read every other named module, whether automatic or explicit.
- An automatic module exports all its packages
- An automatic module grants implied readability to all other automatic modules
- Automatic modules offer a middle ground between the chaos of the class path and the discipline of explicit modules.

#### Explicit module
An explicit module is a named module defined explicitly (it contains module-info.java)
