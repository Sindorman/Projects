import java.util.ArrayList;
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

	}

	public class EgyptianPlayer{
		int won;
		int lost;
		
		double slap_speed;
		
		public EgyptianPlayer(){this.won = 0; this.lost = 0; double slap_speed;}
	}
}


