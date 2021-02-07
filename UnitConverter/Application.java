package UnitConverter;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("This Program Converts Units");
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			String convertNumber = Console.getString(
		"\n1. cm -> in" +
		"\n2. in -> cm" +
		"\n3. L -> gal" +
		"\n4. gal -> L" +
		"\n5. 'C -> 'F" +
		"\n6. 'F -> 'C" +
		"\n7. kg -> lbs" +
		"\n8. lb -> kg" +
		"\n\nEnter a number you want to convert: ");
					
					
			
			UnitConverter cn = UnitConverterDB.getunitConverter((convertNumber));
			
			choice = Console.getString(("Another Conversion? (y/n)"));
		}

	}

}
