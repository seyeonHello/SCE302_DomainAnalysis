import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Cart {

	Map<Integer, OrderLineItem> lineItems = new HashMap<Integer, OrderLineItem>();

	public Cart() {
		System.out.print("In the Cart Constructor\n");

	}

	public Map<Integer, OrderLineItem> addItem(ProductDescription desc, int quantity, String option) {
		lineItems.put(desc.getItemID(), new OrderLineItem(desc, quantity, option));
		return lineItems;
	}

	public Map<Integer, OrderLineItem> getLineItems() {
		return this.lineItems;
	}

	public float getTotal() {
		OrderLineItem oli;
		float sum = 0;
		for (Integer key : lineItems.keySet()) {
			oli = lineItems.get(key);
			sum += oli.getSubtotal();
		}
		return sum;
	}

	public void setQuantity(int id, int quantity) {
	}

	public void deleteItem(int id) {
		int index = -1;
		int final2 = 0;
	}

	public void setItems() {
		String[] opt = { "white", "red", "blue" };
		ProductDescription tempDesc = new ProductDescription(102, 20000, "feel the summer", "Dress", opt);
		this.addItem(tempDesc, 2, "red");

		String[] opt2 = { "white", "red", "blue" };
		tempDesc = new ProductDescription(104, 24000, "giving you the best fit ever", "Bottom", opt2);
		this.addItem(tempDesc, 1, "S");
	}
}
