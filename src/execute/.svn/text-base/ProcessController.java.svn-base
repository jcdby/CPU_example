/**
 * ProcessController.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-9
 */

package execute;

public class ProcessController extends Thread implements Parameters {
	
	private PCB pcb = new PCB();
	private AsmExecuter asm;
	private Memory mem;
	private Keyboard keyboard;
	private Printer printer;
	private SynchronizedQueue readyQueue;
	private SynchronizedQueue inputQueue;
	private SynchronizedQueue printQueue;
	
	private UI ui;
	private RunningMode mode;
	
	/**
	 * Return the ui.
	 */
	
	public UI getUi() {
	
		return ui;
	
	}

	/**
	 * Reset the ui.
	 */
	
	public void setUi(UI ui) {
	
		this.ui = ui;
		asm.setUi(ui);
		mem.setUi(ui);
		readyQueue.setUi(ui);
		inputQueue.setUi(ui);
		printQueue.setUi(ui);
		keyboard.setUi(ui);
		printer.setUi(ui);
	
	}

	public ProcessController(SynchronizedQueue readyQueue, SynchronizedQueue inputQueue, SynchronizedQueue printQueue, Memory mem, Keyboard keyboard, Printer printer) {

		this.readyQueue = readyQueue;
		this.inputQueue = inputQueue;
		this.printQueue = printQueue;
		this.mem = mem;
		this.keyboard = keyboard;
		this.printer = printer;
		asm = new AsmExecuter(mem);
	}
	
	public void run() {
		
		int processID;
		Registers rs;
		DataCell pc;
		PSWCell psw;
		int count;
		
		while(true) {
			
			if(readyQueue.isEmpty()) {
				try {
					Thread.sleep(400);
					//System.out.println("There is no process in readyqueue");
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
			else {
				
				processID = readyQueue.dequeue();
				mem.loadPCB(processID, pcb);
				asm.reset(pcb);
				rs = pcb.getRegisters();
				pc = rs.getPc();
				psw = rs.getPsw();
				count = 20;
				ui.display("Process " + processID + " running");
				ui.updatePCB();
				//System.out.println("Process " + processID + " running");
				
				while(true) {
					
					if(mode.getMode() == RunningMode.AUTO) {
						try {
							Thread.sleep(ui.getSleepTime());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					else {
						while(!mode.getButtonPressed() && (mode.getMode() != RunningMode.AUTO)) {
							try {
								Thread.sleep(20);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						ui.enableButton();
					}
					
					if(count-- == 0) {
						mem.savePCB(pcb);
						//ui.display("Process " + processID + " use up time slice");
						//System.out.println(pcb.toString());
						readyQueue.inqueue(processID);
						ui.updateQueue();
						ui.updatePCB();
						break;
					}

					if(psw.getState(HALT) != 0) {
						//System.out.println("Process " + processID + " over");
						ui.display("Process " + processID + " over");
						//System.out.println(pcb.toString());
						ui.updatePCB();
						mem.removeProcess(processID);
						break;
					}
					else if(psw.getState(DIVBYZERO) != 0) {
						//System.out.println(" Divided by zero, process " + processID + " terminated");
						ui.display("Divided by zero, Process " + processID + " terminated");
						//System.out.println(pcb.toString());
						ui.updatePCB();
						mem.removeProcess(processID);
						break;
					}
					else if(psw.getState(OVERFlOW) != 0) {
						//System.out.println("Overflow, process " + processID + " process terminated");
						//System.out.println(pcb.toString());
						ui.display("Process " + processID + " overflow process terminated");
						ui.updatePCB();
						mem.removeProcess(processID);
						break;
					}
					else if(psw.getState(INPUT_INTERRUPT) != 0) {
						mem.savePCB(pcb);
						//System.out.println("Process " + processID + " is waiting for input");
						//System.out.println(pcb.toString());
						ui.display("Process " + processID + " waiting for input");
						inputQueue.inqueue(processID);
						ui.updatePCB();
						break;
					}
					else if(psw.getState(PRINT_INTERRUPT) != 0) {
						mem.savePCB(pcb);
						//System.out.println("Process " + processID + " waiting for print");
						//System.out.println(pcb.toString());
						printQueue.inqueue(processID);
						ui.display("Process " + processID + " waiting for print");
						ui.updatePCB();
						break;
					}
					
					asm.execute(mem.getMem(pc.getContent()));
					ui.updatePCB();
						
				}
				
			}
			
		}
		
	}

	/**
	 * Return the asm.
	 */
	
	public AsmExecuter getAsm() {
	
		return asm;
	
	}

	/**
	 * Reset the asm.
	 */
	
	public void setAsm(AsmExecuter asm) {
	
		this.asm = asm;
	
	}

	/**
	 * Return the mem.
	 */
	
	public Memory getMem() {
	
		return mem;
	
	}

	/**
	 * Reset the mem.
	 */
	
	public void setMem(Memory mem) {
	
		this.mem = mem;
	
	}

	/**
	 * Return the keyboard.
	 */
	
	public Keyboard getKeyboard() {
	
		return keyboard;
	
	}

	/**
	 * Reset the keyboard.
	 */
	
	public void setKeyboard(Keyboard keyboard) {
	
		this.keyboard = keyboard;
	
	}

	/**
	 * Return the readyQueue.
	 */
	
	public SynchronizedQueue getReadyQueue() {
	
		return readyQueue;
	
	}

	/**
	 * Reset the readyQueue.
	 */
	
	public void setReadyQueue(SynchronizedQueue readyQueue) {
	
		this.readyQueue = readyQueue;
	
	}

	/**
	 * Return the inputQueue.
	 */
	
	public SynchronizedQueue getInputQueue() {
	
		return inputQueue;
	
	}

	/**
	 * Reset the inputQueue.
	 */
	
	public void setInputQueue(SynchronizedQueue inputQueue) {
	
		this.inputQueue = inputQueue;
	
	}

	/**
	 * Return the pcb.
	 */
	
	public PCB getPcb() {
	
		return pcb;
	
	}

	/**
	 * Reset the pcb.
	 */
	
	public void setPcb(PCB pcb) {
	
		this.pcb = pcb;
	
	}

	/**
	 * Return the mode.
	 */
	
	public RunningMode getMode() {
	
		return mode;
	
	}

	/**
	 * Reset the mode.
	 */
	
	public void setMode(RunningMode mode) {
	
		this.mode = mode;
	
	}
	
}
