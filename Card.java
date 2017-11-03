import java.util.*;

public class Card {	
	
	/** name of the card */
	private String name;
	
	String nameAttribute;
	
	int numTheme = 1;
	
	//switched to public for testing
	public ArrayList<Attribute> attributes;
	
	public Card(){}
	//
	
	public Card(String name) { 
	 	this.name = name;
	}
	
	public Card(String nameCard, int numAttributes, int numTheme) { 
	 	this.name = nameCard;
	 	this.numTheme = numTheme;
	 	attributes = new ArrayList<Attribute>(numAttributes);
		
	 	if(numTheme == 1) {
			attributes.add( new Attribute( "HP", (int)(Math.random()*10)));
			attributes.add( new Attribute( "Attack", (int)(Math.random()*10)));
			attributes.add( new Attribute( "Defence", (int)(Math.random()*10)));
			attributes.add( new Attribute( "Strength", (int)(Math.random()*10)));
	 		
		}else if(numTheme == 2) {
			attributes.add( new Attribute( "Price", (int)(Math.random()*10)));
			attributes.add( new Attribute( "BHP", (int)(Math.random()*10)));
			attributes.add( new Attribute( "Top Speed", (int)(Math.random()*10)));
			attributes.add( new Attribute( "Acceleration", (int)(Math.random()*10)));
			attributes.add( new Attribute( "Handling", (int)(Math.random()*10)));
			
		}else if(numTheme == 3) {
			attributes.add( new Attribute( "Honour", (int)(Math.random()*10)));
			attributes.add( new Attribute( "Magic", (int)(Math.random()*10)));
			attributes.add( new Attribute( "Nobility", (int)(Math.random()*10)));
			
		}else if(numTheme == 4) {
			attributes.add( new Attribute( "Height", (int)(Math.random()*10)));
			attributes.add( new Attribute( "Weight", (int)(Math.random()*10)));
			attributes.add( new Attribute( "Killer Rating", (int)(Math.random()*10)));
			attributes.add( new Attribute( "Intelligence", (int)(Math.random()*10)));
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
	public void setName(String name) {
		if ( name.length() > 1 ) //name = "empty";
			this.name = name; 
	}
	
	/** 
	* Prints name 
	*/
	public void print() { 
    	System.out.println(name);    	
    	for (Attribute a : attributes ) {
    		a.print();
		 }
    }
}