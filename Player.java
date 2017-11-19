import java.util.ArrayDeque;;

/**
 * Player.java - abstract class that different kinds of players extends from - 
 * Easy to add your own different kinds of players who select different attrbutes based on different rules. 
 * @author Jack Gee
 * @version 1.0
 */
public abstract class Player {
	
	/**
	 * The name of the player. 
	 */
	protected String playerName;
	
	/**
	 * The number assigned to the attribute. 
	 */
	protected int numAttribute;
	
	/**
	 * The player's hand of cards. 
	 */
	protected ArrayDeque<Card> hand = new ArrayDeque<Card>();
	
	/**
	 * Gets the player's hand of cards. 
	 * @return ArrayDeque hand
	 */
	public ArrayDeque<Card> getHand() {
		return hand;
	}
	
	/**
	 * Setter method for name. 
	 * @param playerName
	 */
	public void setName(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * Get player name. 
	 * @return String playerName
	 */
	public String getName() {
		return playerName;
	}

	/**
	 * Abstract method returns different input depending on type of player. 
	 */
	public abstract void takeInput();
	
	/**
	 * Selects the attribute that the player input. 
	 * @return String a.getName()
	 */
	public String selectAttribute() {
		
		Card card = hand.peekFirst(); //first card. 
		Attribute a = card.getAttributes().get(numAttribute);
		return a.getName();
	}
	
}	