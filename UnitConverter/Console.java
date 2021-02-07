package UnitConverter;

import java.util.*;

public class Console {
	private static Scanner sc = new Scanner(System.in);
	
	public static String getString(String prompt) {
		System.out.print(prompt);
		String s = sc.nextLine();
		return s;
	}
	
	public static double getDouble(String prompt) {
		double j = 0.0;
		while(true) {
			System.out.print(prompt);
			try {
				j = Double.parseDouble(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.print("Invalid input. Try again");
			}
		}
		return j;
	}
	

}
