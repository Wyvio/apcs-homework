/* Jolie Zhou
 * Mr. Peterson
 * APCS Period 2
 * 2 March 2020
 * 
 * The Item describes the price and the name of the item.
 */

import java.text.*;

public class Item {
	private String name;
	private double price;
	private int bulkQuantity;
	private double bulkPrice;

	// Constructor for an Item (without bulk pricing)
	public Item(String name, double price) throws IllegalArgumentException {
		this(name, price, 1, price);
	}

	// Constructor for an Item (with bulk pricing too)
	public Item(String name, double price, int bulkQuantity, double bulkPrice) throws IllegalArgumentException {
		if (price < 0) {
			throw new IllegalArgumentException("Cannot have negative price");
		}
		if (bulkQuantity < 0) {
			throw new IllegalArgumentException("Cannot have negative bulk quantity");
		}
		if (bulkPrice < 0) {
			throw new IllegalArgumentException("Cannot have negative bulk price");
		}

		this.name = name;
		this.price = price;
		this.bulkQuantity = bulkQuantity;
		this.bulkPrice = bulkPrice;
	}
	
	// Returns price of item given quantity
	public double priceFor(int quantity) throws IllegalArgumentException {
		if (quantity < 0) {
			throw new IllegalArgumentException("Cannot have negative quantity");
		}
		if (quantity < bulkQuantity) {
			return quantity * price;
		} else {
			return quantity % bulkQuantity * price + quantity/bulkQuantity * bulkPrice;
		}
	}

	// Returns name of item with $price.cents format ($00.00) and bulk quantity/price too
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String price = nf.format(this.price);
		
		String label = name + ", " + price;
		if (bulkQuantity > 1) {
			label += " (" + bulkPrice + " for " + bulkQuantity + ")";
		}

		return label;
	}
}
