import java.io.*;
import java.nio.file.*;

public class Try {
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("Test.java");
		File file = path.toFile();
		BufferedReader reader = new BufferedReader(new FileReader(file));
				
		System.out.println("Example1");
		try (var insideReader = reader) {
			System.out.println(insideReader.readLine());
		}
		
		System.out.println("\nExample2");
		
		try (One one = new One(); Two two = new Two()) {
			System.out.println("Try");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("Catch");
		} finally {
			System.out.println("Finally");
		}
	}
}

class One implements AutoCloseable {
	
	public void close() {
		System.out.println("Close - One");
	}
}


class Two implements AutoCloseable {
	
	public void close() {
		System.out.println("Close - Two");
	}
}
