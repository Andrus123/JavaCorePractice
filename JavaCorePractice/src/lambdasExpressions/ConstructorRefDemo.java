package lambdasExpressions;

// Demonstrate a Constructor reference.

// MyFunc is a functional interface whose method returns
// a MyClass reference
interface MyFunc2 {
	MyClass2 func(String s);
}

class MyClass2 {
	private String str;
	
	// This constructor takes an argument.
	MyClass2(String s) { str = s; }
	
	// This is the default constructor
	MyClass2() { str = ""; }
	// ...
	
	String getStr() { return str; }
}

public class ConstructorRefDemo {
	public static void main(String[] args) {
		// Create a reference to the MyClass constructor
		// Because func() in MyFunc() takes an argument, new
		// refers to the parameterized constructror in MyClass
		// not the default constructor
		MyFunc2 myClassCons = MyClass2::new;
		
		// Create an instance of MyClass via that constructor reference.
		MyClass2 mc = myClassCons.func("Testing");
		
		// Use the isntance of MyClass just created
		System.out.println("str in mc is "+ mc.getStr());
	}
}
