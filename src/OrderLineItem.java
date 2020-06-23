
public class OrderLineItem{   
	private int quantity;
	private ProductDescription description;
	public OrderLineItem (ProductDescription desc, int quantity )   
	{
      this.description = desc;      
      this.quantity = quantity;   
    }
	public float getSubtotal()   
	{
		float eachItemPrice=description.getPrice();
		return eachItemPrice*quantity;   
    }
}
