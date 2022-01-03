import java.io.FileWriter;

import java.util.ArrayList;

public class Others extends Foods{
	private String nameOfOthers;
	private int price;
	private ArrayList<Purchase>others;
	
	public Others(int limit, String nameOfOthers, int price) {
		super(limit);
		this.nameOfOthers = nameOfOthers;
		this.price  = price;
		this.others = new ArrayList<Purchase>();
		
	}
	
	public void addOthers(String name, int price) {
		Purchase pur = new Purchase(name, price);
		others.add(pur);
		System.out.println("記錄成功！");
		
	}
	
	public int getTotal() {
		int total = 0;
		for(Purchase p: others) {
			total = total + p.getPrice();
		}
		return total;
	}
	public String detail() {
		String detail = "";
		for(Purchase p: others) {
			detail = detail + p.getName() + " " + p.getPrice() + "\n";
		}
		detail = "其他: \n" + detail + "\nTotal: " + this.getTotal() + "\n";
		return detail;
	}

}