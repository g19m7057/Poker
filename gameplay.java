import java.util.Scanner;
import java.util.*;

public class gameplay{

	public void gameloop(){
		System.out.println("\tWELCOME TO CASINO WARS\n");
		poker p1 = new poker();
		Scanner in = new Scanner(System.in);
		String cis = ""; // variable used for input yes or no
		LinkedList<String> list = p1.dealer(); // deals the four cards
		
		System.out.println("if player[0]");
		int players = in.nextInt();
		String dealer = "";
		
		if(players == 1){
			dealer = p1.comp();
		}if (players == 0){
			
			dealer = player(list);
		}
		
		String player_one = player(list); // card chosen by player
		System.out.print("\nhow much do you want to bet: R ");
		
		int bet = in.nextInt();

		while(true){

			if(checkeq(player_one, dealer)){
				System.out.println("\nIt's a Draw\n");
				System.out.print("Do you want to GO TO WAR [yes] or no[no]: \n");
				String con = in.next();
				con = con.toLowerCase();
				while(!con.equals("yes") && !con.equals("no")){
					System.out.print("invalid input\n Do you want to GO TO WAR [yes] or not[no]: ");
					con = in.next();
					con = con.toLowerCase();
				}

				if(con.equals("yes"))
				{
					list = p1.dealer();
					bet *= 2;
					if(players == 1){
						dealer = p1.comp();
					}if(players == 0){
						
						dealer = player(list);
					}
					player_one = player(list);
					
					if(!checkless(player_one, dealer)) // if player card is more than player wins
					{
						bet *= 2;
					}
				}

				if(con.equals("no"))
				{
					list = p1.dealer();
					player_one = player(list); // card chosen by player
					dealer = p1.comp(); // card chosen by computer
					System.out.println("how much do you want to bet:");
					bet = in.nextInt();
					break;
				}
			}
			if(checkless(player_one, dealer))
			{
				if(players == 0){
					System.out.printf("\nplayer two won R %d \n\n", bet);
					System.out.println("player one's card was " +player_one+"\n");
					System.out.println("player twos card was "+dealer+"\n");
				}else
				{
					System.out.printf("\nYou lost a your bet \n\n");
					System.out.println("your card was " +player_one+"\n");
					System.out.println("dealers card was "+dealer+"\n");
				}
				break;
			}
			if(checkmore(player_one, dealer))
			{
				if(players == 0){
					bet*=2;
					System.out.printf("\ncongratulations player one have won: R %d\n\n", bet);
					System.out.println("your card was " +player_one+"\n");
					System.out.println("player twos card was "+dealer+"\n");
				}else{
					bet*=2;
					System.out.printf("\ncongratulations you have won: R %d\n\n", bet);
					System.out.println("player one's card was " +player_one+"\n");
					System.out.println("dealers card was "+dealer+"\n");
				}
				break;
			}

		}
	}

	public static String player(LinkedList<String> list) // player card selection
	{
		Scanner in = new Scanner(System.in);
		System.out.print("which card do you want [1] [2] [3] [4] [5] [6]:  ");
		int x = in.nextInt();
		while(x > 6){
			System.out.println("invalid input\n");
			System.out.print("which card do you want [1] [2] [3] [4] [5] [6]: ");
			x = in.nextInt();
		}
		return list.get(x-1);
	}


	public static boolean checkeq(String p, String c) //checks if card is equal than dealers
	{

		if(p.length() <= 6 && c.length() <= 6){
			if(Character.getNumericValue(c.charAt(0)) == Character.getNumericValue(p.charAt(0))){
				return true;
			}
		}
		if(p.length() >= 7 && c.length() >= 7){
			if(Integer.parseInt(c.substring(0,2)) == Integer.parseInt(p.substring(0,2))){
				return true;
			}
		}
		if(p.length() >= 7 && c.length() <= 6){
			if(Integer.parseInt(p.substring(0,2)) == Character.getNumericValue(c.charAt(0))){
				return true;
			}
		}
		if(p.length() <= 6 && c.length() >= 7){
			if(Character.getNumericValue(p.charAt(0)) == Integer.parseInt(c.substring(0,2))){
				return true;
			}
		}
		return false;
	}
	public static boolean checkless(String p, String c)//checks if card is less than dealers
	{

		if(p.length() >= 7 && c.length() >= 7){
			if(Integer.parseInt(c.substring(0,2)) > Integer.parseInt(p.substring(0,2))){
				return true;
			}
		}if(p.length() >= 7 && c.length() <= 6){
			if(Integer.parseInt(p.substring(0,2)) < Character.getNumericValue(c.charAt(0))){
				return true;
			}
		}if(p.length() <= 6 && c.length() >= 7){
			if(Character.getNumericValue(p.charAt(0)) < Integer.parseInt(c.substring(0,2))){
				return true;
			}
		}if(p.length() == 6 && c.length() == 6){
			if(Character.getNumericValue(c.charAt(0)) > Character.getNumericValue(p.charAt(0))){
				return true;
			}
		}
		return false;
	}
	public static boolean checkmore(String p, String c)//checks if card is more than dealers
	{
		if(p.length() >= 7 && c.length() >= 7){
			if(Integer.parseInt(c.substring(0,2)) < Integer.parseInt(p.substring(0,2))){
				return true;
			}
		}if(p.length() >= 7 && c.length() <= 6){
			if(Integer.parseInt(p.substring(0,2)) > Character.getNumericValue(c.charAt(0))){
				return true;
			}
		}if(p.length() <= 6 && c.length() >= 7){
			if(Character.getNumericValue(p.charAt(0)) > Integer.parseInt(c.substring(0,2))){
				return true;
			}
		}if(p.length() <= 6 && c.length() <= 6){
			if(Character.getNumericValue(c.charAt(0)) < Character.getNumericValue(p.charAt(0))){
				return true;
			}
		}
		return false;
	}
}
