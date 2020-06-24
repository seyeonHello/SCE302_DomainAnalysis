import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("***********************************\n");
		System.out.print("******** WELCOME TO PAYMO *********\n");
		System.out.print("***********************************\n");
		ShoppingMall shop=new ShoppingMall();
		
		Cart cart=shop.getCart();
		
		ProductCatalog catalog=shop.getCatalog();
		System.out.print("____________< CATEGORY >____________\n");
		System.out.println();
		catalog.showCategoryList();
		System.out.printf("Please Select Category: ");
		int catalogID=input.nextInt();
		System.out.println();
		System.out.print("____________< ITEM LIST >____________\n");
		catalog.showItemList(catalogID); //itemList출력
		
		System.out.printf("Please Select Item: ");
		int itemID=input.nextInt();
		System.out.printf("Please Select quantity: ");
		int quantity=input.nextInt();
		cart.enterItem(itemID,quantity); //상품 담기
		
		int Cash=300000;
		cart.makePayment(Cash); //결제하기
	}

}
