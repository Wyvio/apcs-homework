/* Jolie Zhou
 * Mr. Peterson
 * APCS Period 2
 * 3 March 2020
 * 
 * The ShoppingCart class describes a list of ItemOrders that the user wants to purchase.
 */
import java.util.*;

public class ShoppingCart {
	private ArrayList<ItemOrder> orders;
	private boolean value;

	// Constructor for a ShoppingCart
	public ShoppingCart() {
		orders = new ArrayList<ItemOrder>();
	}

	// Adds an ItemOrder to the catalog (or replaces ItemOrder of same Item type)
	public void add(ItemOrder itemOrder) {
		boolean needReplace = false;
		int indexNeedReplace = 0;
		for (ItemOrder i : orders) {
			if (i.getItem().equals(itemOrder.getItem())) {
				needReplace = true;
				indexNeedReplace = orders.indexOf(i);
			}
		}

		if (needReplace) {
			orders.set(indexNeedReplace, itemOrder);
		} else {
			orders.add(itemOrder);
		}
	}

	// Applies discount to cost
	public void setDiscount(boolean value) {
		this.value = value;
	}

	// Returns total cost of all ItemOrders
	public double getTotal() {
		double total = 0;
		for (ItemOrder itemOrder : orders) {
			total += itemOrder.getPrice();
		}

		if (value) {
			total *= 0.9;
		}

		return total;
	}
}
