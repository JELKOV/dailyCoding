package service;

public class Calc {
	private int num1;
	private int num2;
	private String op;
	private int result;
	//getter setter는 필수이고 생성자는 필요할때 만들어야 한다 !! 
	//뷰단에서 유효성검사를 하기때문에 서비스 단에서는 안해도 된다 !! 
	
	public void calc() {
		if(op.equals("+")) {
			result=num1+num2;
		}
		else if(op.equals("-")) {
			result=num1-num2;
		}
		else if(op.equals("X")) {
			result=num1*num2;
		}
	}
	
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}


}
