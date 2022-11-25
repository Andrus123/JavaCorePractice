package lambdasExpressions;

// Use an instance method reference to refer to any instance.

// A functional interface for numeric predicates that operate
// on an object of type MyIntNum and an integer value.
interface MyIntNumPredicate {
	boolean test(MyIntNum2 mv, int n);
}

// This class stores an int value and defines the instance
// method isFactor(), which returns true if its argument
// is a factor of the stored value
class MyIntNum2 {
	private int v;
	
	MyIntNum2(int x) { v = x; }
	
	int getNum() { return v; }
	
	// Return true if n is a factor of v.
	boolean isFactor(int n) {
		return (v % n) == 0;
	}
}

public class MethodRefDemo3 {

	public static void main(String[] args) {
		boolean result;
		
		MyIntNum2 myNum = new MyIntNum2(12);
		MyIntNum2 myNum2 = new MyIntNum2(16);
		
		// This makes inp refer to the instance method isFactor()
		MyIntNumPredicate inp = MyIntNum2::isFactor;
		
		// The following calls isFactor() on myNum.
		result = inp.test(myNum, 3);
		if(result)
			System.out.println("3 is a factor of " + myNum.getNum());
		
		// The following calls isFactor() on myNum2
		result = inp.test(myNum2, 3);
		if(!result)
			System.out.println("3 is not a factor of " + myNum2.getNum());
	}
}
