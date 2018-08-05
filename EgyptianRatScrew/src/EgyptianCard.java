import java.util.ArrayList;
import java.util.Arrays;

public class EgyptianCard implements Comparable<EgyptianCard> {
	private String rank;
	private String suit;
	public ArrayList<String> ranks = new ArrayList<String>(Arrays.asList("", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));

	
	
	public EgyptianCard(String rank, String suit) {
		if (isRank(rank)){
			this.rank = rank;
			
		} else {
			throw new IllegalArgumentException();
		}
		if (isSuit(suit)){
			this.suit = suit;
		} else {
			throw new IllegalArgumentException();
		}
		attempts();
	}
	
	public static boolean isRank(String rank){
		if (rank.equals("A") || rank.equals("Q") || rank.equals("J") || rank.equals("K")){
		return true;
		}		
		for (int x = 2; x <= 10; x++){			
			if (rank.equals("" + x)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isSuit(String suit){
		if (suit.equals("S") || suit.equals("D") || suit.equals("H") || suit.equals("C")){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean Covers(){
		if (rank.equals("A") || rank.equals("Q") || rank.equals("J") || rank.equals("K"))return true;
		return false;
	}
	public int attempts(){
		switch(rank){
			case "J":
				return 1;			
			case "Q":
				return 2;			
			case "K":
				return 3;
			case "A":
				return 4;
		}
		return 0;
	}
	public String getSuit() { return this.suit;}
	public String toString() {
		return "" + this.rank + this.suit;
	}

	@Override
	public int compareTo(EgyptianCard arg0) {
		return this.ranks.indexOf(this.rank) - arg0.ranks.indexOf(arg0.rank);
	}
}