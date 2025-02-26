package day0124;

class Ramen {
	
	private int price, kcal;
	private String name, taste;
	
	public Ramen() {
		this.price = 1000;
		this.kcal = 500;
		this.name = "신라면";
		this.taste = "Soso";
	}
	public Ramen(int price, String name, int kcal, String taste) {
		this.price = price;
		this.name = name;
		this.kcal = kcal;
		if(!("Spicy".equals(taste) || "Soso".equals(taste) || "Mild".equals(taste))) {
			this.taste = "Soso";
		} else {
			this.taste = taste;
		}
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		if(!("Spicy".equals(taste) || "Soso".equals(taste) || "Mild".equals(taste))) {
			this.taste = "Soso";
		}
		this.taste = taste;
	}
	public void ramenInfo() {
		System.out.printf("%s 구입, 가격은 %d, 칼로리는 %d이며 라면의 맛은 %s다.\n", this.name, this.price, this.kcal, this.taste);
	}
	
}
public class Exam0124 {
	
	public static void main(String[] args) {
		
		Ramen r = new Ramen(1500, "불닭볶음면", 530, "Spicy");
		r.ramenInfo();
		
	}
}
