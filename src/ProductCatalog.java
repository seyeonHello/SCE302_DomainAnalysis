import java.util.HashMap;
import java.util.Map;

public class ProductCatalog{   
	private Map<Integer, ProductDescription> descriptions = new HashMap<Integer, ProductDescription>();
	public ProductCatalog()   
	{      // sample data
      int id1=100;
      int id2=200;
      float price=30000;
      ProductDescription desc;
      desc = new ProductDescription( id1, price, "원피스" );
      descriptions.put( id1, desc );
      desc = new ProductDescription( id2, price, "모자" );
      descriptions.put( id2, desc );   
     }
   public ProductDescription getProductDescription( int id )   
   {
      return descriptions.get( id );   
   }
   public void showItemList() {
	
	   for (Integer key : descriptions.keySet()) {
           ProductDescription value = descriptions.get(key);
           System.out.println("[itemID]:" + key + ", [가격]:" + value.getPrice()+" [설명]:"+value.getDescription());
       }
	   
   }
}