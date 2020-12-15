package project2;

public class Card {
	
	// fields, 
	// suit example: Spades, hearts, etc
	// rank example: Ace, 3, Jack, King, etc
	private String suit;
	private String rank;
	private boolean isInDeck;
	
	// constructor
	public Card(String suit, String rank){
		this.suit = suit;
		this.rank = rank;
	}
	
	/**
	 * 
	 * valueOf() finds the value of the rank
	 * of the card.
	 * 
	 * Ace rank value is 1
	 * 2 rank value is 2
	 * King rank value is 10
	 * Etc.
	 * 
	 * @return rankValue, the value of the rank
	 * as an integer
	 * 
	 */
	public int valueOf(){
		
		int rankValue;
		
		if (rank.equals("Ace")){
			rankValue = 1;
		}else if (rank.equals("Jack")){
			rankValue = 10;
		}else if (rank.equals("Queen")){
			rankValue = 10;
		}else if (rank.equals("King")){
			rankValue = 10;
		}else{
			rankValue = Integer.parseInt(rank);
		}
		
		return rankValue;
		
	}
	
	/**
	 * 
	 * toString() returns the card in a readable
	 * format
	 * 
	 * Example: "Ace of Spades"
	 * 
	 * @return, rank and suit in String format
	 * 
	 */
	public String toString(){
		return rank + " of " + suit;
	}
	
	// Getters and Setters
	
	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public boolean isInDeck() {
		return isInDeck;
	}

	public void setInDeck(boolean isInDeck) {
		this.isInDeck = isInDeck;
	}
	
}
