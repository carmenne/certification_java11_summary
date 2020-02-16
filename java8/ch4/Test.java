import java.util.*;
import java.util.stream.*;

public class Test {
	public static void main(String[] args) {
		
		System.out.println("TEST");

		Stream.iterate(new int[] {0,1}, t -> {
											int temp = t[1];
											t[1]=t[0] + t[1];
											t[0]=temp;
											return t;
				})
				.limit(20)
				.forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
	}
}
