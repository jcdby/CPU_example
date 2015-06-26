/**
 * Registers.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-7
 */

package execute;

public class Registers implements Parameters {

	private DataCell pc = new DataCell();
	private PSWCell psw = new PSWCell();
	private InstrumentCell ir = new InstrumentCell();
	private DataCell ac = new DataCell();
	private DataCell r[] = {new DataCell(), new DataCell(), 
			new DataCell(), new DataCell(), new DataCell(), 
			new DataCell(), new DataCell(), new DataCell()};
	
	public Registers() {
		
	}

	/**
	 * Return the psw.
	 */
	
	public PSWCell getPsw() {
	
		return psw;
	
	}

	/**
	 * Reset the psw.
	 */
	
	public void setPsw(PSWCell psw) {
	
		this.psw = psw;
	
	}

	/**
	 * Return the pc.
	 */
	
	public DataCell getPc() {
	
		return pc;
	
	}

	/**
	 * Reset the pc.
	 */
	
	public void setPc(DataCell pc) {
	
		this.pc = pc;
	
	}

	/**
	 * Return the ir.
	 */
	
	public InstrumentCell getIr() {
	
		return ir;
	
	}

	/**
	 * Reset the ir.
	 */
	
	public void setIr(InstrumentCell ir) {
	
		this.ir = ir;
	
	}

	/**
	 * Return the ac.
	 */
	
	public DataCell getAc() {
	
		return ac;
	
	}

	/**
	 * Reset the ac.
	 */
	
	public void setAc(DataCell ac) {
	
		this.ac = ac;
	
	}

	/**
	 * Return the r.
	 */
	
	public DataCell[] getR() {
	
		return r;
	
	}

	/**
	 * Reset the r.
	 */
	
	public void setR(DataCell[] r) {
	
		this.r = r;
	
	}

	/**
	 * Return the r.
	 */
	
	public DataCell getRn(int x) {
	
		return r[x];
	
	}

	/**
	 * Reset the r.
	 */
	
	public void setRn(int x, DataCell r) {
	
		this.r[x] = r;
	
	}

	/**
	 * Return the DataRegister.
	 */
	
	public DataCell getDataRegister(String name) {

		name = name.toLowerCase();
		
		if(name.compareTo("ac") == 0)
			return ac;
		else if(name.compareTo("pc") == 0)
			return pc;
		else if(name.compareTo("r0") == 0)
			return r[0];
		else if(name.compareTo("r1") == 0)
			return r[1];
		else if(name.compareTo("r2") == 0)
			return r[2];
		else if(name.compareTo("r3") == 0)
			return r[3];
		else if(name.compareTo("r4") == 0)
			return r[4];
		else if(name.compareTo("r5") == 0)
			return r[5];
		else if(name.compareTo("r6") == 0)
			return r[6];
		else if(name.compareTo("r7") == 0)
			return r[7];
		
		///System.out.println("there is not a DataRegister named " + name + " exist.");
		
		return null;
	
	}

	/**
	 * Reset the DataRegister.
	 */
	
	public void setDataRegister(String name, DataCell register) {

		name = name.toLowerCase();
		
		if(name.compareTo("ac") == 0)
			ac = register;
		else if(name.compareTo("pc") == 0)
			pc = register;
		else if(name.compareTo("r0") == 0)
			r[0] = register;
		else if(name.compareTo("r1") == 0)
			r[1] = register;
		else if(name.compareTo("r2") == 0)
			r[2] = register;
		else if(name.compareTo("r3") == 0)
			r[3] = register;
		else if(name.compareTo("r4") == 0)
			r[4] = register;
		else if(name.compareTo("r5") == 0)
			r[5] = register;
		else if(name.compareTo("r6") == 0)
			r[6] = register;
		else if(name.compareTo("r7") == 0)
			r[7] = register;
		
		//System.out.println("there is not a DataRegister named " + name + " exist.");
	
	}

	/**
	 * Return the SIZE.
	 */
	
	public static int getSIZE() {
	
		return REGISTERS_SIZE;
	
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("pc " + pc.toString() + '\n');
		sb.append("ir " + ir.toString() + '\n');
		sb.append("ac " + ac.toString() + '\n');
		sb.append("psw " + psw.toString() + '\n');
		
		for(int i = 0; i < 8; ++i)
			sb.append("r" + i + ' ' + r[i].toString() + '\n');
		
		return sb.toString();
		
	}

}
