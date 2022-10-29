package ExceptionHandles;

public class RethrowDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Rethrow.genException();
		} catch (ArrayIndexOutOfBoundsException exc) {
			// recatch exception
			System.out.println("Fatal error - " + "program terminated.");
		}
	}

}
