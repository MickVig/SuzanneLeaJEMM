package service;

import java.util.List;

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
	public List allMedecins() {
		List medecins = AidantDAO.getInstance().readAllAidantType(2); // 2 = type médecin
		System.out.println(medecins);
		return medecins;
				
	}
	
	

}
