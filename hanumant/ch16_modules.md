Directory structure
--src
  -- simleinterest
    - module-info.java
    -- simpleinterstpackage
      - SimpleInterestCalculator.java


- compile a module
javac -d out --module-src-path src --module simpleinterest

- run 
java --module-path out --module simpleinterest/simpleinterestpackage.SimpleInterestCalculator
