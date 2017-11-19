import java.util.ArrayDeque;

/**
 * PredictableComputer.java - predictable computer player.
 * @see Player
 * @author Jack Gee
 * @version 1.0
 */
public class PredictableComputer extends Player {
	
	/**
	 * Constructor method. 
	 * @param hand
	 */
	public PredictableComputer(ArrayDeque<Card> hand){
		this.hand = hand;
	}  
	
	/**
	 * Constructor method. 
	 * @param playerName
	 */
	public PredictableComputer(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * This player always selects the first attribute. 
	 */
	public void takeInput() {
		numAttribute = 0;
	}
}