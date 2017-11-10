import java.util.ArrayDeque;

public class RandomComputer extends Player {
	
	/**
	 * 
	 * @param hand
	 */
	public RandomComputer(ArrayDeque<Card> hand){
		this.hand = hand;
	}
	 
	/**
	 * 
	 * @param playerName
	 */
	public RandomComputer(String playerName) {
		this.playerName = playerName;
	}
	
	public void takeInput() {
		
		//Pick a random attribute
		numAttribute = (int)Math.floor(Math.random() * hand.peekFirst().attributes.size());
	}
	
	/**
	 * 
	 */
	public String selectAttribute() {
		
		
		
		Card card = hand.getFirst(); //first card
		Attribute a = card.attributes.get(numAttribute);
		return a.getName();	
	}
}