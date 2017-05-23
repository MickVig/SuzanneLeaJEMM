package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

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
	public List<Personne> allAidant(Integer id) {
		this.connexion();
		//On selectionne les aidants d'un certain type
		Query requete=this.getEm().createQuery("SELECT r.aidant FROM Relation r WHERE r.aidee.ID_Aidee="+id);	
		List liste = requete.getResultList();
		    	
		//on cree une nouvelle liste avec les informations qui nous intéresse
		/*List resultat = new ArrayList();
		    for (int i=0; i<liste.size(); i++) {
				Aidant a=(Aidant) liste.get(i);
				resultat.add(a.getID_Aidant());
				Personne p=a.getPersonne();
				resultat.add(p.getID());
				resultat.add(p.getNom());
				resultat.add(p.getPrenom());
		    }*/
		    System.out.println(liste);
		this.deconnexion();
		return null;
	}
	
	public Integer readAideeByPersonne(Integer ID_Personne) {
		this.connexion();
		Personne p1 = this.getEm().find(Personne.class, ID_Personne);
		Query requete=this.getEm().createQuery("SELECT a FROM Aidee a WHERE a.personne.ID="+ID_Personne);
		Aidee a=(Aidee) requete.getResultList().get(0);
		System.out.println(a.getID_Aidee());
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
