package UnitConverter;

public class UnitConverterDB {
	
	
	public static UnitConverter getunitConverter(String convertNumber) {
		
		
		
		UnitConverter uc = new UnitConverter();
		uc.setConvertnumber(convertNumber);
		
		//Convert cm to in
		if(convertNumber.equals("1")) {
			Double centimeter = Console.getDouble("Convert centimeter to inch. Enter your cm value: " );
			uc.setInch(centimeter * 0.093701);
			
			String cm = Double.toString(centimeter);
			String in = Double.toString(uc.getInch());
			display("cm", "in", cm, in);
		}
		
		//Convert in to cm
		else if(convertNumber.equals("2")) {
			Double inch = Console.getDouble(("Convert inch to centimeter. Enter your inch value: "));
			uc.setCentimeter(inch * 2.54);
			
			String cm = Double.toString(uc.getCentimeter());
			String in = Double.toString(inch);
			display("in", "cm", in, cm);
		}
		
		//Convert liter to gallon
		else if(convertNumber.equals("3")) {
			Double liter = Console.getDouble("Convert liter to gallon. Enter your L value: ");
			uc.setGallon(liter * 0.264172);
			
			String l = Double.toString(liter);
			String gal = Double.toString(uc.getGallon());
			display("L","gal",l,gal);
		}
		
		//Convert gallon to liter
		else if(convertNumber.equals("4")) {
			Double gallon = Console.getDouble("Convert gallon to liter. Enter your gal value: ");
			uc.setLiter(gallon * 3.785412);
			
			String l = Double.toString(uc.getLiter());
			String gal = Double.toString(gallon);
			display("gal","L",gal,l);
		}
		
		//Convert celsius to fahrenheit
		else if(convertNumber.equals("5")) {
			Double celsius = Console.getDouble("Convert celsius to fahrenheit. Enter your 'C value: ");
			uc.setFahrenheit(9/5 * celsius + 32);
			String C = Double.toString(celsius);
			String F = Double.toString(uc.getFahrenheit());
			display("'C","'F",C,F);
		}
		
		//Convert fahrenheit to celsius
		else if(convertNumber.equals("6")) {
			Double fahrenheit = Console.getDouble("Convert fahrenheit to celsius . Enter your 'F value: ");
			uc.setCelsius((fahrenheit-32) * 5/9);
			
			String C = Double.toString(uc.getCelsius());
			String F = Double.toString(fahrenheit);
			display("'F","'C",F,C);
		}
		
		//Convert kilogram to pound
		else if(convertNumber.equals("7")) {
			Double killogram = Console.getDouble("convert killogram to pound . Enter your kg value: ");
			uc.setPound(killogram * 2.204623);
			
			String kg = Double.toString(killogram);
			String lb = Double.toString(uc.getPound());
			display("kg","lb",kg,lb);
		}
		
		//Convert pound to kilogram
		else if(convertNumber.equals("8")) {
			Double pound = Console.getDouble("convert pound to killogram . Enter lb value: ");
			uc.setKillogram(pound / 2.204623);
			
			String kg = Double.toString(uc.getKillogram());
			String lb = Double.toString(pound);
			display("lb","kg",lb,kg);
		}
		return uc;
	}
	
	public static void display(String unitA, String unitB, String valueA, String valueB) {
		StringBuilder list = new StringBuilder();
		
		final int FROMWIDTH = 13;
		final int AWIDTH = 5;
		final int TOWIDTH = 13;
		
		list.append(StringUtil.pad(unitA, FROMWIDTH));
		list.append(StringUtil.pad("->", AWIDTH));
		list.append(StringUtil.pad(unitB, TOWIDTH));
		list.append("\n");
		
		list.append(StringUtil.pad("==========", FROMWIDTH));
		list.append(StringUtil.pad("===", AWIDTH));
		list.append(StringUtil.pad("==========", TOWIDTH));
		list.append("\n");
		
		list.append(StringUtil.pad(valueA + unitA, FROMWIDTH));
		list.append(StringUtil.pad("->", AWIDTH));
		list.append(StringUtil.pad(valueB + unitB, TOWIDTH));
		list.append("\n");
		System.out.println(list);
		
	}

}
