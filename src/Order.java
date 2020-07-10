import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

import java.text.SimpleDateFormat;

public class Order {

   Customer customer;
   Map<Integer, OrderLineItem> lineItems;
   private Date date;
   private int orderID;
   private boolean isComplete = false;
   private Payment payment;
   private String address;

   public Order(Map<Integer, OrderLineItem> lineItems, Customer cus, int orderID, String address) {
      this.lineItems = lineItems;
      this.customer = cus;
      this.date = new Date(System.currentTimeMillis());
      this.orderID = orderID;
      this.address = address;
   }

   public float getBalance() {
      float originAmount = payment.getAmount();
      return originAmount - getTotal();
   }

   public int getOrderID() {
      return this.orderID;
   }

   public void becomeComplete() {
      isComplete = true;
      // 결제되면 line item들도 모두 결제완료로? 해봅시다.
   }

   public boolean isComplete() {
      return isComplete;
   }

   public String getAddress() {
      return this.address;
   }

   public String getDate() {
      SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
      return dateform.format(this.date);
   }

   public Map<Integer, OrderLineItem> getLineItem() {
      return this.lineItems;

   }

   // public void makeLineItem(int id, int quantity, String option) { //�ٷ� �ֹ��ϱ�
   // ProductDescription desc = catalog.getProductDescription(id);
   // lineItems.add(new OrderLineItem(desc, quantity, option));
   // enrollOrderHistory();
   // }

   // public void setLineItem(ArrayList<OrderLineItem> cartLineItems) {
   // lineItems = cartLineItems;
   // }

   // public void enrollOrderHistory() {
   // for (OrderLineItem lineItems : lineItems) {
   // orderhistory.insertOrderHistory(new OrderLineHistory(lineItems.getID(),
   // lineItems.getOption(),
   // lineItems.getQuantity(), lineItems.getSubtotal()));
   // }
   // }

   public float getTotal() {
      float total = 0;
      float subtotal = 0;

      // for (OrderLineItem lineItem : lineItems) {
      // subtotal = lineItem.getSubtotal();
      // total += subtotal;
      // }
      return total;
   }

   public void makePayment(float cashTendered) {
      payment = new Payment(cashTendered);
   }
}
