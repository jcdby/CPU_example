/**
 * DataCell.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-6
 */

package execute;

public class DataCell extends Cell implements Parameters {
	
	protected int content;

	public DataCell() {
		
		super(DATA);
		setContent(0);
		
	}

	public DataCell(int data) {
		
		super(DATA);
		setContent(data);
		
	}
	
	public DataCell(String s) {
		
		super(DATA);
		setContent(s);
		
	}

	/**
	 * Return the content.
	 */
	
	public int getContent() {
	
		return content;
	
	}

	/**
	 * Reset the content.
	 */
	
	public void setContent(String s) {


		String tempStr = s.substring(1);
		int temp = (new Integer(tempStr)).intValue();
		setContent(temp);
	
	}

	/**
	 * Reset the content.
	 */
	
	public void setContent(int content) {

		if(content < MIN && content > MAX) {
			content = content % MAX;
			System.out.println("error @ DataCell: data out of range");
		}
		
		this.content = content;
	
	}
	
	public String toString() {
		
		return '#' + (new Integer(content)).toString();
		
	}

}
