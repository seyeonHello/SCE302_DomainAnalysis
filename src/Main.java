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
			catalog.showItemList(catalogID); // itemList출력

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
				cart.addItem(itemID, quantity, optionID); //장바구니에 담기
				cart.showCartItem(); //장바구니에 담긴 상품들을 확인
				System.out.printf("Please select Item: ");
				itemID = input.nextInt();
				System.out.printf("Please input quantity(change): ");
				quantity = input.nextInt();
				cart.setQuantity(itemID,quantity); //수량을 변경하는 경우 테스트
				cart.showCartItem(); //장바구니에 담긴 상품들을 확인
				System.out.printf("Please input deleteItemID: ");
				itemID = input.nextInt();
				cart.deleteItem(itemID); //해당 아이디를 가진 아이템 삭제하는 경우
				System.out.printf("DELETE....");
				cart.showCartItem();
				break;
			} 
			else if(decision==2){
				order.makeLineItem(itemID, quantity, optionID); //바로 주문하기
				break;
			}
			else {
				cart.addItem(itemID, quantity, optionID); //장바구니에 담기
				continue;
			}
		
		}

	}

}
