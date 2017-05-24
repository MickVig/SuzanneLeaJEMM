package Presentation;

import java.util.List;

import bean.Agenda;
import dao.AgendaDAO;
import service.FormulaireService;
import service.PersonneService;


public class Exec {

	public static void main(String[] args) {
		
		String mail = "test@gmail.com";
		String mdp = "12ghg";
		String nom="lo'e";
		String prenom="chouchou";
		String adresse="10 r";
		String tel="0214325612";
		
		FormulaireService.getInstance().verifInscription(nom, prenom, adresse, tel, mail, mdp);
		
		System.out.println("fait");
		

	}

}
