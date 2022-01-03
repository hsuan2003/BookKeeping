import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Meal extends Foods{
	private String nameOfMeal;
	private int price;
	private ArrayList<Purchase>meals;
	
	public Meal(int limit, String nameOfMeal, int price) {
		super(limit);
		this.nameOfMeal = nameOfMeal;
		this.price  = price;
		this.meals = new ArrayList<Purchase>();
		
	}
	
	public void addMeals(String name, int price) {
		Purchase pur = new Purchase(name, price);
		meals.add(pur);
		System.out.println("記錄成功！");
		
	}
	
	public int getTotal() {
		int total = 0;
		for(Purchase p: meals) {
			total = total + p.getPrice();
		}
		return total;
	}
	public String detail() {
		String detail = "";
		for(Purchase p: meals) {
			detail = detail + p.getName() + " " + p.getPrice() + "\n";
		}
		detail = "正餐: \n" + detail + "\nTotal: " + this.getTotal() + "\n";
		return detail;
	
	}

}

