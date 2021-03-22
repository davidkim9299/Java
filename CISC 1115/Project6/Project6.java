package Project;
import java.io.*;
import java.util.*;

public class Project6 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("c:\\data of assig 6.txt"));
		int size = 0;
		
		// all System.out statement will print on 'output of assig 6.txt'. not on the screen
		File file = new File("Output of assig 6.txt");
		FileOutputStream output = new FileOutputStream(file);
		PrintStream ps = new PrintStream(output);
		System.setOut(ps);
		

		System.out.println("DONGRYUL KIM's 6th assignment\n\n");
		
		// create an standard double based array to read numbers.txt file
		// and fill out an array size of 100
		double[] text = new double[100];
		
		// if numbers.txt does not have next line, loop will stop
		// can determine the value of integer variable 'size'
		while(sc.hasNext()) {
			text[size++] = sc.nextDouble();
		}
		
		//create new array using exist data
		double[] arr = readData(size, text);
		
		/*
		 * print the original array
		 * sent the original array to method 'printArray' with two parameters
	     * which represent the size of the array and array 'arr'
	     */
		System.out.println("Here is the original array");
		
		
		printArray(size,arr);
		
		// print the average of the original array
		System.out.println("\n\nHere is the average of the original Array");
		System.out.print("Average : ");
		
		/*
		 * findAverage method calculates the average of sent array
		 * each two parameteres represent the size of the array and the array 'arr'
		 */ 
		System.out.printf("%-8.2f",findAverage(size,arr));
		
		/* 
		 * create new array which is different with arr
		 * each three parameters represent the size of the array
		 * the average value of the origianl array
		 * and the original array
		 */
		double[] newArr = howFarAway(size,findAverage(size,arr),arr);
		System.out.println("\n\nHere is the new array");
		// print new array
		printArray(size, newArr);
		
		findFurClo(size, findAverage(size,arr),newArr);
		
	}
	
	static double[] readData(int n, double[] numbers) {
		double[] temp = new double[n];
		// copy 'numbers' to 'temp' starts with index 0. until index reaches to n.
		System.arraycopy(numbers, 0, temp, 0, n);
		return temp;
	}
	
	// using while loop, this method prints an array sent by main program.
	static void printArray(int q, double numb[]) {
		int i=0;
		while(i<q) {
			System.out.printf("%-8.2f",numb[i]);
			//every row has five elements to print out
			if(++i%5 == 0) System.out.println();
		}
	}
	
	// this method calculates the average of an array sent by main program.
	static double findAverage(int k, double[] p) {
		double average = 0, sum = 0;
		for (int i = 0; i < k; i++) {
			sum = sum + p[i];
		}
		average = sum / k;
		return average;
	}
	
	/*
	 * this method create new array using average value and the original array.
	 * each elements in the new array equals the difference between 
	 * the original array's average and the corresponding element in the original array
	*/
	static double[] howFarAway(int m, double average, double[] r) {
		double[] temp = new double[m];
		for (int i = 0; i < m; i++) {
			temp[i] = r[i]-average;
		}
		return temp;
	}
	
	/*
	 * Find the furthest and closest value from the average.
	 * Compare the new array which represents the difference with original array and average
	 * Than means, the maximum absolute value in the new array is the furthest value from the average
	 * and the minimum absolute value in the new array is the closest value from the average
	 */
	static void findFurClo(int n, double average, double[] x) {
		double max = Math.abs(x[0]);
		for (int i = 1; i <n; i++) {
			if(Math.abs(x[i])>max) {
				max = x[i];
			}
		}
		System.out.print("\n\nThe furthest value from the average is " + (max+average) + " and ");
		System.out.printf("%-5.2f",Math.abs(max));
		System.out.print(" far from average");
		
		double min = Math.abs(x[0]);
		for (int i = 1; i <n; i++) {
			if(Math.abs(x[i])<min) {
				min = x[i];
			}
		}
		System.out.print("\n\nThe closest value from the average is " + (min+average) + " and ");
		System.out.printf("%-5.2f",Math.abs(min));
		System.out.print(" far from average");
	}
}
