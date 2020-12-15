package huntmj01_lab8;

public class Circle {
	
	// variables
	private double radius;	// the radius of the circle
	private final double PI = 3.14159;	// the value of PI
	
	// constructors
	
	// a constructor that accepts a double argument, 
	// and use it to set the radius of the circle
	public Circle(double radius){
		this.radius = radius;
	}
	
	// a constructor that accepts no arguments 
	// and set the circle’s radius to 0.0.
	public Circle(){
		radius = 0.0;
	}
	
	//GETTERS and SETTERS
	
	// setRadius – take a double argument, set radius to that value
	public void setRadius(double radius){
		this.radius = radius;
	}
	
	// getRadius – take no arguments, return the current value of the circle’s radius
	public double getRadius(){
		return radius;
	}
	
	// getArea – take no arguments, return the area (PI * radius * radius) of the circle
	public double getArea(){
		return PI * radius * radius;
	}
	
	// getDiameter – take no arguments, return the diameter (radius * 2)
	public double getDiameter(){
		return radius * 2;
	}
	
	// getCircumference – take no arguments, return 2 * PI * radius
	public double getCircumference(){
		return 2 * PI * radius;
	}
	
}
