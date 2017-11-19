import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Human.java - human player.
 * @see Player
 * @author Jack Gee
 * @version 1.0
 */
public class Human extends Player {
	
	/**
	 * Constructor method. 
	 * @param hand
	 */
	public Human(ArrayDeque<Card> hand){
		this.hand = hand;
	}
	
	/**
	 * Constructor method. 
	 * @param playerName
	 */
	public Human(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * Input is selected by the user from the console. 
	 */
	public void takeInput() {
		//Selecting Attribute
		System.out.println("Choose an attribute (type number):");
		
		while(true) {
			Scanner s = new Scanner(System.in);
			if(s.hasNextInt()) numAttribute = Integer.parseInt(s.next()) - 1;
			if(numAttribute > -1 && numAttribute < hand.peekFirst().getAttributes().size()) break;
			System.out.println("Please input a valid number (one of the options):");
		}	
	}
}