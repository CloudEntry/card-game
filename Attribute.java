/**
 * Attribute.java - custom object to represent a card's attribute. 
 * @author Jack Gee
 * @version 1.0
 */
public class Attribute {
	
	/**
	 * Name of the attribute. 
	 */
	private String name;
	
	/**
	 * Value of the attribute. 
	 */
	private int value;
	 
	/**
	 * Constructor method. 
	 * @param name
	 * @param value
	 */
	public Attribute(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Prints the name of the attribute and its value. 
	 */
	public void print() {
		System.out.println(name + ": " + value);
		
	}

	/**
	 * Gets the name of the attribute. 
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the value of the attribute. 
	 * @return int value
	 */
	public int getValue() {
		return value;
	}
}