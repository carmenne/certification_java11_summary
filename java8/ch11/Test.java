import java.util.Random;
import java.util.concurrent.*;

public class Test {
	

	public static void main(String[] args) {
		Shop shop = new Shop();
		System.out.println("Async");
		
		long start = System.nanoTime();
		Future<Double> futurePrice = shop.getPriceAsync("apples");
		long invocationTime = ((System.nanoTime() - start) / 1_000_000);

		System.out.println("Invocation returned after " + invocationTime + " msec");
		
		try {
			double price = futurePrice.get();
			System.out.printf("Price is %.2f%n", price);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Price returned after " + retrievalTime + " msec");
		
		System.out.println("Sync");
		start = System.nanoTime();
		double priceSync = shop.getPrice("apples");
		retrievalTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Price returned after " + retrievalTime + " msec");
		
	}
	

}

class Shop {
	
	private final Random random = new Random();
	
	public Future<Double> getPriceAsync(String product) {
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		new Thread(() -> {
				double price = calculatePrice(product);
				futurePrice.complete(price);
			}).start();
		return futurePrice;
	}
	
	public double getPrice(String product) {
		return calculatePrice(product);
	}
	
	private double calculatePrice(String product) {
			delay();
			return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}

	public static void delay() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
