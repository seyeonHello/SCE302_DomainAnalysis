import java.util.ArrayList;
import java.util.Map;

public class ManageOrderController {
    private OrderHistory orderhistory;
    private Order selectedOrder;

    public ManageOrderController(OrderHistory orderHistory) {
        this.orderhistory = orderHistory;

    }

    // Getting the OrderHistory
    public Map<Integer, Order> checkManageOrder() {
        return orderhistory.getOrderHistory();
    }

    // Selecting an Order from The OrderHistory List
    public Order selectOrder(int orderID) {
        selectedOrder = orderhistory.selectOrderHistory(orderID);
        return selectedOrder;
    }

    // Selecting an Item from the Selected Order
    public String selectOrderItem(int itemID) {
        OrderLineItem oli = selectedOrder.lineItems.get(itemID);
        return oli.getStatus();
    }

    // Changing the Status of the Selected Item
    public String OrderStatusChange(int itemID, int statusNum) {
        OrderLineItem oli = selectedOrder.lineItems.get(itemID);
        switch (statusNum) {
            case 1:
                oli.setStatus("입금확인 중");
                break;
            case 2:
                oli.setStatus("결제 완료");
                break;
            case 3:
                oli.setStatus("발송 완료");
                break;
            default:
                break;
        }
        return oli.getStatus();
    }

    public void showSelectedStatus(String status) {
        Map<Integer, Order> orders = orderhistory.getOrderHistory();
        Map<Integer, OrderLineItem> items;
        Order o;
        OrderLineItem oli;

        for (Integer key : orders.keySet()) {
            o = orders.get(key);
            items = o.getLineItem();
            System.out.print("[OrderID]: " + o.getOrderID() + "\n");
            for (Integer key2 : items.keySet()) {
                oli = items.get(key2);
                if (oli.getStatus() == status) {
                    System.out.print("[ItemID]: " + oli.getID() + "\n");
                    System.out.print("[Status]: " + oli.getStatus() + "\n");
                }
            }
        }

    }

}