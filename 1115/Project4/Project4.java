package Project;
import java.util.*;

public class Project4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		introduction();
		System.out.println(" ");
		Scanner sc = new Scanner(System.in);
		
		//loop indicator
		String loop = "y";
		//this is an array to store values which are ever compute for the sum
		//total number of set should be 10
		int[] computedNum = new int[20];
		//this is an array to store three integer
		int[] input = new int[3];
		//index variable for computedNum array
		int j = 0;
		//variable which stores the total number of times my name printed
		int count = 0;
		
		//make a while loop to repeat the program
		while(loop.equalsIgnoreCase("y")) {
			//get three integers using for loop statement
			for(int i=0;i<input.length;i++) {
				System.out.print("Enter the number : ");
				input[i] = sc.nextInt();
			}
			System.out.println(" ");
			//print three original integers
			System.out.print("The three original integers are : ");
			for(int i=0; i<input.length; i++) {
				System.out.print(input[i] + " ");
			}
			//sort the array by ascending order
			Arrays.sort(input);
			//send the array to method 'getSum' and get um of three variables
			System.out.println("\nThe sum is " + getSum(input));
			//this statement determines whether to print name or not
			//if sume of three variable less than or equals to 0 or greater than 10, the name will not be printed
			if(getSum(input)<=0|| getSum(input)>10) {
				System.out.println("It is not possible to print the name in this case");
			}
			//other case, name will printed as many as the sum from getSum() method
			else {
				printName(getSum(input));
				count = count + getSum(input);
			}
			//while looping, store the total number of times name printed in variable count
			
			//send array to method, and get the number of even number
			findEven(input);
			
			//store values which ever computed for the sum to array
			computedNum[j] = input[1];
			computedNum[j+1] = input[2];
			//every loop it uses 2 variables to calculate sum, so it needs 2+ index in every loop
			j=j+2;
			//ask to user to repeat. if user types y or Y it repeats
			System.out.print("\nAnother try? (y/n) : ");
			loop = sc.next();
			System.out.println(" ");
			}		
		//print the total number of times my name was printed
		System.out.println("\nTotal number of times my name was printed " + count);
		//print the array which include the values ever computed for the sum. in this program 20 values
		System.out.println("The numbers which ever computed for the sum");
		for(int i=0; i<computedNum.length; i++) {
			System.out.print(computedNum[i] + ", ");
		}
		//sort the array by ascending order
		Arrays.sort(computedNum);
		//print the smallest value. since array is ordered by ascending order, the minimum value is in index 0
		System.out.println("\nThe smallest vlaue ever computed : " + computedNum[0]);
		//print the largest value. since array is ordered by ascending order, the maximum value is in index 19
		System.out.println("The Largest value ever computed : " + computedNum[19]);
	}
	
	//print the introduction of this program. never repeated
	public static void introduction() {
		System.out.println("This program will"+
						   "\n1.Ask the user to type in three integer values"+
						   "\n2.Determine the sum of lager 2 of the three values, sending the answer back"+
						   "\n3.Print user's name as many as the answer from 2" +
						   "\n4.Determine how many of ther values are even and return that value");
		}
	
	//get sum of three variables
	//since array is ordered before it sent to this method, sum of larger two values is sum of index 1 and 2
	public static int getSum(int x[]) {
		int sum = x[1] + x[2];
		return sum;
	}
	
	//print name as many as the sum from getSum method
	public static void printName(int a) {
		for(int i=0; i<a; i++) {
			System.out.println("My name is DONRGYUL KIM");
		}
	}
	
	//find the number of even number(s) 
	public static void findEven(int x[]) {
		int noe = 0; 
		//if the remainder equals to 0, that means the number is even
		for(int i=0; i<x.length; i++) {
			if(x[i]%2==0) {
				//when the number is even, it add +1 to counter
				noe ++;;
			}
		}
		//print counter
		System.out.println("there is/are " + noe + " even number(s)");
	}
}
