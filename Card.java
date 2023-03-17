import java.util.LinkedList;
import java.util.Collections;

public class Card implements Comparable<Card>{

	private Cards cardNumber;
	private Suits cardSuit;

	public Cards getNumber(){
		return cardNumber;
	}

	public Suits getSuit(){
		return cardSuit;
	}

	private enum Suits{
		Spades, Hearts, Clubs, Diamonds;
	}

	private enum Cards{
		Two(2), Three(3), Four(4), Five(5), Six(6),
		Seven(7), Eight(8), Nine(9), Ten(10), Eleven(11), 
		Twelve(12), Thirteen(13), Ace(14);
		
		int ind;

		private Cards(int x){
			this.ind = x;
		}
		public int getValue(){
			return ind;
		}
	}

	public LinkedList<Card> deck = new LinkedList<Card>();

	public LinkedList<Card> cardDeck(){

		for(Suits s : Suits.values()){
			for(Cards c: Cards.values()){
				Card card = new Card();
				card.cardSuit = s;
				card.cardNumber = c;
				deck.add(card);
			}	
		}
		return deck;
	}

	@Override
	public int compareTo(Card card){
		// the first is bigger than the second card
		if(this.getNumber().getValue() > card.getNumber().getValue()){
			return 1;
		}
		if(this.getNumber().getValue() < card.getNumber().getValue()){
			return 0;
		}
		else{
			return -1;
		}
	}

	@Override
	public String toString(){
		return (cardNumber + " of " + cardSuit);
	}

	public static void shuffle(LinkedList<Card> deck){
		Collections.shuffle(deck);
	}

	public static void main(String[] args){
		Card c = new Card();
		LinkedList<Card> deck = c.cardDeck();
		System.out.println(deck);
		System.out.println(deck.get(0).getNumber()+"\n");
		shuffle(deck);
		System.out.println(deck);
		System.out.println(deck.get(0).getNumber());

		System.out.println(deck.get(1).compareTo(deck.get(0)));
	}
}
