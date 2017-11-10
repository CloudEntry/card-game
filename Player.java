import java.util.ArrayDeque;;

public abstract class Player {
	
	
	protected String playerName;
	
	protected int numAttribute;
	
	protected ArrayDeque<Card> hand = new ArrayDeque<Card>();
	

	/**
	 * 
	 * @return
	 */
	public ArrayDeque<Card> getHand() {
		return hand;
	}
	
	/**
	 * 
	 * @param playerName
	 */
	public void setName(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return playerName;
	}

	/**
	 * 
	 */
	public abstract void takeInput();
	
	/**
	 * 
	 * @return
	 */
	public abstract String selectAttribute();
}	