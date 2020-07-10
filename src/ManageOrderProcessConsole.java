import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;

public class ManageOrderProcessConsole {
	ManageOrderController manageorderController;

	public ManageOrderProcessConsole(ManageOrderController moController) {
		this.manageorderController = moController;
	}

	public void scenario() {
		Scanner input = new Scanner(System.in);

		System.out.print("***********************************\n");
		System.out.print("******** WELCOME TO PAYMO *********\n");
		System.out.print("***********************************\n\n");
		System.out.print("____________< ORDER HISTORY >____________\n");
		Map<Integer, Order> orders = manageorderController.checkManageOrder();
		Order o;
		for (Integer key : orders.keySet()) {
			o = orders.get(key);
			System.out.print("[OrderID]: " + o.getOrderID() + "\n[Customer]: " + o.customer.getName()
					+ "\n[Ordered Date]: " + o.getDate() + "\n[Address]: " + o.getAddress() + "\n");
		}
		System.out.print("\n____________< SELECT ORDER >____________\n");
		System.out.printf("Select an Order: \n");

		Order selectedOrder = manageorderController.selectOrder(input.nextInt());
		Map<Integer, OrderLineItem> items = selectedOrder.getLineItem();
		OrderLineItem oli;
		System.out.print("[Item ID] [Item Quantity] [Item Option] [Item Status]\n");
		for (Integer key : items.keySet()) {
			oli = items.get(key);
			System.out.print(oli.getID() + "\t\t" + oli.getQuantity() + "\t\t" + oli.getOption() + "\t\t"
					+ oli.getStatus() + "\n");
		}
		System.out.print("\n____________< SELECT ITEM >____________\n");
		System.out.printf("Select an Item: \n");
		int itemID = input.nextInt();
		String status = manageorderController.selectOrderItem(itemID);
		String[] s = { "입금확인 중", "결제 완료", "발송 완료" };
		for (int i = 0; i < 3; i++) {
			System.out.print(i + 1 + ". [" + s[i] + "] : ");
			if (status == s[i])
				System.out.print(" V \n");
			else
				System.out.print("\n");
		}
		System.out.print("\n____________< CHANGE STATUS >____________\n");
		System.out.printf("Select a Status: \n");
		int statusNum = input.nextInt();
		status = manageorderController.OrderStatusChange(itemID, statusNum);
		for (int i = 0; i < 3; i++) {
			System.out.print(i + 1 + ". [" + s[i] + "] : ");
			if (status == s[i])
				System.out.print(" V \n");
			else
				System.out.print("\n");
		}

	}
}
