package Inheritance;
// A simple class hierarchy

// A Class for two dimensional objects
class TwoDShape1 {
	double width;
	double height;

	void showDim() {
		System.out.println("Width and height are " + width + " and " + height);
	}
}

// A subclass of TwoDShape for triangles
class Triangle1 extends TwoDShape1 {
	String style;

	double area() {
		return width * height / 2;
	}

	void showStyle() {
		System.out.println("Triangle is " + style);
	}

}

// A subclass of TwoDShape for rectangles
class Rectangle1 extends TwoDShape1 {
	boolean isSquare() {
		if (width == height)
			return true;
		return false;
	}

	double area() {
		return width * height;
	}
}

public class Shapes {
	public static void main(String[] args) {
		Triangle1 t1 = new Triangle1();
		Triangle1 t2 = new Triangle1();

		t1.width = 4.0;
		t1.height = 4.0;
		t1.style = "filled";

		t2.width = 8.0;
		t2.height = 12.0;
		t2.style = "outlined";

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
