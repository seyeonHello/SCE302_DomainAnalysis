import java.util.HashMap;
import java.util.Map;

public class ProductCatalog{   
	private Map<Integer, ProductDescription> descriptions = new HashMap<Integer, ProductDescription>();
	private Map<Integer, String> categoryList = new HashMap<Integer, String>();
	public ProductCatalog()   
	{      // sample data
      categoryList.put(1,"����");
      categoryList.put(2,"����");
      categoryList.put(3,"���ǽ�");
      categoryList.put(4,"�Ǽ��縮");
	  int id1=100;
      int id2=200;
      int id3=300;
      int id4=400;
      float price=30000;
      ProductDescription desc;
      desc = new ProductDescription( id1, price, "Ƽ����","����");
      descriptions.put( id1, desc );
      desc = new ProductDescription( id2, price, "�ݹ���","����");
      descriptions.put( id2, desc );
      desc = new ProductDescription( id3, price, "���ǽ�","���ǽ�");
      descriptions.put( id3, desc );
      desc = new ProductDescription( id4, price, "����","�Ǽ��縮");
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
        	   System.out.println("[itemID]:" + key + ", [����]:" + value.getPrice()+" [����]:"+value.getDescription());
           }
       }
	   
   }
   public void showCategoryList() {
		
	   for (Integer key : categoryList.keySet()) {
           String value = categoryList.get(key);
           System.out.println("[ī�װ� "+key+"]:" + value);
       }
	   
   }
}