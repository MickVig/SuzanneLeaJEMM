package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	public void addEvent(HttpServletRequest request, HttpServletResponse response) throws ParseException {

		// recuperation des donnees saisies dans le formulaire
		String titre = request.getParameter("titre");
		String contenu = request.getParameter("contenu");
		String accompagnant = request.getParameter("accompagnant");
		
		// recuperer la date
		String d=request.getParameter("datepicker");
		String h=request.getParameter("heure");
		String m=request.getParameter("minute");
		System.out.println("rdv : "+d+", heure : "+ h+" minute "+m);
		//Mettre string dans le bon ordre
		StringBuilder d1 = new StringBuilder();
		d1.append(d.charAt(6));
		d1.append(d.charAt(7));
		d1.append(d.charAt(8));
		d1.append(d.charAt(9));
		d1.append("-");
		d1.append(d.charAt(3));
		d1.append(d.charAt(4));
		d1.append("-");
		d1.append(d.charAt(0));
		d1.append(d.charAt(1));
		d1.append(" ");
		d1.append(h);
		d1.append(":");
		d1.append(m);
		d1.append(":");
		d1.append("00");
		
		System.out.println("date :" + d1);
		//convertir string en date
		String s = "2011-07-08 03:48:45";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date dat = sdf.parse(d1.toString());

		// pour récupérer l'ID_Aidant de l'aidant (accompagnant) sélectionné
		// dans le formulaire
		Integer IDAidant = Integer.valueOf(request.getParameter("accompagnant"));

		// pour recuperer l'ID_Aidee de la personne qui s'est connectée pour
		// ajouter un évènement
		HttpSession session = request.getSession();
		Integer IDAidee = (Integer) session.getAttribute("IDAidee");

		
	
		// creer un evenement
		AgendaDAO.getInstance().createEvenement(dat, titre, contenu, IDAidee, IDAidant);
	}

	/*
	 * Ajouter un nouveau CR depuis le formulaire de saisie addCR
	 */

	public void addCR(HttpServletRequest request, HttpServletResponse response) {

		// recuperation des donnees saisies dans le formulaire
		String commentaire = request.getParameter("contenu");

		// recuperer l'ID de l'aidee
		HttpSession session = request.getSession();
		Integer IDAidee = (Integer) session.getAttribute("IDAidee");
		
		// recuperer l'ID de l'aidant
		Integer IDAidant = null;
		if (session.getAttribute("IDAidant")!=null) {
			 IDAidant = (Integer) session.getAttribute("IDAidant");
			
		}
		
		// recuperer la date
		Date date = new Date();

		// creer un CR
		 CompteRenduDAO.getInstance().createCompteRendu(date, commentaire, IDAidant, IDAidee);

	}
	
	public List lastCompteRendu(Integer Id_Aidee) {
		return CompteRenduDAO.getInstance().lastCompteRendu(Id_Aidee);
	}
	
	public Agenda nextEvenement(Integer Id_Aidee){
		return AgendaDAO.getInstance().nextEvenement(Id_Aidee);
	}

}
