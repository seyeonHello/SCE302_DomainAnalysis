import java.util.Scanner;
import java.util.Map;

public class AddCartProcessConsole {

	AddItemController itemcontroller;

	public AddCartProcessConsole(AddItemController aiController) {
		this.itemcontroller = aiController;
	}

	public void scenario() {
		Scanner input = new Scanner(System.in);

		System.out.print("\n\n***********************************\n");
		System.out.print("******** WELCOME TO PAYMO *********\n");
		System.out.print("***********************************\n\n");

		/****************************************************************************
		 * *******************SHOW SHOPPING MALL CATALOGY LIST************************
		 ***************************************************************************/
		System.out.println("____________< CATEGORY >____________\n");
		Map<Integer, Map<Integer, ProductDescription>> templist = this.itemcontroller.startShopping();
		Map<Integer, ProductDescription> onelist;

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
			System.out.println("[itemID]: " + key + "\n[Price]: " + tempDesc.getPrice() + " won\n[description]: "
					+ tempDesc.getDescription() + "\n");
		}
		System.out.println("____________________________________\n");
		/****************************************************************************
		 * ****************SHOW SHOPPING MALL_SELECTING CATALOG ITEM LIST*************
		 ***************************************************************************/
		System.out.printf("Please Select Item: ");
		ProductDescription selectedItem = this.itemcontroller.selectItem(input.nextInt());

		System.out.println("\n\n[options]:" + selectedItem.getOption() + "\n");
		/****************************************************************************
		 * **************************SELECTING OPTIONS*******************************
		 ***************************************************************************/
		System.out.print("Please Select Option: ");
		String opt = input.next();
		System.out.printf("Please Select quantity: ");
		int qty = input.nextInt();
		System.out.println("\n\n____________< TOTAL PRICE >____________\n\n"
				+ this.itemcontroller.selectOption(opt, qty) + " won\n");
		/****************************************************************************
		 * **************************NEXT STEP CART OR ORDER?************************
		 ***************************************************************************/
		System.out.printf("Do you want to..\n");
		System.out.println("1. go to Cart, 2. Order items at Cart, 3. add item to Cart and contiune ");

		int decision = input.nextInt();
		switch (decision) {
			case 1:
				System.out.print(this.itemcontroller.addItem(opt, qty));
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
		}

		// if (decision == 1) {
		// cart.addItem(itemID, quantity, optionID); // ??????? ???
		// cart.showCartItem(); // ??????? ??? ??????? ???
		// System.out.printf("Please select Item: ");
		// itemID = input.nextInt();
		// System.out.printf("Please input quantity(change): ");
		// quantity = input.nextInt();
		// cart.setQuantity(itemID, quantity); // ?????? ??????? ??? ????
		// cart.showCartItem(); // ??????? ??? ??????? ???
		// System.out.printf("Please input deleteItemID: ");
		// itemID = input.nextInt();
		// cart.deleteItem(itemID); // ??? ????? ???? ?????? ??????? ???
		// System.out.printf("DELETE....");
		// cart.showCartItem();
		// } else if (decision == 2) {
		// order.makeLineItem(itemID, quantity, optionID); // ??? ??????
		// } else {
		// cart.addItem(itemID, quantity, optionID); // ??????? ???
		// }

	}
}
