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
 
    

    
    
}
