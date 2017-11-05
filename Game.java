import java.util.*;

public class Game {
	
	int numCards;
	int numAttributes;
	int numAttribute;
	int numPlayers;
	int numTheme;
	String playerName;
	
	public Game(int numPlayers, int numCards, int numTheme) {
		
		this.numCards = numCards;
		this.numTheme = numTheme;
		this.numPlayers = numPlayers;
	}
	
	public void run() {
		
		ArrayList<Player> players = generatePlayers(numPlayers);
		ArrayList<Card> fullDeck = generateDeck(numCards, numAttributes);
		
		dealCards(fullDeck, players);
		
		while(true) {
			
			for(int i = 0; i < players.size(); i++) {
				
				for(int j = 0; j < players.size(); j++) {
					//Player info
					System.out.println(players.get(j).playerName + ": " + players.get(j).hand.size() + " cards");
					
					if(players.get(j).hand.size() == 0) players.remove(j);
				}
				System.out.print("\n" + players.get(i).getName() + "'s turn: \n");
				
				System.out.println("__________________");
				
				players.get(i).hand.peekFirst().print();
				
				System.out.println("__________________");
				
				players.get(i).takeInput();
				
				System.out.println(players.get(i).getName() + " picked " + players.get(i).selectAttribute());
				
				for(int n = 0; n < players.get(i).hand.peekFirst().attributes.size(); n++) {
					
					if(players.get(i).hand.peekFirst().attributes.get(n).name == players.get(i).selectAttribute()) 
						numAttribute = n;
				}

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
			if(players.size() == 1) {
				System.out.println(players.get(0).getName() + " won the game!");
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
		
		int numType;
		
		System.out.println("1 - Human");
		System.out.println("2 - Predictable Computer");
		System.out.println("3 - Random Computer");
		System.out.println("4 - Smart Computer");
		
		for (int i = 0; i < numOpponents; i++) {
			
			System.out.println("Select type for player " + String.valueOf(i + 1));
			while(true) {
				Scanner s = new Scanner( System.in );
				numType = Integer.parseInt(s.next());
				if(numType > 0 && numType < 5) break;
			}
			if(numType == 1){
				System.out.println("Enter your name: ");
				Scanner s1 = new Scanner( System.in );
				String playerName = s1.next();
				Human human1 = new Human(playerName);
				players.add(human1);
			} else if(numType == 2) {
				PredictableComputer predictable = new PredictableComputer("CPU" + String.valueOf(i+1));
				players.add(predictable);
			} else if(numType == 3) {
				RandomComputer random = new RandomComputer("CPU" + String.valueOf(i+1));
				players.add(random);
			} else if(numType == 4) {
				SmartComputer opponent = new SmartComputer("CPU" + String.valueOf(i+1));
				players.add(opponent);			
			}
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
	