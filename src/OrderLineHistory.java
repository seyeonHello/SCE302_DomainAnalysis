
public class OrderLineHistory {
	private int quantity;
	private String option;
	private int id;
	private float price;

	public OrderLineHistory(int id, String option, int quantity, float price) {
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.option = option;
	}

	public int getID() {
		return id;
	}

	public float getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getOption() {
		return option;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
