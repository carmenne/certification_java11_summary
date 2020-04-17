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
