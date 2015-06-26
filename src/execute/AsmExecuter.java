/**
 * AsmExecuter.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-7
 */
package execute;

import java.io.*;
import java.util.StringTokenizer;

public class AsmExecuter implements Parameters {
	
	private Registers registers;
	private PSWCell psw;
	private DataCell pc;
	private DataCell ac;
	private DataCell dc = new DataCell();
	private Memory mem;
	private int processID = -1;
	
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

	public static void main(String[] args) throws IOException {
//
//		Memory mem = new Memory();
//		File file = new File("./1.txt");
//		file.createNewFile();
//		FileReader input = new FileReader(file);
//		mem.addProcess(new BufferedReader(input));
//		System.out.println(mem);
//		PCB pcb = new PCB();
//		mem.loadPCB(0, pcb);
//		Registers rs = pcb.getRegisters();
//		int pc = rs.getPc().getContent();
//		System.out.println(pc);
//		
//		AsmExecuter exe = new AsmExecuter(mem);
//		exe.reset(pcb);
//		
//		for(int i = 0; i < 7; i++) {
//			exe.execute(mem.getMem(pc));
//			pc = rs.getPc().getContent();
//			System.out.println(pcb.getRegisters());
//		}
//		
//		mem.savePCB(pcb);
//		System.out.println(mem);

	}

	public AsmExecuter(Memory mem) {
		
		this.registers = null;
		this.mem = mem;
		
	}
	
	public void execute(String s) {
		//System.out.println("+++++++++" + s);
		s = s.toLowerCase();
		System.out.println("asm " + s);
		registers.getIr().setContent(s);
		
		StringTokenizer tokens = new StringTokenizer(s);
		if(tokens.countTokens() < 1)
			System.out.println("error @ execute");
		
		String label = tokens.nextToken();
		String arg[] = new String[tokens.countTokens()];
		for(int i = 0; i < arg.length; i++)
			arg[i] = tokens.nextToken();
		
		if(label.compareTo("inc") == 0)
			inc(arg);
		else if(label.compareTo("dec") == 0)
			dec(arg);
		else if(label.compareTo("neg") == 0)
			neg(arg);
		else if(label.compareTo("add") == 0)
			add(arg);
		else if(label.compareTo("mul") == 0)
			mul(arg);
		else if(label.compareTo("div") == 0)
			div(arg);
		else if(label.compareTo("and") == 0)
			and(arg);
		else if(label.compareTo("or") == 0)
			or(arg);
		else if(label.compareTo("xor") == 0)
			xor(arg);
		else if(label.compareTo("not") == 0)
			not(arg);
		else if(label.compareTo("cmp") == 0)
			cmp(arg);
		else if(label.compareTo("jmp") == 0)
			jmp(arg);
		else if(label.compareTo("loopn") == 0)
			loopn(arg);
		else if(label.compareTo("loopnz") == 0)
			loopnz(arg);
		else if(label.compareTo("loopz") == 0)
			loopz(arg);
		else if(label.compareTo("loopp") == 0)
			loopp(arg);
		else if(label.compareTo("loopzp") == 0)
			loopzp(arg);
		else if(label.compareTo("mov") == 0)
			mov(arg);
		else if(label.compareTo("in") == 0)
			in(arg);
		else if(label.compareTo("out") == 0)
			out(arg);
		else if(label.compareTo("print") == 0)
			print(arg);
		else if(label.compareTo("halt") == 0)
			halt(arg);
		else
			System.out.println("errer1 @ execute");
		
	}
	
	private boolean overFlowCheck(int n) {
		
		if(n <= MAX && n >=MIN)
			return false;
		else {
			psw.setState(OVERFlOW);
			return true;
		}
		
	}
	
	private void pcINC() {
		
		int i = pc.getContent();
		if(i >= 0 && i < MEM_SIZE - 1)
			pc.setContent(i + 1);
		else
			pc.setContent(0);
		
	}
	
