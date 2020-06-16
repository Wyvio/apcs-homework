/* Jolie Zhou
 * Mr. Peterson
 * APCS Period 2
 * 3 March 2020
 * 
 * The Catalog class describes a list of items that can be purchased.
 */

import java.util.*;

public class Catalog {
	private String name;
	private ArrayList<Item> catalog;
	
	// Constructor for a Catalog
	public Catalog (String name) {
		this.name = name;
		catalog = new ArrayList<Item>();
	} 
	
	// Adds an Item to the Catalog
	public void add(Item item) {
		catalog.add(item);
	}
	
	// Returns size of the Catalog
	public int size() {
		return catalog.size();
	}
	
	// Gets an Item from the Catalog
	public Item get(int index) {
		return catalog.get(index);
	}
	
	// Returns name of the Catalog
	public String getName() {
		return name;
	}
}
