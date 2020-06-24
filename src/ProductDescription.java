
public class ProductDescription{   
	private int id;   
	private float price;
	private String description;
	private String categoryName;
	public ProductDescription( int id, float price, String description,String category )   
	{      
		this.id = id;
		this.price = price;      
		this.description = description;
		this.categoryName=category;
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
   public String getCategoryName() 
   { 
	   return categoryName; 
   }
}
