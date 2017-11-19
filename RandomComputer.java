import java.util.ArrayDeque;

/**
 * RandomComputer.java - random computer player.
 * @see Player
 * @author Jack Gee
 * @version 1.0
 */
public class RandomComputer extends Player {
	
	/**
	 * Constructor method. 
	 * @param hand
	 */
	public RandomComputer(ArrayDeque<Card> hand){
		this.hand = hand;
	}
	 
	/**
	 * Constructor method. 
	 * @param playerName
	 */
	public RandomComputer(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * This player always selects a random attribute. 
	 */
	public void takeInput() {
		
		//Pick a random attribute from 0 to the maximum attribute. 
		numAttribute = (int)Math.floor(Math.random() * hand.peekFirst().getAttributes().size());
	}
}