package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConnexionDAO {
	
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx;

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
