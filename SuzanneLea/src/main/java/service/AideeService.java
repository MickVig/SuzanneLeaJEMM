package service;

import java.util.List;

import bean.Personne;
import dao.AideeDAO;

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
	
	
	
}
