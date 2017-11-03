import java.util.ArrayDeque;

public class SmartComputer extends Player {
	
	public SmartComputer(ArrayDeque<Card> hand){
		this.hand = hand;
	}
	
	public SmartComputer(String playerName) {
		this.playerName = playerName;
	}
	
	public String selectAttribute() {
		
		int numAttribute = 0;
		
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
		
		Card card = hand.peekFirst(); //first card
		Attribute a = card.attributes.get(numAttribute);
		return a.name;	
	}
}