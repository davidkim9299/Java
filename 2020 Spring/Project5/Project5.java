package Project;
import java.util.*;

public class Project5 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("DONGRYUL KIM's 5th Assignment. \nDice game!\n\n");
		int die1 = 0, die2 = 0;
		String choice = "y";
		int i = 1;
		
		while(choice.equalsIgnoreCase("y")) {
			System.out.println("## New game has been started ##" + " " + i);
			die1=getFirst();
			die2=getSecond();
			System.out.println("Your numbers are "+die1+", "+die2);
			System.out.println(outCome(die1, die2));
			System.out.println(" ");
			if(outCome(die1, die2)=="You win"||outCome(die1,die2)=="You lose") {
				choice = "y";
				}
			else {
				int sum = die1+die2;
				System.out.println(bonusGame(sum));
				System.out.println(" ");
			}
			i++;
			if((i+1)>11) {
				System.out.println("Continue ? (y/n) : ");
				choice = sc.next();
				if(choice.equalsIgnoreCase("n")) {
					break;
				}
			}
		}
	}
	
	public static int getFirst() {
		System.out.print("Enter first number (1~6) : ");
		int first = sc.nextInt();
		if(first<=0||first>=7) {
			System.out.println("Wrong input. Try again");
			return getFirst();
		}
		else
			return first;
	}
		
	public static int getSecond() {
		System.out.print("Enter second number (1~6) : ");
		int second = sc.nextInt();
		if(second<=0||second>=7) {
			System.out.println("Wrong input. Try again");
			return getSecond();
		}
		else
			return second;
	}
	
	public static String outCome(int a, int b) {
		int sum = a+b;
		if(sum==7||sum==11) {
			return "You win";
		}
		else if(sum==2||sum==12) {
			return "You lose";
		}
		else
			return "Draw";
	}
	public static String bonusGame(int a) {
		System.out.println("* Bonus Game *");
		int aDie1 = getFirst();
		int aDie2 = getSecond();
		System.out.println("Your numbers are "+aDie1+", "+aDie2);
		
		int sum = aDie1 + aDie2;
		if(sum==7) {
			return "You lose";
		}
		else if(sum==a) {
			return "You win";
		}
		else {
			System.out.println("Draw\n");
			return bonusGame(sum);
		}
	}
	

}
