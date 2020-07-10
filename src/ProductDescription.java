
public class ProductDescription {
	private int id;
	private float price;
	private String description;
	private String categoryName;
	private String[] option = new String[10];

	public ProductDescription(int id, float price, String description, String category, String[] option) {
		this.id = id;
		this.price = price;
		this.description = description;
		this.categoryName = category;
		this.option = option;
	}

	public String getOption() {
		String returnOpt = new String();

		for (String opt : this.option) {
			returnOpt = returnOpt + opt + " ";
		}
		return returnOpt;

	}

	public int getItemID() {
		return id;
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
