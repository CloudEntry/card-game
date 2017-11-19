import java.util.*;

/**
 * Main.java - Main class. 
 * @author Jack Gee
 * @version 1.0
 */
public class Main {

	/**
	 * The number of players. 
	 */
	static int numPlayers;
	
	/**
	 * The number of cards in the deck. 
	 */
	static int numCards;
	
	/**
	 * The number associated with the theme. 
	 */
	static int numTheme;
	
	/**
	 * Main method - loops through taking user input for setting up game and playing game until user types "n". 
	 * Calls {@link Main#selectNumPlayers()} {@link Main#selectNumCards()} {@link Main#selectTheme()} {@link Game#run()}
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Variable to store user input for whether to play again. 
		String playAgain = "";
		Scanner s = new Scanner(System.in);
		
		do {
		selectNumPlayers();
		selectNumCards();
		selectTheme();
		
		Game game = new Game(numPlayers, numCards, numTheme);
		game.run();
		
		System.out.println("Play new game? (Y,n)");
		
		playAgain = s.nextLine();
		
		} while(playAgain.equalsIgnoreCase("Y"));
			
		System.out.println("Thanks for playing - see you again soon!");
		
		System.exit(0); //success
	}
	
	/**
	 * Takes uses input for number of players. 
	 */
	public static void selectNumPlayers() {
		System.out.println("Please select number of players: ");
		while(true){
			Scanner s = new Scanner( System.in );	
			if(s.hasNextInt()) numPlayers = Integer.parseInt(s.next());
			if(numPlayers > 1) break;
			System.out.println("Please input a valid number (>1):");
		}
	}
	
	/**
	 * Takes uses input for number of cards. 
	 */
	public static void selectNumCards() {
		System.out.println("Please select number of cards: ");
		while(true) {
			Scanner s = new Scanner( System.in );
			if(s.hasNextInt()) numCards = Integer.parseInt(s.next());
			if(numCards % numPlayers == 0 && numCards > 0) break;
			System.out.println("Please input a valid number (multiple of " + numPlayers + "):");
		}
	}
	
	/**
	 * Takes input for number to select theme. 
	 */
	public static void selectTheme() {
		System.out.println("Please select theme (type number):");
		System.out.println("1 - Warriors");
		System.out.println("2 - Cars");
		System.out.println("3 - Game of Thrones");
		System.out.println("4 - Dinosaurs");
		while(true) {
			Scanner s = new Scanner(System.in);
			if(s.hasNextInt()) numTheme = Integer.parseInt(s.next());
			if(numTheme > 0 && numTheme < 5) break;
			System.out.println("Please input a valid number (one of the options):");
		}
	}
}