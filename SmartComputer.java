import java.util.ArrayDeque;

/**
 * SmartComputer.java - smart computer player.
 * @see Player
 * @author Jack Gee
 * @version 1.0
 */
public class SmartComputer extends Player {
	
	/**
	 * Constructor method. 
	 * @param hand
	 */
	public SmartComputer(ArrayDeque<Card> hand){
		this.hand = hand;
	}
	
	/**
	 * Constructor method. 
	 * @param playerName
	 */
	public SmartComputer(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * This player always selects the highest attribute. 
	 */
	public void takeInput() {
		//Pick the highest attribute
		for(int m = 0; m < hand.peekFirst().getAttributes().size(); m++ ) {
			
			for(int n = m+1; n < hand.peekFirst().getAttributes().size(); n++) {
			
				if (hand.peekFirst().getAttributes().get(m).getValue() > hand.peekFirst().getAttributes().get(n).getValue()) {
					
					numAttribute = m;
					
				} else {
					
					numAttribute = n;	
				}
			}
		}
	}
}