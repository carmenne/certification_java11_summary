#### Resolve
path1.resolve(path2) should be read as resolve path2 within path1 directory
```
Path dir = Paths.get("/home/java");
Path file = Paths.get("learn/java.md");
Path result = dir.rezolve(file); // /home/java/learn/java.md
```


#### Relativize
path1.relativize(path2) shoul be read as give me a path that shows how to get from path1 to path2
```
Path dir = Paths.get("/home/java");
Path file = Paths.get("/home/java/learn/java.md");
Path result = dir.relativize(file); // learn/java.md
```
