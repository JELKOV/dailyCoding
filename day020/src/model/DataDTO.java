package model;

public class DataDTO {
	private int pk;
	private String title;
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "DataDTO [pk=" + pk + ", title=" + title + "]";
	}
}
