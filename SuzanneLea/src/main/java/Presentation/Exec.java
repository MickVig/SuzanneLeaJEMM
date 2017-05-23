package Presentation;

import java.util.Date;

import bean.Agenda;
import bean.Aidant;
import bean.Aidee;
import bean.Personne;
import bean.Relation;
import bean.Type;
import dao.AidantDAO;
import dao.ConnexionDAO;
import dao.PersonneDAO;
import dao.TypeDAO;


public class Exec {

	public static void main(String[] args) {
		/*ConnexionDAO connexion=new ConnexionDAO();
		Personne p1=PersonneDAO.getInstance().createPersonne("Joie", "Cathy", "cathy.joie@gmail.com", "3 impasse des fleurs 44000 Nantes", "0215349613", "cathy1");
		Personne p2=PersonneDAO.getInstance().createPersonne("Triste", "Michel", "michel.triste@gmail.com", "56 Avenue des fourmis 44000 Nantes", "0235416832", "michel1");
		Type t=TypeDAO.getInstance().createType("proche");
		Aidant aidant=connexion.createAidant(p1, t);
		Aidee aidee=connexion.createAidee(p2);
		Relation r=connexion.createRelation(aidant, aidee);
		Agenda a=connexion.createAgenda(new Date(), "rdv medecin", "14h renouvelement medicament avec Michel", aidant, aidee);*/
		System.out.println(AidantDAO.getInstance().readAllAidantType(5));
		System.out.println("fait");
		

	}

}
