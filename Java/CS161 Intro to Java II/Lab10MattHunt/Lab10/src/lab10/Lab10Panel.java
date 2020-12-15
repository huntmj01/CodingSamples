package lab10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Lab10Panel extends JPanel {

	private int animal;

	public Lab10Panel() {
		setPreferredSize(new Dimension(600, 400));
		animal = 0;
	}

	@Override
	public void paintComponent(Graphics g) {

		// call super and pass it the graphic
		super.paintComponent(g);

		// draw a turkey
		if (animal == 0) {
			g.setColor(Color.RED);

			g.fillOval(85, 100, 50, 250);

			g.setColor(Color.BLUE);

			g.fillOval(100, 80, 50, 250);

			g.setColor(Color.RED);

			g.fillOval(125, 60, 50, 250);

			g.setColor(Color.BLUE);

			g.fillOval(145, 80, 50, 250);

			g.setColor(Color.RED);

			g.fillOval(185, 100, 50, 250);

			g.setColor(new Color(145, 85, 45));

			g.fillOval(75, 150, 250, 250);

			g.fillOval(174, 100, 40, 100);

			g.setColor(Color.BLACK);

			g.drawOval(173, 99, 42, 102);
			g.fillOval(155, 120, 40, 40);

			g.fillOval(195, 120, 40, 40);

			g.setColor(Color.YELLOW);

			int xPoints[] = { 174, 180, 214 };
			int yPoints[] = { 150, 200, 150 };

			g.fillPolygon(xPoints, yPoints, 3);

			// draw a fish
		} else if (animal == 1) {


			// Draws the body
			g.setColor(Color.blue);
			g.fillOval(70, 70, 360, 120);

			// Draws the fin
			g.setColor(Color.red);
			g.fillOval(225, 40, 85, 45);

			// Draws the tail
			g.setColor(Color.red);
			g.fillOval(375, 90, 140, 75);

			// Draws the eye
			g.setColor(Color.red);
			g.fillOval(100, 100, 12, 12);

			// Draws the mouth
			g.setColor(Color.white);
			g.drawArc(68, 105, 75, 30, 190, 110);

			// draw a rock
		} else if (animal == 2){
			// Draws the body of the pet rock
						g.setColor(Color.GRAY);
						g.fillOval(70, 70, 360, 120);
		}

	}

	// getters and setters
	
	public int getAnimal() {
		return animal;
	}

	public void setAnimal(int animal) {
		this.animal = animal;
	}
	
	
}
