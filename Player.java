import java.util.ArrayDeque;;

public abstract class Player {
	
	protected String playerName;
	
	protected ArrayDeque<Card> hand = new ArrayDeque<Card>();
	
	public ArrayDeque<Card> getHand() {
		return hand;
	}
	
	public void setName(String playerName) {
		this.playerName = playerName;
	}
	
	public String getName() {
		return playerName;
	}
	
	public abstract String selectAttribute();
}	