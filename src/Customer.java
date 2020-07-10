public class Customer {
    private String customerName;
    private String customerId;
    private Cart cart;

    public Customer(String name, String id) {
        System.out.print("new customer");
        this.customerName = name;
        this.customerId = id;
        this.cart = new Cart();
    }

    public String getName() {
        return this.customerName;
    }

    public String getID() {
        return this.customerId;
    }

    public void setName(String name) {
        this.customerName = name;
    }

    public void setID(String id) {
        this.customerId = id;
    }

    public Cart getCart() {
        return this.cart;
    }
}