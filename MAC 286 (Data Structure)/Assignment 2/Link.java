package assignment2;

public class Link {
	public String lName;
	public String fName;
	public String nu;
	public long pNumber;
	public Link next;
	
	Link(String l, String f, long p) {
		lName = l;
		fName = f;
		pNumber = p;
		nu = String.valueOf(pNumber);
		next = null;
		
	}

	public void display() {
		System.out.println(String.format("%-16s%-16s%-20s", lName, fName, nu));
		
	}
}
