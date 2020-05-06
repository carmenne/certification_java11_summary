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

#### Cyclic readability
No cyclic dependencies are allowed at compile time, however at runtime because frameworks are using refelction and because reflection frameworks are automatically creating a readability relation at run-time, cyclic dependency is allowed.
For instance the application package has a dependency on spring, however spring also needs a dependency on the application module because it needs to invoke reflection on it

#### Exports, qualified exports and a word on reflection
