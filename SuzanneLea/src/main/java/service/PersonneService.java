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
		// On r�cup�re les param�tres de connexion (mail et mot de passe)
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		// On r�cup�re la session
		HttpSession session = request.getSession();
		// On v�rifie que les param�tres de connexion
		Boolean verifOK = FormulaireService.getInstance().verifLogin(mail, mdp, request);
		// On initialise les messages d'erreurs
		session.setAttribute("messageLoginAide", "");
		session.setAttribute("messageLogin", "");
		
		// Si la v�rification des param�tres renvoie True
		if (verifOK) {
			
			// Alors, envoi vers PersonneDAO pour r�cup�rer les informations de la personne si personne existe
			Personne p = PersonneDAO.getInstance().personneExiste(mail, mdp);
			
			// Si la personne existe dans la base de donn�es
			if (p.getID() != null) {
 
				// Alors on la met en session et on renvoie true

				session.setAttribute("personne", p);
				/* 
				*  Une fois la personne en session, recuperer l'ID AIdee � partir de l'ID personne avec la methode readAideeByPersonne
				*  IDAidee est enregistr� dans la session (utilis� pour creer les relations quand ajout d'un nouvel aidant)
				*/
				IDAidee = AideeDAO.getInstance().readAideeByPersonne(p.getID());
				session.setAttribute("IDAidee", IDAidee);

				// Si la personne est une personne Aidee 
				if(IDAidee!=null) {
					// Alors retourne True pour se connecter au dashboard
					return true;
				}else {
					// Sinon on retourne false apr�s avoir enregistr� un message d'erreur en session pour l'afficher sur la page login
					String message ="Vous �tes enregist� comme aidant, votre session n'est pas encore disponible";
					session.setAttribute("messageLoginAide", message);
					return false;
				}	
			} else {
				/* Si la personne n'existe pas dans la base de donn�es 
				 * on retourne false apr�s avoir enregistr� un message d'erreur en session pour l'afficher sur la page login
				 */
				String message="Erreur dans le mail ou le mot de passe";
				session.setAttribute("messageLogin", message);
				return false;
			}
		} else {
			/* Si la v�rification des param�tres renvoie false
			 * on retourne false apr�s avoir enregistr� un message d'erreur en session pour l'afficher sur la page login
			 */
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
