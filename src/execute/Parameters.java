/**
 * Parameters.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-6
 */

package execute;

public interface Parameters {
	
	// Cell types
	
	final static int INSTRUMENT = 0;
	final static int DATA = 1;
	final static int PSW = 2;
	final static int MEM = 3;
	
	// Integer range
	
	final static int MAX = (int)Math.pow(2, 15) - 1;
	final static int MIN = -MAX - 1;
	
	// PSW parameters

	final static int RESET = 0;
	final static int MASK = (int)Math.pow(2, 16) - 1;
	final static int INPUT_INTERRUPT = 1;
	final static int UNINPUT_INTERRUPT = Integer.MAX_VALUE - INPUT_INTERRUPT;
	final static int PRINT_INTERRUPT = 2;
	final static int UNPRINT_INTERRUPT = Integer.MAX_VALUE - PRINT_INTERRUPT;
	final static int OVERFlOW = 4;
	final static int UNOVERFlOW = Integer.MAX_VALUE - OVERFlOW;
	final static int POSITIVE = 8;
	final static int UNPOSITIVE = Integer.MAX_VALUE - POSITIVE;
	final static int ZERO = 16;
	final static int UNZERO = Integer.MAX_VALUE - ZERO;
	final static int NEGATIVE = 32;
	final static int UNNEGATIVE = Integer.MAX_VALUE - NEGATIVE;
	final static int DIVBYZERO = 64;
	final static int UNDIVBYZERO = Integer.MAX_VALUE - DIVBYZERO;
	final static int HALT = 128;
	final static int UNHALT = Integer.MAX_VALUE - DIVBYZERO;
	
	// PCB parameters
	
	final static int REGISTERS_SIZE = 12;
	final static int PCB_SIZE = REGISTERS_SIZE + 5;
	final static int MEM_SIZE = 1024;
	final static int MAX_PROCESS_NUM = 10;
	final static int DATAPOINTER_OFFSET = 1;
	final static int DBS_OFFSET = 2;
	final static int INSTRUMENT_OFFSET = 3;
	final static int IBS_OFFSET = 4;
	final static int REGISTERS_OFFSET = 5;
	final static int PC_OFFSET = 5;
	final static int PSW_OFFSET = 6;
	final static int IR_OFFSET = 7;
	final static int AC_OFFSET = 8;
	final static int REGISTER0_OFFSET = 9;
	
	final static int AUTOMODE = 0;
	final static int MANUALMODE = 1;
	
}
