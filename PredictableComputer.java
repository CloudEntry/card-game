import java.util.ArrayDeque;

public class PredictableComputer extends Player {
	
	/**
	 * 
	 * @param hand
	 */
	public PredictableComputer(ArrayDeque<Card> hand){
		this.hand = hand;
	}  
	
	/**
	 * 
	 * @param playerName
	 */
	public PredictableComputer(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * 
	 */
	public void takeInput() {
		numAttribute = 0;
	}
	
	/**
	 * 
	 */
	public String selectAttribute() {
		Card card = hand.peekFirst(); //first card
		Attribute a = card.attributes.get(numAttribute);
		return a.getName();
	}
}