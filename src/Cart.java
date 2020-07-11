import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Cart {

	private Map<Integer, OrderLineItem> lineItems = new HashMap<Integer, OrderLineItem>();

	public Cart() {
	}

	// Adding Items to Cart
	public void addItem(ProductDescription desc, int quantity, String option) {
		OrderLineItem oli = new OrderLineItem(desc, quantity, option);
		lineItems.put(desc.getItemID(), oli);
	}

	// Get the total of Cart Items
	public float getTotal() {
		OrderLineItem oli;
		float sum = 0;
		for (Integer key : lineItems.keySet()) {
			oli = lineItems.get(key);
			sum += oli.getSubtotal();
		}
		return sum;
	}

	// Deleting the Line Item in the Cart
	public void deleteItem(int id) {
		lineItems.remove(id);
	}

	public OrderLineItem setQuantity(int id, int quantity) {
		OrderLineItem oli = lineItems.get(id);
		oli.setQuantity(quantity);
		return oli;
	}

	public Map<Integer, OrderLineItem> getLineItems() {
		return this.lineItems;
	}

	public OrderLineItem getLineItem(int id) {
		return lineItems.get(id);
	}

	// setting Cart Items for Use Case test3
	public void setItems() {
		String[] opt = { "white", "red", "blue" };
		ProductDescription tempDesc = new ProductDescription(102, 20000, "feel the summer", "Dress", opt);
		this.addItem(tempDesc, 2, "red");

		String[] opt2 = { "white", "red", "blue" };
		tempDesc = new ProductDescription(104, 24000, "giving you the best fit ever", "Bottom", opt2);
		this.addItem(tempDesc, 1, "S");
	}
}
