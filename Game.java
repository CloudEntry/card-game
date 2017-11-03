import java.util.*;

public class Game {
	
	int numCards;
	int numAttributes;
	int numAttribute;
	int numOpponents;
	int numTheme;
	String playerName;
	
	public boolean isHuman;
	public boolean isSmart;
	public boolean isPredictable;
	public boolean isRandom;
	
	public Game(int numPlayers, int numCards, int numTheme, String playerName) {
		
		this.numCards = numCards;
		this.numTheme = numTheme;
		this.playerName = playerName;
		numOpponents = numPlayers-1;
	}
	
	public void run() {
		
		ArrayList<Player> players = generatePlayers(numOpponents);
		ArrayList<Card> fullDeck = generateDeck(numCards, numAttributes);
		
		dealCards(fullDeck, players);
		
		while(true) {
			
			for(int i = 0; i < players.size(); i++) {
				
				System.out.println();
				
				for(int j = 0; j < players.size(); j++) {
					//Player info
					System.out.println(players.get(j).getName() + ": " + players.get(j).hand.size() + "cards");
				}
				
				System.out.println();
				
				System.out.print(players.get(i).getName() + "'s turn: \n");
				
				System.out.println();
				
				players.get(i).hand.peekFirst().print();
				
				System.out.println();
				
		    	players.get(i).selectAttribute();

				System.out.println(players.get(i).getName() + " picked " + players.get(i).hand.peekFirst().attributes.get(numAttribute).name);

				for(int j = 0; j < players.size(); j++) {
					
				    for(int k = j+1; k < players.size(); k++) {
				      // compare list.get(i) and list.get(j)
				    	
				    	System.out.print(players.get(j).getName() + ": ");
						players.get(j).hand.peekFirst().attributes.get(numAttribute).print();
						
						System.out.print(players.get(k).getName() + ": ");
						players.get(k).hand.peekFirst().attributes.get(numAttribute).print();
				    	
				    	//The actual gameplay
						if(players.get(j).hand.peekFirst().attributes.get(numAttribute).value > players.get(k).hand.peekFirst().attributes.get(numAttribute).value) {
							
							System.out.print(players.get(j).getName() + " wins! \n");
							
							//Add player2's card to player 1
							players.get(j).hand.addLast(players.get(k).hand.pop());
							//Send player's own card to back
							players.get(j).hand.addLast(players.get(j).hand.pop());
							
						}else {
							System.out.print(players.get(k).getName() + " wins! \n");
							
							//Add player1's card to player 2
							players.get(k).hand.addLast(players.get(j).hand.pop());
							//Send player's own card to back
							players.get(k).hand.addLast(players.get(k).hand.pop());	
						}  	
				    }		
				}	
			}
			
			if (players.get(0).hand.isEmpty()) {
				
				System.out.println("You lost the game!");
				break;
				
			} else if (players.get(1).hand.isEmpty()){
				
				System.out.println("You won the game!");
				break;
			} 	
		}
	}
		
	public ArrayList<Card> generateDeck(int numCards, int numAttributes) {
		
		ArrayList<Card> fullDeck = new ArrayList<Card>( numCards );
		
		for (int i = 0; i < numCards; i++) {
			
			Card card = new Card("Card " + String.valueOf(i), numAttributes, numTheme);
			
			fullDeck.add(card);
		}
		return fullDeck;
	}
	
	public ArrayList<Player> generatePlayers(int numOpponents) {
		
		ArrayList<Player> players = new ArrayList<Player>(numOpponents);
		
		Human human = new Human(playerName);
		players.add(human);
		
		for (int i = 0; i < numOpponents; i++) {
			//conditional statement: if user selects opponent to be random, predictable or smart ....
			PredictableComputer opponent = new PredictableComputer("CPU" + String.valueOf(i+1));
			players.add(opponent);			
		}
		return players;
	}
	
	//Deal cards to each player
	public void dealCards(ArrayList<Card> fullDeck, ArrayList<Player> players) {
		
		while(fullDeck.isEmpty() == false) {
		
			for(int i = 0; i < players.size(); i++) {
						
				players.get(i).hand.add(fullDeck.remove(0));
			}
		}
	}
}
/** Calls {@link Card#print()	}.	
	* @param args array of Strings from the user.*/
	