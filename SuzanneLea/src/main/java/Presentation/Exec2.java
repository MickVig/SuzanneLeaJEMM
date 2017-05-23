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
		
		//lire les CR �crits dans la BDD
		ICompteRenduDAO dao = CompteRenduDAO.getInstance();
		System.out.println(dao.readCompteRendu(1));
		System.out.println(dao.readCompteRendu(2));
		System.out.println(dao.readCompteRendu(3));
		System.out.println("ok");
		
		//lire tous les CR (aidant)
		CompteRenduDAO.getInstance().comptesRendusAidant(3);
		//dao.comptesRendusAidant(3).get(3);
		
		//lire tous les CR (aidee)
		CompteRenduDAO.getInstance().comptesRendusAidee(1);
		//dao.comptesRendusAidee(1).get(1);
		
		
		//date
		Date DateCR = new Date();
		//�crire CR dans BDD
		dao.createCompteRendu(DateCR, "blablabla", 2, 1);

		
		
	}
}
