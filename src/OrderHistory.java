import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderHistory {

	private Map<Integer, Order> orderList = new HashMap<Integer, Order>();
	int orderhistoryID = 0;

	// PersistenceStorage db = new PersistenceStorage();
	public OrderHistory() {

	}

	public void makeNewOrder(Customer customer) {
		String address = "Suwon TomTom_ ajou.";
		Cart c = customer.getCart();
		c.setItems();
		Order o = new Order(c.getLineItems(), customer, orderhistoryID, address);
		orderList.put(orderhistoryID, o);
		orderhistoryID++;
	}

	public void insertOrderHistory(Order order) {
		orderList.put(order.getOrderID(), order);
		// db.insert(order);
	}

	public void updateOrderHistory() {
		// db.update(lineHistory);
	}

	public Order selectOrderHistory(int orderID) {
		return orderList.get(orderID);
		// lineHistory = db.select();
	}

	public void setQuantity(int id, int quantity) {
		updateOrderHistory();
	}

	public Map<Integer, Order> getOrderHistory() {
		return this.orderList;
	}

	// set OrderID at OrderHistory,,
	public void selectOrderHistory() {

	}
}
