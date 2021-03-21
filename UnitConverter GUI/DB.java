package UnitGUI;

import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DB 
{
	JTextField t1, t2, t3, t4, t5, t6;
	String  s;
	double a=0;
	double b=0;
	static String result;
	static int operator = 0;
	String str = "";

	public DB(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5, JTextField t6) 
	{
		// TODO Auto-generated constructor stub
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		this.t5 = t5;
		this.t6 = t6;
		//this.a = a;
		//this.b = b;
	
	}

	

	public void result(String s, JTextField t3) 
	{
		

		if (s.equals("inch")) 
		{
			t6.setText("in");
			a=Double.parseDouble(t3.getText());
			b = (a * 2.54);
			result = Double.toString(b);
			operator = 1;
		}
		else if (s.equals("centimeter")) 
		{
			t6.setText("cm");
			a=Double.parseDouble(t3.getText());
			b = (a * 0.393701);
			result = Double.toString(b);
			operator = 2;
		} 
		else if (s.equals("gallon")) 
		{
			t6.setText("gallon");
			a=Double.parseDouble(t3.getText());
			b = (a * 3.785412);
			result = Double.toString(b);
			operator = 3;
		} 
		else if (s.equals("liter")) 
		{
			t6.setText("liter");
			a=Double.parseDouble(t3.getText());
			b = (a * 0.264172);
			result = Double.toString(b);
			operator = 4;
		} 
		else if (s.equals("fahrenheit")) 
		{
			t6.setText("ขต");
			a=Double.parseDouble(t3.getText());
			b = ((a - 32) / 1.8);
			result = Double.toString(b);
			operator = 5;
		} 
		else if (s.equals("celcius")) 
		{
			t6.setText("กษ");
			a=Double.parseDouble(t3.getText());
			b = (32 + (a * 1.8));
			result = Double.toString(b);
			operator = 6;
		} 
		else if (s.equals("pound")) 
		{
			t6.setText("lb");
			a=Double.parseDouble(t3.getText());
			b = (a / 2.204623);
			result = Double.toString(b);
			operator = 7;
		} 
		else if (s.equals("killogram")) 
		{
			t6.setText("kg");
			a=Double.parseDouble(t3.getText());
			b = (a * 2.204623);
			result = Double.toString(b);
			operator = 8;
		} 
		else if (s.equals("reset"))
		{
			t3.setText("");
			t6.setText("");
			t4.setText("");
		}
		else if (s.equals("Convert")) 
		{
			switch (operator) 
			{
				case 1:
					t4.setText(result + "cm");
					break;
				case 2:
					t4.setText(result + "in");
					break;
				case 3:
					t4.setText(result + "งค");
					break;
				case 4:
					t4.setText(result + "gal");
					break;
				case 5:
					t4.setText(result + "กษ");
					break;
				case 6:
					t4.setText(result + "ขต");
					break;
				case 7:
					t4.setText(result + "kg");
					break;
				case 8:
					t4.setText(result + "lb");
					
					break;
				default:
					t4.setText("no");
					System.out.println("no");
			
			}
			//t4.setText(Double.toString(a));
			
			
		}
	}
	
}