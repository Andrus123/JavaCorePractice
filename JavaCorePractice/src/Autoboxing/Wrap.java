package Autoboxing;

// Demonstrate manual boxing and unboxing with a type wrapper

public class Wrap {
	public static void main(String[] args) {
		
		@SuppressWarnings("removal")
		Integer iOb = new Integer(100);
		
		int i = iOb.intValue();
		
		System.out.println(i + " " + iOb); // displays 100 100
	}

}
