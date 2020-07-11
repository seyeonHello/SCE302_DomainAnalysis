import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private Map<Integer, Map<Integer, ProductDescription>> categoryList = new HashMap<Integer, Map<Integer, ProductDescription>>();

    public ProductCatalog() { // setting up the sample data
        this.setProductDescription();
    }

    public Map<Integer, Map<Integer, ProductDescription>> getCatalogList() {
        return this.categoryList;
    }

    public Map<Integer, ProductDescription> selectCategory(Integer catalogID) {
        Map<Integer, ProductDescription> itemList;
        itemList = this.categoryList.get(catalogID);
        return itemList;
    }

    // Setting up some sample Items data for Use Case 1
    public void setProductDescription() {

        Map<Integer, ProductDescription> toplist = new HashMap<Integer, ProductDescription>();
        Map<Integer, ProductDescription> bottomlist = new HashMap<Integer, ProductDescription>();
        Map<Integer, ProductDescription> dresslist = new HashMap<Integer, ProductDescription>();
        Map<Integer, ProductDescription> etclist = new HashMap<Integer, ProductDescription>();

        int id1 = 100;
        int id2 = 200;
        int id3 = 300;
        int id4 = 400;
        float price = 30000;
        ProductDescription desc;

        String[] options = { "red", "blue", "yellow" };
        String[] options2 = { "S", "M", "L" };

        desc = new ProductDescription(id1, price, "for spring >_<!", "TOP", options);
        toplist.put(id1, desc);
        desc = new ProductDescription(id1 + 2, price, "for summer>_<!", "TOP", options);
        toplist.put(id1 + 2, desc);
        this.categoryList.put(1, toplist);

        desc = new ProductDescription(id2, price, "blue", "BOTTOM", options2);
        bottomlist.put(id2, desc);
        this.categoryList.put(2, bottomlist);

        desc = new ProductDescription(id3, price, "yellow", "DRESS", options);
        dresslist.put(id3, desc);
        this.categoryList.put(3, dresslist);

        desc = new ProductDescription(id4, price, "white", "ETC", options2);
        etclist.put(id4, desc);
        this.categoryList.put(4, etclist);

    }

}