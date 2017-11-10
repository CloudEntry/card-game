public class Attribute {
	
	//modifier switched for testing
	private String name;
	
	//modifier switched for testing
	public int value;
	 
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public Attribute(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * 
	 */
	public void print() {
		System.out.println("  " + name + ": " + value);
		
	}

	public String getName() {
		return name;
	}
}