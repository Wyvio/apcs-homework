/* Jolie Zhou
 * Mr. Peterson
 * APCS Period 2
 * 3 March 2020
 * 
 * The ItemOrder class describes one order of items. It describes the Item being purchased
 * and the quantity of the Items being purchased.
 */

public class ItemOrder {
	private Item item;
	private int quantity;

	// Constructor for an ItemOrder
	public ItemOrder(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	// Returns Item of ItemOrder
	public Item getItem() {
		return item;
	}

	// Returns price of ItemOrder
	public double getPrice() {
		return item.priceFor(quantity);
	}
}
