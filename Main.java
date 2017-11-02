import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Enter your name: ");
		@SuppressWarnings("resource")
		Scanner nameInput = new Scanner( System.in );
		String playerName = nameInput.next( );
		
		
		System.out.println("Hi "+playerName+", please select number of cards: ");
		@SuppressWarnings("resource")
		Scanner numCardsInput = new Scanner( System.in );
		int numCards = Integer.parseInt(numCardsInput.next());
		
		
		System.out.println("Hi "+playerName+", please select number of attributes: ");
		@SuppressWarnings("resource")
		Scanner numAttributesInput = new Scanner( System.in );
		int numAttributes = Integer.parseInt(numAttributesInput.next());
		
		
		/*System.out.println("Please select theme from: ");
		System.out.println("1 - Warriors");
		System.out.println("2 - Cars");
		System.out.println("3 - Game of Thrones");
		System.out.println("4 - Dinosaurs");
		Scanner numThemeInput = new Scanner(System.in);
		int numTheme = Integer.parseInt(numThemeInput.next());*/
		
		
		
					
		
		Game game = new Game(numCards, numAttributes, playerName);
		game.run();
		
		System.exit( 0 ); //success
		
	}
}