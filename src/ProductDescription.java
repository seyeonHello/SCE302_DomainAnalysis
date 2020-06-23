
public class ProductDescription{   
	private int id;   
	private float price;
	private String description;   
	public ProductDescription( int id, float price, String description )   
	{      
		this.id = id;
		this.price = price;      
		this.description = description;   
	}
   public int getItemID() 
   { 
	   return id;   
   }
   public float getPrice() 
   { 
	   return price; 
   }
   public String getDescription() 
   { 
	   return description; 
   }
}
