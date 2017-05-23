package dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import bean.Aidant;
import bean.Aidee;
import bean.Personne;

public class AidantDAO extends ConnexionDAO implements IAidantDAO {
	
	private static IAidantDAO instance=null;
	private AidantDAO(){
	}
	public static synchronized IAidantDAO getInstance() {
		if (instance==null){
			instance=new AidantDAO();
		}
		return instance;
	}
	
	/////// Autres Requetes \\\\\\\
	
	@Override
	/*public List readAllAidantType(Integer ID_Type) {
		this.connexion();
		//On selectionne les aidants d'un certain type
		Query requete=this.getEm().createQuery("SELECT a FROM Aidant a WHERE a.type.ID_Type="+ID_Type);   	
    	List liste = requete.getResultList();
    	
    	//on cree une nouvelle liste avec les informations qui nous intéresse
    	List aidants = new ArrayList();
    	for (int i=0; i<liste.size(); i++) {
    		List aidant = new ArrayList();
    		
			Aidant a=(Aidant) liste.get(i);
			aidant.add(a.getID_Aidant());
			Personne p=a.getPersonne();
			aidant.add(p.getID());
			aidant.add(p.getNom());
			aidant.add(p.getPrenom());
    		
    		aidants.add(aidant);
    	}
    	System.out.println(aidants);
		this.deconnexion();
    	return aidants;
	}*/
	
	public List<Personne> readAllAidantType(Integer ID_Type) {
		this.connexion();
		//On selectionne les aidants d'un certain type
		Query requete=this.getEm().createQuery("SELECT a FROM Aidant a WHERE a.type.ID_Type="+ID_Type);   	
    	List liste = requete.getResultList();
    	
    	//on cree une nouvelle liste avec les informations qui nous intéresse
    	List<Personne> listePersonne = new ArrayList();
    	for (int i=0; i<liste.size(); i++) {
			Aidant a=(Aidant) liste.get(i);
			Personne p=a.getPersonne();
			System.out.println(p);
			listePersonne.add(p);
    	}
    	System.out.println(listePersonne);
		this.deconnexion();
    	return listePersonne;
	}
	
	public Integer readAidantByPersonne(Integer ID_Personne) {
		this.connexion();
		Personne p1 = this.getEm().find(Personne.class, ID_Personne);
		Query requete=this.getEm().createQuery("SELECT a FROM Aidant a WHERE a.personne.ID="+ID_Personne);
		Aidant a=(Aidant) requete.getResultList().get(0);
		this.deconnexion();
		return a.getID_Aidant();	
	}

	/////// CRUD \\\\\\\
	
	@Override
	public Aidant createAidant(Integer ID_Pers, Integer ID_Type) {
		Aidant aidant=new Aidant();
		this.connexion();
		aidant.setPersonne(PersonneDAO.getInstance().readPersonne(ID_Pers));
		aidant.setType(TypeDAO.getInstance().readType(ID_Type));
		this.getEm().persist(aidant);
		this.commit();
		this.deconnexion();
		return aidant;
	}
	
	@Override
	public Aidant readAidant(Integer id) {
		this.connexion();
		Aidant a = this.getEm().find(Aidant.class, id);
		System.out.println(a);
		this.deconnexion();		
    	return a;
	}
	
	@Override
	public void updateAidant(Personne p, Integer ID_Type) {
		this.connexion();
		// TODO Auto-generated method stub
		this.commit();
		this.deconnexion();
	}
	
	@Override
	public void supprAidant(Integer id) {
		this.connexion();
		// TODO Auto-generated method stub
		this.commit();
		this.deconnexion();
	}

}
