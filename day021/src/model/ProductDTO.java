package model;

public class ProductDTO {
	private int num; // PK
	private String name;
	private int price;
	private int cnt;
	//Count는 SQL에서 키워드 사용 xx
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return cnt;
	}
	public void setCount(int count) {
		this.cnt = count;
	}
	@Override
	public String toString() {
		System.out.print("품번 : "+this.num+"번 \t"); // 제어문자
		System.out.print("재고 : "+this.cnt+"개 \t");
		System.out.print("가격 : "+this.price+"원 \t");
		return "상품명 : "+this.name;
	}
}