	private void inc(String arg[]) {
		
		if(!isR(arg[0]))
			System.out.println("error0 @ inc");
		
		DataCell dr = registers.getDataRegister(arg[0]);
		int result = dr.getContent() + 1;
		
		if(overFlowCheck(result))
			return;
		
		dr.setContent(result);
		pcINC();
		
	}
	
	private void dec(String arg[]) {
		
		if(!isR(arg[0]))
			System.out.println("error0 @ dec");
		
		DataCell dr = registers.getDataRegister(arg[0]);
		int result = dr.getContent() - 1;
		
		if(overFlowCheck(result))
			return;
		
		dr.setContent(result);
		pcINC();
		
	}
	
	private void neg(String arg[]) {
		
		if(!isR(arg[0]))
			System.out.println("error0 @ neg");
		
		DataCell dr = registers.getDataRegister(arg[0]);
		int result = -dr.getContent();
		
		if(overFlowCheck(result))
			return;
		
		dr.setContent(result);
		pcINC();
		
	}
	
	private void add(String arg[]) {
		
		int result = 0;
		
		if(!isR(arg[0]))
			System.out.println("error0 @ add");
		
		DataCell dr = registers.getDataRegister(arg[0]);
		result = dr.getContent();
		
		if(isR(arg[1])) {
			dr = registers.getDataRegister(arg[1]);
			result += dr.getContent();
		}
		else {
			ac.setContent(arg[1]);
			if(overFlowCheck(ac.getContent()))
				return;
			result += ac.getContent();
		}
		
		if(overFlowCheck(result))
			return;
		
		ac.setContent(result);
		pcINC();
		
	}
	
	private void mul(String arg[]) {
		
		int result = 1;
		
		if(!isR(arg[0]))
			System.out.println("error0 @ mul");
		
		DataCell dr = registers.getDataRegister(arg[0]);
		
		result = dr.getContent();
		
		if(isR(arg[1])) {
			dr = registers.getDataRegister(arg[1]);
			result *= dr.getContent();
		}
		else {
			ac.setContent(arg[1]);
			if(overFlowCheck(ac.getContent())) {
				return;
			}
			result *= ac.getContent();
		}
		
		if(overFlowCheck(result))
			return;
		
		ac.setContent(result);
		pcINC();
		
	}
	
	private void div(String arg[]) {
		
		int result = 0;
		
		if(!isR(arg[0]))
			System.out.println("error0 @ add");
		
		DataCell dr = registers.getDataRegister(arg[0]);
		
		result = dr.getContent();
		
		int temp = 1;
		
		if(isR(arg[1])) {
			dr = registers.getDataRegister(arg[1]);
			temp = dr.getContent();
		}
		else {
			ac.setContent(arg[1]);
			temp = ac.getContent();
			if(overFlowCheck(temp))
				return;
		}
		
		if(temp == 0)
			divByZero();
		else
			ac.setContent(result / temp);
		
		pcINC();
		
	}
	
	private void divByZero() {
		
		psw.setState(DIVBYZERO);
		
	}
	
	private void and(String arg[]) {
		
		int result = 0;
		
		if(!isR(arg[0]))
			System.out.println("error0 @ mul");
		
		DataCell dr = registers.getDataRegister(arg[0]);
		
		result = dr.getContent();
		
		if(isR(arg[1])) {
			dr = registers.getDataRegister(arg[1]);
			result = result & dr.getContent();
		}
		else {
			ac.setContent(arg[1]);
			result = result & ac.getContent();
		}
		
		ac.setContent(result);
		pcINC();
		
	}
	
	private void or(String arg[]) {
		
		int result = 0;
		
		if(!isR(arg[0]))
			System.out.println("error0 @ or");
		
		DataCell dr = registers.getDataRegister(arg[0]);
		
		result = dr.getContent();
		
		if(isR(arg[1])) {
			dr = registers.getDataRegister(arg[1]);
			result = result | dr.getContent();
		}
		else {
			ac.setContent(arg[1]);
			result = result | ac.getContent();
		}
		
		ac.setContent(result);
		pcINC();
		
	}
	
