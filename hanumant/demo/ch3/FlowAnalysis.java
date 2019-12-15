package com.carmen.learn;

public class FlowAnalysis {
		
	public static void main(String[] args) {
	
		String description = "The compiler perfroms flow analysis to " + 
		"determine if the variables are initialized vefore being used.";
		System.out.println(description);
	
		System.out.println("");
		System.out.println("int val;");
		System.out.println("int i = 0;");
		System.out.println("if (i = 0) {");
		System.out.println("    val = 10;");
		System.out.println("}");
		System.out.print("The compiler will return compilation error");
		System.out.println("error: variable val might not have been initialized");
		
		int val;
		final int i = 0;
		if (i == 0) {
			val = 10;
		}
		
		System.out.println("");
		System.out.println("int val;");
		System.out.println("final int i = 0;");
		System.out.println("if (i = 0) {");
		System.out.println("    val = 10;");
		System.out.println("}");
		System.out.print("The compiler knows i cannot be re-assigned, so it compiles: ");
		System.out.println("val=" + val);			
	}
		
}

