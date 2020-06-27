import java.util.HashMap;
import java.util.Map;

public class ProductCatalog{   
	private Map<Integer, ProductDescription> descriptions = new HashMap<Integer, ProductDescription>();
	private Map<Integer, String> categoryList = new HashMap<Integer, String>();
	public ProductCatalog()   
	{      // sample data
      categoryList.put(1,"상의");
      categoryList.put(2,"하의");
      categoryList.put(3,"원피스");
      categoryList.put(4,"악세사리");
	  int id1=100;
      int id2=200;
      int id3=300;
      int id4=400;
      float price=30000;
      ProductDescription desc;
      desc = new ProductDescription( id1, price, "티셔츠","상의");
      descriptions.put( id1, desc );
      desc = new ProductDescription( id2, price, "반바지","하의");
      descriptions.put( id2, desc );
      desc = new ProductDescription( id3, price, "원피스","원피스");
      descriptions.put( id3, desc );
      desc = new ProductDescription( id4, price, "모자","악세사리");
      descriptions.put( id4, desc );   
     }
   public ProductDescription getProductDescription( int id )   
   {
      return descriptions.get( id );   
   }
   public void showItemList(Integer num) {

	   for (Integer key : descriptions.keySet()) {
           ProductDescription value = descriptions.get(key);
           if(categoryList.get(num)==value.getCategoryName()) {
        	   System.out.println("[itemID]:" + key + ", [가격]:" + value.getPrice()+" [설명]:"+value.getDescription());
           }
       }
	   
   }
   public void showCategoryList() {
		
	   for (Integer key : categoryList.keySet()) {
           String value = categoryList.get(key);
           System.out.println("[카테고리 "+key+"]:" + value);
       }
	   
   }
}