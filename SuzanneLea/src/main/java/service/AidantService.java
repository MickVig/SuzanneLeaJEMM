package service;

import java.util.List;



import bean.Personne;
import dao.AidantDAO;
import dao.IAidantDAO;

public class AidantService implements IAidantService{
	
	private static IAidantService instance=null;
	private AidantService(){
	}
	public static synchronized IAidantService getInstance() {
		if (instance==null){
			instance=new AidantService();
		}
		return instance;
	}
	
	public List<Personne> getListPersonne() {
		//return AidantDAO.getInstance().getListPersonne();
		return null;
	}
	
	

}
