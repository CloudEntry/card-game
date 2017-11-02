import java.util.*;

public class Game {
	
	int numCards;
	int numAttributes;
	int numAttribute;
	int numOpponents = 1;
	int numTheme;
	String playerName;
	
	public boolean isHuman;
	public boolean isSmart;
	public boolean isPredictable;
	public boolean isRandom;
	
	public Game(int numCards, int numAttributes, String playerName) {
		
		this.numCards = numCards;
		this.numAttributes = numAttributes;
		this.playerName = playerName;
	}
	

	public void run() {
		
		ArrayList<Card> fullDeck = generateDeck( numCards, numAttributes );
		ArrayList<Player> players = generatePlayers(numOpponents);
		

		dealCards(fullDeck, players, numOpponents);
		
		
		while(players.get(0).hand.isEmpty() == false || players.get(1).hand.isEmpty() == false) {
			
			
			for(int i = 0; i < players.size(); i++) {
				

				System.out.println();
				
				for(int j = 0; j < players.size(); j++) {
					//Player info
					players.get(j).print();
					System.out.print(": " + players.get(j).hand.size() +"\n");
				}
				
				System.out.println();
				
				players.get(i).print();
				System.out.print("'s turn: \n");
				
				System.out.println("First Card: ");
				
				players.get(i).hand.peekFirst().print();
				
				//Different numAttribute depending on type of player
				
				if (players.get(i).isHuman == true) {
					//Selecting Attribute
					System.out.println("Choose an attribute:");
					
					@SuppressWarnings("resource")
					Scanner numAttributeInput = new Scanner( System.in );
					numAttribute = Integer.parseInt(numAttributeInput.next());
					
					
					
				}
				else if (players.get(i).isPredictable == true) {
					//Pick the first attribute
					numAttribute = 0;
					
				}
					
				else if (players.get(i).isRandom == true) {
					//Pick a random attribute
					numAttribute = (int) ( Math.random() *  players.get(i).hand.peekFirst().attributes.size());
					
				}
					
				
				else if (players.get(i).isSmart == true) {
					//Pick the highest attribute
					for(int m = 0; m < players.get(i).hand.peekFirst().attributes.size(); m++ ) {
						
						for(int n = i+1; n < players.size(); n++) {
						
							if (players.get(m).hand.peekFirst().attributes.get(m).value > players.get(n).hand.peekFirst().attributes.get(n).value) {
								
								numAttribute = m;
								
							} else {
								
								numAttribute = n;
								
							}
						
						}
						
					}
				}	

				
				


				for(int j = 0; j < players.size(); j++) {
					
					
				    for(int k = j+1; k < players.size(); k++) {
				      // compare list.get(i) and list.get(j)
				    	
				    	
				    	//The actual gameplay
						if(players.get(j).hand.peekFirst().attributes.get(numAttribute).value > players.get(k).hand.peekFirst().attributes.get(numAttribute).value) {
							
							players.get(j).print();
							System.out.print(" ");
							players.get(j).hand.peekFirst().attributes.get(numAttribute).print();
							
							players.get(k).print();
							System.out.print(" ");
							players.get(k).hand.peekFirst().attributes.get(numAttribute).print();
							
							players.get(j).print();
							System.out.print(" wins! \n");
							
							//Add player2's card to player 1
							players.get(j).hand.addLast(players.get(k).hand.pop());
							//Send player's own card to back
							players.get(j).hand.addLast(players.get(j).hand.pop());
							
						}else {
							
							players.get(k).print();
							System.out.print(" ");
							players.get(k).hand.peekFirst().attributes.get(numAttribute).print();
							
							players.get(j).print();
							System.out.print(" ");
							players.get(j).hand.peekFirst().attributes.get(numAttribute).print();
							
							players.get(k).print();
							System.out.print(" wins! \n");
							
							//Add player1's card to player 2
							players.get(k).hand.addLast(players.get(j).hand.pop());
							//Send player's own card to back
							players.get(k).hand.addLast(players.get(k).hand.pop());	
						}
				    	
				    }		
				}
					
			}
			
		}
		
		if (players.get(0).hand.isEmpty()) {
			
			System.out.println("You lost the game!");
			
		} else {
			
			System.out.println("You won the game!");
			
		} 
	}
		
	
	public ArrayList<Card> generateDeck(int numCards, int numAttributes) {
		
		ArrayList<Card> fullDeck = new ArrayList<Card>( numCards );
		for ( int i =0; i<numCards; i++ ) {
			Card card = new Card( "Card " + String.valueOf( i ), numAttributes );
			fullDeck.add( card );
			//card.print();
		}
		return fullDeck;
	}
	
	public ArrayList<Player> generatePlayers(int numOpponents) {
		
		ArrayList<Player> players = new ArrayList<Player>(numOpponents);
		
		Human human = new Human(playerName, numOpponents, isHuman, isSmart, isPredictable, isRandom);
		players.add(human);
		
	
		for (int i = 0; i<numOpponents; i++) {
			//conditional statement: if user selects opponent to be random, predictable or smart ....
			PredictableComputer opponent = new PredictableComputer("Predictable CPU " + String.valueOf(i + 1), numOpponents, isHuman, isSmart, isPredictable, isRandom);
			players.add(opponent);
			
			
			//player.print();
			
			
		}
		return players;
	}
	
	//Deal cards to each player
	public void dealCards(ArrayList<Card> fullDeck, ArrayList<Player> players, int numOpponents) {
		
	
		while(fullDeck.isEmpty() == false) {
		
			for(int j = 0; j < players.size(); j++) {
						
					players.get(j).hand.add(fullDeck.remove(0));
						
			}
			
		}	
	}
	

}

/** Calls {@link Card#print()	}.	
	* @param args array of Strings from the user.*/
	