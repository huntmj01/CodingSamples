package project3;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.JButton;

/**
 * 
 * A Tile represents an individual tile of the GUI as 
 * well as its associated fields.  The class is an 
 * extension of the JButton class.  A Tile displays
 * its background color, foreground color 
 * and label content (X or O).
 * 
 * @author 2015H_000
 *
 */

public class Tile extends JButton implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// fields
	private Color backgroundColor;
	private Color foregroundColor;
	private String labelContent;
	
	// constructor
	public Tile(){
		
		// initialize field defaults
		backgroundColor = Color.BLACK;
		foregroundColor = Color.WHITE;
		labelContent = "O";
		
		super.setBackground(backgroundColor);
		super.setForeground(foregroundColor);
		super.setText(labelContent);
		
	}

	/**
	 * 
	 * reset() resets the tile to the default
	 * black background with white foreground
	 * and "O" as the label content
	 * 
	 */
	public void reset(){
		backgroundColor = Color.BLACK;
		foregroundColor = Color.WHITE;
		labelContent = "O";
		super.setBackground(backgroundColor);
		super.setForeground(foregroundColor);
		super.setText(labelContent);
	}
	
	// getters and setters
	
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		super.setBackground(this.backgroundColor);
	}

	public Color getForegroundColor() {
		return foregroundColor;
	}

	public void setForegroundColor(Color foregroundColor) {
		this.foregroundColor = foregroundColor;
		super.setForeground(this.foregroundColor);
	}

	public String getLabelContent() {
		return labelContent;
	}

	public void setLabelContent(String labelContent) {
		this.labelContent = labelContent;
		super.setText(this.labelContent);
	}
		
}
