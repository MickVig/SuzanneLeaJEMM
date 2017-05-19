package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bean.Personne;

public class AidantDAO implements IAidantDAO {
	
	private static IAidantDAO instance=null;
	private AidantDAO(){
	}
	public static synchronized IAidantDAO getInstance() {
		if (instance==null){
			instance=new AidantDAO();
		}
		return instance;
	}
	
	
	public List<Personne> getListPersonne() {
		System.out.println("bonjour!");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();       
        tx.begin();
		List<Personne> liste=em.createQuery("select p from Personne p order by p.nom asc").getResultList();
		for (Personne p : liste) {
            System.out.println(p);
        }
        return liste;
	}
	
	
	

}
