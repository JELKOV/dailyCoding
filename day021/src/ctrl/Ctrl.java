package ctrl;

import java.util.ArrayList;

import model.ProductDAO;
import model.ProductDTO;
import view.View;

public class Ctrl {
	private View view;
	private ProductDAO productDAO;
	public Ctrl() { // 생성자 : 멤버변수 초기화, 생성자를 통해 객체를 생성할수있음
		this.view=new View();
		this.productDAO=new ProductDAO();
	}
	public void start() {
		while(true) {
			view.printMenuList();
			int menuNum=view.inputMenuNum();
			
			if(menuNum==0) {
				view.print00();
				break;
			}
			else if(menuNum==1) {
				ProductDTO productDTO=new ProductDTO();
				ArrayList<ProductDTO> datas=productDAO.selectAll(productDTO);
				view.print01(datas);
			}
			else if(menuNum==2) {
				int num=view.inputProductNum();
				ProductDTO productDTO=new ProductDTO();
				productDTO.setNum(num);
				ProductDTO data=productDAO.selectOne(productDTO);
				view.print02(data);
			}
		}
	}
}
