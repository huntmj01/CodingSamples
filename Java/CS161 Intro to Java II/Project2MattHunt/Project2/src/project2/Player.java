package project2;

public abstract class Player {
	
	// fields
	private Card[] hand;
	
	// constructor
	public Player(){
		// initialize hand to be a card array of 12 cards
		hand = new Card[12];
	}
	
	// abstract methods
	
	public abstract boolean stand();
	public abstract int valueOf();
	
	// methods
	
	/**
	 * 
	 * clearHand() loops through the hand array of cards
	 * and sets each card to empty
	 * 
	 */
	public void clearHand(){
		hand = new Card[12];
	}
	
	/**
	 * 
	 * bust() returns whether the value of the
	 * players hand has exceeded 21
	 * 
	 * @return bust, true if user hand has
	 * exceeded 21
	 * 
	 */
	public boolean bust(){
		boolean b = false;
		
		// check if hand value is over 21
		if (valueOf() > 21){
			b = true;
		}
		
		return b;
	}
	
	/**
	 * 
	 * hit() loops through the players hand until an
	 * empty card is found and then the empty card is
	 * replaced with the next card on top of the deck
	 * 
	 * @param Deck d, the deck that you wish to take 
	 * a card from
	 * 
	 */
	public void hit(Deck d){
		// loop through hand
		for (int i = 0; i < hand.length; i++){
			// find card that is empty
			if (hand[i]==null){
				// assign the empty card to the next card in the deck
				hand[i] = d.dealCard();
				break;
			}
		}
	}

	
	// getters and setters
	
	public Card[] getHand() {
		return hand;
	}

	public void setHand(Card[] hand) {
		this.hand = hand;
	}
	
}
