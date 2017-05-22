package dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bean.Aidant;
import bean.Aidee;
import bean.CompteRendu;
import bean.Personne;
import bean.Referent;
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
 
    
    /*
	 * La fonction renvoie la personne si celle-ci existe dans la BDD
	 */
	
    public Boolean personneExiste(String mail, String mdp) {
    	Personne p = new Personne();
    	Boolean bool=false;
    	Query requete = em.createQuery("SELECT p FROM Personne p WHERE nom=truc");
    	if (requete!=null) {
    		bool=true;
    	}
    	System.out.println(bool);
    	return bool;
        
    }
    
    public Personne createPersonne(String nom, String prenom, String email, String adresse, String tel, String mdp) {
    	Personne p=new Personne();
    	p.setAdresse(adresse);
    	p.setEmail(email);
    	p.setMdp(mdp);
    	p.setNom(nom);
    	p.setPrenom(prenom);
    	p.setTel(tel);
    	System.out.println(p);
    	em.persist(p);
    	return p;
    		
	}
    
    
    
    public Type createType(String type) {
    	Type t=new Type();
    	t.setType(type);   	
    	em.persist(t);
    	System.out.println(t);
    	return t;
    		
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
    
    public Referent createReferent(Aidant aidant, Aidee aidee) {
    	Referent r=new Referent();
    	r.setAidee(aidee);
    	r.setAidant(aidant);
    	em.persist(r);
    	System.out.println(r);
    	return r;
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
    
    
}
