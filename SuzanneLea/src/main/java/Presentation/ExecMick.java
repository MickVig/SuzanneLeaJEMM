package Presentation;

import dao.AidantDAO;

public class ExecMick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(AidantDAO.getInstance().readAllAidantType(2));
	}

}
