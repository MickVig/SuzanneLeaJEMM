package Presentation;

import java.text.SimpleDateFormat;
import java.util.Date;

import bean.CompteRendu;
import dao.AidantDAO;
import dao.AideeDAO;
import dao.CompteRenduDAO;
import dao.ICompteRenduDAO;
import dao.IPersonneDAO;
import dao.PersonneDAO;

public class Exec2 {

	public static void main(String[] args) {
		
		//lire les CR écrits dans la BDD
		ICompteRenduDAO dao = CompteRenduDAO.getInstance();
		System.out.println(dao.readCompteRendu(1));
		System.out.println(dao.readCompteRendu(2));
		System.out.println(dao.readCompteRendu(3));
		System.out.println("ok");
		
		//lire tous les CR (liste)
		CompteRenduDAO.getInstance().comptesRendusAidant(1);
		dao.comptesRendusAidant(1);
		
		
		
		//date
//		SimpleDateFormat formater = null;
//		Date DateCR = new Date();
//		formater = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(formater.format(DateCR));
//		//écrire CR dans BDD
//		CompteRendu cr = new CompteRendu();
//		dao.createCompteRendu(DateCR, "blablabla", 4, 3);

		
		
		
		
		
		
		
		
		
	}
}
