
public class ShoppingMall{   
	private ProductCatalog catalog = new ProductCatalog();
	private Cart cart = new Cart( catalog );
	public Cart getCart() { return cart; } 
	public ProductCatalog getCatalog() { return catalog;}
}
