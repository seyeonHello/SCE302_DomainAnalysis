
public class ShoppingMall{   
	private ProductCatalog catalog = new ProductCatalog();
	private Cart cart = new Cart( catalog );
	private Order order = new Order( catalog );
	public Cart getCart() { return cart; } 
	public ProductCatalog getCatalog() { return catalog;}	
	public Order getOrder() { return order;}
}
