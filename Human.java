import java.util.ArrayDeque;
import java.util.Scanner;

public class Human extends Player {
	
	public Human(ArrayDeque<Card> hand){
		this.hand = hand;
	}
	
	public Human(String playerName) {
		this.playerName = playerName;
	}
	
	public String selectAttribute() {
		
		//Selecting Attribute
		System.out.println("Choose an attribute:");
		
		@SuppressWarnings("resource")
		Scanner AttributeInput = new Scanner(System.in);
		int numAttribute = Integer.parseInt(AttributeInput.next());
		
		Card card = hand.peekFirst(); //first card
		Attribute a = card.attributes.get(numAttribute);
		return a.name;
	}
}