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
		
		//AideeDAO.getInstance().allAidant(1);
		AideeDAO.getInstance().readAideeByPersonne(55);
		
		
		
		
		System.out.println("fait");
		
		

		
		
		

	}

}
