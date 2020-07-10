import java.util.ArrayList;
import java.util.Map;

// import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class AddItemController {
    ShoppingMall shop;
    Cart cart;
    Customer customer;
    ProductCatalog catalog;
    Map<Integer, ProductDescription> selectedCatalog;
    ProductDescription selectedItem;

    public AddItemController(ShoppingMall shop) {

        this.shop = shop;
        this.catalog = shop.getCatalog();
        this.customer = shop.getCustomer();

        this.cart = shop.getCustomer().getCart();
        System.out.print("WHYYYYYYYYYYYYYYYYYYYYY\n");
    }

    public Map<Integer, Map<Integer, ProductDescription>> startShopping() {
        Map<Integer, Map<Integer, ProductDescription>> templist = catalog.getCatalogList();
        return templist;
    }

    public Map<Integer, ProductDescription> selectCategory(int catalogID) {
        this.selectedCatalog = catalog.selectCategory(catalogID);
        return selectedCatalog;
    }

    public ProductDescription selectItem(int itemID) {
        this.selectedItem = selectedCatalog.get(itemID);
        return selectedItem;
    }

    public float selectOption(String option, int quantity) {
        return selectedItem.getPrice() * quantity;
    }

    public StringBuilder addItem(String option, int quantity) {
        Map<Integer, OrderLineItem> lineItems = this.cart.addItem(selectedItem, quantity, option);
        StringBuilder returnString = new StringBuilder();
        OrderLineItem oli;
        for (Integer key : lineItems.keySet()) {
            oli = lineItems.get(key);
            returnString.append("[itemID]: " + oli.getID() + "\n[Option]: " + oli.getOption() + " \n[Quantity]: "
                    + oli.getQuantity() + "\n\n");
        }
        returnString.append("[Total Price]: " + this.cart.getTotal() + "\n");
        return returnString;
    }

    // public void makeNewOrder() {
    // shop.getOrderHistory().makeNewOrder(customer);
    // }
}