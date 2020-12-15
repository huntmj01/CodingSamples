package project2;

public class Dealer extends Player{

	/**
	 * 
	 * stand() checks the value of the dealer hand
	 * and if the value is over 16 the dealer stands
	 * 
	 * @return stand, whether the dealer will stand
	 * 
	 */
	@Override
	public boolean stand() {
		
		boolean st = false;
		
		// check if value is over 16
		if (valueOf() > 16){
			// set stand to true
			st = true;
		}
	
		return st;
		
	}
	
	/**
	 * 
	 * valueOf() calculates value of Dealer's 
	 * hand and returns the total. NOTE: Ace
	 * always counts as 11 if possible.
	 * 
	 * @return total, the total of the players
	 * hand
	 * 
	 */
	@Override
	public int valueOf() {
		
		int total = 0;
		
		Card[] hand = getHand();
		
		// loop through cards in hand
		for (Card c: hand){
			
			if (c==null) break;
			
			// check if total is less than 12 and
			// if card value is an ace
			if (total > 12 && c.valueOf() == 1){
				// add 11 to the total
				total += 11;
			}else{
				// add the card value to the total
				total += c.valueOf();
			}
		}
		
		return total;
		
	}
		
}
