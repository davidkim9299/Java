package class1;

import java.util.*;


//find() --> o(n)
//insert() --> o(1)
//delete() --> o(n)
//display() --> o(n)


public class UnorderedArray {
	private long[] a;    // ref to array a
	private int nElems;  // number of data items

	public UnorderedArray(int n) {    // constructor
		a = new long[n];      // create the array
		nElems = 0;           // no items yet
	}

	public int find(long value) {

		for (int i = 0; i < nElems; i++) // for each element,
		{
			if (a[i] == value) // found item?
				return i; // if found, return index (location) of item
		}
		return -1; // can't find it, return -1
	}

	public boolean insert(long value) {

		boolean isArrayFull = isFull(); // test if there is space in array

		 if (isArrayFull == true)      // array is full return false
			return false;
		else {                       // array is not full, insert 

			a[nElems] = value; // insert it
			nElems++; // increment size
			return true;
		}
	}

	public boolean isFull() {         // test if the array is full
	
		if (nElems == a.length)  
			return true;
		else
			return false;
	}

	public boolean isEmpty() {      // test if the array is empty
		if (nElems == 0)
			return true;
		else
			return false;
	}

	
	public boolean delete(long value) {

		boolean isArrayEmpty = isEmpty(); // test if there is items in array
		
		if (isArrayEmpty == true) // if array empty, return false (nothing to be deleted) return false
			return false;
		else {                    // array is not empty
			int j = find(value); // find the location of item to be deleted
			
			if (j == -1)        // if item not found
				return false;   // return false
			else {              // item is found, start shifting items

				for (int i = j+1 ; i < nElems ; i++) {
	                a[i-1] = a[i] ;
				}
			} // end of shifting items
			nElems--;   // decrement size by 1
			return true;
		}
	}
	
	public void display() {
		System.out.print("Array : ");
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	public void newdisplay() {
		System.out.print("NewArray : ");
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
		
	public long getMax()
	{
		long max = a[0];
		for (int i =1; i<nElems; i++)
		{
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}
	
	public long getSum()
	{
		long sum = 0;
		for (int i=0; i<nElems; i++)
		{
			sum = sum + a[i];
		}
		return sum;
	}
	
	public int getAboveAverage()
	{
		long average = getSum()/nElems;
		System.out.println("Average : " + average);
		int counter = 0;
		for(int i =0; i<nElems; i++)
		{
			if(a[i] > average)
				counter++;
		}
		return counter;
	}
	
	public void reverse() 
	{
		long []b = new long[nElems];
		int j = nElems;
		System.out.print("New Array : ");
		for (int i = 0; i<nElems; i++)
		{
			b[i] = a[j-1];
			System.out.print(b[i] + " ");
			j--;
			
		}
		
	}
	
	public long getMin()
	{
		long min = a[0];
		for (int i =1; i<nElems; i++)
		{
			if (a[i] < min)
				min = a[i];
		}
		return min;
	}
	
	/*
	public void insertByIndex()
	{
		display();
		Scanner sc = new Scanner(System.in);
		int counter = 4;
		
		//Get additional 2 elements into array list 
		for(int i =0; i<nElems+2; i++)
		{
			//first, get elements in a[4] and a[5]
			if(i>=nElems)
			{
				System.out.println("\nEnter a Value : ");
				long value = sc.nextLong();
				
				System.out.println("Location? (0~" +counter +")");
				int location = sc.nextInt();
				
				//expand number of elements until the array has 6 elements
				for(int j = 0; j<nElems+2; j++)
				{
					if(j==location)
					{
						long temp = a[j];
						a[j]=value;
					
						//the last value in array will be extended
						for (int k=nElems; k>j; k-- )
						{
							a[k]=a[k-1];
							
						}
						a[j+1]=temp;
						
					}
					System.out.print(a[j] + " ");
				}
				counter++;
			}
			
		}
		
				
	}*/
	
	public void insertByIndex(int position)
	{
		
		for(int i=0; i<nElems; i++)
		{
				if(i==position)
				{
					long temp = a[i];
					a[i]=a[nElems-1];
				
					//the last value in array will be extended
					for (int k=nElems; k>i; k-- )
					{
						a[k]=a[k-1];
						
					}
					a[i+1]=temp;
			}
		}
		
	}
	
	
	public int frequent(int[] n)
	{
		Arrays.sort(n);
	    
	    int count2 = 0;
	    int count1 = 0;
	    int frequent1 =0;
	    int frequent2 =0;


	    for (int i = 0; i < n.length; i++)
	    {
	    		frequent1 = n[i];
	            count1 = 0;    //see edit

	        for (int j = i + 1; j < n.length; j++)
	        {
	            if (frequent1 == n[j]) count1++;
	        }

	        if (count1 > count2)
	        {
	        	frequent2 = frequent1;
	                count2 = count1;
	        }

	        else if(count1 == count2)
	        {
	        	frequent2 = Math.min(frequent2, frequent1);
	        }
	    }

	    return frequent2;
	}
	
	public void deleteI(int position)
	{
		for(int k = 0; k<nElems; k++)
		{
			if (k == position)
			{
				a[k] = a[k+1];
			}
			else
				System.out.print(a[k] + " ");
		}
			
	}
	
	public void setnElems(int nElems) {
		this.nElems = nElems;
	}

	public int getnElems()
	{
		return nElems-1;
	}
	

}
