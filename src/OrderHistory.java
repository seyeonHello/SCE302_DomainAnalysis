import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderHistory {

	private Map<Integer, Order> orderList = new HashMap<Integer, Order>();
	private int orderhistoryID = 0;
	PersistenceStorage db = new PersistenceStorage();

	public OrderHistory() {

	}

	public Map<Integer, Order> getOrderHistory() {
		return this.orderList;
	}

	public Order selectOrderHistory(int orderID) {
		return orderList.get(orderID);

	}

	public void insertOrderHistory(Order order) {
		orderList.put(order.getOrderID(), order);
		this.updateOrderHistory();
	}

	public void updateOrderHistory() {
		db.update(orderList);
	}

	// making new Order tests for Use Case 3
	public void makeNewOrder(Customer customer) {
		Cart c = customer.getCart();
		c.setItems();
		Order o = new Order(c.getLineItems(), customer, orderhistoryID);
		this.insertOrderHistory(o);
		orderhistoryID++;
	}
}
