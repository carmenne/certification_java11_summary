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
#### Module resolution (--show-module-resolution, --limit-modules)
#### Cyclic readability
#### Exports, qualified exports and a word on reflection
