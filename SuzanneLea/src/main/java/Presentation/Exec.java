package Presentation;

import java.util.Date;

import bean.Aidant;
import bean.Aidee;
import bean.CompteRendu;
import bean.Personne;
import bean.Referent;
import bean.Relation;
import bean.Type;
import dao.AidantDAO;
import dao.ConnexionDAO;
import dao.IPersonneDAO;
import dao.PersonneDAO;


public class Exec {

	public static void main(String[] args) {

		IPersonneDAO dao = PersonneDAO.getInstance();		
		dao.personneExiste("marc.bonraisin@free.fr", "taxi1");	
		
		dao.readPersonne(2);
		System.out.println("fini");

		
		
		

	}

}
