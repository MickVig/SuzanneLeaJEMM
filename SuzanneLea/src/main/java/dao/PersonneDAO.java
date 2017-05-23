package dao;

import java.util.List;

import javax.persistence.Query;

import bean.Personne;

public class PersonneDAO extends ConnexionDAO implements IPersonneDAO {
	
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
	
	/////// Autres Requetes \\\\\\\
		
	/*
	 * La fonction renvoie la personne si celle-ci existe dans la BDD
	 */
	@Override	
	public Personne personneExiste(String mail, String mdp) {
		this.connexion();
				
    	Query requete=this.getEm().createQuery("SELECT p FROM Personne p WHERE p.email='"+mail+"' AND p.mdp='"+mdp+"'");
    	
    	List liste = requete.getResultList();
    	Personne p = (Personne) liste.get(0);
    	System.out.println(p);
		this.commit();
		this.deconnexion();
    	return p;
    }
	
	
	/////// CRUD \\\\\\\
	
    /*
     * Fonction pour CREER une nouvelle personne dans la BDD
     */
	public Personne createPersonne(String nom, String prenom, String email, String adresse, String tel, String mdp) {
		this.connexion();		
		Personne p=new Personne();
    	p.setAdresse(adresse);
    	p.setEmail(email);
    	p.setMdp(mdp);
    	p.setNom(nom);
    	p.setPrenom(prenom);
    	p.setTel(tel);
    	System.out.println(p);
    	this.getEm().persist(p);
    	this.commit();
		this.deconnexion();
    	return p;
    		
	}
    
    /*
     * Fonction pour LIRE une personne de la BDD
     */
	@Override
    public Personne readPersonne(Integer id) {
		this.connexion();
		Personne p = this.getEm().find(Personne.class, id);
		System.out.println(p);
		this.deconnexion();
		
    	return p;
    }
    
    
    /*
     * Fonction pour MODIFIER une nouvelle personne dans la BDD
     */
	@Override
    public void updatePersonne(Integer id, String nom, String prenom, String email, String adresse, String tel, String mdp) {
		this.connexion();
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
		this.commit();
		this.deconnexion(); 
    }
    
    
    
    /*
     * Fonction pour SUPPRIMER une personne de la BDD
     */
	@Override
    public void supprPersonne(Integer id) {
		this.connexion();
        
        /* 
         * TODO
         * Code a finir récupérer la personne du résultat
         * 
         * em.createQuery("delete from personne where id = '" + id + "'"
                +");
         * 
         * 
         */ 
		this.commit();
		this.deconnexion();
        
    }
    
}
