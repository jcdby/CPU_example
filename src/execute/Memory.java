/**
 * Memory.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-6
 */

package execute;

import java.io.*;

public class Memory implements Parameters {
	
	private MemCell memory[] = new MemCell[MEM_SIZE];
	private int numOfProcess = 0;
	private int dap = PCB_SIZE * MAX_PROCESS_NUM;	// Data Area Pointer
	private int das = 0;	// Data Area Size
	private SynchronizedQueue readyQueue;
	private SynchronizedQueue inputQueue;
	private SynchronizedQueue printQueue;
	
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
	
	public Memory(SynchronizedQueue readyQueue, SynchronizedQueue inputQueue, SynchronizedQueue printQueue) {
		
		for(int i = 0; i < memory.length; i++)
			memory[i] = new MemCell();
		this.readyQueue = readyQueue;
		this.inputQueue = inputQueue;
		this.printQueue = printQueue;
		
	}
	
	public synchronized void setMem(int i, String s) {
		System.out.println("setmem : i " + i + " " + s);
		memory[i].setContent(s);
		
	}
	
	public synchronized String getMem(int i) {

		return memory[i].getContent();
		
	}
	
	public synchronized void setProcessData(int id, int offset, String s) {
		
		int i = id * PCB_SIZE;
		if(offset < Integer.parseInt((memory[i + DBS_OFFSET].getContent())))
			memory[Integer.parseInt((memory[i + DATAPOINTER_OFFSET].getContent())) 
			       + offset].setContent(s);
		
	}
	
	public synchronized String getProcessData(int id, int offset) {
		
		int i = id * PCB_SIZE;
		if(offset < Integer.parseInt((memory[i + DBS_OFFSET].getContent())))
			return memory[Integer.parseInt((memory[i + DATAPOINTER_OFFSET].getContent())) 
			       + offset].getContent();
		else {
			System.out.println("Out of data block.");
			return null;
		}
		
	}
	
