package dao;

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
    	Personne p = new Personne();
    	
        
        /* 
         * TODO
         * Code a finir récupérer la personne du résultat
         * 
         * 
         * List resultat = em.createQuery("select p from personne where mail = '" + mail + "'"
                + " AND mdp = MD5('" + mdp + "')").getResultList();
         * 
         */ 
        
        return p;
    }
	
	
	
	/////// CRUD \\\\\\\
	
    /*
     * Fonction pour CREER une nouvelle personne dans la BDD
     */
	@Override
    public void createPersonne(String nom, String prenom, String email, String adresse, String tel, String mdp) {
    	
        /* 
         * TODO
         * Code a finir créer la personne et la récupérer pour la retourner
         * 
         * em.createQuery(" INSERT INTO personne (nom_colonne_1, nom_colonne_2, ...
 				VALUES ('valeur 1', 'valeur 2', ...)");
         * 
         * 
         */ 
        
    }
    
    /*
     * Fonction pour LIRE une personne de la BDD
     */
	@Override
    public Personne readPersonne(Integer id) {
    	Personne p = new Personne();
        
        /* 
         * TODO
         * Code a finir récupérer la personne du résultat
         * 
         * em.createQuery("select p from personne where id = '" + id + "'"
                +");
         * 
         * Récupérer la personne avec la requete
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
         * Code a finir récupérer la personne du résultat
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
         * Code a finir récupérer la personne du résultat
         * 
         * em.createQuery("delete from personne where id = '" + id + "'"
                +");
         * 
         * 
         */ 
        
    }
    
}
