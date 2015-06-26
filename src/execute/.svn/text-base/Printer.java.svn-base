/**
 * Printer.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-8
 */

package execute;

import java.util.StringTokenizer;

public class Printer extends Thread implements Parameters {
	
	private SynchronizedQueue readyQueue;
	private SynchronizedQueue printQueue;
	private Memory mem;
	
	private UI ui;
	
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
	
	}
	
	public Printer(SynchronizedQueue readyQueue, SynchronizedQueue printQueue, Memory mem) {
		
		this.readyQueue = readyQueue;
		this.printQueue = printQueue;
		this.mem = mem;
		
	}
	
	public void run() {
		
		DataCell dc = new DataCell();
		PSWCell psw = new PSWCell();
		
		while(true) {
			
			if(printQueue.isEmpty()) {
				try {
					Thread.sleep(500);
					//System.out.println("There is no process in printQueue");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			else if(!printQueue.isEmpty()) {
				
				int i;
				int index;
				StringTokenizer asm;
				
				String type;
				String arg;
				int n;
				
				ui.clearPrinter();
				
				while(true) {

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					String temp;
					
					synchronized (mem) {

						synchronized (printQueue) {
							i = printQueue.peek();
						}
						dc.setContent(mem.getMem(i * PCB_SIZE + PC_OFFSET));
						index = dc.getContent();
						System.out.println("index @ printer is " + index);
						temp = mem.getMem(index).toLowerCase();
						asm = new StringTokenizer(temp);
	
					}
					
//					System.out.println(temp);
					
					if(asm.nextToken().compareTo("print") != 0) {
						System.out.println("error0 @ printer");
						break;
					}
					
					type = asm.nextToken();
					
					if(type.compareTo("end") == 0) {
						break;
					}
					
					arg = asm.nextToken();
					System.out.println(arg);
					if(arg.charAt(0) == '#') {
						dc.setContent(arg);
						n = dc.getContent();
					}
					
					else if(arg.charAt(0) == 'r') {
						
						synchronized (mem) {
							
							synchronized (printQueue) {
								i = printQueue.peek();
								System.out.println("printer get process " + i);
								dc.setContent(arg);
								System.out.println("printer get from memory is " + i * PCB_SIZE + REGISTER0_OFFSET + dc.getContent());
								dc.setContent(mem.getMem(i * PCB_SIZE + REGISTER0_OFFSET + dc.getContent()));
								n = dc.getContent();
							}

							
						}
						
					}
					
					else {
						
						synchronized (mem) {

							synchronized (printQueue) {
								i = printQueue.peek();
								System.out.println("printer get process " + i);
								System.out.println("printer get from memory is " + arg);
								dc.setContent(mem.getProcessData(i, Integer.parseInt(arg)));
								n = dc.getContent();
							}
							
						}
						
					}
					
					if(type.compareTo("int") == 0) {
						ui.print(new Integer(n).toString());
					}
					else if(type.compareTo("char") == 0) {
						ui.print("" + (char)n);
					}
					else {
						System.out.println("error2 @ printer");
					}
					
					synchronized (mem) {

						synchronized (printQueue) {
							i = printQueue.peek();
							System.out.println("printer get process " + i);
							dc.setContent(mem.getMem(i * PCB_SIZE + PC_OFFSET));
							index = dc.getContent() + 1;
							mem.setMem(i * PCB_SIZE + PC_OFFSET, '#' + (new Integer(index).toString()));
						}
						
					}
				
				}
				
				//System.out.println("Print: " + printBuffer.toString());
				//System.out.println("process" + i + " print over");
				ui.display("process" + i + " print over");
				
				synchronized (mem) {

					synchronized (printQueue) {
						i = printQueue.dequeue();
					}
					System.out.println("printer get process " + i);
					dc.setContent(mem.getMem(i * PCB_SIZE + PC_OFFSET));
					index = dc.getContent() + 1;
					mem.setMem(i * PCB_SIZE + PC_OFFSET, '#' + (new Integer(index).toString()));
					psw.setState(mem.getMem(i * PCB_SIZE + PSW_OFFSET));
					psw.clearState(UNPRINT_INTERRUPT);
					mem.setMem(i * PCB_SIZE + PSW_OFFSET, psw.toString());
//					System.out.println("Process " + i + " print over");
					readyQueue.inqueue(i);
					
				}
				
			}
			
		}
		
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
	 * Return the printQueue.
	 */
	
	public SynchronizedQueue getprintQueue() {
	
		return printQueue;
	
	}

	/**
	 * Reset the printQueue.
	 */
	
	public void setprintQueue(SynchronizedQueue printQueue) {
	
		this.printQueue = printQueue;
	
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

}
