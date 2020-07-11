
public class ProductDescription {
	private int itemID;
	private float price;
	private String description;
	private String categoryName;
	private String[] option = new String[10];

	public ProductDescription(int id, float price, String description, String category, String[] option) {
		this.itemID = id;
		this.price = price;
		this.description = description;
		this.categoryName = category;
		this.option = option;
	}

	public String getOption() {
		String itemOption = new String();

		for (String opt : this.option) {
			itemOption = itemOption + opt + " ";
		}
		return itemOption;
	}

	public int getItemID() {
		return itemID;
	}

	public float getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getCategoryName() {
		return categoryName;
	}
}
