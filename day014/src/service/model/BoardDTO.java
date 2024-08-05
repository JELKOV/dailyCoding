package service.model;

//데이터 그자체를 의미
//게시글 속성이 어떻게 되는지 파악

//PK(번호)/ 게시글 제목/내용/조회수/ - > pk가 가장 중요해서 변수를 앞에 두는게 좋다
//getter setter tostring 

public class BoardDTO {
	private int num;
	private String title;
	private String content;
	private int cnt;
	private String condition;// 개발자에게 필요한 변수
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
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
	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", title=" + title + ", content=" + content + ", cnt=" + cnt + "]";
	}

}
