import java.util.ArrayDeque;

public class RandomComputer extends Player {
	
	public RandomComputer(ArrayDeque<Card> hand){
		this.hand = hand;
	}
	
	public RandomComputer(String playerName) {
		this.playerName = playerName;
	}
	
	public String selectAttribute() {
		
		//Pick a random attribute
		int numAttribute = (int)(Math.random() *  hand.peekFirst().attributes.size());
		
		Card card = hand.getFirst(); //first card
		Attribute a = card.attributes.get(numAttribute);
		return a.name;	
	}
}