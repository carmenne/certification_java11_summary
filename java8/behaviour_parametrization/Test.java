import java.util.List;
import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		
		
		var inventory= new ArrayList<Apple>();
		inventory.add(new Apple(1, "red", 130));
		inventory.add(new Apple(2, "green", 100));
		inventory.add(new Apple(3, "green", 150));
		inventory.add(new Apple(4, "green", 100));
		inventory.add(new Apple(5, "red", 130));
		inventory.add(new Apple(6, "red", 140));
		inventory.add(new Apple(7, "red", 170));
		System.out.println("TEST");
		
		AppleFunction byColor = new AppleFunction() {
			@Override
			public String pretty(Apple apple) {
				
				return  apple.id + " --- An apple of color: " + AppleFunction.addColor(apple) 
						+ apple.color + AppleFunction.resetColor();
			}
		};
		
		AppleFunction byWeight = new AppleFunction() {
			@Override
			public String pretty(Apple apple) {
				return apple.id + " --- An apple of weight: " + AppleFunction.addColor(apple) + 
						apple.weight + AppleFunction.resetColor();
			}
		};	
		
		prettyPrintApples(inventory, byColor);
		prettyPrintApples(inventory, byWeight);
	}
	
	
	public static void prettyPrintApples(List<Apple> inventory, AppleFunction function) {
		for (Apple apple : inventory) {
			System.out.println(function.pretty(apple));
		}
	}
	
	public static <T> filter(List<T> list, Predicate<T> p) {
		return list.get(0);
	}
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
}

interface AppleFunction {
	
	static final String ANSI_RED = "\u001B[31m";
	static final String ANSI_GREEN = "\u001B[32m";
	static final String ANSI_RESET = "\u001B[0m";
			
	
	static String addColor(Apple apple) {
		return "red".equals(apple.color) ? ANSI_RED : ANSI_GREEN;
	}
	static String resetColor() {
		return ANSI_RESET;
	}
	
	String pretty(Apple apple);
}
