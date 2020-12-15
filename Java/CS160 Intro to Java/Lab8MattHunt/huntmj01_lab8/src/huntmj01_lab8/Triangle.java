package huntmj01_lab8;

public class Triangle {
		
		// variables
		private double base;	// the base length of the triangle
		private double height;	// the height of the triangle
		
		// constructors
		
		// a constructor that takes two double arguments and 
		// uses them to assign the base and height respectively
		public Triangle(double base, double height){
			this.base = base;
			this.height = height;
		}
		
		// a constructor that takes no arguments 
		// and sets both base and height to 0.0
		public Triangle(){
			base = 0.0;
			height = 0.0;
		}
		
		//GETTERS and SETTERS
		
		// setBase – takes a double argument, set base to that value
		public void setBase(double base){
			this.base = base;
		}
		
		// setHeight – takes a double argument, set height to that value
		public void setHeight(double height){
			this.height = height;
		}
		
		// getBase – take no arguments, return the current value of the triangle’s base
		public double getBase(){
			return base;
		}
		
		// getHeight – take no arguments, return the current value of the triangle’s height
		public double getHeight(){
			return height;
		}
		
		// getArea – take no arguments, return the area (1/2 * base * height) of the circle
		public double getArea(){
			return 0.5 * base * height;
		}
		
}
