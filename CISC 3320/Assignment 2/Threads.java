package Project2;

/*
 * This is Dongryul Kim's assignment for CISC 3320
 * pid_manager
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.Thread.currentThread;

public class Threads implements Runnable{
	
	public int thread_id;
	private int sleep_time;
	private Pid_Manager pids;
	
	Threads(int thread_id, int sleep_time, Pid_Manager pids){
		this.thread_id = thread_id;
		this.sleep_time = sleep_time;
		this.pids = pids;
	}
	
	/*
	 * Each thread requests an pid
	 * If a pid is used by another thread, the other thread waits for the pid becomes available
	 */
	@Override
	public void run() {
		Integer npid;
		//get new pid
		npid = pids.allocate_pid();
		//show running thread with requested pid and random sleep time
		System.out.println(currentThread().getName() + " is created. Requests PID: " + npid + " || Sleep time: " + sleep_time);
		//if the value of npid equals to -1, it means the pid is already allocated.
		while(npid == -1) {
			System.out.println("Pid is already allocated");
			npid = pids.allocate_pid();
		}
		//print allocated pid to thread
		System.out.println("PID " + npid + " is allocated to " + currentThread().getName());
		currentThread().setName(npid.toString());
				
		//allocated pid is sotred to release_pid
		int release_pid = Integer.valueOf(currentThread().getName());
		System.out.println("%%%% Terminate thread " + currentThread().getName() +".....");
		
		//release pid
		pids.release_pid(release_pid);
		System.out.println("@@@@ Pid " + release_pid + " has been released");
	}
	
	
	public static class ThreadPool {
		public static void main(String args[]) {
			
			Pid_Manager pids = new Pid_Manager();
			
			//check if the map is allocated and initialized
			if(pids.allocate_map() == 1) {
				System.out.println("##### succeeded to create a map for pids #####\n");
			}
			else {
				System.out.println("##### Failed to create a map for pids #####\n");
			}
			
			//specify the number of thread in each pool using newFixedThreadpool
			ExecutorService pool1 = Executors.newFixedThreadPool(100);
			ExecutorService pool2 = Executors.newFixedThreadPool(100);
			for(int i=0; i<100; i++) {
				Threads tr1 = new Threads(i, (int)(Math.random()*100+1),pids);
				pool1.execute(tr1);
			}
			for(int i=0; i<100; i++) {
				Threads tr2 = new Threads(i, (int)(Math.random()*100+1),pids);
				pool2.execute(tr2);
			}
			
			
			
			//shutdown method closes the ExceutorService
			pool1.shutdown();
			pool2.shutdown();
			
			
			//print 'finished' when the threads in each pool totally terminated
			while (!pool1.isTerminated()) {}
			System.out.println("\n##### Finished Pool1 #####\n");
            
			
           		while (!pool2.isTerminated()) {}
            		System.out.println("\n##### Finished Pool2 #####\n");
           
		}
	}

}
