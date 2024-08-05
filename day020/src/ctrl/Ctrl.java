package ctrl;

import java.util.ArrayList;

import model.DataDAO;
import model.DataDTO;

public class Ctrl {
	private DataDAO model;
	public Ctrl() {
		model=new DataDAO();
	}
	public void start() {
		ArrayList<DataDTO> datas = model.selectAll(null);
		System.out.println(datas);
	}
}
