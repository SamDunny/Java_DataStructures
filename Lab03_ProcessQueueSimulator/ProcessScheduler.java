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
	
	public Process getCurrentProcess() {
		return this.currentProcess;
	}
	
	public void addProcess(Process aP) {
		if (currentProcess == null)
			this.currentProcess = aP;
		else
			this.processes.enqueue(aP);
	}
	
	public void runNextProcess() {
		this.currentProcess = processes.dequeue();
	}
	
	public void cancelCurrentProcess() {
		this.runNextProcess();
	}
	
	public void printProcessQueue() {
		this.processes.print_V();
	}
}
