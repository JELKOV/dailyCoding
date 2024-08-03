package client;

import service.Calc;
import view.CalcView;

public class Client {
	public static void main(String[] args) {

		CalcView view=new CalcView();
		Calc service=new Calc();
		
		while(true) {
			view.printIntInfo();
			int num1=view.inputInt();
			view.printOpINfo();
			String op=view.inputOp();
			view.printIntInfo();
			int num2=view.inputInt();
			
			service.setNum1(num1);// 계산기능을 하려면 다음과 같은 값들을 가지고 있어야 한다 .
			service.setOp(op);
			service.setNum2(num2);
			service.calc();
			int result=service.getResult();
			
			view.printResult(num1, op, num2, result);
		}

	}
}
