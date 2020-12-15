package project2;

import java.util.Random;

public class Guest extends Player {

	/**
	 * 
	 * stand() checks the value of the guest hand
	 * and if the value is 19 or over the guest stands,
	 * if the value is between 16-18 the guest has a
	 * 50/50 chance of standing
	 * 
	 * @return stand, whether the guest will stand
	 * 
	 */
	@Override
	public boolean stand() {
		
		boolean st = false;
		
		// check if value is over 19
		if (valueOf() >= 19){
			// set stand to true
			st = true;
		
		// check if value of hand is between 16 and 18
		}else if (valueOf() < 19 && valueOf() > 15){
			// generate a new random
			Random rand = new Random();
			
			// half the time set to true
			// the other half set to false
			if (rand.nextGaussian() > 0.5){
				st = true;
			}else {
				st = false;
			}
		}

		return st;
	}

	/**
	 * 
	 * valueOf() calculates value of Guest's 
	 * hand and returns the total. NOTE: Ace
	 * always counts as 1 for Guest.
	 * 
	 * @return total, the total of the players
	 * hand
	 * 
	 */
	@Override
	public int valueOf() {
		
		int total = 0;
		
		Card[] hand = getHand();
		
		for (Card c: hand){
			if (c==null) break;
			total += c.valueOf();
			
		}
		
		return total;
	}

}
