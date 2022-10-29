package ExceptionHandles;

class FinallyDemo {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			UseFinally.getException(i);
			System.out.println();
		}
	}
}
