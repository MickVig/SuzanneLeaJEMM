package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Aidant;
import bean.Aidee;
import bean.Personne;
import dao.AidantDAO;
import dao.AideeDAO;
import dao.PersonneDAO;
import dao.RelationDAO;

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

	Integer IDAidee;
	
	

	// M�thode

	/*
	 * M�thode qui permet de v�rifier que lorsqu'une personne essaie de se
	 * connecter elle existe dans la BDD
	 */	
	public boolean connexion(HttpServletRequest request, HttpServletResponse response) {

		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		HttpSession session = request.getSession();
		Boolean verifOK = FormulaireService.getInstance().verifLogin(mail, mdp, request);

		if (verifOK) {
			/*
			 * Envoi vers PersonneDAO pour r�cup�rer la personne si personne
			 * existe La mettre en session et renvoyer true Sinon retourner
			 * false Une fois la personne en session, recuperer l'ID AIdee �
			 * partir de l'ID personne avec la methode readAideeByPersonne ID
			 * Aidee utilisee pour creer relation quand ajout d'un nouvel aidant
			 */
			Personne p = PersonneDAO.getInstance().personneExiste(mail, mdp);
			System.out.println(p);
			if (p.getID() != null) {

				session.setAttribute("personne", p);
				IDAidee = AideeDAO.getInstance().readAideeByPersonne(p.getID());
				session.setAttribute("IDAidee", IDAidee);

				System.out.println("connexion OK");
				return true;
			} else {
				System.out.println("erreur pas de personne");
				return false;
			}

		} else {
			System.out.println("erreur de login");
			System.out.println(session.getAttribute("messageLogin"));
			return false;
		}
	}

	
	/*
	 * Inscription d'un aidee et de son aidant referent
	 */

	public Boolean inscription(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		// Personne aidee
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");

		//verifier si la premiere partie de formulaire est remplie
		Boolean verifAideeOK = FormulaireService.getInstance().verifInscription(nom, prenom, adresse, tel, mail, mdp,
				request);
		if (!verifAideeOK) {
			String messageInscriptionAidee = (String) session.getAttribute("messageinscription");
			session.setAttribute("messageInscriptionAidee", messageInscriptionAidee);
		}
		// Personne aidant
		String nomref = request.getParameter("nomref");
		String prenomref = request.getParameter("prenomref");
		String adresseref = request.getParameter("adresseref");
		String telref = request.getParameter("telref");
		String mailref = request.getParameter("mailref");
		String mdpref = request.getParameter("mdpref");

		//verifier si la deuxieme partie du formulaire est remplie
		Boolean verifRefOK = FormulaireService.getInstance().verifInscription(nomref, prenomref, adresseref, telref,
				mailref, mdpref, request);
		if (!verifRefOK) {
			String messageInscriptionRef = (String) session.getAttribute("messageinscription");
			session.setAttribute("messageInscriptionRef", messageInscriptionRef);
		}
		/*
		 * On cr�� les 2 personnes � partir des 2 m�thodes create des classes
		 * DAO on diff�rencie en aidee et aidant
		 */
		if (verifAideeOK && verifRefOK) {
			Personne pAidant = PersonneDAO.getInstance().createPersonne(nomref, prenomref, mailref, adresseref, telref,
					mdpref);
			Personne pAidee = PersonneDAO.getInstance().createPersonne(nom, prenom, mail, adresse, tel, mdp);

			/*
			 * Cr�er la personne aidee et la personne aidant � partir des 2
			 * personnes crees au dessus En attibut, penser � mettre l'ID_Type
			 * en proche ID_Type = 1
			 */
			Aidant aidant = AidantDAO.getInstance().createAidant(pAidant.getID(), 1);
			Aidee aidee = AideeDAO.getInstance().createAidee(pAidee.getID());

			/* Creer la relation aidee referent proche */
			RelationDAO.getInstance().createRelation(aidant.getID_Aidant(), aidee.getID_Aidee(), true);

			/* Creer la relation aidee referent medecin */
			Integer ID_medecin = Integer.valueOf(request.getParameter("medecin"));
			System.out.println(ID_medecin);
			RelationDAO.getInstance().createRelation(ID_medecin, aidee.getID_Aidee(), true);
			return true;
		} else {
			System.out.println("erreur dans l'inscription");
			System.out.println(session.getAttribute("messageinscription"));
			return false;
		}
	}

}
