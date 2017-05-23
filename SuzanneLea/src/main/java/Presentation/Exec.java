package Presentation;

import java.util.Date;

import bean.Aidant;
import bean.Aidee;
import bean.CompteRendu;
import bean.Personne;
import bean.Relation;
import bean.Type;
import dao.AidantDAO;
import dao.AideeDAO;
import dao.ConnexionDAO;
import dao.IPersonneDAO;
import dao.PersonneDAO;


public class Exec {

	public static void main(String[] args) {

		IPersonneDAO dao = PersonneDAO.getInstance();		
		//dao.personneExiste("marc.bonraisin@free.fr", "taxi1");	
		
		Personne p=AideeDAO.getInstance().readProcheRef(1);
		System.out.println(p.getPrenom());
		Personne p1=AideeDAO.getInstance().readMedecinRef(1);
		System.out.println(p1);
		
		System.out.println("fait");
		

	}

}
