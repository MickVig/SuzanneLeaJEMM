package dao;

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
	
	/*
	 * La fonction renvoie la personne si celle-ci existe dans la BDD
	 */
	@Override
    public Boolean personneExiste(String mail, String mdp) {
    	Personne p = new Personne();
    	Boolean bool=false;
    	/*Query requete=(Query) em.createQuery("SELECT p FROM personne p where id=3").getResultList();
    	if (requete!=null) {
    		bool=true;
    	}
    	System.out.println(bool);*/
    	return bool;
        
    }
	
	
	
	/////// CRUD \\\\\\\
	
    /*
     * Fonction pour CREER une nouvelle personne dans la BDD
     */
	//Ne fonctionne pas : erreur avec le persist
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
    	connexion.em.persist(p);
    	connexion.commit();
		connexion.deconnexion();
    	return p;
    		
	}
    
    /*
     * Fonction pour LIRE une personne de la BDD
     */
	@Override
    public Personne readPersonne(Integer id) {
    	Personne p = new Personne();
    	
        
        /* 
         * TODO
         * Code a finir r�cup�rer la personne du r�sultat
         * 
         * em.createQuery("select p from personne where id = '" + id + "'"
                +");
         * 
         * R�cup�rer la personne avec la requete
         * 
         * 
         */ 
        return p;
    }
    
    
    /*
     * Fonction pour MODIFIER une nouvelle personne dans la BDD
     */
	@Override
    public void updatePersonne(Integer id, String nom, String prenom, String email, String adresse, String tel, String mdp) {
    	
        /* 
         * TODO
         * Code a finir r�cup�rer la personne du r�sultat
         * 
         * em.createQuery(" UPDATE table
							SET nom = 'nom', prenom = 'prenom', email = 'email'
							WHERE id = id");
         * 
         * 
         */ 
        
    }
    
    
    
    /*
     * Fonction pour SUPPRIMER une personne de la BDD
     */
	@Override
    public void supprPersonne(Integer id) {
    	
        
        /* 
         * TODO
         * Code a finir r�cup�rer la personne du r�sultat
         * 
         * em.createQuery("delete from personne where id = '" + id + "'"
                +");
         * 
         * 
         */ 
        
    }
    
}
