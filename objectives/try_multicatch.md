#### Multi-catch

##### Syntax
Syntax is `catch (Exception1 | Exception2 e)`, you can have any number of Exceptions.
The exception classes in the multi-catch statement should not be sublasses of the others.
`catch (FileNotFound | IOException e)` does not compile
</br></br>
Altough bad practice, it legal to re-assign the e variable in the traditional catch
```
try {
 ...
}  catch (IOException e) {
  e = new Exception();
}
```
It is illegal to re-assing the variable e in multi-catch (e is final)
```
try {

} catch (SQLException | IOException e) {
  e = new Exception();  // compilation error
}
```

##### Rethrow an exception
'handle and declare' could refer to catching an exception, logging it and then throwing it again.

```
public void rethrow() throws SQLException, IOException {
try {

} catch (SQLException | IOException e) {
  log(e);
  throw e;
}
```
Multi-catc statement can be replaced with `catch (Exception e)`. It is not bad practice because we are not really catching all the exceptions.
It catches all Exception subclases that allows the code to compile. Java infers the Exception subclasses.
