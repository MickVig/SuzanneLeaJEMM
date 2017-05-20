package dao;

import java.util.List;

import bean.Aidant;
import bean.Personne;

public class AideeDAO extends ConnexionDAO implements IAideeDAO {
	
	/////// SINGLETON \\\\\\\
	private static IAideeDAO instance=null;
	private AideeDAO(){
	}
	public static synchronized IAideeDAO getInstance() {
		if (instance==null){
			instance=new AideeDAO();
		}
		return instance;
	}
	
	
	/////// Autres Requetes \\\\\\\
	
	@Override
	public List<Aidant> allAidant(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/////// CRUD \\\\\\\
	
	@Override
	public void createAidee(Personne p, Integer iD_MedecinRef, Integer iD_ProcheRef) {
		// TODO Auto-generated method stub
		/*
		 * Si la personne n'existe pas la créer avant de le mettre aidee
		 */
		
	}
	@Override
	public Personne readAidee(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateAidee(Personne p, Integer iD_MedecinRef, Integer iD_ProcheRef) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void supprAidee(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
