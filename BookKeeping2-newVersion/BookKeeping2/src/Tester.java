import java.util.*;
import java.io.*;
import java.io.File;

public class Tester {
	static Foods foods = new Foods(7500);
	static Clothes clothes = new Clothes(3000);
	static Entertainment entertainments = new Entertainment(2000);
	static int check;
	static Scanner sc = new Scanner(System.in);
	
	public static void bookKeeping(String name, int price) {
		System.out.println("分類至: 1. foods, 2. clothes, 3. entertainments");
		check = sc.nextInt();
		if(check == 1) {
			foods.addFoods(name, price);
		}else if(check == 2) {
			clothes.addClothes(name, price);
		}else if(check == 3) {
			entertainments.addEntertainments(name, price);
		}
	}
	
	public static void alert() {
		if(foods.getTotal() >= foods.getLimit()) {
			System.out.println("食物消費已超過上限, 請謹慎消費！");
		}else if(foods.getTotal() >= foods.getLimit()*0.8) {
			System.out.println("食物消費已達80%, 請謹慎消費！");
		} 
		
		if(clothes.getTotal() >= clothes.getLimit()) {
			System.out.println("衣著消費已超過上限, 請謹慎消費！");
		}else if(clothes.getTotal() >= clothes.getLimit()*0.8) {
			System.out.println("衣著消費已達80%, 請謹慎消費！");
		} 
		
		if(entertainments.getTotal() >= entertainments.getLimit()) {
			System.out.println("娛樂消費已超過上限, 請謹慎消費！");
		}else if(entertainments.getTotal() >= entertainments.getLimit()*0.8) {
			System.out.println("娛樂消費已達80%, 請謹慎消費！");
		}
		
		
		
	}
	
	public static String summary() {
		String result = null;
		result = String.format("總覽: \nFoods: \n%d元 %.2f %c\nClothes: \n%d元 %.2f %c\nEntertainments: \n%d元 %.2f %c\n\n目前消費金額最高的類別為: ",
				foods.getTotal(), (foods.getTotal()*100.0/(foods.getTotal()+clothes.getTotal()+entertainments.getTotal())), '%',
				clothes.getTotal(), (clothes.getTotal()*100.0/(foods.getTotal()+clothes.getTotal()+entertainments.getTotal())), '%',
				entertainments.getTotal(), (entertainments.getTotal()*100.0/(foods.getTotal()+clothes.getTotal()+entertainments.getTotal())), '%');
		if(foods.getTotal() >= clothes.getTotal() && foods.getTotal() >= entertainments.getTotal()) {
			result += "Foods ";
		}
		if(clothes.getTotal() >= foods.getTotal() && clothes.getTotal() >= entertainments.getTotal()) {
			result += "Clothes ";
		}
		if(entertainments.getTotal() >= foods.getTotal() && entertainments.getTotal() >= clothes.getTotal()) {
			result += "Entertainments ";
		}
		return result;
	}
	
	public static void detail() {
		if(check == 1) {
			System.out.print(foods.detail());
		}else if(check == 2) {
			System.out.print(clothes.detail());
		}else if(check == 3) {
			System.out.print(entertainments.detail());
		}
	}

	public static void main(String[] args) {
		String prompt = "1. 記帳, 2. 查看總覽, 3. 查看單一類別明細: ";
		double payment = (Math.pow((1+0.00749),84) * 0.00749) / (Math.pow((1+0.00749),84)-1);
		System.out.println(payment);
		
		System.out.print(prompt);
		while(sc.hasNextInt()) {
			check = sc.nextInt();
			if(check == 1) {
				System.out.print("名稱: ");
				String name = sc.next();
				System.out.print("金額: ");
				int price = sc.nextInt();
				
				bookKeeping(name, price);
				alert();

			}else if(check == 2){
				System.out.println(summary());
				
			}else if(check == 3) {
				System.out.println("請選擇要查看的類別: 1. foods, 2. clothes, 3. entertainments");
				check = sc.nextInt();
//				try {
//					Scanner in = new Scanner(new File("foods.txt"));
//					System.out.println(in.nextLine());
//					
//				}catch(Exception e) {
//					System.out.println(e);
//				}
				detail();
				
			}
			
			System.out.println("-".repeat(40));
			System.out.print(prompt);
		}
		
		System.out.print("Thank you~");

	}

}
