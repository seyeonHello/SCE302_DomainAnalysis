import java.util.ArrayList;

public class Cart {
	private ProductCatalog catalog;
	private Order currentOrder;
	private ProductDescription description;
	ArrayList<OrderLineItem> lineItems = new ArrayList<OrderLineItem>();

	public Cart(ProductCatalog catalog) {
		super();
		this.catalog = catalog;
	}

	public void addItem(int id, int quantity, int option) {
		ProductDescription desc = catalog.getProductDescription(id);
		lineItems.add(new OrderLineItem(desc, quantity, option));
		
	}

	public void makeNewOrder() { //�ֹ��� �����Ѵ�.
		currentOrder = new Order(catalog);
		currentOrder.setLineItem(lineItems);
	}

	public void showCartItem() { //��ٱ��� ���� ����
		for (OrderLineItem lineItems : lineItems) {
			System.out
					.println(lineItems.getID() + " " + lineItems.getOption() + " " + lineItems.getQuantity());
		}
	}
	public float getTotal() { //��ٱ��Ͽ� ��� �����۵��� �� ����
		float sum=0;
		for (OrderLineItem lineItems : lineItems) {
			sum+=lineItems.getSubtotal();
		}
		return sum;
	}
	public void setQuantity(int id, int quantity) { //��ٱ��Ͽ� ��� �����۵��� �� ����
		for (OrderLineItem lineItems : lineItems) {
			if(lineItems.getID()==id) {
				lineItems.setQuantity(quantity);
			}
		}
	}
	public void deleteItem (int id) { 
		int index=-1;
		int final2=0;
		for (OrderLineItem lineItemss : lineItems) {
			index++;
			if(lineItemss.getID()==id) {
				final2=index;
			}
		}
		lineItems.remove(final2);
	}
}
