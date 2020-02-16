import java.util.*;
import java.util.stream.*;

public class Test {
	public static void main(String[] args) {
		
		System.out.println("TEST");

		Stream.iterate(new int[] {0,1}, t -> new int[] {t[1], t[0] + t[1]})
				.limit(20)
				.map(t->t[0])
				.forEach(System.out::println);
	}
}
