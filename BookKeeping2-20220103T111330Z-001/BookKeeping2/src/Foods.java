
import java.io.*;
import java.util.*;

public class Foods {
	private ArrayList<Purchase>foods;
	private int limit;
//	private File detail;
//	private FileWriter writer;
	
	public Foods(int limit) {
		this.limit = limit;
		this.foods = new ArrayList<Purchase>();
//		this.detail = new File("foods.txt");
//		this.writer = new FileWriter("foods.txt");
	}
	
	public int getLimit() {
		return limit;
	}
	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public void addFoods(String name, int price) {
		Purchase pur = new Purchase(name, price);
		foods.add(pur);
		try {
			FileWriter writer = new FileWriter("foods.txt");
			writer.write(name + " " + price);
			writer.close();
			//System.out.println("記錄成功！");
		}catch(IOException e) {
			System.out.println(e);
		}
		
		
	}
	
	public int getTotal() {
		int total = 0;
		for(Purchase p: foods) {
			total = total + p.getPrice();
		}
		return total;
	}
	
	public String detail() {
		String detail = "";
		for(Purchase p: foods) {
			detail = detail + p.getName() + " " + p.getPrice() + "\n";
		}
		detail = "食物: \n" + detail + "\nTotal: " + this.getTotal() + "\n";
		return detail;
	}

}
