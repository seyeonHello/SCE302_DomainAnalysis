import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShoppingMall shop=new ShoppingMall();
		Cart cart=shop.getCart();
		ProductCatalog catalog=shop.getCatalog();
		catalog.showItemList(); //itemList���
		cart.enterItem(100, 10); //��ǰ ���
		int Cash=300000;
		cart.makePayment(Cash); //�����ϱ�
	}

}
