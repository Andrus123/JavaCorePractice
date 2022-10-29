package Interfaces;

// Implement MyIF
class MyIFImp implements MyIF {
	// Only getUserID() defined by MyIF needs to be implemented
	public int getUserID() {
		return 100;
	}
}

class MyIFImp2 implements MyIF {
	public int getUserID() {
		return 100;
	}
	public int getAdminID() {
		return 42;
	}
}

public class DefaultMethodDemo {
	public static void main(String[] args) {
		MyIFImp obj = new MyIFImp();
		
		// Can call getUserID(), because it is explicitly
		// implemented by MyIFImp
		System.out.println("User ID is "+ obj.getUserID());
		
		// Can also call getAdminId(), because of default implementation
		System.out.println("Administrator ID is "+ obj.getAdminID());
	}

}
