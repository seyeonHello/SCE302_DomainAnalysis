import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class PersistenceStorage {
	ArrayList<OrderLineHistory> lineItems = new ArrayList<OrderLineHistory>();

	
	public void insert(OrderLineHistory orderlinehistory) {
		try {
			File file = new File("C:\\Users\\Owner\\Desktop\\소프트웨어\\도메인분석및설계\\PAYMO\\src\\Output.txt");
			FileWriter fw = new FileWriter(file, true);
			String str = orderlinehistory.getOption()+" "+orderlinehistory.getID();
			String str2="\n";
			fw.append(str);
		    fw.append(str2);
		    fw.close();
				
		} catch (Exception e) {
	            e.getStackTrace();
		}
	}
	public void update(ArrayList<OrderLineHistory> lineItems2) {
		try {
			File file = new File("C:\\Users\\Owner\\Desktop\\소프트웨어\\도메인분석및설계\\PAYMO\\src\\Output.txt");
			FileWriter fw = new FileWriter(file);
			for (OrderLineHistory element : lineItems2) {
				String str = element.getOption()+" "+element.getID();
				String str2="\n";
				fw.append(str);
			    fw.append(str2);
				}
			
		    fw.close();
				
		} catch (Exception e) {
	            e.getStackTrace();
		}
	}
	public ArrayList<OrderLineHistory> select() {
		try {
			File file = new File("C:\\Users\\Owner\\Desktop\\소프트웨어\\도메인분석및설계\\PAYMO\\src\\Output.txt");
			FileReader fr = new FileReader(file);
			
			BufferedReader bufReader = new BufferedReader(fr);
            String line = "";
            //String split[];
            while((line = bufReader.readLine()) != null){
            	String split[]=line.split(" ");
            	int num=3;
            	float price=100;
            	lineItems.add(new OrderLineHistory(Integer.parseInt(split[1]),split[0],num,price)); 
            }
				
		} catch (Exception e) {
	            e.getStackTrace();
		}
		return lineItems;
	}
}
