package Project2;

/*
 * This is Dongryul Kim's assignment for CISC 3320
 * pid_manager
 * change this class to use multi-thread operation
 * remove user input.
 */

class Pid_Manager {
	final static int min_pid = 300;
	final static int max_pid = 5000;
	static int[] pids;
	
	public int allocate_map() {
		//create a map for pid. array range from 300 to 5000, index 0 to 4700
		pids = new int[max_pid-min_pid];
		//if fail to initialize map return -1
		if(pids == null) {
			return -1;
		}
		//initialize all pids to 0
		for (int i = 0; i<pids.length; i++) {
			pids[i] = 0;
		}
		//if success reutn 1
		return 1;
	}
	
	public synchronized int allocate_pid() {
		for(int i=min_pid; i<=max_pid; i++) {
			if(pids[i]==0) {
				pids[i]=1;
				return i;
			}
		}
		return -1;
	}
	
	public void release_pid(int pid) {
		if (pid < min_pid || pid > max_pid) {
			System.out.println("Pid is out of range");
		}
		pids[pid] = 0;
	}
	
}