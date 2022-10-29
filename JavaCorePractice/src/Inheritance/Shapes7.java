package Inheritance;

class TwoDShapes3 {
	private double width;
	private double height;

	// A default constructor
	TwoDShapes3() {
		width = height = 0.0;
	}

	// Parameterized constructor
	TwoDShapes3(double w, double h) {
		width = w;
		height = h;
	}

	// Construct an object with equal width and height
	TwoDShapes3(double x) {
		width = height = x;
	}

	// Construct an object from an object
	TwoDShapes3(TwoDShapes3 ob) {
		width = ob.width;
		height = ob.height;
	}

	// Accessor methods for width and height
	double getWidth() {
		return width;
	}

	double getHeight() {
		return height;
	}

	void setWidth(double w) {
		width = w;
	}

	void setHeight(double h) {
		height = h;
	}

	void showDim() {
		System.out.println("Width and height are " + width + "and " + height);
	}
}

// A subclass of TwoDShapes3 for triangles
class Triangle4 extends TwoDShapes3 {
	private String style;

	// A default constructor
	Triangle4() {
		super();
		style = "none";
	}

	// Constructor for Triangle
	Triangle4(String s, double w, double h) {
		super(w, h); // call superclass constructor

		style = s;
	}

	// One argument constructor
	Triangle4(double x) {
		super(x); // call superclass constructor
		style = "filled";
	}

	// Construct an object from an object.
	Triangle4(Triangle4 ob) {
		super(ob); // pass object to TwoDShape3 constructor
		style = ob.style;
	}

	double area() {
		return getWidth() * getHeight() / 2;
	}

	void showStyle() {
		System.out.println("Triangle is " + style);
	}
}

public class Shapes7 {
	public static void main(String[] args) {
		Triangle4 t1 = new Triangle4("outlined", 8.0, 12.0);
		// make a copy of t1
		Triangle4 t2 = new Triangle4(t1);
		System.out.println("Info for t1: ");
		t1.showStyle();
		t1.showDim();
		System.out.println("Area is " + t1.area());
		System.out.println();
		System.out.println("Info for t2: ");
		t2.showStyle();
		t2.showDim();
		System.out.println("Area is " + t2.area());
	}

}
