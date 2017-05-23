package Presentation;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		//dao.comptesRendusAidee(1);
		System.out.println("ok");
		
		
		//date
		SimpleDateFormat formater = null;
		Date DateCR = new Date();
		formater = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(formater.format(DateCR));
		//écrire CR dans BDD
		dao.createCompteRendu(DateCR, "blablabla", 4, 3);
		
	}
}
