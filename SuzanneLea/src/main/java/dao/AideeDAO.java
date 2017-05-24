package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import bean.Aidant;
import bean.Aidee;
import bean.Personne;
import bean.Relation;

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
	public List<Personne> allAidant(Integer id) {
		this.connexion();
		//On selectionne les aidants d'un certain type
		Query requete=this.getEm().createQuery("SELECT r FROM Relation r WHERE r.aidee.ID_Aidee="+id+"AND r.referent=0");	
		List<?> liste = requete.getResultList();
		    	
		//on cree une nouvelle liste avec les personnes aidantes
		List<Personne> resultat = new ArrayList<Personne>();
		    for (int i=0; i<liste.size(); i++) {
		    	Personne p=new Personne();
		    	Relation r=(Relation) liste.get(i);
		    	Aidant a=r.getAidant();
		    	p=a.getPersonne();
		    	System.out.println(p);
		    	resultat.add(p);
		    }
		this.deconnexion();
		return resultat;
	}
	
	public Personne readProcheRef(Integer ID_Aidee) {
		this.connexion();
		//On selectionne les aidants d'un certain type
		Query requete=this.getEm().createQuery("SELECT r FROM Relation r WHERE r.aidee.ID_Aidee="+ID_Aidee+"AND r.referent=1 AND r.aidant.type.ID_Type=1");	
		List<?> liste = requete.getResultList();
		    	
		//on cree une nouvelle liste avec les personnes aidantes
		Personne p=new Personne();
		Relation r=(Relation) liste.get(0);
		Aidant a=r.getAidant();
		p=a.getPersonne();
		System.out.println(p);
		this.deconnexion();
		return p;
	}
	
	public Personne readMedecinRef(Integer ID_Aidee) {
		this.connexion();
		//On selectionne les aidants d'un certain type
		Query requete=this.getEm().createQuery("SELECT r FROM Relation r WHERE r.aidee.ID_Aidee="+ID_Aidee+"AND r.referent=1 AND r.aidant.type.ID_Type=2");	
		List<?> liste = requete.getResultList();
		    	
		//on cree une nouvelle liste avec les personnes aidantes
		Personne p=new Personne();
		Relation r=(Relation) liste.get(0);
		Aidant a=r.getAidant();
		p=a.getPersonne();
		System.out.println(p);
		this.deconnexion();
		return p;
	}
	
	public Integer readAideeByPersonne(Integer ID_Personne) {
		this.connexion();
		//Personne p1 = this.getEm().find(Personne.class, ID_Personne);TODO à supprimer ??
		Aidee a=new Aidee();
		Query requete=this.getEm().createQuery("SELECT a FROM Aidee a WHERE a.personne.ID="+ID_Personne);
		if(requete.getResultList().size()!=0) {
			a=(Aidee) requete.getResultList().get(0);
		}
		this.deconnexion();
		return a.getID_Aidee();	
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
