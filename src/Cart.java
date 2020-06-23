
public class Cart {
	private ProductCatalog catalog;
	private Order currentOrder;   
	public Cart( ProductCatalog catalog )
	{
	  super();
      this.catalog = catalog;
      this.makeNewOrder();
	}   
//	public void endOrder()   
//	{
//		currentOrder.becomeComplete();   
//    }
   public void enterItem( int id, int quantity )   
   {
      ProductDescription desc = catalog.getProductDescription( id );
      currentOrder.makeLineItem( desc, quantity );   
   }
   public void makeNewOrder()   
   {      
	   currentOrder = new Order();   
   }
   public void makePayment( float cashTendered )   
   {
	   currentOrder.makePayment( cashTendered );   
   }
}
