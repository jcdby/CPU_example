/**
 * PSWCell.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-6
 */

package execute;

public class PSWCell extends Cell implements Parameters {
	
	private int state = 0;
	
	public static void main(String[] args) {

		PSWCell psw =  new PSWCell("0110");
		System.out.println(psw);
		psw.setState("1111111111111111111111101110");
		System.out.println(psw);

	}

	public PSWCell() {
		
		super(PSW);
		state = 0;
		
	}

	public PSWCell(String s) {
		
		super(PSW);
		state = (Integer.valueOf(s, 2));
		
	}

	public PSWCell(int state) {
		
		super(PSW);
		this.state = state;
		
	}

	/**
	 * Return the state.
	 */
	
	public int getState() {
	
		return state;
	
	}

	/**
	 * Return the state.
	 */
	
	public int getState(int i) {
	
		return state & i;
	
	}

	/**
	 * Clear the state.
	 */
	
	public void clearState(int i) {
	
		state = state & i;
		state = state & MASK;
	
	}

	/**
	 * Reset the state.
	 */
	
	public void setState(int i) {
	
		state = state | i;
		state = state & MASK;
	
	}

	/**
	 * Reset the state.
	 */
	
	public void setState(String s) {

		state = Integer.valueOf(s, 2) & MASK;
	
	}

	public String toString() {
		
		String stateString = Integer.toBinaryString(state);
		int i = 16 - stateString.length();
		
		if(i > 0) {
			StringBuffer sb = new StringBuffer(i);
			while(i > 0) {
				sb.append('0');
				--i;
			}
			return sb.toString() + stateString;
		}
		else
			return stateString;
	}

}
