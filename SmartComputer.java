import java.util.ArrayDeque;

public class SmartComputer extends Player {
	
	/**
	 * 
	 * @param hand
	 */
	public SmartComputer(ArrayDeque<Card> hand){
		this.hand = hand;
	}
	
	/**
	 * 
	 * @param playerName
	 */
	public SmartComputer(String playerName) {
		this.playerName = playerName;
	}
	
	public void takeInput() {
		//Pick the highest attribute
		for(int m = 0; m < hand.peekFirst().attributes.size(); m++ ) {
			
			for(int n = m+1; n < hand.peekFirst().attributes.size(); n++) {
			
				if (hand.peekFirst().attributes.get(m).value > hand.peekFirst().attributes.get(n).value) {
					
					numAttribute = m;
					
				} else {
					
					numAttribute = n;	
				}
			}
		}
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