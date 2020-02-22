import java.util.*;
import java.util.stream.*;
import java.lang.Math;

import static java.util.stream.Collectors.*;

public class Sums {
	public static void main(String[] args) {
		
		System.out.println("Starting calculeting sums");

		System.out.println("Option 1: collect(reducing( with 1-arg");
		int sum1 = Dish.menu.stream().map(Dish::getCalories).collect(reducing(Integer::sum)).get();
		System.out.println("Total=" + sum1);
		
		System.out.println("Option 2: collect(reducing( with 3-args");
		int sum2 = Dish.menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
		System.out.println("Total=" + sum2);

		System.out.println("Option 3: reduce( with 1-arg");
		int sum3 = Dish.menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
		System.out.println("Total=" + sum3);

		System.out.println("Option 4: reduce( with 3-args");
		int sum4 = Dish.menu.stream().reduce(0, (acc, el) -> acc + el.getCalories(), Integer::sum);
		System.out.println("Total=" + sum4);
	}
}
