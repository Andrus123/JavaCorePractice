package ClassFundamentals;

// method overriding
class Aa {
	int i, j;

	Aa(int a, int b) {
		i = a;
		j = b;
	}

	// display i and j
	void show() {
		System.out.println("i and j: " + i + " " + j);
	}
}

class Bb extends Aa {
	int k;

	Bb(int a, int b, int c) {
		super(a, b);
		k = c;
	}

	// display K this overrides show() in A
	void show() {
		System.out.println("k: " + k);
	}
}

public class Override {
	public static void main(String[] args) {
		Bb subOb = new Bb(1, 2, 3);
		subOb.show(); // this calls show() in B
	}
}
