/**
 * PCB.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-7
 */

package execute;

public class PCB {
	
	private int processID = -1;
	private int dataPointer;
	private int dbs = 0;	// Data Block Size
	private int instrumentPointer;
	private int ibs = 0;	// Instrument Block Size
	private Registers registers = new Registers();
	
	public PCB() {
		
	}

	/**
	 * Return the processID.
	 */
	
	public int getProcessID() {
	
		return processID;
	
	}

	/**
	 * Reset the processID.
	 */
	
	public void setProcessID(int processID) {
	
		this.processID = processID;
	
	}

	/**
	 * Return the registers.
	 */
	
	public Registers getRegisters() {
	
		return registers;
	
	}

	/**
	 * Reset the registers.
	 */
	
	public void setRegisters(Registers registers) {
	
		this.registers = registers;
	
	}

	/**
	 * Return the instrumentPointer.
	 */
	
	public int getInstrumentPointer() {
	
		return instrumentPointer;
	
	}

	/**
	 * Reset the instrumentPointer.
	 */
	
	public void setInstrumentPointer(int instrumentPointer) {
	
		this.instrumentPointer = instrumentPointer;
	
	}

	/**
	 * Return the ibs.
	 */
	
	public int getIbs() {
	
		return ibs;
	
	}

	/**
	 * Reset the ibs.
	 */
	
	public void setIbs(int ibs) {
	
		this.ibs = ibs;
	
	}

	/**
	 * Return the dataPointer.
	 */
	
	public int getDataPointer() {
	
		return dataPointer;
	
	}

	/**
	 * Reset the dataPointer.
	 */
	
	public void setDataPointer(int dataPointer) {
	
		this.dataPointer = dataPointer;
	
	}

	/**
	 * Return the dbs.
	 */
	
	public int getDbs() {
	
		return dbs;
	
	}

	/**
	 * Reset the dbs.
	 */
	
	public void setDbs(int dbs) {
	
		this.dbs = dbs;
	
	}

	/**
	 * Return the processSize.
	 */
	
	public int getProcessSize() {
	
		return ibs + dbs;
		
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("processID " + processID + '\n');
		sb.append("dataPointer " + dataPointer + '\n');
		sb.append("dbs " + dbs + '\n');
		sb.append("instrumentPointer " + instrumentPointer + '\n');
		sb.append("ibs " + ibs + '\n');
		sb.append(registers.toString());
		
		return sb.toString();
		
	}

}
