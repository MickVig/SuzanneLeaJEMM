package dao;

import java.util.List;

import bean.Personne;

public class PersonneDAO extends ConnexionDAO implements IPersonneDAO {
	
	//SINGLETON//
	private static IPersonneDAO instance=null;
	private PersonneDAO(){
	}
	public static synchronized IPersonneDAO getInstance() {
		if (instance==null){
			instance=new PersonneDAO();
		}
		return instance;
	}
    
	/**
	 * La fonction renvoie la personne si celle-ci existe dans la BDD
	 * @param mail	L'email rentré par la personne
	 * @param mdp	Le mot de passe rentré par la personne
	 * @return		La personne qui se connecte
	 */
    public Personne personneExiste(String mail, String mdp) {
    	Personne p = new Personne();
    	List resultat = em.createQuery("select p from personne where mail = '" + mail + "'"
                + " AND mdp = MD5('" + mdp + "')").getResultList();
        
        /* 
         * 
         * Code a finir récupérer la personne du résultat
         * 
         */ 
        
        return p;
    }
	
	
	
	///////////////   CRUD    \\\\\\\\\\\\\\\\\\
	
    /**
     * Fonction pour CREER une nouvelle personne dans la BDD
     * @param nom		le nom de la personne à inscrire
     * @param prenom	le prénom de la personne à inscrire
     * @param email		le mail de la personne à inscrire
     * @param adresse	l'adresse de la personne à inscrire
     * @param tel		le téléphone de la personne à inscrire
     * @param mdp		le MDP de la personne à inscrire
     */
    public void createPersonne(String nom, String prenom, String email, String adresse, String tel, String mdp) {
    	
        /* 
         * 
         * Code a finir récupérer la personne du résultat
         * 
         * em.createQuery(" INSERT INTO personne (nom_colonne_1, nom_colonne_2, ...
 				VALUES ('valeur 1', 'valeur 2', ...)");
         * 
         * 
         */ 
        
    }
    
    /**
     * Fonction pour LIRE une personne de la BDD
     * @param id	Numéro unique de la personne à lire
     */
    public Personne readPersonne(Integer id) {
    	Personne p = new Personne();
        
        /* 
         * 
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
    
    
    /**
     * Fonction pour MODIFIER une nouvelle personne dans la BDD
     * @param id		le numéro unique de la personne à modifier
     * @param nom		le nom de la personne à inscrire
     * @param prenom	le prénom de la personne à inscrire
     * @param email		le mail de la personne à inscrire
     * @param adresse	l'adresse de la personne à inscrire
     * @param tel		le téléphone de la personne à inscrire
     * @param mdp		le MDP de la personne à inscrire
     */
    public void updatePersonne(Integer id, String nom, String prenom, String email, String adresse, String tel, String mdp) {
    	
        /* 
         * 
         * Code a finir récupérer la personne du résultat
         * 
         * em.createQuery(" UPDATE table
							SET nom = 'nom', prenom = 'prenom', email = 'email'
							WHERE id = id");
         * 
         * 
         */ 
        
    }
    
    
    
    /**
     * Fonction pour SUPPRIMER une personne de la BDD
     * @param id	Numéro unique de la personne à supprimer
     */
    public void supprPersonne(Integer id) {
    	
        
        /* 
         * 
         * Code a finir récupérer la personne du résultat
         * 
         * em.createQuery("delete from personne where id = '" + id + "'"
                +");
         * 
         * 
         */ 
        
    }
    
}
