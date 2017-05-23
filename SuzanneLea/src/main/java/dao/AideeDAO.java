package dao;

import java.util.List;

import bean.Aidant;
import bean.Aidee;
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
		this.connexion();
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/////// CRUD \\\\\\\
	
	@Override
	public Aidee createAidee(Integer ID_Pers) {
		Aidee aidee=new Aidee();
		this.connexion();
		aidee.setPersonne(PersonneDAO.getInstance().readPersonne(ID_Pers));
		this.em.persist(aidee);
		this.commit();
		this.deconnexion();
		return aidee;
	}
	
	@Override
	public Aidee readAidee(Integer id) {
		this.connexion();
		Aidee a = this.getEm().find(Aidee.class, id);
		System.out.println(a);
		this.deconnexion();		
    	return a;
	}
	
	@Override
	public void updateAidee(Personne p, Integer iD_MedecinRef, Integer iD_ProcheRef) {
		this.connexion();
		// TODO Auto-generated method stub
		this.commit();
		this.deconnexion();
	}
	
	@Override
	public void supprAidee(Integer id) {
		this.connexion();
		// TODO Auto-generated method stub
		this.commit();
		this.deconnexion();
	}
}
