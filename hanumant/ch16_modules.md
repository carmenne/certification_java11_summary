Directory structure
<pre>
--src
  -- simleinterest
    - module-info.java
    -- simpleinterstpackage
      - SimpleInterestCalculator.java
</pre>

- compile a module
```
javac -d out --module-src-path src --module simpleinterest
```

- run
```
java --module-path out --module simpleinterest/simpleinterestpackage.SimpleInterestCalculator
```
--module = 'module name'/'main class name'

- package
```
jar --create --file simpleinterest.jar --main-class simpleinterestpackage.SimpleInterestCalculator
    -C out/simpleinterest .
```
- run
java --module-path . --module simpleinterest


A module contains more packages. A module cannot access types from another modules unless they are made explicitly accessible. This is done via the export statement that is put in the module-info class. The export statement 
can only export packages. All the public types from that package will be accessible from another modules.
Accessing a module is called reading a module.

