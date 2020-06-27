
public class OrderLineItem{   
	private int quantity;
	private String option;
	private ProductDescription description;
	public OrderLineItem (ProductDescription desc, int quantity, String option )   
	{
      this.description = desc;      
      this.quantity = quantity;
      this.option=option;
    }
	public int getID()
	{
		return description.getItemID();
	}
	public float getSubtotal()   
	{
		float eachItemPrice=description.getPrice();
		return eachItemPrice*quantity;   
    }
	public String getDescription()   
	{
		return description.getDescription();   
    }
	public int getQuantity()   
	{
		return quantity;   
    }
	public String getOption()   
	{
		return option;   
    }
	public void setQuantity(int quantity)   
	{
		 this.quantity=quantity;
    }
}
