import java.util.Arrays;

enum Micutenii {
	
	MICUTA("Carmen", 32) { // constant specific class body
		@Override
		public String toString() {
			return "MICUTICA!!!";
		}
	},
	MICUTUL("Teodor", 34);
	
	public String name;
	public int age;
	
	private Micutenii(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + " " + age;
	}
	
	// error: method values() is already defined in enum Micutenii
	//~ public Micutenii[] values() {
		//~ return new Micutenii[]{};
	//~ }
	
}

public class Test {
	
	static enum Ceiuțuri {
		CULCATOARE, ROIBOS;
	}
	
	enum Deserturi {
		BOMBOANE, CIOCOLATA;
	}
	
	public static void main(String[] args) {
		
		System.out.println(Micutenii.MICUTA + " " + Micutenii.MICUTUL);
		Micutenii.MICUTA.name = "tot Carmen";
		System.out.println(Micutenii.MICUTA + " " + Micutenii.MICUTUL);
		//~ System.out.println(new Micutenii("a treia micutenie?", 0)); // error: enum types may not be instantiated
		System.out.println(Arrays.toString(Ceiuțuri.values()));
		System.out.println(Arrays.toString(Deserturi.values()));
	}
}
