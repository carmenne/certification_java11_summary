public class Test {
	public static void main(String[] args) {
		int i = 0;
		while (i < 10) {
			// int i = -5; // COMPILATION ERROR: Test.java:5: error: variable i is already defined in method main(String[])
			i++;
		}
		System.out.println(i);
	}
}
