import java.util.ArrayDeque;
import java.util.Scanner;

public class Human extends Player {
	
	/**
	 * 
	 * @param hand
	 */
	public Human(ArrayDeque<Card> hand){
		this.hand = hand;
	}
	
	/**
	 * 
	 * @param playerName
	 */
	public Human(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * 
	 */
	public void takeInput() {
		//Selecting Attribute
		System.out.println("Choose an attribute (type number):");
		
		while(true) {
			Scanner s = new Scanner(System.in);
			numAttribute = Integer.parseInt(s.next()) - 1;
			if(numAttribute > -1 && numAttribute < hand.peekFirst().attributes.size()) break;
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