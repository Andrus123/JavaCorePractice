package ExceptionHandles;

public class CustomExceptDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numer = { 4, 8, 15, 32, 64, 127, 256, 512 };
		int[] denom = { 2, 0, 4, 4, 0, 8 };

		for (int i = 0; i < numer.length; i++) {
			try {
				if ((numer[i] % 2) != 0)
					throw new NonIntResultException(numer[i], denom[i]);
				System.out.println(numer[i] + " / " + denom[i] + " is " + numer[i] / denom[i]);
			} catch (ArithmeticException exc) {
				// catch the exception
				System.out.println("Can't divide by Zero!");
			} catch (ArrayIndexOutOfBoundsException exc) {
				// catch the exception
				System.out.println("No matching element found.");
			} catch (NonIntResultException exc) {
				System.out.println(exc);
			}
		}
	}
}
