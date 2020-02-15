import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ParameterizedTest {
	
	public static void main(String[] args) {
		
		var apples = new ArrayList<Apple>();
		apples.add(new Apple(1, "red", 130));
		apples.add(new Apple(2, "green", 100));
		apples.add(new Apple(3, "green", 150));
		List<Apple> greenApples = filter(apples, apple -> "green".equals(apple.color));
		greenApples.forEach(System.out::println);
		
		Integer[] numbers = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		List<Integer> evenNumbers = filter(Arrays.asList(numbers), number -> number % 2 == 0);
		evenNumbers.forEach(System.out::println);
	}
	
	public static <T> List<T> filter(List<T> elements, Predicate<T> predicate) {
		List<T> filteredElements = new ArrayList();
		for (T element: elements) {
			if (predicate.test(element)) {
				filteredElements.add(element);
			}
		}
		return filteredElements;
	}
}

interface Predicate<T> {
	boolean test(T t);
}


class Apple {
	int id;
	String color;
	int weight;
	
	Apple(int id, String color, int weight) {
		this.id = id;
		this.color = color;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return id + "-" + color + "-" + weight;
	}
}
