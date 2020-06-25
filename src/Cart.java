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

	public void makeNewOrder() { //주문을 시작한다.
		currentOrder = new Order(catalog);
		currentOrder.setLineItem(lineItems);
	}

	public void showCartItem() { //장바구니 내역 보기
		for (OrderLineItem lineItems : lineItems) {
			System.out
					.println(lineItems.getID() + " " + lineItems.getOption() + " " + lineItems.getQuantity());
		}
	}
	public float getTotal() { //장바구니에 담긴 아이템들의 총 가격
		float sum=0;
		for (OrderLineItem lineItems : lineItems) {
			sum+=lineItems.getSubtotal();
		}
		return sum;
	}
	public void setQuantity(int id, int quantity) { //장바구니에 담긴 아이템들의 총 가격
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
