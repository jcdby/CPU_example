/**
 * Keyboard.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-8
 */

package execute;

import java.util.StringTokenizer;

public class Keyboard extends Thread implements Parameters {
	
	private SynchronizedQueue readyQueue;
	private SynchronizedQueue inputQueue;
	private Memory mem;
	private String input = null;
	private MemCell mc = new MemCell(null);
	
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
	
	public Keyboard(SynchronizedQueue readyQueue, SynchronizedQueue inputQueue, Memory mem) {
		
		this.readyQueue = readyQueue;
		this.inputQueue = inputQueue;
		this.mem = mem;
		
	}
	
	public void run() {
		
		DataCell dc = new DataCell();
		PSWCell psw = new PSWCell();
		
		while(true) {
			
			if(inputQueue.isEmpty()) {
				try {
					Thread.sleep(400);
					//System.out.println("There is no process in inputqueue");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			else if(!inputQueue.isEmpty()) {
				
				int i;
				int index;
				int n;
				StringTokenizer asm;
				
				synchronized (mem) {
					i = inputQueue.peek();
					dc.setContent(mem.getMem(i * PCB_SIZE + PC_OFFSET));
					index = dc.getContent() - 1;
					asm = new StringTokenizer(mem.getMem(index).toLowerCase());

				}
				
				asm.nextToken();
				input = null;
				//System.out.println("ttttt");
				String temp = asm.nextToken();
				
				if(temp.compareTo("int") == 0) {
					//System.out.println("enter a int: ");
					ui.setJlInputText("---enter a int");
					mc.setContent(null);
					while(mc.getContent() == null) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					ui.display("You input " + mc.getContent());
					try {
						n = Integer.parseInt(mc.getContent());
					}
					catch (NumberFormatException ex) {
						System.out.println("error1 @ keyboard");
						//System.out.println("---not a int, input set to 0");
						ui.setJlInputText("---not a int, input set to 0");
						n = 0;
					}
				}
				
				else {
					ui.setJlInputText("---enter a char");
					mc.setContent(null);
					while(mc.getContent() == null) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					ui.display("You input " + mc.getContent());
					n = (int)mc.getContent().charAt(0);
				}
				
				ui.setJlInputText("");
					
				temp = asm.nextToken();
				//System.out.println(temp);
				
				if(temp.charAt(0) == 'r') {
						
					synchronized (mem) {
				
						i = inputQueue.dequeue();
						dc.setContent(temp);
						index = i * PCB_SIZE + REGISTER0_OFFSET + dc.getContent();
						mem.setMem(index, "#" + (new Integer(n)).toString());
						psw.setState(mem.getMem(i * PCB_SIZE + PSW_OFFSET));
						psw.clearState(UNINPUT_INTERRUPT);
						mem.setMem(i * PCB_SIZE + PSW_OFFSET, psw.toString());
						//System.out.println("Process " + i + " get input");
						ui.display("Process " + i + " get input");
						readyQueue.inqueue(i);
						ui.updateQueue();
					
					}
					
				}
					
				else {
						
					synchronized (mem) {
				
						i = inputQueue.dequeue();
						index = Integer.parseInt((mem.getMem(i * PCB_SIZE + DATAPOINTER_OFFSET)));
						//System.out.println(temp);
						index += Integer.parseInt(temp);
						mem.setMem(index, "#" + (new Integer(n)).toString());
						psw.setState(mem.getMem(i * PCB_SIZE + PSW_OFFSET));
						psw.clearState(UNINPUT_INTERRUPT);
						mem.setMem(i * PCB_SIZE + PSW_OFFSET, psw.toString());
						//System.out.println("Process " + i + " get input");
						readyQueue.inqueue(i);
						ui.display("Process " + i + " get input");
						ui.updateQueue();
					
					}
					
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
	 * Return the input.
	 */
	
	public String getInput() {
	
		return input;
	
	}

	/**
	 * Reset the input.
	 */
	
	public boolean setInput(String input) {
		
		//System.out.println(input);
	
		if(input == null) {
			this.input = input;
			return true;
		}
		else
			return false;
	
	}

	/**
	 * Return the mc.
	 */
	
	public MemCell getMc() {
	
		return mc;
	
	}

	/**
	 * Reset the mc.
	 */
	
	public void setMc(MemCell mc) {
	
		this.mc = mc;
	
	}

}
