import java.util.ArrayDeque;

public class PredictableComputer extends Player {
	
	public PredictableComputer(ArrayDeque<Card> hand){
		this.hand = hand;
	}  
	
	public PredictableComputer(String playerName) {
		this.playerName = playerName;
	}
	
	public String selectAttribute() {
		Card card = hand.peekFirst(); //first card
		Attribute a = card.attributes.get(0);
		return a.name;
	}
}