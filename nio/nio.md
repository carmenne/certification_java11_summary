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

#### StreamDirectory
```
Path dir = Paths.get("/home/java");
DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "**/*.txt);

```
**/*.txt - glob
There's one limitation to DirectoryStream. It streams only one directory (like ls)

- One astericks `*` means match any character except for a directory boundary. 
- Two astericks `**` means match any character including directory boundarie(s).
- `{A*, b}` - either a capital A followed by any character, or character b
- `?` one character
