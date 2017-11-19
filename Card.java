import java.util.*;

/**
 * Card.java - custom object to represent a card in a game of Top Trumps.
 * @author Jack Gee
 * @version 1.0 
 */
public class Card {	
	
	/**
	 * Name of the card. 
	 */
	private String name;
	
	/**
	 * Name of the attribute. 
	 */
	String nameAttribute;
	
	int numTheme = 1;
	
	/**
	 * ArrayList to store attributes for each card. 
	 */
	private ArrayList<Attribute> attributes;
	
	/**
	 * Prints different set of attribute names according to which theme selected.
	 * Easy to add new themes with different attribute names. 
	 * @param nameCard
	 * @param numTheme
	 */
	public Card(String nameCard, int numTheme) { 
	 	this.name = nameCard;
	 	this.numTheme = numTheme;
	 	attributes = new ArrayList<Attribute>();
		
	 	if(numTheme == 1) {
			attributes.add( new Attribute("HP", (int)(Math.random()*10)));
			attributes.add( new Attribute("Attack", (int)(Math.random()*10)));
			attributes.add( new Attribute("Defence", (int)(Math.random()*10)));
			attributes.add( new Attribute("Strength", (int)(Math.random()*10)));
	 		
		}else if(numTheme == 2) {
			attributes.add( new Attribute("Price", (int)(Math.random()*10)));
			attributes.add( new Attribute("BHP", (int)(Math.random()*10)));
			attributes.add( new Attribute("Top Speed", (int)(Math.random()*10)));
			attributes.add( new Attribute("Acceleration", (int)(Math.random()*10)));
			attributes.add( new Attribute("Handling", (int)(Math.random()*10)));
			
		}else if(numTheme == 3) {
			attributes.add( new Attribute("Honour", (int)(Math.random()*10)));
			attributes.add( new Attribute("Magic", (int)(Math.random()*10)));
			attributes.add( new Attribute("Nobility", (int)(Math.random()*10)));
			
		}else if(numTheme == 4) {
			attributes.add( new Attribute("Height", (int)(Math.random()*10)));
			attributes.add( new Attribute("Weight", (int)(Math.random()*10)));
			attributes.add( new Attribute("Killer Rating", (int)(Math.random()*10)));
			attributes.add( new Attribute("Intelligence", (int)(Math.random()*10)));
		} 
	}
	
   /**
	* Gets name of card. 
	* @return String name
	*/
	public String getName() {
		return name; 
	}
	
   /** 
	* @param s has type String and will be the new name
	*/
	public void setName(String name) {
		if (name.length() > 1)
			this.name = name; 
	}
	
	/**
	 * Gets ArralyList of attributes. 
	 * @return ArrayList attributes
	 */
	public ArrayList<Attribute> getAttributes() {
		return attributes; 
	}
	
   /** 
	* Prints name of card. 
	*/
	public void print() { 
    	System.out.println(" -----"+name+"-----");    	
    	for (int i = 0; i < attributes.size(); i++) {
    		System.out.print(String.valueOf(i+1) + " - ");
    		attributes.get(i).print();
		 }
    }
}