import java.util.Scanner;

public class ShoppingMall {
	private ProductCatalog catalog;
	private OrderHistory history;
	public AddItemController aiController;
	public ManageOrderController moController;
	// private Cart cart;
	private Customer customer;

	public ShoppingMall() {
		this.catalog = new ProductCatalog();
		this.history = new OrderHistory();
		this.customer = new Customer("kimC", "eemo");
		this.aiController = new AddItemController(this);
		this.moController = new ManageOrderController(this);

	}

	// private Order order = new Order( catalog );

	public ProductCatalog getCatalog() {
		return catalog;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public OrderHistory getOrderHistory() {
		return history;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		ShoppingMall shop = new ShoppingMall();
		AddCartProcessConsole frame1 = new AddCartProcessConsole(shop.aiController);
		ManageOrderProcessConsole frame2 = new ManageOrderProcessConsole(shop.moController);

		System.out.println("Choose Use Case\n");
		System.out.println("[1] Use Case 1: Add Item to cart\n");
		System.out.println("[2] Use Case 3: Manage Order List\n");

		switch (input.nextInt()) {
			case 1:
				frame1.scenario();
				break;
			case 2:
				shop.getCustomer().getCart().setItems();
				shop.getOrderHistory().makeNewOrder(shop.getCustomer());
				frame2.scenario();
				break;
			default:
				break;

		}

		// use-case1

		// use-case2

		// use-case3

	}
	// controller의 역할을 하는 아이들을

	// public Order getOrder() { return order;}

}
