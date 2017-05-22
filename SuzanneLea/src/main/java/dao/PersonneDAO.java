package dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import bean.Personne;

public class PersonneDAO implements IPersonneDAO {
	
	/////// SINGLETON \\\\\\\
	private static IPersonneDAO instance=null;
	private PersonneDAO(){
	}
	public static synchronized IPersonneDAO getInstance() {
		if (instance==null){
			instance=new PersonneDAO();
		}
		return instance;
	}
	
	ConnexionDAO connexion=new ConnexionDAO();
	/////// Autres Requetes \\\\\\\
	
	public Personne getPersonne(String nom, String prenom, String email, String adresse, String tel, String mdp) {
		Personne p = new Personne(nom, prenom, email, adresse, tel, mdp);
		connexion.getEm().persist(p);
		return p;
	}
	
	
	
	
	/*
	 * La fonction renvoie la personne si celle-ci existe dans la BDD
	 */
	@Override	
	public Personne personneExiste(String mail, String mdp) {
		connexion.connexion();
				
    	Query requete=connexion.getEm().createQuery("SELECT p FROM Personne p WHERE p.email='"+mail+"' AND p.mdp='"+mdp+"'");
    	
    	List liste = requete.getResultList();
    	Personne p = (Personne) liste.get(0);
    	System.out.println(p);
		connexion.commit();
		connexion.deconnexion();
    	return p;
    }
	
	
	
	
	/////// CRUD \\\\\\\
	
    /*
     * Fonction pour CREER une nouvelle personne dans la BDD
     */
	public Personne createPersonne(String nom, String prenom, String email, String adresse, String tel, String mdp) {
		connexion.connexion();		
		Personne p=new Personne();
    	p.setAdresse(adresse);
    	p.setEmail(email);
    	p.setMdp(mdp);
    	p.setNom(nom);
    	p.setPrenom(prenom);
    	p.setTel(tel);
    	System.out.println(p);
    	connexion.getEm().persist(p);
    	connexion.commit();
		connexion.deconnexion();
    	return p;
    		
	}
    
    /*
     * Fonction pour LIRE une personne de la BDD
     */
	@Override
    public Personne readPersonne(Integer id) {
		connexion.connexion();
		
    	Query requete=connexion.getEm().createQuery("SELECT p FROM Personne p WHERE p.ID="+id);
    	
    	List liste = requete.getResultList();
    	Personne p = (Personne) liste.get(0);
    	System.out.println(p);
		connexion.commit();
		connexion.deconnexion();
    	return p;
    }
    
    
    /*
     * Fonction pour MODIFIER une nouvelle personne dans la BDD
     */
	@Override
    public void updatePersonne(Integer id, String nom, String prenom, String email, String adresse, String tel, String mdp) {
		connexion.connexion();
        /* 
         * TODO
         * Code a finir récupérer la personne du résultat
         * 
         * em.createQuery(" UPDATE table
							SET nom = 'nom', prenom = 'prenom', email = 'email'
							WHERE id = id");
         * 
         * 
         */ 
		connexion.commit();
		connexion.deconnexion(); 
    }
    
    
    
    /*
     * Fonction pour SUPPRIMER une personne de la BDD
     */
	@Override
    public void supprPersonne(Integer id) {
		connexion.connexion();
        
        /* 
         * TODO
         * Code a finir récupérer la personne du résultat
         * 
         * em.createQuery("delete from personne where id = '" + id + "'"
                +");
         * 
         * 
         */ 
		connexion.commit();
		connexion.deconnexion();
        
    }
    
}
