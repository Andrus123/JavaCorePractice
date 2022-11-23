package Generics;

// Use a wildcard.
class NumericFns2<T extends Number> {
	T num;
	
	// Pass the constructor a reference to
	// a numeric object.
	NumericFns2(T n) {
		num = n;
	}
	
	// Return the reciprocal
	double reciprocal() {
		return 1 / num.doubleValue();
	}
	
	// Return the fractional component.
	double fraction() {
		return num.doubleValue() - num.intValue();
	}
	
	// Determine if the absolute values of two
	// objects are the same.
	boolean absEqual(NumericFns2<?> ob) {
		if (Math.abs(num.doubleValue()) ==
				Math.abs(ob.num.doubleValue())) return true;
		
		return false;
	}
}

public class WildcardDemo {

	public static void main(String[] args) {
		
		NumericFns2<Integer> iOb = new NumericFns2<Integer>(6);
		NumericFns2<Double> dOb = new NumericFns2<Double>(-6.0);
		NumericFns2<Long> lOb = new NumericFns2<Long>(5L);
		
		System.out.println("Testing iOb and dOb.");
		if(iOb.absEqual(dOb))
			System.out.println("Absolute values are equal.");
		else
			System.out.println("Absolute values differ.");
		
		System.out.println();
		
		System.out.println("Testing iOb and lOb.");
		if(iOb.absEqual(lOb))
			System.out.println("Absolute values are equal.");
		else
			System.out.println("Absolute values differ.");
	}
}
 