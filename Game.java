import java.util.*;

/**
 * Game.java - called in {@link Main#main()} where the main game play takes place after the options have been selected by the user. 
 * @author Jack Gee
 * @version 1.0
 */
public class Game {
	
	/**
	 * The number of cards. 
	 */
	int numCards;
	
	/**
	 * The number to represent selected attribute. 
	 */
	int numAttribute;
	
	/**
	 * The number of players. 
	 */
	int numPlayers;
	
	/**
	 * The number to represent the theme. 
	 */
	int numTheme;
	
	/**
	 * The name of the player. 
	 */
	String playerName;
	
	/**
	 * An arraylist of players. 
	 */
	ArrayList<Player> players;
	
	/**
	 * An arraylist of cards to represent the deck. 
	 */
	ArrayList<Card> fullDeck;
	
	/**
	 * Constructor method for the game class. 
	 * @param numPlayers
	 * @param numCards
	 * @param numTheme
	 */
	public Game(int numPlayers, int numCards, int numTheme) {
		
		this.numCards = numCards;
		this.numTheme = numTheme;
		this.numPlayers = numPlayers;
	}
	
	/**
	 * Runs the game loop. 
	 * Calls {@link Game#generatePlayers()} {@link Game#generateDeck()} {@link Game#dealCards()} {@link Game#gamePlay()} 
	 */
	public void run() {
		
		// Generate arraylist of players. 
		players = generatePlayers(numPlayers);
		
		// Generate arraylist of cards. 
		fullDeck = generateDeck(numCards);
		
		// Split deck into each players hand - queue of cards. 
		dealCards();
		
		// While loop which breaks out of gameplay when only one player in the game. 
		while(true) {
			
			// Execute the game loop. 
			gamePlay();
			
			// Break out when there is only one player left. 
			if(players.size() == 1) break;
		}
		
		// Prints game winner
		System.out.println(players.get(0).getName() + " won the game!");	
	}
	
	/**
	 * The sequence of steps in each players' turn. 
	 * Calls {@link Game#cardCount()} {@link Game#printCard()} {@link Player#takeInput()} {@link Game#printAttributes()} {@link Game#findWinner()} {@link Game#removePlayers()}
	 */
	public void gamePlay() {
		
		for(int i = 0; i < players.size(); i++) {
			
			// Print number of cards for each player. 
			cardCount();
			
			// Print current player's card. 
			printCard(i);
			
			// Take input from player if human player or AI if computer player. 
			players.get(i).takeInput();
			
			// Print which attribute the player picked. 
			System.out.println(players.get(i).getName() + " picked " + players.get(i).selectAttribute());
			
			// Print the attribute value picked for each player. 
			printAttributes(i);
			
			// Find the winning player. 
			findWinner(i);
			
			// Remove any players that have 0 cards in hand. 
			removePlayers();
		}
	}
	
	/**
	 * Implemented ListIterator to remove players when they have 0 cards in their hand and print when they have ran out of cards. 
	 */
	public void removePlayers() {
		
		for(ListIterator<Player> it = players.listIterator(); it.hasNext();) {
			//Remove player from arraylist when they have no cards. 
			if(it.next().hand.size() == 0) { 
				System.out.println(it.previous().getName() + " is out of cards!");
				it.remove();
			}
		}
	}
	
	/**
	 * Prints the attribute value for each player. 
	 * @param i
	 */
	public void printAttributes(int i) {
		
		//Print value of the chosen attribute for each player. 
		for(int j = 0; j < players.size(); j++) {
			System.out.print(players.get(j).getName() + "'s ");
			players.get(j).hand.peekFirst().getAttributes().get(getNumAttribute(i)).print();
		}
	}
	
