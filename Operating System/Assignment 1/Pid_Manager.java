package Project1;

import java.util.Scanner;

class Pid_Manager {
	static Scanner sc = new Scanner(System.in);
	final static int min_pid = 300;
	final static int max_pid = 5000;
	static int[] pids;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(allocate_map());
		
		//do-whil loop statement
		String choice = "yes";
		while(choice.equalsIgnoreCase("yes")) {
			System.out.println("\nEnter 1 to allocate pid");
			System.out.println("Enter 2 to release pid");
			System.out.println("Enter 3 to see all allocated pids");
			System.out.print("Enter: ");
			
			int select = sc.nextInt();
			//allocate pid
			if(select == 1) {
				System.out.println(allocate_pid());
			}
			//release pid
			if(select == 2) {
				System.out.print("\nEnter a pid you want to release: ");
				int pid = sc.nextInt();
				release_pid(pid);
			}
			//see all allocated pid
			if(select == 3) {
				browse_allocated_pid();
			}
		
			System.out.print("\nContinue? (yse/no): ");
			choice = sc.next();
			if(choice.equalsIgnoreCase("yes")) {
				continue;
			}
			else if(choice.equalsIgnoreCase("no")) {
				break;
			}
			else {
				System.out.println("Wrong input. Try again");
				System.out.print("\nContinue? (yse/no): ");
				choice = sc.next();
			}
		
		}
		
		
	}
	
	public static int allocate_map() {
		//create a map for pid. array range from 300 to 5000, index 0 to 4700
		pids = new int[max_pid-min_pid];
		//if fail to initialize map return -1
		if(pids == null) {
			System.out.print("### Map result: ");
			return -1;
		}
		//initialize all pids to 0
		for (int i = 0; i<pids.length; i++) {
			pids[i] = 0;
		}
		//if success reutn 1
		System.out.print("### Map result: ");
		return 1;
		
	}
	
	public static int allocate_pid() {
		//if map is not created return 01
		if(pids == null) {
			System.out.print("map is not initialized. result: ");
			return -1;
		}
		//get an input from user
		System.out.print("\nEnter a pid you want to allocate (300-5000): ");
		int pid = sc.nextInt();
		//set index for pid[]
		int index = pid-min_pid;
		
		//if pid is already allocated,
		//print error message with pid
		if(pids[index] == 1) {
			System.out.print("The pid you entered is already allocated. code: ");
			return -1;
		}
		
		//if pid is not allocated,
		//allocate pid
		if(pids[index] == 0) {
			pids[index] = 1;
		}
		System.out.print("Allocated pid: ");
		return pid;
	}
	
	
	public static void release_pid(int pid) {
		//if map is not created, return -1
		if (pids == null) {
			System.out.println("map is not initialized.");
			return;
		}
		//if entered pid is out of range, show error message
		if (pid < min_pid || pid > max_pid) {
			System.out.println("pid is out of range");
		}
		//set index of pids[]
		int index = pid - min_pid;
		//if pid[index] == 0, that means pid is not allocated
		//therefore, display "already released"
		if(pids[index] == 0) {
			System.out.println("pid is already released");
			return;
		}
		//if pid does not meet the above condition,
		//pid is released.
		System.out.println("pid " + pid + " released");
		pids[index] = 0;
	}
	
	//show all allocated pids
	public static void browse_allocated_pid() {
		System.out.print("\nAllcoted pids: ");
		for(int i = 0; i < pids.length; i++) {
			//if pid is allocated, display
			if(pids[i]==1) {
				System.out.print(i+min_pid + " ");
			}
		}
	}
}
