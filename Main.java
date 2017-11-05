import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		int numPlayers;
		int numCards;
		int numTheme;
		
		
		
		
		System.out.println("Please select number of players: ");
		while(true){
			Scanner s2 = new Scanner( System.in );			
			numPlayers = Integer.parseInt(s2.next());
			if(numPlayers > 1) break;
		}
		
		
		System.out.println("Please select number of cards: ");
		while(true) {
			Scanner s3 = new Scanner( System.in );
			numCards = Integer.parseInt(s3.next());
			if(numCards % numPlayers == 0) break;
		}
		
		
		System.out.println("Please select theme (type number):");
		System.out.println("1 - Warriors");
		System.out.println("2 - Cars");
		System.out.println("3 - Game of Thrones");
		System.out.println("4 - Dinosaurs");
		while(true) {
			Scanner s4 = new Scanner(System.in);
			numTheme = Integer.parseInt(s4.next());
			if(numTheme > 0 && numTheme < 5) break;
		}
		
		Game game = new Game(numPlayers, numCards, numTheme);
		game.run();
		
		System.exit(0); //success
		
	}
}