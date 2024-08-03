package service.model;

// MVC 패턴에서 data를 VO, DTO라고 함
public class StudentDTO {
	private int num;
	private String name;
	private int score;
	private double avg;
	private String condition;
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "StudentDTO [num=" + num + ", name=" + name + ", score=" + score + "]";
	}
}
