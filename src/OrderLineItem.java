
public class OrderLineItem {
	private int quantity;
	private String option;
	private ProductDescription itemDescription;
	private String status;

	public OrderLineItem(ProductDescription desc, int quantity, String option) {
		this.itemDescription = desc;
		this.quantity = quantity;
		this.option = option;
		// default value
		this.status = "결제 완료";// 발송완료, 결제완료
	}

	public int getID() {
		return itemDescription.getItemID();
	}

	public String getDescription() {
		return itemDescription.getDescription();
	}

	public int getQuantity() {
		return quantity;
	}

	public String getOption() {
		return option;
	}

	public String getStatus() {
		return this.status;
	}

	public float getSubtotal() {
		float eachItemPrice = itemDescription.getPrice();
		return eachItemPrice * quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setStatus(String s) {
		this.status = s;
	}

}
