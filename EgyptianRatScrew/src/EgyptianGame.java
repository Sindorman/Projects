import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EgyptianGame {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Welcome to Egyptian screw rat. Please give number of players 2 or 4");
		int input = System.in.read();
		while((input) < 2 || (input > 4)){
			System.out.println("Please give number of players from 2 to 4");
			System.in.read();
		}
		System.out.println("Number of games to play?");
		input = System.in.read();
		ArrayList<EgyptianPlayer> players = new ArrayList<EgyptianPlayer>();
		
		EgyptianDeck deck = new EgyptianDeck();
		// Shuffling deck
		for(int x = 0; x < ThreadLocalRandom.current().nextInt(1, 10 + 1); x++) deck.shuffle();
		
		// Set players slap speed. Who is slower and who is faster
		for(EgyptianPlayer p : players){
			double slap_speed = ThreadLocalRandom.current().nextDouble(1, 2 + 1);
			for(EgyptianPlayer h: players){
				while(h.slap_speed == slap_speed)
					slap_speed = ThreadLocalRandom.current().nextDouble(1, 2 + 1);
			p.slap_speed = slap_speed;
			}
		}
		
		// Hand cards to the players
		for(EgyptianPlayer p : players)
			p.addCard(deck.draw());
		int whoTakes = -1;
		ArrayList<EgyptianCard> CardsOnTable = new ArrayList<EgyptianCard>();
		
		while(winner(players) == null) {
			for(int x = 0; x < players.size(); x ++) {
				CardsOnTable.add(players.get(x).drawCard());
			}
		}
		

	}
	
	public static EgyptianPlayer winner(ArrayList<EgyptianPlayer> players) {
		for(EgyptianPlayer p : players) {
			if(p.NumCards() == 26)
				return p;
		}
		return null;
	}

	public class EgyptianPlayer{
		int won;
		int lost;
		
		double slap_speed;
		private Queue<EgyptianCard> deck;
		
		public void addCard(EgyptianCard C) {deck.add(C);}
		public EgyptianCard drawCard() {return deck.remove();}
		public int NumCards() {return deck.size();}
		
		public EgyptianPlayer(){
			this.won = 0; 
			this.lost = 0; 
			slap_speed = 0.0; 
			deck = new LinkedList<EgyptianCard>();}
		
	}
}


