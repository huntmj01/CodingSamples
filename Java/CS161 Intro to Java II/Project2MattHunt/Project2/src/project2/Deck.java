package project2;

import java.util.Random;

public class Deck {

	// create an array of 52 cards
	Card[] deck = new Card[52];

	// constructor
	public Deck() {
		createDeck();
	}

	/**
	 * 
	 * createDeck() uses a creative algorithm to create
	 * all 52 cards in a deck 
	 * 
	 */
	public void createDeck() {
		// counters
		int iterationCounter = 0;
		int suitCounter = 0;
		int rankCounter = 0;

		// loop through deck
		for (iterationCounter = 0; iterationCounter < deck.length; iterationCounter++) {

			// variables to hold the current suit and rank
			String suit;
			String rank;

			//
			if (suitCounter == 0) {
				suit = "Cluds";
			} else if (suitCounter == 1) {
				suit = "Diamonds";
			} else if (suitCounter == 2) {
				suit = "Hearts";
			} else {
				suit = "Spades";
				suitCounter = -1;
			}

			//
			suitCounter++;

			//
			if (rankCounter == 0) {
				rank = "Ace";
			} else if (rankCounter == 1) {
				rank = "2";
			} else if (rankCounter == 2) {
				rank = "3";
			} else if (rankCounter == 3) {
				rank = "4";
			} else if (rankCounter == 4) {
				rank = "5";
			} else if (rankCounter == 5) {
				rank = "6";
			} else if (rankCounter == 6) {
				rank = "7";
			} else if (rankCounter == 7) {
				rank = "8";
			} else if (rankCounter == 8) {
				rank = "9";
			} else if (rankCounter == 9) {
				rank = "10";
			} else if (rankCounter == 10) {
				rank = "Jack";
			} else if (rankCounter == 11) {
				rank = "Queen";
			} else {
				rank = "King";
				rankCounter = -1;
			}

			//
			rankCounter++;

			// add the new card to the deck
			deck[iterationCounter] = new Card(suit, rank);
		}
	}

	/**
	 * 
	 * shuffle() shuffles the deck by looping through 
	 * the deck 100 times and randomly switching 
	 * 2 cards places
	 * 
	 */

	public  void shuffle() {

		// loop 100 times
		for (int i = 0; i < 100; i++) {

			// create a random object
			Random rand = new Random();

			// create to random ints both between 0 and 51
			int rand1 = rand.nextInt(52);
			int rand2 = rand.nextInt(52);

			// create a temporary card to hold rand1
			Card temp = new Card(deck[rand1].getSuit(), deck[rand1].getRank());

			// replace card at random 1 to card at random 2
			deck[rand1] = deck[rand2];

			// replace card at random 2 with card at random 1
			deck[rand2] = temp;

		}

	}

	/**
	 * 
	 * dealCard() loops through the deck until it
	 * finds a card that is in the deck and returns
	 * that card.  If the deck is empty it creates a 
	 * new deck, shuffles the new deck, and then 
	 * returns the top card.
	 * 
	 * @return Card, the next card on top of the deck
	 * 
	 */
	public Card dealCard() {

		// loop through cards in deck
		for (Card c : deck) {
			// find a card that is in the deck
			if (c.isInDeck()) {
				c.setInDeck(false);
				return c;
			}
		}

		// create a new deck if all cards have been played
		deck = new Card[52];
		// call the constructor
		createDeck();
		// shuffle the new deck
		shuffle();
		// return the top card of the new deck
		deck[0].setInDeck(false);
		return deck[0];
		
	}

}
