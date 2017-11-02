import java.util.*;

public class Player {
	
	//Changed modifier to public for testing purposes
	public boolean isHuman;
	public boolean isSmart;
	public boolean isPredictable;
	public boolean isRandom;
	protected String playerName;
	
	ArrayDeque<Card> hand = new ArrayDeque<Card>();

	public Player (String playerName, int numPlayers, boolean isHuman, boolean isSmart, boolean isPredictable, boolean isRandom) { 
		
		this.playerName = playerName;
		this.isHuman = isHuman;
		this.isSmart = isSmart;
		this.isPredictable = isPredictable;
		this.isRandom = isRandom;
	}
	
	public void print() {
		
		System.out.print(playerName);
	}	
		
	
}	