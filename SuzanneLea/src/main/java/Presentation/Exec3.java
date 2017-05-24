package Presentation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.AideeDAO;

public class Exec3 {

	public static void main(String[] args) {
		
		
		//AideeDAO.getInstance().readAideeByPersonne(55);
		
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date = new Date();
		String date2 = sdf.format(date);
		System.out.println(date2);
		
		
		//System.out.println("Methode validee");
		
		

	}

}
