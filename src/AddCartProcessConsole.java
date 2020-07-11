import java.util.Scanner;
import java.util.Map;

public class AddCartProcessConsole {

	private AddItemController itemcontroller;

	public AddCartProcessConsole(AddItemController aiController) {
		this.itemcontroller = aiController;
	}

	public void scenario() {
		int makeChoice = 0;
		Scanner input = new Scanner(System.in);

		System.out.print("\n\n***********************************\n");
		System.out.print("******** WELCOME TO PAYMO *********\n");
		System.out.print("***********************************\n\n");

		/****************************************************************************
		 * *******************SHOW SHOPPING MALL CATALOG LIST************************
		 ***************************************************************************/

		Map<Integer, Map<Integer, ProductDescription>> templist = this.itemcontroller.startShopping();
		Map<Integer, ProductDescription> onelist;
		while (true) {
			System.out.println("____________< CATEGORY >____________\n");
			String[] cataloglist = { "TOP", "BOTTOM", "DRESS", "ETC" };
			for (Integer i = 0; i < 4; i++) {
				onelist = templist.get(i + 1);
				System.out.println("[" + (i + 1) + "]: " + cataloglist[i] + "\n");
			}
			System.out.printf("Please Select Category: \n");
			ProductDescription tempDesc;
			Map<Integer, ProductDescription> itemList = this.itemcontroller.selectCategory(input.nextInt());

			System.out.print("\n\n____________< ITEM LIST >____________\n\n");
			for (Integer key : itemList.keySet()) {
				tempDesc = itemList.get(key);
				System.out.println("[itemID]: " + key + "\n[Price]: " + tempDesc.getPrice() + " won\n");
			}
			System.out.println("____________________________________\n");

			/****************************************************************************
			 * ****************SHOW SHOPPING MALL_SELECTING CATALOG ITEM LIST************
			 ***************************************************************************/
			System.out.printf("Please Select Item: ");
			int selItem = input.nextInt();
			ProductDescription selectedItem = this.itemcontroller.selectItem(selItem);

			System.out.println("\n\n[options]:" + selectedItem.getOption() + "\n[description]: "
					+ selectedItem.getDescription() + "\n");
			/****************************************************************************
			 * **************************SELECTING OPTIONS*******************************
			 ***************************************************************************/
			System.out.print("Please Select Option: ");
			String option = input.next();
			System.out.printf("Please Select quantity: ");
			int quantity = input.nextInt();

			System.out.println("\n\n____________< TOTAL PRICE >____________\n\n"
					+ this.itemcontroller.selectOption(option, quantity) + " won\n");

			/****************************************************************************
			 * **************************NEXT STEP CART OR ORDER?************************
			 ***************************************************************************/

			System.out.printf("Do you want to..\n");
			System.out.println("1. Add The Item and Go to Cart 2. Add The Item and contiune 3. Quit ");

			int decision = input.nextInt();
			int cartdecision, change;
			switch (decision) {
				case 1:
					int itemID;
					this.itemcontroller.addItem(selItem, option, quantity);
					this.itemcontroller.showMeTheCart();
					System.out.printf("\n____________< CART >____________\n");
					System.out.println("1. Make Some Changes(delete, quantity..etc) 2. Order the Items in the Cart :");
					cartdecision = input.nextInt();
					if (cartdecision == 1) {
						System.out.println("Choose an Item to give a Change: ");
						itemID = input.nextInt();
						itemcontroller.selectCartItem(itemID);

						System.out.println("What Do You want to do with this Item?\n");
						System.out.println("1. Delete Item 2. Change Quantity\n");
						change = input.nextInt();

						if (change == 1) {
							System.out.println("Are you sure You want to Delete the Item? (Deleting it anyway..): \n");
							itemcontroller.deleteItem(itemID);
						} else if (change == 2) {
							System.out.println("The Quantity want to change: \n");
							int itemqty = input.nextInt();
							itemcontroller.changeItemQuantity(itemID, itemqty);
						}
						// Order the Items in the List
					} else if (cartdecision == 2) {

					}
					makeChoice = 1;

					break;
				case 2:
					this.itemcontroller.addItem(selItem, option, quantity);

					makeChoice = 2;
					break;
				case 3:
					this.itemcontroller.showMeTheCart();
					makeChoice = 3;
					break;
				default:
					break;
			}
			if (makeChoice == 1)
				break;
			else if (makeChoice == 2)
				continue;
			else
				break;
		}
	}
}
