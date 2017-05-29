package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Agenda;
import bean.Aidant;
import bean.Personne;
import dao.AgendaDAO;
import dao.AidantDAO;
import dao.AideeDAO;
import dao.CompteRenduDAO;
import dao.PersonneDAO;
import dao.RelationDAO;

public class AideeService implements IAideeService {

	// Singleton\\
	private static IAideeService instance = null;

	private AideeService() {
	}

	public static synchronized IAideeService getInstance() {
		if (instance == null) {
			instance = new AideeService();
		}
		return instance;
	}

	// Méthodes

	/*
	 * Inscription d'un nouvel aidant pour un aidee
	 */
	public Boolean inscriptionAidant(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Integer IDAidee = (Integer) session.getAttribute("IDAidee");
		Boolean b = false;
		/*
		 * recuperation des donnees saisies dans le formulaire creation aidant
		 */
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");

		if (FormulaireService.getInstance().verifInscription(nom, prenom, adresse, tel, mail, mdp, request)) {
			/*
			 * On créé une personne à partir des infos recuperees du formulaire
			 */
			Personne pAidant = PersonneDAO.getInstance().createPersonne(nom, prenom, mail, adresse, tel, mdp);

			/* Creer la personne Aidant */
			Aidant aidant = AidantDAO.getInstance().createAidant(pAidant.getID(), 1);

			/* Creer la relation aidee - aidant proche */
			RelationDAO.getInstance().createRelation(aidant.getID_Aidant(), IDAidee, false);
			b = true;
		}
		return b;
	}

	/*
	 * Recuperer la liste de tous les aidants d'un aidee (choisi avec son ID)
	 * sauf le referent
	 */
	public List<Personne> allAidantsProches(Integer IDAidee) {
		List<Personne> aidantsProches = AideeDAO.getInstance().allAidant(IDAidee);
		System.out.println(aidantsProches);
		return aidantsProches;
	}

	/*
	 * Recuperer la liste de tous les evenements d'un aidee (a partir de l'ID de
	 * l'aidee)
	 */

	public List allRDV(Integer IDAidee) {
		List allRDV = AgendaDAO.getInstance().readAllEvenement(IDAidee);
		return allRDV;
	}

	/*
	 * Recuperer la liste de tous les CR d'un aidee (a partir de l'ID de
	 * l'aidee)
	 */

	public List allCR(Integer IDAidee) {
		List allCR = CompteRenduDAO.getInstance().comptesRendusAidee(IDAidee);
		return allCR;
	}

	/*
	 * Recuperer le proche referent d'un aidee
	 */

	public Personne procheReferent(Integer IDAidee) {
		Personne procheReferent = AideeDAO.getInstance().readProcheRef(IDAidee);
		return procheReferent;
	}

	/*
	 * Recuperer le medecin referent d'un aidee
	 */

	public Personne medecinReferent(Integer IDAidee) {
		Personne medecinReferent = AideeDAO.getInstance().readMedecinRef(IDAidee);
		return medecinReferent;
	}

	/*
	 * Ajouter un nouvel évènement depuis le formulaire de saisie addEvent
	 */

	public void addEvent(HttpServletRequest request, HttpServletResponse response) {

		// recuperation des donnees saisies dans le formulaire
		String titre = request.getParameter("titre");
		String contenu = request.getParameter("contenu");
		String accompagnant = request.getParameter("accompagnant");

		// pour récupérer l'ID_Aidant de l'aidant (accompagnant) sélectionné
		// dans le formulaire
		Integer IDAidant = Integer.valueOf(request.getParameter("accompagnant"));

		// pour recuperer l'ID_Aidee de la personne qui s'est connectée pour
		// ajouter un évènement
		HttpSession session = request.getSession();
		Integer IDAidee = (Integer) session.getAttribute("IDAidee");

		// recuperer la date
		// DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date = new Date();
		// String date2 = sdf.format(date);

		// creer un evenement
		AgendaDAO.getInstance().createEvenement(date, titre, contenu, IDAidee, IDAidant);
	}

	/*
	 * Ajouter un nouveau CR depuis le formulaire de saisie addCR
	 */

	public void addCR(HttpServletRequest request, HttpServletResponse response) {

		// recuperation des donnees saisies dans le formulaire
		String commentaire = request.getParameter("contenu");

		// recuperer l'ID de l'aidant

		// recuperer l'ID de l'aidee
		HttpSession session = request.getSession();
		Integer IDAidee = (Integer) session.getAttribute("IDAidee");

		// recuperer la date
		Date date = new Date();

		// creer un CR
		// CompteRenduDAO.getInstance().createCompteRendu(date, commentaire,
		// iD_Aidant, IDAidee);

	}
	
	public List lastCompteRendu(Integer Id_Aidee) {
		return CompteRenduDAO.getInstance().lastCompteRendu(Id_Aidee);
	}
	
	public Agenda nextEvenement(Integer Id_Aidee){
		return AgendaDAO.getInstance().nextEvenement(Id_Aidee);
	}

}
