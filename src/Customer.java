public class Customer {
    private String customerName;
    private String customerId;
    private Cart cart;
    private String Address;

    public Customer(String name, String id, String Address) {
        System.out.print("new customer");
        this.customerName = name;
        this.customerId = id;
        this.Address = Address;
        this.cart = new Cart();
    }

    public String getName() {
        return this.customerName;
    }

    public String getAddress() {
        return this.Address;
    }

    public String getID() {
        return this.customerId;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setName(String name) {
        this.customerName = name;
    }

    public void setID(String id) {
        this.customerId = id;
    }

}