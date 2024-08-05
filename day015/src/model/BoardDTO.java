package model;

public class BoardDTO {
	private int num;
	private String title;
	private String content;
	private int cnt;
	private String writer;
	//: 상대 DTO의 PK값 == FK
	private String condition;
	
	public String getcondition() {
		return condition;
	}
	public void setcondition(String condition) {
		this.condition = condition;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", title=" + title + ", content=" + content + ", cnt=" + cnt + ", writer="
				+ writer + "]";
	}
}