	public synchronized boolean addProcess(BufferedReader input) {
		
		if(numOfProcess >= 10) {
			ui.display("There are too many processes.");
			return false;
		}
		
		int i = das + dap;
		int j;
		
		String s;
		
		try {
			
			do {
				s = input.readLine();
				if(s == null) {
					ui.display("Not enough memory.");
				return false;
				}
			} while(s.compareToIgnoreCase("data") != 0);

			do {
				s = input.readLine();
				if((s == null) || (i >= MEM_SIZE)) {
					ui.display("Not enough memory.");
					return false;
				}
				if(s.charAt(0) == '#')
					memory[i++].setContent(s);
			} while(s.compareToIgnoreCase("enddata") != 0);
			
			j = i;

			do {
				s = input.readLine();
				if(s == null) {
					ui.display("Not enough memory.");
				return false;
				}
			} while(s.compareToIgnoreCase("begin") != 0);

			do {
				s = input.readLine();
				if((s == null) || (j >= MEM_SIZE)) {
					ui.display("Not enough memory.");
					return false;
				}
				if(s.compareToIgnoreCase("end") != 0) {
					memory[j++].setContent(s);
				}
				else
					break;
			} while(true);
			
			int k = numOfProcess * PCB_SIZE;
			memory[k++].setContent((new Integer(numOfProcess)).toString());
			memory[k++].setContent((new Integer(dap + das)).toString());
			memory[k++].setContent((new Integer(i - dap - das)).toString());
			memory[k++].setContent((new Integer(i)).toString());
			memory[k++].setContent((new Integer(j - i)).toString());
			memory[k++].setContent("#" + (new Integer(i)).toString());
			memory[k++].setContent("0");
			for(int m = 0; m < REGISTERS_SIZE - 2; m++)
				memory[k++].setContent("#0");
			
			readyQueue.inqueue(numOfProcess);
			numOfProcess++;
			das = j - dap;
			
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public synchronized boolean removeProcess(int id) {
		
		int i = id * PCB_SIZE;
		synchronized (inputQueue) {

			synchronized (printQueue) {

				synchronized (readyQueue) {

					inputQueue.update(id);
					printQueue.update(id);
					readyQueue.update(id);
					
					
					if(id < 0) {
						System.out.println("Invalid id.");
						return false;
					}
					
					else if(id >= numOfProcess) {
						System.out.println("process " + id + " is not exist.");
						return false;
					}
					
					else if(id == numOfProcess - 1) {
						das = das - Integer.parseInt(memory[i + DBS_OFFSET].getContent()) 
							- Integer.parseInt(memory[i + IBS_OFFSET].getContent());
						for(int j = i; j < i + PCB_SIZE; j++)
							memory[j].setContent(null);
					}
					
					else if(id < numOfProcess - 1) {
						int x = Integer.parseInt(memory[i + DATAPOINTER_OFFSET].getContent());
						int y = Integer.parseInt(memory[i + PCB_SIZE + DATAPOINTER_OFFSET].getContent());
						int count = das + dap - y;
						
						for(; count > 0; count--)
							memory[x++].setContent(memory[y++].getContent());
						
						count = numOfProcess - id - 1;
						int z = Integer.parseInt(memory[i + DBS_OFFSET].getContent()) 
							+ Integer.parseInt(memory[i + IBS_OFFSET].getContent());
						DataCell dc = new DataCell();
						for(int j = i + PCB_SIZE; count > 0; count--, j += PCB_SIZE) {
							memory[j].setContent((new Integer(
									Integer.parseInt(memory[j].getContent()) - 1)).toString());
							memory[j + DATAPOINTER_OFFSET].setContent((new Integer(
									Integer.parseInt(memory[j + DATAPOINTER_OFFSET].getContent()) - z)).toString());
							memory[j + INSTRUMENT_OFFSET].setContent((new Integer(
									Integer.parseInt(memory[j + INSTRUMENT_OFFSET].getContent()) - z)).toString());
							dc.setContent((memory[j + PC_OFFSET].getContent()));
							dc.setContent(dc.getContent() - z);
							memory[j + PC_OFFSET].setContent(dc.toString());
						}
						
						x = i + PCB_SIZE;
						count = (numOfProcess - id - 1) * PCB_SIZE;
						for(;count > 0; count--)
							memory[i++].setContent(memory[x++].getContent());
						
						y = (numOfProcess - 1) * PCB_SIZE;
						count = PCB_SIZE;
						for(;count > 0; count--)
							memory[y++].setContent(null);
							
					}
					
					numOfProcess--;

				}

			}

		}
		
		return true;
		
	}
	
	public synchronized boolean loadPCB(int processID, PCB pcb) {
		
		if(processID >= numOfProcess)
			return false;
		
		int i = processID * PCB_SIZE;
		
		pcb.setProcessID(Integer.parseInt(memory[i++].getContent()));
		pcb.setDataPointer(Integer.parseInt(memory[i++].getContent()));
		pcb.setDbs(Integer.parseInt(memory[i++].getContent()));
		pcb.setInstrumentPointer(Integer.parseInt(memory[i++].getContent()));
		pcb.setIbs(Integer.parseInt(memory[i++].getContent()));
		
		Registers rs = pcb.getRegisters();
		rs.getPc().setContent(memory[i++].getContent());
		rs.getPsw().setState(memory[i++].getContent());
		rs.getIr().setContent(memory[i++].getContent());
		rs.getAc().setContent(memory[i++].getContent());
		for(int j = 0; j < 8; j++)
			rs.getRn(j).setContent(memory[i++].getContent());
		
		return true;
		
	}
	
	public synchronized boolean savePCB(PCB pcb) {
		
		int i = pcb.getProcessID();
		if(i >= numOfProcess)
			return false;
		
		i = i * PCB_SIZE + 1;
		
		memory[i++].setContent((new Integer(pcb.getDataPointer())).toString());
		memory[i++].setContent((new Integer(pcb.getDbs())).toString());
		memory[i++].setContent((new Integer(pcb.getInstrumentPointer())).toString());
		memory[i++].setContent((new Integer(pcb.getIbs())).toString());
		
		Registers rs = pcb.getRegisters();
		memory[i++].setContent(rs.getPc().toString());
		memory[i++].setContent(rs.getPsw().toString());
		memory[i++].setContent(rs.getIr().toString());
		memory[i++].setContent(rs.getAc().toString());
		for(int j = 0; j < 8; j++)
			memory[i++].setContent(rs.getRn(j).toString());
		
		return true;
		
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer(2048);
		
		for(int i = 0; i < memory.length; i++)
			sb.append("" + i + " " + memory[i] + '\n');
		
		sb.append("numOfProcess " + numOfProcess + '\n');
		sb.append("dap " + dap + '\n');
		sb.append("das " + das + '\n');
		
		return sb.toString();
		
	}

}
