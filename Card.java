import java.util.*;

public class Card {	
	
	/** name of the card */
	private String name;
	
	String nameAttribute;
	
	int numTheme = 1;
	
	//switched to public for testing
	public ArrayList<Attribute> attributes;
	
	public Card (){}
	//
	
	public Card (String name) { 
	 	this.name = name;
	}
	
	public Card (String nameCard, int numAttributes) { 
	 	this.name = nameCard;
	 	attributes = new ArrayList<Attribute>( numAttributes );
	 	
	 	for ( int i = 0; i < numAttributes; i++ ) {
			nameAttribute = "Attribute " + Integer.toString( i );
		
			int value = (int) ( Math.random() * 10 );
			attributes.add( new Attribute( nameAttribute, value ) );
		}
	 	
	}
	
	/**
	* @return String name
	*/
	public String getName() {
		return name; 
		
	}
	
	/** 
	* @param s has type String and will be the new name
	*/
	public void setName (String name) {
		if ( name.length() > 1 ) //name = "empty";
			this.name = name; 
	}
	
	/** 
	* Prints name 
	*/
	public void print() { 
    	System.out.println( "------- " + name );    	
    	for ( Attribute a : attributes ) {
			 a.print();
		 }
		
    		
    }
}