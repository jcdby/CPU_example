/**
 * RunningMode.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-15
 */

package execute;

public class RunningMode {
	
	private boolean mode = false;
	private boolean buttonPressed = false;
	
	final static boolean AUTO = true;
	final static boolean MANUAL = false;
	
	public RunningMode() {
		
		this.mode = AUTO;
		
	}

	/**
	 * Return the mode.
	 */
	
	public synchronized boolean getMode() {
	
		return mode;
	
	}

	/**
	 * Reset the mode.
	 */
	
	public synchronized void setMode(boolean mode) {
	
		this.mode = mode;
	
	}

	/**
	 * Return the buttonPressed.
	 */
	
	public synchronized boolean getButtonPressed() {
	
		return buttonPressed;
	
	}

	/**
	 * Reset the buttonPressed.
	 */
	
	public synchronized void setButtonPressed(boolean buttonPressed) {
	
		this.buttonPressed = buttonPressed;
	
	}
	
}
