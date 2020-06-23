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
      desc = new ProductDescription( id1, price, "���ǽ�" );
      descriptions.put( id1, desc );
      desc = new ProductDescription( id2, price, "����" );
      descriptions.put( id2, desc );   
     }
   public ProductDescription getProductDescription( int id )   
   {
      return descriptions.get( id );   
   }
   public void showItemList() {
	
	   for (Integer key : descriptions.keySet()) {
           ProductDescription value = descriptions.get(key);
           System.out.println("[itemID]:" + key + ", [����]:" + value.getPrice()+" [����]:"+value.getDescription());
       }
	   
   }
}