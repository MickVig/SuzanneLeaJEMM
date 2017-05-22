package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Aidant;
import bean.Aidee;
import bean.Personne;
import bean.Referent;
import dao.AidantDAO;
import dao.AideeDAO;
import dao.IPersonneDAO;
import dao.PersonneDAO;

public class PersonneService implements IPersonneService {
	/////// SINGLETON \\\\\\\
	private static IPersonneService instance = null;

	private PersonneService() {
	}

	public static synchronized IPersonneService getInstance() {
		if (instance == null) {
			instance = new PersonneService();
		}
		return instance;
	}

	@Override
	public boolean connexion(HttpServletRequest request, HttpServletResponse response) {

		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");

		/*
		 * envoi vers PersonneDAO pour récupérer la personne si personne existe
		 * : la mettre en session et renvoyer true sinon retourner false
		 */

		Personne p = PersonneDAO.getInstance().personneExiste(mail, mdp);

		if (p != null) {
			HttpSession session = request.getSession();
			session.setAttribute("personne", p);
			System.out.println("connexion OK");
			return true;

		} else {
			System.out.println("erreur");
			return false;
		}
	}

	
	public void inscription(HttpServletRequest request, HttpServletResponse response) {

		// Personne aidee
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");

		// Personne aidant
		String nomref = request.getParameter("nomref");
		String prenomref = request.getParameter("prenomref");
		String adresseref = request.getParameter("adresseref");
		String telref = request.getParameter("telref");
		String mailref = request.getParameter("mailref");
		String mdpref = request.getParameter("mdpref");

		/*
		 * On créé les 2 personnes à partir des 2 méthodes create des classes
		 * DAO on différencie en aidee et aidant
		 */

		Personne pAidant = PersonneDAO.getInstance().createPersonne(nomref, prenomref, mailref, adresseref, telref,
				mdpref);
		Personne pAidee = PersonneDAO.getInstance().createPersonne(nom, prenom, mail, adresse, tel, mdp);

		/*
		 * Créer la personne aidee et la personne aidant à partir des 2
		 * personnes crees au dessus
		 */

		//En attibut, penser à mettre l'ID_Type en dernier ID_Type = 1
		 Aidant aidant = AidantDAO.getInstance().createAidant(pAidant.getID(),1);
		 Aidee aidee = AideeDAO.getInstance().createAidee(pAidee.getID());

		/*
		 * Creer le referent
		 */
		 
	
		 
	}


}
