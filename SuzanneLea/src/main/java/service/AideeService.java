package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Aidant;
import bean.Personne;
import dao.AidantDAO;
import dao.AideeDAO;
import dao.PersonneDAO;
import dao.RelationDAO;

public class AideeService implements IAideeService {
	
	//Singleton\\
	private static IAideeService instance=null;
	
	private AideeService(){
	}

	public static synchronized IAideeService getInstance() {
		if (instance==null){
			instance = new AideeService();
		}
		return instance;
	}
	
	
	//Méthodes
	
	/*
	 * Inscription d'un nouvel aidant pour un aidee
	 */
		public void inscriptionAidant (HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
			Integer IDAidee = (Integer) session.getAttribute("IDAidee");
			
			/*recuperation des donnees saisies dans le formulaire creation aidant*/
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");
			String tel = request.getParameter("tel");
			String mail = request.getParameter("mail");
			String mdp = request.getParameter("mdp");
			
			/*On créé une personne à partir des infos recuperees du formulaire*/
			Personne pAidant = PersonneDAO.getInstance().createPersonne(nom, prenom, mail, adresse, tel, mdp);
			
			/*Creer la personne Aidant */
			Aidant aidant = AidantDAO.getInstance().createAidant(pAidant.getID(), 1);
			
			/*Creer la relation aidee - aidant proche*/
			 RelationDAO.getInstance().createRelation(aidant.getID_Aidant(), IDAidee, false);
		
		}
	
	
	/*
	 * Recuperer la liste de tous les aidants d'un aidee (choisi avec son ID) sauf le referent
	 */
	public List<Personne> allAidantsProches(Integer IDAidee) {
		List<Personne> aidantsProches = AideeDAO.getInstance().allAidant(IDAidee); 
		System.out.println(aidantsProches);
		return aidantsProches;
	}
	
	
	/*
	 * Recuperer le proche referent d'un aidee
	 */
	
	public Personne procheReferent (Integer IDAidee){
		Personne procheReferent = AideeDAO.getInstance().readProcheRef(IDAidee);
		System.out.println(procheReferent);
		return procheReferent;
	}

	/*
	 * Recuperer le medecin referent d'un aidee
	 */
	
	public Personne medecinReferent (Integer IDAidee) {
		Personne medecinReferent = AideeDAO.getInstance().readMedecinRef(IDAidee);
		System.out.println(medecinReferent);	
		return medecinReferent;
	}
	
	/*
	 * Ajouter un nouvel évènement depuis le formulaire de saisie addEvent
	 */
	
	public void addEvent (HttpServletRequest request, HttpServletResponse response) {
		
		//recuperation des donnees saisies dans le formulaire
		String titre = request.getParameter("titre");
		String contenu = request.getParameter("contenu");
		String accompagnant = request.getParameter("accompagnant");
		
		
	}
	
}
