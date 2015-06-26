/**
 * InstrumentCell.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-6
 */

package execute;

public class InstrumentCell extends Cell implements Parameters {
	
	private String content;

	public InstrumentCell() {
		
		super(INSTRUMENT);
		content = null;

	}

	public InstrumentCell(String s) {
		
		super(INSTRUMENT);
		setContent(s);

	}
	
	/**
	 * Return the content.
	 */
	
	public String getContent() {
	
		return content;
	
	}

	/**
	 * Reset the content.
	 */
	
	public void setContent(String content) {
	
		this.content = content;
	
	}

	public String toString() {
		
		return content;
		
	}

}
