package service;

import java.util.ArrayList;
import java.util.List;

import bean.Personne;
import dao.AidantDAO;
import dao.AideeDAO;

public class AidantService implements IAidantService{
	
	// Singleton \\
	private static IAidantService instance=null;
	private AidantService(){
	}
	public static synchronized IAidantService getInstance() {
		if (instance==null){
			instance=new AidantService();
		}
		return instance;
	}
	
	// Méthodes
	public List<?> allMedecins() {
		List medecins = new ArrayList();
		List<Personne> personnes = AidantDAO.getInstance().readAllAidantType(2); // 2 = type médecin
		for(int i=0; i<personnes.size();i++){
			List m = new ArrayList();
			Personne p=personnes.get(i);
			
			Integer ID_Aidant = AidantDAO.getInstance().readAidantByPersonne(p.getID());
			
			m.add(ID_Aidant);
			
			m.add(p.getID());
			m.add(p.getNom());
			m.add(p.getPrenom());
    		
			medecins.add(m);
		}
		System.out.println(medecins);
		return medecins;
				
	}
	
	/*
	 * Méthode pour lister tous les aidants selon le type de l'aidant (proche, artisan, medecin....)
	 */
	public List<?> allAidantsByType(Integer IDType) {
		List aidants = new ArrayList();
		List<Personne> personnes = AidantDAO.getInstance().readAllAidantType(IDType); 
		for(int i=0; i<personnes.size();i++){
			List a = new ArrayList();
			Personne p=personnes.get(i);
			
			Integer ID_Aidant = AidantDAO.getInstance().readAidantByPersonne(p.getID());
			
			a.add(ID_Aidant);
			
			a.add(p.getID());
			a.add(p.getNom());
			a.add(p.getPrenom());
			a.add(p.getAdresse());
			a.add(p.getTel());
			a.add(p.getEmail());
    		
			aidants.add(a);
		}
		System.out.println(aidants);
		return aidants;
				
	}
	
	/*
	 * Méthode pour lister tous les aidants proches d'un aidee
	 */
	public List<?> allProchesByAidee(Integer IDAidee) {
		List proches = new ArrayList();
		List<Personne> personnes = AideeDAO.getInstance().allAidant(IDAidee); 
		for(int i=0; i<personnes.size();i++){
			List proches2 = new ArrayList();
			Personne p=personnes.get(i);
			
			Integer ID_Aidant = AidantDAO.getInstance().readAidantByPersonne(p.getID());
			
			proches2.add(ID_Aidant);
			
			proches2.add(p.getID());
			proches2.add(p.getNom());
			proches2.add(p.getPrenom());
    		
			proches.add(proches2);
		}
		System.out.println(proches);
		return proches;
				
	}
	
	
	
	
	

}
