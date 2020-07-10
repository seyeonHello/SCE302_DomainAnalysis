import java.util.ArrayList;
import java.util.Map;

public class ManageOrderController {
    OrderHistory orderhistory;
    Order selectedOrder;

    public ManageOrderController(ShoppingMall shop) {
        this.orderhistory = shop.getOrderHistory();
    }

    public Map<Integer, Order> checkManageOrder() {
        return orderhistory.getOrderHistory();
    }

    public Order selectOrder(int orderID) {
        selectedOrder = orderhistory.selectOrderHistory(orderID);
        return selectedOrder;
    }

    public String selectOrderItem(int itemID) {
        OrderLineItem oli = selectedOrder.lineItems.get(itemID);
        return oli.getStatus();
    }

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

}