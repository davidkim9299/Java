package assignment2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkList Original = new LinkList();
		LinkList Sorted = new LinkList();
		String Repeat;
		
		System.out.println("Phone Book Contact List");
		
		do {
			LinkList.showOperation();
			String op = LinkList.getString();
			if(op.equalsIgnoreCase("add")) {
				String lName = Original.getLastName();
				String fName = Original.getFirstName();
				long pNum = Original.getPhoneNumber();
				Original.insertLast(lName.toUpperCase(), fName.toUpperCase(), pNum);
				Sorted.sortedInsert(lName.toUpperCase(), fName.toUpperCase(), pNum); 
			}
			else if(op.equalsIgnoreCase("ser")) {
				String lName = Original.getLastName();
				Original.Search(lName);
				Sorted.SortedSearch(lName);
			}
			else if(op.equalsIgnoreCase("del")) {
				long pNum = Original.getPhoneNumber();
				Original.Delete(pNum);
				Sorted.SortedDelete(pNum);
			}
			else if(op.equalsIgnoreCase("sor")) {
				Sorted.DisplayList();
			}
			else if(op.equalsIgnoreCase("dsp")) {
				Original.DisplayList();
			}
			else if(op.equalsIgnoreCase("e")) {
				break;
			}
			else {
				System.out.println("Please enter valid code");
			}
		System.out.print("Continue? (y/n) : ");

		Repeat = LinkList.getString();
		} while(Repeat.equalsIgnoreCase("y"));	
		System.out.println("Bye");
	}
}
