import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

public class Order
{
   ArrayList<OrderLineItem> lineItems = new ArrayList<OrderLineItem>();
   private Date date = new Date();
   private boolean isComplete = false;
   private ProductCatalog catalog;
   private Payment payment;
   public Order(ProductCatalog catalog) {
		this.catalog = catalog;
	}
   public float getBalance()
   {
	  float originAmount=payment.getAmount();
      return originAmount-getTotal();
   }

   public void becomeComplete() { isComplete = true; }

   public boolean isComplete() { return isComplete; }

   public void makeLineItem(int id, int quantity, String option) { //바로  주문하기
		ProductDescription desc = catalog.getProductDescription(id);
		lineItems.add(new OrderLineItem(desc, quantity, option));
		System.out.println(this.getTotal());
	}
   public void setLineItem(ArrayList<OrderLineItem> cartLineItems) { //장바구니에서 가져오기
	   lineItems=cartLineItems;	   
   }

   public float getTotal()
   {
      float total=0;
      float subtotal = 0;

      for ( OrderLineItem lineItem : lineItems )
      {
         subtotal = lineItem.getSubtotal();
         total+=subtotal;
      }
   return total;
   }

   public void makePayment( float cashTendered )
   {
      payment = new Payment( cashTendered );
   }
}


