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
	
	ConnexionDAO connexion=new ConnexionDAO();
	/////// Autres Requetes \\\\\\\
	
	@Override
	public List<Aidant> allAidant(Integer id) {
		connexion.connexion();
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/////// CRUD \\\\\\\
	
	@Override
	public void createAidee(Integer ID_Pers) {
		connexion.connexion();
		/*
		 * Si la personne n'existe pas la créer avant de le mettre aidee
		 */
		connexion.commit();
		connexion.deconnexion();
	}
	
	@Override
	public Personne readAidee(Integer id) {
		connexion.connexion();
		// TODO Auto-generated method stub
		connexion.commit();
		connexion.deconnexion();
		return null;
	}
	
	@Override
	public void updateAidee(Personne p, Integer iD_MedecinRef, Integer iD_ProcheRef) {
		connexion.connexion();
		// TODO Auto-generated method stub
		connexion.commit();
		connexion.deconnexion();
	}
	
	@Override
	public void supprAidee(Integer id) {
		connexion.connexion();
		// TODO Auto-generated method stub
		connexion.commit();
		connexion.deconnexion();
	}
}
