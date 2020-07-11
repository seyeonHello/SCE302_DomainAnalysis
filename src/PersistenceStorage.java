import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;

public class PersistenceStorage {
	private File file = new File("./Output.txt");

	public PersistenceStorage() {

	}

	// public void insert(OrderLineHistory orderlinehistory) {
	// try {
	// FileWriter fw = new FileWriter(file, true);
	// String str = orderlinehistory.getOption() + " " + orderlinehistory.getID();
	// String str2 = "\n";
	// fw.append(str);
	// fw.append(str2);
	// fw.close();
	// } catch (Exception e) {
	// e.getStackTrace();
	// }
	// }

	public void update(Map<Integer, Order> orderList) {

		Order temporder;
		Map<Integer, OrderLineItem> oliList;
		OrderLineItem oli;
		String str2 = new String();
		try {
			FileWriter fw = new FileWriter(file);
			for (Integer key : orderList.keySet()) {
				temporder = orderList.get(key);
				String str = temporder.getOrderID() + " " + temporder.getDate();
				oliList = temporder.getLineItem();
				for (Integer key2 : oliList.keySet()) {
					oli = oliList.get(key2);
					str2 = str2 + oli.getID() + " " + oli.getStatus();
				}
				str2 = str2 + "\n";
				fw.append(str);
				fw.append(str2);
			}
			fw.close();

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
