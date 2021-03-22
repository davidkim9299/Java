package assignment2;

import java.util.*;

public class LinkList {
	
	private Link first;
	private Link last;
	
	LinkList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		if(last == null) {
			return true;
		}
		else {
			return false;
		}
	}

	//insert from last of linked list
	public void insertLast(String lName, String fName, long pNum) {
		Link newLink = new Link(lName, fName, pNum);
		if(isEmpty()) {
			first = newLink;
		}
		else {
			last.next = newLink;
		}
		last = newLink;
	}
	
	//sort linked list alphabetically by last name, but only consider the first letter
	public void sortedInsert(String lName, String fName, long pNum) {
		Link newLink = new Link(lName,fName,pNum);
		Link current = first;
		Link previous = null;
		while (current!=null && (int)current.lName.charAt(0) < (int)lName.charAt(0)){
			previous = current;
			current = current.next;
		}
			if (previous==null) {
				first = newLink;
				newLink.next = current;
			}
			else {
				previous.next = newLink;
				newLink.next = current;	
			}
		}
	
	//search link using given last name
	public void Search(String lname) {
		Link current = first;
		int count = 1;
		for(;;) {
			if(current.lName.equalsIgnoreCase(lname)) {
				System.out.println(lname + " is in original list of " + count);
				break;
			}
			else if(current.next == null) {
				System.out.println("cannot find");
				return;
			}
			else {
				current = current.next;
			}
			count ++;
		}
	}
	
	public void SortedSearch(String lname) {
		Link current = first;
		int count = 1;
		for(;;) {
			if(current.lName.equalsIgnoreCase(lname)) {
				System.out.println(lname + " is in sorted list of " + count);
				break;
			}
			else if(current.next == null) {
				System.out.println("cannot find");
				return;
			}
			else {
				current = current.next;
			}
			count ++;
		}
	}
	
	//delete link using give phone number
	public Link Delete(long key) {
		Link current = first;
		Link previous = first;
		while(current.pNumber!=key) {
		if(current.next == null) {
			return null;
		}
		else {
			previous = current;
			current = current.next;
		}
		}
		if(current==first) {
			first=first.next;
		}
		else
			previous.next=current.next;
		return current;
	}
	
	public Link SortedDelete(long key) {
		Link current = first;
		Link previous = first;
		while(current.pNumber!=key) {
		if(current.next == null) {
			return null;
		}
		else {
			previous = current;
			current = current.next;
		}
		}
		if(current==first) {
			first=first.next;
		}
		else
			previous.next=current.next;
		return current;
	}
	
	//display list
	public void DisplayList()
	{
		System.out.println("Contact List");
		System.out.println(String.format("%-16s%-16s%-20s", "Last Name", "First Name","Phone number"));
		System.out.println("--------------  --------------  -------------");
		Link current = first;        
		while(current != null)     
		{
			current.display();     
			current = current.next;  
		}
		System.out.println(" ");
	}

	//show operations when the program starts
	public static void showOperation() {
		System.out.println(" ");
		System.out.println(String.format("%-6s%-6s%-3s%-20s","Enter","'ADD'","to","add contact"));
		System.out.println(String.format("%-6s%-6s%-3s%-20s","Enter","'SER'","to","search contact"));
		System.out.println(String.format("%-6s%-6s%-3s%-20s","Enter","'DEL'","to","delete contact"));
		System.out.println(String.format("%-6s%-6s%-3s%-20s","Enter","'DSP'","to","display contact list"));
		System.out.println(String.format("%-6s%-6s%-3s%-20s","Enter","'SOR'","to","display sorted contact list"));
		System.out.println(String.format("%-6s%-6s%-3s%-20s","Enter","' E '","to","end program"));
		System.out.print("\nCode : ");
	}
	
	//all method from here are getting input from user
	public String getLastName() {
		System.out.print("Enter Last Name : ");
		String s = getString();
		return s;
	}
	
	public String getFirstName() {
		System.out.print("Enter First Name : ");
		String f = getString();
		return f;
	}
	
	public long getPhoneNumber() {
		System.out.print("Enter Phone Number (number only) : ");
		long p = getLong();
		return p;
	}
	
	public static String getString()
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		return s;
	}
	
	public long getLong()
	{
		Scanner sc = new Scanner(System.in);
		long l = sc.nextLong();
		return l;
	}
}
