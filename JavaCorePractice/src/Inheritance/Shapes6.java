package Inheritance;

// A multilevel hierarchy
class TwoDShapes {
	private double width;
	private double height;

	// A default constructor
	TwoDShapes() {
		width = height = 0.0;
	}

	// Parameterized constructor
	TwoDShapes(double w, double h) {
		width = w;
		height = h;
	}

	// Construct object with equal width and height
	TwoDShapes(double x) {
		width = height = x;
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
		System.out.println("Width and height are " + width + " and " + height);
	}
}

// Extend TwoDShape.
class TriangleShape extends TwoDShapes {
	private String style;

	// A default constructor
	TriangleShape() {
		super();
		style = "none";
	}

	TriangleShape(String s, double w, double h) {
		super(w, h); // call superclass constructor

		style = s;
	}

	TriangleShape(double x) {
		super(x);
		style = "filled";
	}

	double area() {
		return getWidth() * getHeight() / 2;
	}

	void showStyle() {
		System.out.println("Triangle is " + style);
	}
}

// Extend Triangle
class ColorTriangle extends TriangleShape {
	private String color;

	ColorTriangle(String c, String s, double w, double h) {
		super(s, w, h);
		color = c;
	}

	String getColor() {
		return color;
	}

	void showColor() {
		System.out.println("Color is " + color);
	}
}

public class Shapes6 {
	public static void main(String[] args) {
		ColorTriangle t1 = new ColorTriangle("Blue", "outlined", 8.0, 12.0);
		ColorTriangle t2 = new ColorTriangle("Red", "filled", 2.0, 2.0);

		System.out.println("Info for t1: ");
		t1.showStyle();
		t1.showDim();
		t1.showColor();
		System.out.println("Area is " + t1.area());
		System.out.println();
		System.out.println("Info for t2: ");
		t2.showStyle();
		t2.showDim();
		t2.showColor();
		System.out.println("Area is " + t2.area());

	}

}