	/**
	 * Finds the winning player and adds losing players' cards to the back of winner's hand. 
	 * @param i
	 */
	public void findWinner(int i) {
		
		String winner = "";
		int winningPlayer = i;
		
		//Add losing players' cards to winners hand. 
		for(int j = 0; j < players.size(); j++) {
		    	
			if(players.get(j).hand.peekFirst().getAttributes().get(numAttribute).getValue() > players.get(winningPlayer).hand.peekFirst().getAttributes().get(numAttribute).getValue()) {
				
				winningPlayer = j;	
			}
						
			winner = players.get(winningPlayer).getName();
		}	
		
		for(int j = 0; j < players.size(); j++) {
			
			// Add loser's card to winner's hand. 
			players.get(winningPlayer).hand.addLast(players.get(j).hand.pop());
			
			// Winner moves their top card to back of their hand. 
			players.get(winningPlayer).hand.addLast(players.get(winningPlayer).hand.pop());
		}
		
		//Print winner
		System.out.println(winner + " wins!");
	}
	
	/**
	 * Print number of cards in each player hand. 
	 */
	public void cardCount() {
		
		for(int j = 0; j < players.size(); j++) {
			//Player info
			System.out.println(players.get(j).getName() + ": " + players.get(j).hand.size() + " cards");	
		}
	}
	
	/**
	 * Print current player's top card. 
	 * @param i
	 */
	public void printCard(int i) {

			
		System.out.print("\n" + players.get(i).getName() + "'s turn: \n");
		
		System.out.println("__________________");
		
		players.get(i).hand.peekFirst().print();
		
		System.out.println("__________________");
			
		}
	
	/**
	 * Returns the index number of the attribute the player has selected. 
	 * @param i
	 * @return numAttribute
	 */
	public int getNumAttribute(int i) {
		
		for(int n = 0; n < players.get(i).hand.peekFirst().getAttributes().size(); n++) {
			
			if(players.get(i).hand.peekFirst().getAttributes().get(n).getName() == players.get(i).selectAttribute()) 
				numAttribute = n;
		}
		return numAttribute;
	}
	
	/**
	 * Generates a deck of cards. 
	 * @param numCards
	 * @return fullDeck
	 */
	public ArrayList<Card> generateDeck(int numCards) {
		
		ArrayList<Card> fullDeck = new ArrayList<Card>( numCards );
		
		for (int i = 0; i < numCards; i++) {
			
			Card card = new Card("Card " + String.valueOf(i), numTheme);
			
			fullDeck.add(card);
		}
		return fullDeck;
	}
	
	/**
	 * Generates the arraylist of players. 
	 * @param numOpponents
	 * @return players
	 */
	public ArrayList<Player> generatePlayers(int numOpponents) {
		
		ArrayList<Player> players = new ArrayList<Player>(numOpponents);
		
		
		System.out.println("1 - Human");
		System.out.println("2 - Predictable Computer");
		System.out.println("3 - Random Computer");
		System.out.println("4 - Smart Computer");
		
		for (int i = 0; i < numOpponents; i++) {
			
			System.out.println("Select type for player " + String.valueOf(i + 1));
			int numType = 0;
			while(true) {
				Scanner s = new Scanner( System.in );
				if(s.hasNextInt()) numType = Integer.parseInt(s.next());
				if(numType > 0 && numType < 5) break;
				System.out.println("Please input a valid number (one of the options):");
			}
			// If players is human enter name for that player. 
			if(numType == 1){
				System.out.println("Enter your name: ");
				Scanner s = new Scanner( System.in );
				String playerName = s.next();
				Human human = new Human(playerName);
				players.add(human);
			// If plyer is CPU name is "CPU + number" to distinguish them. 
			} else if(numType == 2) {
				PredictableComputer predictable = new PredictableComputer("CPU" + String.valueOf(i+1) + " (Predictable)");
				players.add(predictable);
			} else if(numType == 3) {
				RandomComputer random = new RandomComputer("CPU" + String.valueOf(i+1) + " (Random)");
				players.add(random);
			} else if(numType == 4) {
				SmartComputer opponent = new SmartComputer("CPU" + String.valueOf(i+1) + " (Smart)");
				players.add(opponent);			
			}
		}
		return players;
	}
	
	/**
	 * Deals the cards out to each player. 
	 */
	public void dealCards() {
		
		while(fullDeck.isEmpty() == false) {
		
			for(int i = 0; i < players.size(); i++) {
						
				players.get(i).hand.add(fullDeck.remove(0));
			}
		}
	}
}	