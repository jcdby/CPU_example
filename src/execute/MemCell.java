/**
 * MemCell.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-7
 */

package execute;

public class MemCell extends Cell implements Parameters {
	
	private String content;

	public MemCell() {
		
		super(MEM);
		content = null;

	}

	public MemCell(String s) {
		
		super(MEM);
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
