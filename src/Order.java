
import java.util.Date;
import java.util.Map;
import java.text.SimpleDateFormat;

public class Order {

   Customer customer;
   Map<Integer, OrderLineItem> lineItems;
   private Date date;
   private int orderID;
   private String address;

   public Order(Map<Integer, OrderLineItem> lineItems, Customer cus, int orderID) {
      this.lineItems = lineItems;
      this.customer = cus;
      this.orderID = orderID;
      this.address = cus.getAddress();
      this.date = new Date(System.currentTimeMillis());
   }

   public String getDate() {
      SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
      return dateform.format(this.date);
   }

   public Map<Integer, OrderLineItem> getLineItem() {
      return this.lineItems;
   }

   // confusing...which one should have the total Cost [Cart? or Order?]
   public float getTotal() {
      return customer.getCart().getTotal();
   }

   public int getOrderID() {
      return this.orderID;
   }

   public String getAddress() {
      return this.address;
   }

}
