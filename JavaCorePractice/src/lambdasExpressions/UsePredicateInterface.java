package lambdasExpressions;

// Use the Predicate built-in functional interface

import java.util.function.Predicate;

public class UsePredicateInterface {
	public static void main(String[] args) {
		// This lambda uses Predicate<Integer> to determine
		// if a number is even
		Predicate<Integer> isEven = (n) -> (n % 2) == 0;
		
		if(isEven.test(4)) System.out.println("4 is even");
		
		if(!isEven.test(5)) System.out.println("5 is odd");
	}
}
