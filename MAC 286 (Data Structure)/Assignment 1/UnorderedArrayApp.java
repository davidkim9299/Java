package class1;

import java.util.*;

public class UnorderedArrayApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UnorderedArray ua = new UnorderedArray(7);
        ua.insert(3);    
        ua.insert(5);
        ua.insert(8);
        ua.insert(4);
        ua.insert(11);
        ua.insert(33);
        ua.insert(1);
        ua.insert(10); // this will not be inserted because at this point the array is full
       
        //ua.display();        
        
        ua.delete(5);          // delete 5
        //ua.display();          // display items
        
        ua.delete(4);         // delete 4
        //ua.display();         // display items
        ua.delete(33);       // delete 33
        ua.display();
       
        
        
        /*int v = ua.find(33);      // look for 33
        if( v == -1 )
            System.out.println("Not Found !");
        else
            System.out.println("Founded");
        
        v = ua.find(111);    // look for 111
        if( v == -1 )
            System.out.println("Not Found !");
        else
            System.out.println("Founded");
        
        v = ua.find(11);    // look for 111
        if( v == -1 )
            System.out.println("Not Found !");
        else
            System.out.println("Founded");*/
        
       System.out.println("\nSummation : " + ua.getSum());
       System.out.println("\nnMaximum : " + ua.getMax());
       System.out.println("\n"+ua.getAboveAverage() + " numbers are above the average");
       System.out.println(" ");
       ua.reverse();
       System.out.println("\nMin : " + ua.getMin());
       System.out.println("\nThe most frequent number in array [2,5,6,2,5,2] = " + ua.frequent(new int[]{2,5,6,2,5,2}));
  
    
        //ua.insertByIndex();
       System.out.println("\n@Add two additional value and put thme wherever you want@");
       
       //get three additional array elements
   	   Scanner sc = new Scanner(System.in);
   	   int count = 4;
   	   for (int i = 0; i<2; i++)
   	   {
   		   
	   System.out.println("Enter value");
	   long v = sc.nextLong();
	   ua.insert(v);
	   ua.display();
	   System.out.println("Enter position (0~" + count + ")");
	   int position = sc.nextInt();
	   ua.insertByIndex(position);
	   ua.newdisplay();
	   count ++;
   	   }
   	   
   	   System.out.println("Enter the index you want to delete (0~"+ua.getnElems()+")");
   	   int index = sc.nextInt();
   	   ua.deleteI(index);
	  
   
	}
}