	private void xor(String arg[]) {
		
		int result = 0;
		int i, j;
		
		if(!isR(arg[0]))
			System.out.println("error0 @ xor");
		
		DataCell dr = registers.getDataRegister(arg[0]);
		
		i = dr.getContent();
		
		if(isR(arg[1])) {
			dr = registers.getDataRegister(arg[1]);
			j = dr.getContent();
		}
		else {
			ac.setContent(arg[1]);
			j = ac.getContent();
		}
		
		result = (i & (Integer.MAX_VALUE - j)) | (j & (Integer.MAX_VALUE - i));
		result = result & MASK;
		
		ac.setContent(result);
		pcINC();
		
	}
	
	private void not(String arg[]) {
		
		int result = 0;
		
		if(!isR(arg[0]))
			System.out.println("error0 @ not");
		
		DataCell dr = registers.getDataRegister(arg[0]);
		
		result = dr.getContent();
		
		result = Integer.MAX_VALUE - result;
		result = result & MASK;
		
		ac.setContent(result);
		pcINC();
		
	}
	
	private void cmp(String arg[]) {
		
		int result = 0;
		if(!isR(arg[0]))
			System.out.println("error0 @ cmp");
		
		DataCell dr = registers.getDataRegister(arg[0]);
		
		result = dr.getContent();
		
		if(isR(arg[1])) {
			dr = registers.getDataRegister(arg[1]);
			result -= dr.getContent();
		}
		else {
			dc.setContent(arg[1]);
			result -= dc.getContent();
		}

		setPSW(result);

		pcINC();
		
	}
	
	private void jmp(String arg[]) {
		
		int result = 0;
		
		if(isR(arg[0]))
			System.out.println("error0 @ jmp");
		
		ac.setContent(arg[0]);
		result = ac.getContent();
		result += pc.getContent();
		
		if(result < 0 && result > 1023)
			System.out.println("error1 @ jmp");
		
		pc.setContent(result);
		
	}

	private void loopn(String arg[]) {
		
		int result = 0;
		
		if(isR(arg[0]))
			System.out.println("error0 @ loopn");

		ac.setContent(arg[0]);
		result = ac.getContent();
		result += pc.getContent();
		
		if(result >= 0 && result <= 1023)
			System.out.println("error1 @ loopn");
		
		if(psw.getState(NEGATIVE) != 0)
			pc.setContent(result);
		else
			pcINC();
		
	}
	
	private void loopnz(String arg[]) {
		
		int result = 0;
		
		if(isR(arg[0]))
			System.out.println("error0 @ loopnz");

		dc.setContent(arg[0]);
		result = dc.getContent();
		result += pc.getContent();
		
		if(result < 0 && result > 1023) {
			System.out.println("error1 @ loopnz");
		}
		
		if((psw.getState(NEGATIVE) != 0) || 
				(psw.getState(ZERO) != 0))
			pc.setContent(result);
		else
			pcINC();
		
	}
	
	private void loopz(String arg[]) {
		
		int result = 0;
		
		if(isR(arg[0]))
			System.out.println("error0 @ loopz");

		ac.setContent(arg[0]);
		result = ac.getContent();
		result += pc.getContent();
		
		if(result >= 0 && result <= 1023)
			System.out.println("error1 @ loopz");
		
		if(psw.getState(ZERO) != 0)
			pc.setContent(result);
		else
			pcINC();
		
	}
	
	private void loopp(String arg[]) {
		
		int result = 0;
		
		if(isR(arg[0]))
			System.out.println("error0 @ loopp");

		ac.setContent(arg[0]);
		result = ac.getContent();
		result += pc.getContent();
		
		if(result < 0 || result >= 1023)
			System.out.println("error1 @ loopp");
		
		if(psw.getState(POSITIVE) != 0)
			pc.setContent(result);
		else
			pcINC();
		
	}
	
