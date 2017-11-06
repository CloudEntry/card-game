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
		
		do{
			for(int i = 0; i < players.size(); i++) {
				
				cardCount(players);
				
				printCard(players, i);
				
				players.get(i).takeInput();
				
				System.out.println(players.get(i).getName() + " picked " + players.get(i).selectAttribute());				
				
				gamePlay(players, i);
			}
			
		}while(players.size() > 1);
		
		System.out.println(players.get(0).getName() + " won the game!");
	}
	
	public void cardCount(ArrayList<Player> players) {
		
		for(int j = 0; j < players.size(); j++) {
			//Player info
			System.out.println(players.get(j).playerName + ": " + players.get(j).hand.size() + " cards");	
		}
		
	}
	
	public void printCard(ArrayList<Player> players, int i) {

			
		System.out.print("\n" + players.get(i).getName() + "'s turn: \n");
		
		System.out.println("__________________");
		
		players.get(i).hand.peekFirst().print();
		
		System.out.println("__________________");
			
		}
	
	public int getNumAttribute(ArrayList<Player> players, int i) {
		
		for(int n = 0; n < players.get(i).hand.peekFirst().attributes.size(); n++) {
			
			if(players.get(i).hand.peekFirst().attributes.get(n).name == players.get(i).selectAttribute()) 
				numAttribute = n;
		}
		return numAttribute;
	}
	
	public void gamePlay(ArrayList<Player> players, int i) {
		
		String winner = "";
		
		//Print value of the chosen attribute for each player
		for(int j = 0; j < players.size(); j++) {
			System.out.print(players.get(j).playerName + "'s ");
			players.get(j).hand.peekFirst().attributes.get(getNumAttribute(players, i)).print();
		}
		
		//string value for printing winner
		winner = sortPlayers(players, i).get(players.size() - 1).getName();
		
		//Add losing players' cards to winners hand
		for(int j = 0; j < players.size() - 1; j++) {
			sortPlayers(players, i).get(players.size()-1).hand.addLast(sortPlayers(players, i).get(j).hand.pop());
		}
		
		//Everyone move first card to back of hand
		for(int j = 0; j < players.size(); j++) {
			sortPlayers(players, i).get(j).hand.addLast(sortPlayers(players, i).get(j).hand.pop());
		}
		
		//Print winner
		System.out.println(winner + " wins!");
		
		//Remove player from arraylist when they have no cards
		if(players.get(i).hand.size() < 1) players.remove(i);
	}
	public ArrayList<Player> sortPlayers(ArrayList<Player> players, int i){
		
		ArrayList<Player> sortedPlayers = players;
		//Order the list of players from player with lowest chosen attribute value to highest so winner is at the top
		Collections.sort(sortedPlayers, new Comparator<Player>() {
			@Override
			public int compare(Player player1, Player player2) {
				return Integer.compare(player1.hand.peekFirst().attributes.get(getNumAttribute(players, i)).value, player2.hand.peekFirst().attributes.get(getNumAttribute(players, i)).value);
			}
		});
		
		return sortedPlayers;
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
	