import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

public class Order
{
   ArrayList<OrderLineItem> lineItems = new ArrayList<OrderLineItem>();
   private Date date = new Date();
   private boolean isComplete = false;
   private Payment payment;

   public float getBalance()
   {
	  float originAmount=payment.getAmount();
      return originAmount-getTotal();
   }

   public void becomeComplete() { isComplete = true; }

   public boolean isComplete() { return isComplete; }

   public void makeLineItem( ProductDescription desc, int quantity )
   {
      lineItems.add( new OrderLineItem( desc, quantity ) );
      System.out.println(this.getTotal());
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


