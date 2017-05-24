package service;

import java.util.ArrayList;
import java.util.List;

import bean.Personne;
import dao.AidantDAO;

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
	
	

}
