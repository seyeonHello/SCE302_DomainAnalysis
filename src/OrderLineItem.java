
public class OrderLineItem{   
	private int quantity;
	private String option;
	private ProductDescription description;
	public OrderLineItem (ProductDescription desc, int quantity, int option )   
	{
      this.description = desc;      
      this.quantity = quantity;
      if(option==1) {
    	  this.option="S";
      }
      if(option==2) {
    	  this.option="M";
      }
      if(option==3) {
    	  this.option="L";
      }
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
