package ExceptionHandles;

public class MultiCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 88, b = 0;
		@SuppressWarnings("unused")
		int result;
		char[] chrs = { 'A', 'B', 'C' };

		for (int i = 0; i < 2; i++) {
			try {
				if (i == 0)
					result = a / b; // generate an ArithmeticException
				else
					chrs[5] = 'X'; // generate an ArrayIndexOutOfBounds
				// This catch clause catches both exceptions.
			} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
				System.out.println("Exception caught: " + e);
			}
		}
		System.out.println("After multi-catch.");
	}

}
