import java.util.Queue;

public class EgyptianHand{

	private Queue<EgyptianCard> cards;
	private int count = -1;
	
	public EgyptianCard drawCard(){
		if(cards.peek() != null){
			return cards.remove();
		} else {
			return null;
		}
	}
	
	public void addCard(EgyptianCard card){cards.add(card);}
	
}
