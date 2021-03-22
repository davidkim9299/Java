package Project;
import java.util.Arrays;
import java.util.Scanner;

public class Project3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// get the number of athletes from user
		System.out.println("Enter the number of Athletes");
		// change string to integer (to avoid error of nextLine after nextInt
		int noa = Integer.parseInt(sc.nextLine());
		// make an array for athlete's ID
		String[] athlete = new String[noa];
		// make an array to compare each athlete's average score
		double[] avg = new double[noa];
		// make an array to compare each athlete's highest score
		double[] hst = new double[noa];

		// during for loop, get a data from user
		// two dimension loop
		for (int i = 0; i < noa; i++) {
			// get data in ID #judges scores form
			System.out.println("Enter (ID #judges scores) of Athlete " + (i + 1));
			String info = sc.nextLine();
			// to extract the number of judges to make another loop
			int noj = Integer.parseInt(info.substring(5, 6));
			// number of total data = number of judges + 2
			String[] db = new String[noj + 2];
			// number of score = number of judges
			double[] score = new double[noj];
			// cut string based on space
			for (int j = 0; j < noj + 2; j++) {
				db[j] = info.split(" ")[j];
			}
			// first substring goes to athlete's ID
			athlete[i] = db[0];
			// make an array for scores
			for (int j = 0; j < noj; j++) {
				score[j] = Double.parseDouble(db[j + 2]);
			}
			// send a score array to method 'average' to get average score of each athlete
			// and store it to 'avg' array
			avg[i] = average(score);
			// send a score array to method 'highest' to get highest score of each athlete
			// and store it to 'hst' array
			hst[i] = score[(int) highest(score)];

			// Display
			System.out.println("ID\t\t#judge\t\tScores");
			System.out.print(athlete[i] + "\t\t" + noj + "\t\t");
			for (int j = 0; j < noj; j++) {
				System.out.print(score[j] + " ");
			}
			System.out.println();
			System.out.printf("%-16s%-16.2f%-16s%-8.2f", "Average score : ", avg[i], "Highest score : ", hst[i]);
			System.out.println(" ");
			System.out.println(" ");
		}
		System.out.println("//////////////////////////////////////////");
		// send avg array to method 'average' to get highest average score and display
		// avg[] and athlete[]
		System.out.printf("%-30s%-4.2f%-14s%-4s%-2s", "##The highest average score is [", avg[(int) highest(avg)],
				"] from athlete [", athlete[(int) highest(avg)], "]");
		System.out.println();
		System.out.println("**Optional Question**");
		// send hst array to method 'highest' to get single highest score and display
		// hst[] and athlete[]
		System.out.println("Single highest score is [" + hst[(int) highest(hst)] + "] from athlete ["
				+ athlete[(int) highest(hst)] + "]");
	}

	// method to calculate average score
	public static double average(double x[]) {
		// sort an array in ascending order
		Arrays.sort(x);
		double avg = 0;
		double temp = 0;
		// the lowest score goes to index 0 and the highest score goes to last index of
		// array
		// after subtracting the first and last, add all to temp
		for (int i = 1; i < x.length - 1; i++) { // cut the first and last
			temp = temp + x[i]; // sum all of them
		}
		// to calculate average, divide temp by length-2
		avg = temp / (x.length - 2);
		// return average score
		return avg;
	}

	public static double highest(double y[]) {
		// set integer k to find index of array
		int k = 0;
		double temp = 0;
		for (int i = 0; i < y.length; i++) {
			// store a score which is higher than temp and its index
			if (y[i] > temp) {
				temp = y[i];
				k = i;
			}
		}
		// return the index of array which has highest score
		return k;
	}
}
