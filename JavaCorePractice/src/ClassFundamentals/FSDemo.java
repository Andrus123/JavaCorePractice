package ClassFundamentals;

/*This class implements a "fail-soft" array which prevents
 * runtime errors
 * */

class FailSoftArray {
	private int[] a; // reference to array
	private int errval; //value to return if get() fails
	public int length; // length is public
	
	// Construct array given its size and the value to return if
	// if get() fails
	public FailSoftArray(int size, int errv) {
		a = new int[size];
		errval = errv;
		length = size;
	}
}
public class FSDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
