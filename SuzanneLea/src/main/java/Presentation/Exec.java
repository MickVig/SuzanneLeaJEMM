package Presentation;

import java.util.Date;

import bean.Aidant;
import bean.Aidee;
import bean.CompteRendu;
import bean.Personne;
import bean.Referent;
import bean.Relation;
import bean.Type;
import dao.ConnexionDAO;
import dao.PersonneDAO;


public class Exec {

	public static void main(String[] args) {

		//IPersonneDAO dao = PersonneDAO.getInstance();
		System.out.println("hello");
		ConnexionDAO connexion = new ConnexionDAO();
		
			
		
		System.out.println("Bonjour");
		/*Personne p=connexion.createPersonne("Fou", "Dingo", "donald.prust@gmail.com", "25 rue des pivoines 44000 Nantes", "0257963512", "medecin6");
		Personne p1=connexion.createPersonne("Belle", "Daisy", "donald.prust@gmail.com", "25 rue des pivoines 44000 Nantes", "0257963512", "medecin6");
		Type t=connexion.createType("medecin");
		Aidant aidant=connexion.createAidant(p, t);
		Aidee aidee=connexion.createAidee(p1);
		Referent r1=connexion.createReferent(aidant, aidee);
		Relation rel=connexion.createRelation(aidant, aidee);
		CompteRendu cr=connexion.createCompteRendu(new Date(), "coucou", aidee, aidant);
		
		
		connexion.commit();
		*/
		PersonneDAO.getInstance().createPersonne("Bidul", "Chouette", "donald.prust@gmail.com", "25 rue des pivoines 44000 Nantes", "0257963512", "medecin6");

		System.out.println("fini");

		
		
		

	}

}