	private void loopzp(String arg[]) {
		
		int result = 0;
		
		if(isR(arg[0]))
			System.out.println("error0 @ loopzp");

		ac.setContent(arg[0]);
		result = ac.getContent();
		result += pc.getContent();
		
		if(result >= 0 && result <= 1023)
			System.out.println("error1 @ loopzp");
		
		if((psw.getState(POSITIVE) != 0) || 
				(psw.getState(ZERO) != 0))
			pc.setContent(result);
		else
			pcINC();
		
	}
	
	/**
	 * mov push pop call ret is left for finish.///
	 */
	
	private void mov(String arg[]) {
		
		int result = 0;
		int offset = 0;
		String s;
		DataCell temp = new DataCell();
		
		DataCell dr = registers.getDataRegister(arg[0]);
		
		if(dr == null) {
			temp.setContent(Integer.parseInt(arg[0]));
			offset = temp.getContent();
			s = mem.getProcessData(processID, offset);
			temp.setContent(s);
			result = temp.getContent();
		}
		else
			result = dr.getContent();

		dr = registers.getDataRegister(arg[1]);
		
		if(dr == null) {
			temp.setContent(Integer.parseInt(arg[1]));
			offset = temp.getContent();
			temp.setContent(result);
			s = (temp.toString());
			mem.setProcessData(processID, offset, s);
		}
		else {
			dr.setContent(result);
		}
		
		pcINC();
		
	}
	
	private void in(String s[]) {
		
		psw.setState(INPUT_INTERRUPT);
		pcINC();
		
	}
	
	private void out(String arg[]) {
		
		if(arg.length != 2) {
			System.out.println("error0 @ out");
			return;
		}
		
		String out = "";
		//System.out.println(arg[1]);
		int n;
		if(arg[1].charAt(0) == 'r') {
			n = registers.getDataRegister(arg[1]).getContent();
		}
		else if(arg[1].charAt(0) == '#') {
			dc.setContent(arg[1]);
			n = dc.getContent();
		}
		else {
			dc.setContent(mem.getProcessData(processID, Integer.parseInt(arg[1])));
			n = dc.getContent();
		}
		
		//System.out.println("n = " + n);
		
		
		if(arg[0].compareTo("int") == 0) {
			out = (new Integer(n)).toString();
		}
		else if(arg[0].compareTo("char") == 0) {
			out = "" + (char)n;
		}
		else {
			System.out.println("error1 @ out");
		}
		
		//System.out.println(out);
		ui.display(out);
		
		pcINC();
		
	}
	
	private void print(String s[]) {
		
		psw.setState(PRINT_INTERRUPT);
		//System.out.println("process" + processID + " waiting for print");
		pcINC();
		
	}
	
	private void halt(String s[]) {
		
		psw.setState(HALT);
		
	}
	
	private boolean isR(String s) {
		
		if(s == null) {
			System.out.println("error @ isR");
			return false;
		}
		
		return (s.charAt(0) == 'r') || (s.charAt(0) == 'R');
		
	}
	
	private void setPSW(int n) {
		
		psw.clearState(UNNEGATIVE & UNZERO & UNPOSITIVE);

		if(n < 0)
			psw.setState(NEGATIVE);
		else if(n == 0)
			psw.setState(ZERO);
		else
			psw.setState(POSITIVE);
		
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
		psw = registers.getPsw();
		pc = registers.getPc();
		ac = registers.getAc();
	
	}
	
	public void reset(PCB pcb) {

		this.registers = pcb.getRegisters();
		psw = registers.getPsw();
		pc = registers.getPc();
		ac = registers.getAc();
		processID = pcb.getProcessID();
		
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

}
