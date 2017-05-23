package service;

import java.util.List;

import bean.Personne;
import dao.AidantDAO;
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
	public List allAidantsProches(Integer IDAidee) {
		List aidantsProches = AideeDAO.getInstance().allAidant(IDAidee); 
		System.out.println(aidantsProches);
		return aidantsProches;
	}
	

	
}
