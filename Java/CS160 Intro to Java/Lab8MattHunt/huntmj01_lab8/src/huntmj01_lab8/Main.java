package huntmj01_lab8;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Make a Random object. This will be used in some cases.
		Random rand = new Random();

		// Use a Scanner and the console to ask the user what kind
		// of object they want to make – a Circle or a Triangle.
		Scanner scan = new Scanner(System.in);
		System.out.println("What kind of object would you like to make? (Circle or Triangle): ");
		String input = scan.nextLine();

		// The user should enter the entire word,
		// circle or triangle, but case should not matter
		if (input.toLowerCase().equals("circle")) {

			// Ask the user for the Circle’s radius
			System.out.println("You have selected the circle please enter a radius: ");
			double radius = scan.nextDouble();

			Circle circle;

			// If the radius is negative, use the no argument constructor.
			if (radius < 0) {
				circle = new Circle();

				// If the radius is 0, set it to a random number between 1 and
				// 20
				int num = rand.nextInt(21);
				System.out.println("Invalid radius given. Setting radius to: " + num);
				circle.setRadius(num);

				// Otherwise, use the argument constructor and pass the radius
				// to a new circle.
			} else {
				circle = new Circle(radius);
			}

			// Print out the circle’s current area, diameter, and circumference
			System.out.println("Area: " + circle.getArea());
			System.out.println("Diameter: " + circle.getDiameter());
			System.out.println("Circumfrance: " + circle.getCircumference());

		} else if (input.toLowerCase().equals("triangle")) {

			// Ask the user for the Triangle’s base width
			System.out.println("You have selected the triangle please enter the base: ");
			double base = scan.nextDouble();

			// Ask the user for the Triangle’s base width
			System.out.println("You have selected the triangle please enter the height: ");
			double height = scan.nextDouble();

			Triangle triangle;

			// If either of the numbers is negative, use the no argument
			// constructor.
			if (base < 0 || height < 0) {
				triangle = new Triangle();

				// If the base or height is 0, set them both to a random number
				// between 1 and 20
				int b = rand.nextInt(21);
				System.out.println("Invalid base given. Setting base to: " + b);
				int h = rand.nextInt(21);
				System.out.println("Invalid height given. Setting height to: " + h);
				triangle.setBase(b);
				triangle.setHeight(h);

				// Otherwise, use the argument constructor and pass the base and
				// height to a new triangle
			} else {
				triangle = new Triangle(base, height);
			}

			// Print out the triangle's area
			System.out.println("Area: " + triangle.getArea());

		} else {
			System.out.println("Error exiting program");
			System.exit(0);
		}

	}

}
