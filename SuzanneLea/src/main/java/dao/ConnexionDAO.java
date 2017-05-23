package dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bean.Agenda;
import bean.Aidant;
import bean.Aidee;
import bean.CompteRendu;
import bean.Personne;
import bean.Relation;
import bean.Type;

public class ConnexionDAO {
	
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx;
    
    /////// SINGLETON \\\\\\\
	/*private static ConnexionDAO instance=null;
	
	public static ConnexionDAO getInstance() {
		if (instance==null){
			instance=new ConnexionDAO();
		}
		return instance;
	}*/
    
    //accesseurs pour l'entity manager
    public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

    /**
     * 
     */
    public void connexion() {
        emf = Persistence.createEntityManagerFactory("jpa");       
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    

	/**
     * 
     */
    public void commit(){
        tx.commit();
        tx.begin();
    }
    
    /**
     * 
     */
    public void deconnexion() {
        em.close();
        emf.close();
    }
 

    
    
   
    
    public Aidant createAidant(Personne p, Type t) {
    	Aidant aidant=new Aidant();
    	aidant.setPersonne(p);
    	aidant.setType(t);
    	em.persist(aidant);
    	System.out.println(aidant);
    	return aidant;
	
    }
    
    public Aidee createAidee(Personne p) {
    	Aidee aidee=new Aidee();
    	aidee.setPersonne(p);
    	em.persist(aidee);
    	System.out.println(aidee);
    	return aidee;
    }
    
    public Relation createRelation(Aidant aidant, Aidee aidee) {
    	Relation r=new Relation();
    	r.setAidee(aidee);
    	r.setAidant(aidant);
    	em.persist(r);
    	System.out.println(r);
    	return r;
    }
    
    public CompteRendu createCompteRendu (Date date, String commentaire, Aidee aidee, Aidant aidant) {
    	CompteRendu cr=new CompteRendu();
    	cr.setAidant(aidant);
    	cr.setAidee(aidee);
    	cr.setCommentaire(commentaire);
    	cr.setDate(date);
    	em.persist(cr);
    	System.out.println(cr);
    	return cr;
    }
    
    public Agenda createAgenda(Date date, String titre, String contenu, Aidant aidant, Aidee aidee) {
    	Agenda a=new Agenda();
    	a.setAidant(aidant);
    	a.setAidee(aidee);
    	a.setContenu(contenu);
    	a.setDate(date);
    	a.setTitre(titre);
    	em.persist(a);
    	System.out.println(a);
    	return a;
    }
    
    
}
