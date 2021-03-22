package Project;

import java.util.*;

public class Project2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Build Arrays
		String[] name = new String[10];
		int[] win = new int[10]; 
		int[] lost = new int[10];
		int[] win2 = new int[10];
		int[] lost2 = new int[10];
		double[] avg = new double[10];
		double[] avg2 = new double[10];
		double[] avg3 = new double[10];
		// Build Arrays
		int remain;
		System.out.println("DONGRYUL KIM's 2nd assignment");
		System.out.println("Format (#####/##/##)");
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {
			// get information in specific format from user 
			System.out.println("Enter the name and record of team " + (i+1));
			String teamInfo = sc.nextLine();
			// get substrings from input and store it into each variables
			name[i] = teamInfo.substring(0, 5);
			win[i] = Integer.parseInt(teamInfo.substring(6, 8));
			lost[i] = Integer.parseInt(teamInfo.substring(9,11 ));
			
			//if total number of game played is greater than 25, send error message
			if(win[i]+lost[i]>25) {
				System.out.println("Wrong input. try again");
				i --;
			}
			avg[i]=((double)(win[i])/(double)(win[i]+lost[i]));
		}
		
		// display each team's information
		for(int i=0; i<10; i++) {
			remain = 25-(win[i]+lost[i]);
			System.out.println("\n\nTeam "+name[i]+" Record");
			System.out.printf("%-8s%-5s%-5s","NAME","WIN","lost");
			System.out.printf("\n%-8s%-5d%-5d",name[i],win[i],lost[i]);
			System.out.println("\nTotal number of game played is " + (win[i]+lost[i])+", and "+ remain + " games remaining");
			System.out.printf("%-23s%4.4f","The winning average is",avg[i]);
			System.out.println();
			if(remain >= win[i]) {
				System.out.println("Number of games remaining is greater than or equal to number won");
				if(remain >= lost[i]) {
					System.out.println("Number of games ramaining is greater than or equal to number of lost");
				}
				else if(remain < lost[i]) {
					System.out.println("Number of games remaining is not greater than number lost");
				}
			}
			else if(remain < win[i]) {
				System.out.println("Number of games remaining is not greater than or number of won");
				if(remain >= lost[i]) {
					System.out.println("Number of games ramaining is greater than or equal to number of lost");
				}
				else if(remain < lost[i]) {
					System.out.println("Number of games remaining is not greater than number lost");
				}
			}
		}
	
		System.out.println("\n\n###Optional questions###");
		System.out.print("\nwins all of the remaining games-------------------");
		for(int i=0; i<10; i++) {
			if(win[i]+lost[i]!=25) {
			remain = 25-(win[i]+lost[i]);
			System.out.println("\nif team " + name[i] + " wins all of the remaining games");
			win2[i] = win[i]+remain;
			System.out.println("Team "+name[i]+" Record is going to be");
			System.out.printf("%-8s%-5s%-5s","NAME","WIN","lost");
			System.out.printf("\n%-8s%-5d%-5d",name[i],win2[i],lost[i]);
			avg2[i]=((double)(win2[i]/(double)25));
			System.out.printf("%-23s%-4.4f","The winning average is",avg2[i]);
			System.out.println();
			}
		}
		System.out.print("\n\nloses all of the remaining games------------------");
		for(int i=0; i<10; i++) {
			if(win[i]+lost[i]!=25) {
			remain = 25-(win[i]+lost[i]);
			System.out.println("\nif team " + name[i] + " loses all of the remaining games");
			lost2[i] = lost[i]+remain;
			System.out.println("Team "+name[i]+" Record is going to be");
			System.out.printf("%-8s%-5s%-5s","NAME","WIN","lost");
			System.out.printf("\n%-8s%-5d%-5d",name[i],win[i],lost2[i]);
			avg3[i]=((double)(win[i]/(double)25));
			System.out.printf("%-23s%-4.4f","The winning average is",avg3[i]);
			System.out.println();
			}
		}
		System.out.println("\n\nBest winning average----------------------------");
		double maxAvg = avg[0];
		String name2 = name[0];
		for(int i=0; i<10; i++) {
			if(avg[i]>maxAvg) {
				maxAvg = avg[i];
				name2 = name[i];
			}
		}
		System.out.printf("%-21s%-7.4f%-11s%-5s","The best average is",maxAvg,"from team",name2);
		
	}
}
