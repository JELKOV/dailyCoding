package service.controller;

import java.util.ArrayList;

import service.model.StudentDAO;
import service.model.StudentDTO;
import view.StudentView;

public class StudentController {
	private StudentDAO model;
	private StudentView view;
	private int PK;
	public StudentController() {
		this.model=new StudentDAO();
		this.view=new StudentView();
		this.PK=104;
	}

	// 사용자(Client)에게 [M과 V를 조합해서] 서비스를 제공하는 역할
	public void start() {
		while(true) {
			view.print01();
			int action=view.inputAction();

			if(action==1) {
				view.print02();
				String name=view.inputName();
				view.print03();
				int score=view.inputScore();
				StudentDTO studentDTO=new StudentDTO();
				studentDTO.setNum(PK++);
				studentDTO.setName(name);
				studentDTO.setScore(score);
				boolean flag=model.insert(studentDTO);
				if(flag) {
					view.print04();
				}
				else {
					// 실패했습니다.
				}
			}
			else if(action==2) {
				StudentDTO studentDTO=new StudentDTO();
				studentDTO.setCondition("ALL");
				ArrayList<StudentDTO> datas=model.selectAll(studentDTO);
				view.print05(datas);
			}
			else if(action==3) {
				view.print07();
				int num=view.inputNum(PK);
				StudentDTO studentDTO=new StudentDTO();
				studentDTO.setNum(num);
				studentDTO.setCondition("SEARCH_NUM");
				StudentDTO datas=model.selectOne(studentDTO);
				if(datas !=null) {
					view.print08(datas);
				}
				else {
					view.print06();
				}
			}
			else if(action==4) {
				view.print12();
				String name=view.inputName();
				StudentDTO studentDTO=new StudentDTO();
				studentDTO.setName(name);
				studentDTO.setCondition("SEARCH_NAME");
				ArrayList<StudentDTO> datas=model.selectAll(studentDTO);
				if(datas.size()==0) {
					view.print06();
				}
				else {
					view.print13(datas);
				}
			}
			else if(action==5) {
				StudentDTO studentDTO=new StudentDTO();
//				studentDTO.setCondition("ALL");
//				ArrayList<StudentDTO> datas=model.selectAll(studentDTO);
				//데이터를 view에맞게 가공한다 !!  데이터 정제 
//				int sum=0;
//				int size=datas.size();
//				for(StudentDTO data:datas) {
//					sum+=data.getScore();
//				}
//				double avg=sum*1.0/size*1.0;
				studentDTO.setCondition("AVG");
				StudentDTO data=model.selectOne(studentDTO);
				view.print18(data.getAvg());
			}
			else if(action==6) {
				view.print14();
				int num=view.inputNum(PK);
				StudentDTO studentDTO=new StudentDTO();
				studentDTO.setNum(num);
				studentDTO.setCondition("SEARCH_NUM");
				StudentDTO datas=model.selectOne(studentDTO);
				if(datas==null) {
					view.print06();
					break;
				}
				else {
					view.print08(datas);
					view.print15();
					int score=view.inputScore();
					studentDTO.setNum(score);
					studentDTO.setCondition("SCORE");
					boolean flag=model.update(studentDTO);
					if(flag) {
						view.print16();
					}
					else {
						view.print17();
					}
				}
			}
			else if(action==7) {
				view.print09();
				int num=view.inputNum(PK);
				StudentDTO studentDTO=new StudentDTO();
				studentDTO.setNum(num);
				boolean flag=model.delete(studentDTO);
				if(flag) {
					view.print10();
				}
				else {
					view.print11();
				}
			}
			else if(action==0) {
				break;
			}
		}
	}
}
