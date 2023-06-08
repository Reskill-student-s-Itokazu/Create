package la.bean;

import java.io.Serializable;

public class PlusBean implements Serializable {
	private int number1;
	private int number2;
	private int answer;
	public int getNumber1() {
		return number1;
	}
	public void setNumber1(int number1) {
		this.number1 = number1;
	}
	public int getNumber2() {
		return number2;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	public PlusBean(int number1, int number2, int answer) {
		super();
		this.number1 = number1;
		this.number2 = number2;
		this.answer = answer;
	}
	
	public PlusBean() {
		
	}
}
