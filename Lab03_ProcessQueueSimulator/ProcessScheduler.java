// by Sam Dunny

public class ProcessScheduler {

	// instance variables
	private LinkedListQueue<Process> processes;
	private Process currentProcess;
	
	// default constructor
	public ProcessScheduler() {
		processes = new LinkedListQueue<Process>();
		currentProcess = null;
	}
	
	// returns the current process (accessor)
	public Process getCurrentProcess() {
		return this.currentProcess;
	}
	
	// enqueues a process to the queue
	public void addProcess(Process aP) {
		if (currentProcess == null)
			this.currentProcess = aP;
		else
			this.processes.enqueue(aP);
	}
	
	// sets current process to the first item in the queue, removes that item
	public void runNextProcess() {
		this.currentProcess = processes.dequeue();
	}
	
	// calls .runNextProcess
	public void cancelCurrentProcess() {
		this.runNextProcess();
	}
	
	// prints queue data (vertically)
	public void printProcessQueue() {
		this.processes.print_V();
	}
}
