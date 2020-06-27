import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("***********************************\n");
		System.out.print("******** WELCOME TO PAYMO *********\n");
		System.out.print("***********************************\n");
		ShoppingMall shop = new ShoppingMall();

		Cart cart = shop.getCart();
		Order order = shop.getOrder();
		
		loop: while (true) {
			ProductCatalog catalog = shop.getCatalog();
			System.out.print("____________< CATEGORY >____________\n");
			System.out.println();
			catalog.showCategoryList();
			System.out.printf("Please Select Category: ");
			int catalogID = input.nextInt();
			System.out.print("____________< ITEM LIST >____________\n");
			catalog.showItemList(catalogID); // itemList���

			System.out.printf("Please Select Item: ");
			int itemID = input.nextInt();
			System.out.print("____________< OPTION LIST >____________\n");
			System.out.println("s m l");
			System.out.print("Please Select Option: ");
			String optionID=input.next();
			System.out.printf("Please Select quantity: ");
			int quantity = input.nextInt();
			System.out.println("1. go to Cart, 2. go to Order, 3. add item to Cart and contiune ");
			System.out.printf("Please Select Next: ");
			int decision = input.nextInt();
			if (decision == 1) {
				cart.addItem(itemID, quantity, optionID); //��ٱ��Ͽ� ���
				cart.showCartItem(); //��ٱ��Ͽ� ��� ��ǰ���� Ȯ��
				System.out.printf("Please select Item: ");
				itemID = input.nextInt();
				System.out.printf("Please input quantity(change): ");
				quantity = input.nextInt();
				cart.setQuantity(itemID,quantity); //������ �����ϴ� ��� �׽�Ʈ
				cart.showCartItem(); //��ٱ��Ͽ� ��� ��ǰ���� Ȯ��
				System.out.printf("Please input deleteItemID: ");
				itemID = input.nextInt();
				cart.deleteItem(itemID); //�ش� ���̵� ���� ������ �����ϴ� ���
				System.out.printf("DELETE....");
				cart.showCartItem();
				break;
			} 
			else if(decision==2){
				order.makeLineItem(itemID, quantity, optionID); //�ٷ� �ֹ��ϱ�
				break;
			}
			else {
				cart.addItem(itemID, quantity, optionID); //��ٱ��Ͽ� ���
				continue;
			}
		
		}

	}

}
