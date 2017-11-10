import java.util.*;

public class Game {
	
	int numCards, numAttributes, numAttribute, numPlayers,numTheme;
	String playerName;
	boolean gameFinished = false;
	ArrayList<Player> players;
	ArrayList<Card> fullDeck;
	
	/**
	 * 
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
	 * 
	 */
	public void run() {
		
		players = generatePlayers(numPlayers);
		fullDeck = generateDeck(numCards, numAttributes);
		
		dealCards();
		
		while(gameFinished == false) {
			
			gamePlay();
			
			checkWinner();
			
		}
		
		System.out.println(players.get(0).getName() + " won the game!");
	}
	
	public void checkWinner() {
		
		if(players.size() == 1) gameFinished = true;
	}
	
	/**
	 * 
	 * @param players
	 */
	public void gamePlay() {
		
		for(int i = 0; i < players.size(); i++) {
			
			cardCount();
			
			printCard(i);
			
			players.get(i).takeInput();
			
			System.out.println(players.get(i).getName() + " picked " + players.get(i).selectAttribute());
			
			printAttributes(i);
			
			findWinner(i);
			
			moveCardToBack();
			
			removePlayers();
			
		}
		
	}
	
	public void removePlayers() {
		
		for(int i = 0; i < players.size(); i++) {
			//Remove player from arraylist when they have no cards
			if(players.get(i).hand.size() < 1) players.remove(i);
		}
	}
	
	/**
	 * 
	 * @param players
	 * @param i
	 */
	public void printAttributes(int i) {
		
		//Print value of the chosen attribute for each player
		for(int j = 0; j < players.size(); j++) {
			System.out.print(players.get(j).playerName + "'s ");
			players.get(j).hand.peekFirst().attributes.get(getNumAttribute(i)).print();
		}
	}
	
	/**
	 *
	 * @param players
	 * @param i
	 */
	public void findWinner(int i) {
		
		String winner = "";
		int winningPlayer = i;
		
		//Add losing players' cards to winners hand
		for(int j = 0; j < players.size(); j++) {
		    	
			if(players.get(j).hand.peekFirst().attributes.get(numAttribute).value > players.get(winningPlayer).hand.peekFirst().attributes.get(numAttribute).value) {
				
				winningPlayer = j;	
			}
						
			winner = players.get(winningPlayer).getName();
			
		}	
		
		for(int j = 0; j < players.size(); j++) {
			
			players.get(winningPlayer).hand.addLast(players.get(j).hand.pop());
		}
		
		System.out.println(winner + " wins!");
	}
		
	/**
	 * 
	 * @param players
	 */
	public void moveCardToBack() {
		//Everyone move first card to back of hand
		for(int j = 0; j < players.size() - 1; j++) {
			
			players.get(j).hand.addLast(players.get(j).hand.pop());
		}
		
		
	}
	
	/**
	 * 
	 * @param players
	 */
	public void cardCount() {
		
		for(int j = 0; j < players.size(); j++) {
			//Player info
			System.out.println(players.get(j).playerName + ": " + players.get(j).hand.size() + " cards");	
		}
		
	}
	
	/**
	 * 
	 * @param players
	 * @param i
	 */
	public void printCard(int i) {

			
		System.out.print("\n" + players.get(i).getName() + "'s turn: \n");
		
		System.out.println("__________________");
		
		players.get(i).hand.peekFirst().print();
		
		System.out.println("__________________");
			
		}
	
	/**
	 * 
	 * @param players
	 * @param i
	 * @return
	 */
	public int getNumAttribute(int i) {
		
		for(int n = 0; n < players.get(i).hand.peekFirst().attributes.size(); n++) {
			
			if(players.get(i).hand.peekFirst().attributes.get(n).getName() == players.get(i).selectAttribute()) 
				numAttribute = n;
		}
		return numAttribute;
	}
	
	/**
	 * Generates a deck of cards
	 * @param numCards
	 * @param numAttributes
	 * @return fullDeck
	 */
	public ArrayList<Card> generateDeck(int numCards, int numAttributes) {
		
		ArrayList<Card> fullDeck = new ArrayList<Card>( numCards );
		
		for (int i = 0; i < numCards; i++) {
			
			Card card = new Card("Card " + String.valueOf(i), numAttributes, numTheme);
			
			fullDeck.add(card);
		}
		return fullDeck;
	}
	
	/**
	 * 
	 * @param numOpponents
	 * @return
	 */
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
	
	/**
	 * 
	 * @param fullDeck
	 * @param players
	 */
	public void dealCards() {
		
		while(fullDeck.isEmpty() == false) {
		
			for(int i = 0; i < players.size(); i++) {
						
				players.get(i).hand.add(fullDeck.remove(0));
			}
		}
	}
}	