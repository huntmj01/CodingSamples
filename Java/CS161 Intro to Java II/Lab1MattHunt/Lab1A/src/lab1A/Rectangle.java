package lab1A;

public class Rectangle {
	
	// Store the number of rows in the Rectangle
	private int numRows = 1;
	
	// Store the number of columns in the Rectangle
	private int numCols = 1;
	
	// Will  define either a filled or unfilled rectangle
	// True = filled, False = unfilled
	private boolean filled = false;

	// Getters and Setters
	
	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public int getNumCols() {
		return numCols;
	}

	public void setNumCols(int numCols) {
		this.numCols = numCols;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	// toString()
	public String toString(){
		
		String strRect = "";
		
		// rectangle is filled
		if (filled == true){
			
			// loop through rows
			for (int i = 0; i < numRows; i++){
				
				// add a line break at the start of each iteration as long
				// as its not the first iteration
				if (i != 0){
					strRect += "\n";
				}
				
				// loop through columns
				for (int j = 0; j < numCols; j++){
					// attach # to string
					strRect += "#";
				}
			}
		
		// rectangle is unfilled
		} else {
			
			// loop through rows
			for (int i = 0; i < numRows; i++){
				
				// add a line break at the start of each iteration as long
				// as its not the first iteration
				if (i != 0){
					strRect += "\n";
				}
				
				// loop through columns
				for (int j = 0; j < numCols; j++){
					
					// first row of rectangle, first iteration
					if (i == 0){
						strRect += "#";
					}
					// left side of rectangle
					if (i != 0 && i != numRows - 1 && j == 0){
						strRect += "#";
					}
					
					// middle
					if (i != 0 && i != numRows - 1 && j != numCols - 1 && j != 0){
						strRect += " ";
					}
					
					// right
					if (i != 0 && i != numRows - 1 && j == numCols - 1){
						strRect += "#";
					}
					
					// last row
					if (i == numRows - 1){
						strRect += "#";
					}
					
				}
			}
			
		}
		// return the string
		return strRect;
	}
}
