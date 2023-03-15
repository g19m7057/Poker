import java.util.*;
import java.util.Random;
// import java.util.Arrays;

public class poker{
	private LinkedList<String> cards;
	
	public String[] deck() // returns linked list deck
	{
		String[] card = new String[52];
		String[] suit = {"c","d","h","s"};
		String[] nums = {"14", "2","3","4","5","6","7","8","9","10","11","12","13"}; // I made the ace 14
		int e = 0;
		for(int i =0 ; i < suit.length; i++){
			for(int j = 0; j< nums.length; j ++){
				card[e] =   nums[j] +suit[i];
				e ++;
			}
		}
		return card;
	}
	private String[] shuffle(String[] a) //Shuffles deck
	{
		Random r = new Random();
		int t = a.length -1;
		int e = a.length;
		for(int i = 0; i < a.length; i++){
			int index = r.nextInt(e);
			String temp = a[t];
			a[t] = a[index];
			a[index] = temp;
			t -= 1;
			e -= 1;
		}
		return a;
	}
	
	public poker() // this.cards becomes a shuffled list of cards
	{
		LinkedList<String> f = new LinkedList<String>();
		String[] x = shuffle(deck());
		for(String c : x){
			f.add(c);
		}
		this.cards = f;
	}
	
	/* 
	* this dealer only deals cards not play the game
	*/
	
	public LinkedList<String> dealer() // deals 4 cards selected randomly from shuffled deck
	{
		Random r = new Random();
		LinkedList<String> cardstoselectfrom = new LinkedList<String>();
		for(int i = 0; i < 6; i++){
			int y = r.nextInt(52);
			cardstoselectfrom.add(this.cards.get(y));
		}
		return cardstoselectfrom;
	}
	public String comp()//selects the dealers card
	{
		Random r = new Random();
		int u  = r.nextInt(52);
		
		return this.cards.get(u);
	}

}