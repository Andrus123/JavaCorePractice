package Interfaces;

public interface MyIF {
	// This is a "normal" interface method declaration
	int getUserID();
	
	// This is a default method. Notice that it provides
	// a default implementation
	default int getAdminID() {
		return 1;
	}
	
	// This is a static interface method.
	static int getUniversalID() {
		return 0;
	}
}
