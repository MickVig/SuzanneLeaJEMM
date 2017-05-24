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

	/////// Méthodes \\\\\\\
	@Override
	public boolean connexion(HttpServletRequest request, HttpServletResponse response) {

		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		HttpSession session = request.getSession();
		Boolean verifOK = FormulaireService.getInstance().verifLogin(mail, mdp, request);

		if (verifOK) {
			/*
			 * Envoi vers PersonneDAO pour récupérer la personne si personne
			 * existe La mettre en session et renvoyer true Sinon retourner
			 * false Une fois la personne en session, recuperer l'ID AIdee à
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

	// Inscription d'un aidee et de son aidant referent
	public Boolean inscription(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		// Personne aidee
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");

		Boolean verifAideeOK = FormulaireService.getInstance().verifInscription(nom, prenom, adresse, tel, mail, mdp,
				request);
		if (!verifAideeOK) {
			String messageInscriptionAidee=(String) session.getAttribute("messageinscription");
			session.setAttribute("messageInscriptionAidee", messageInscriptionAidee);
		}
		// Personne aidant
		String nomref = request.getParameter("nomref");
		String prenomref = request.getParameter("prenomref");
		String adresseref = request.getParameter("adresseref");
		String telref = request.getParameter("telref");
		String mailref = request.getParameter("mailref");
		String mdpref = request.getParameter("mdpref");

		Boolean verifRefOK = FormulaireService.getInstance().verifInscription(nomref, prenomref, adresseref, telref,
				mailref, mdpref, request);
		if (!verifRefOK) {
			String messageInscriptionRef=(String) session.getAttribute("messageinscription");
			session.setAttribute("messageInscriptionRef", messageInscriptionRef);
		}
		/*
		 * On créé les 2 personnes à partir des 2 méthodes create des classes
		 * DAO on différencie en aidee et aidant
		 */
		if (verifAideeOK && verifRefOK) {
			Personne pAidant = PersonneDAO.getInstance().createPersonne(nomref, prenomref, mailref, adresseref, telref,
					mdpref);
			Personne pAidee = PersonneDAO.getInstance().createPersonne(nom, prenom, mail, adresse, tel, mdp);

			/*
			 * Créer la personne aidee et la personne aidant à partir des 2
			 * personnes crees au dessus En attibut, penser à mettre l'ID_Type
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

	/*
	 * Inscription d'un nouvel aidant pour un aidee : méthode deplacee dans
	 * AideeService
	 */
	/*
	 * public void inscriptionAidant (HttpServletRequest request,
	 * HttpServletResponse response) {
	 * 
	 * //recuperation des donnees saisies dans le formulaire creation aidant
	 * String nom = request.getParameter("nom"); String prenom =
	 * request.getParameter("prenom"); String adresse =
	 * request.getParameter("adresse"); String tel =
	 * request.getParameter("tel"); String mail = request.getParameter("mail");
	 * String mdp = request.getParameter("mdp");
	 * 
	 * //On créé une personne à partir des infos recuperees du formulaire
	 * Personne pAidant = PersonneDAO.getInstance().createPersonne(nom, prenom,
	 * mail, adresse, tel, mdp);
	 * 
	 * //Creer la personne Aidant Aidant aidant =
	 * AidantDAO.getInstance().createAidant(pAidant.getID(), 1);
	 * 
	 * //Creer la relation aidee - aidant proche
	 * RelationDAO.getInstance().createRelation(aidant.getID_Aidant(), IDAidee,
	 * false);
	 * 
	 * }
	 */

}
