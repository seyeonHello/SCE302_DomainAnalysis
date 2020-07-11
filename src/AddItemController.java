import java.util.ArrayList;
import java.util.Map;

// import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class AddItemController {

    private Cart cart;
    private Customer customer;
    private ProductCatalog catalog;
    private Map<Integer, ProductDescription> selectedCatalog;
    private ProductDescription selectedItem;

    public AddItemController(ProductCatalog catalog, Customer customer) {
        this.catalog = catalog;
        this.customer = customer;
        this.cart = customer.getCart();
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

    // Add Item to the Cart,and show the list with Total
    public void addItem(String option, int quantity) {
        this.cart.addItem(selectedItem, quantity, option);
    }

    public void showMeTheCart() {
        Map<Integer, OrderLineItem> lineItems = cart.getLineItems();
        StringBuilder returnString = new StringBuilder();
        OrderLineItem oli;
        for (Integer key : lineItems.keySet()) {
            oli = lineItems.get(key);
            returnString.append("[itemID]: " + oli.getID() + "\n[Option]: " + oli.getOption() + " \n[Quantity]: "
                    + oli.getQuantity() + "\n\n");
        }
        returnString.append("[Total Price]: " + this.cart.getTotal() + "\n");

    }

    // Change the Quantity of The Selected Item and show the change
    public void changeItemQuantity(int itemID, int quantity) {
        OrderLineItem oli = cart.setQuantity(itemID, quantity);
        System.out.println("[itemID]: " + oli.getID() + "\n[Option]: " + oli.getOption() + " \n[Quantity]: "
                + oli.getQuantity() + "\n\n");
        System.out.print("[Total Price]: " + this.cart.getTotal() + "\n");
    }

    // Delete the Selected Item from the Cart and show the Change
    public void deleteItem(int itemID) {
        cart.deleteItem(itemID);
        Map<Integer, OrderLineItem> lineItems = this.cart.getLineItems();

        OrderLineItem oli;
        for (Integer key : lineItems.keySet()) {
            oli = lineItems.get(key);
            System.out.print("[itemID]: " + oli.getID() + "\n[Option]: " + oli.getOption() + " \n[Quantity]: "
                    + oli.getQuantity() + "\n\n");
        }
        System.out.print("[Total Price]: " + this.cart.getTotal() + "\n");

    }

    // get the Selected Item from the Cart LineItem and show
    public void selectCartItem(int itemID) {
        OrderLineItem oli = cart.getLineItem(itemID);
        System.out.println("[itemID]: " + oli.getID() + "\n[Option]: " + oli.getOption() + " \n[Quantity]: "
                + oli.getQuantity() + "\n\n");

    }
}