package Project;

public class Project1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------");
		//Create an array for x and y values
		double[] x = {-3, -2.5, -2, -1.5, -1, -0.5, 0, 0.5, 1, 1.5, 2, 2.5, 3};
		//array addresses will be x[0]~x[13]
		double[] y;
		y = new double[x.length];
		
		int zero = 0; //count number of y which is 0
		int positive = 0;//count number of y which is positive
		int negative = 0;//count number of y which is negative
		double zzero = 0;
		
		//to find y value which is closest to y and its x value
		double nearX =0;
		double nearY =0;
		double min = 50;
		
		//loop statement to evaluate y values
		//using printf statement to generate a neat listing of output
		for(int i=0; i<x.length;i++) {
			y[i] = (double) (4*Math.pow(x[i], 3)+8*Math.pow(x[i], 2)-31*x[i]-35)/(double) (Math.pow((3*Math.sqrt(x[i])), 1/2)+2*Math.abs(x[i]-1.5));
			if (y[i]==0) {//if y equals to 0, it prints Y IS ZERO
				System.out.printf("%-4s%4.1f%7s%6.2f%10s","X =",x[i],"Y =",y[i],",  Y IS ZERO");
				System.out.println("");
				zero++;//it counts the number of y which is 0
			}
			else if (y[i]>0) {//if y is greater than zero, it prints Y IS POSITIVE
				System.out.printf("%-4s%4.1f%7s%6.2f%10s","X =",x[i],"Y =",y[i],",  Y IS POSITIVE");
				System.out.println("");
				positive++;//it counts the number of y which is greater than 0
			}
			else if (y[i]<0) {//if y is less than zero, it prints Y is negative
				System.out.printf("%-4s%4.1f%7s%6.2f%10s","X =",x[i],"Y =",y[i],",  Y IS NEGATIVE");
				System.out.println("");
				negative++;//it counts the number of y which is less than 0
			}
		}
		System.out.println("This program is completed");
		System.out.println("-----------------------------------------");
		
		//loop statement to find the closest y value to 0
		//it compares each y values and finds the minimum absolute y value.
		for(int j=0; j<y.length; j++) {
			double abs = Math.abs(y[j]-zzero);	
			if(abs!=0 && min > abs) {
				min = abs;
				nearY = y[j];
				nearX = x[j];
			}
		}
		System.out.println("For extra credit question");
		System.out.println("\n1."+"\nThe closest y value is " + nearY + " when x is "+ nearX);
		System.out.println("\n2."+"\nNumber of positive : "+positive);
		System.out.println("Number of negative : "+negative);
		System.out.println("Number of zero : "+zero);
	}
}
