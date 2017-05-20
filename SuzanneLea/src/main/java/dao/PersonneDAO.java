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
	 * @param mail	L'email rentr� par la personne
	 * @param mdp	Le mot de passe rentr� par la personne
	 * @return		La personne qui se connecte
	 */
    public Personne personneExiste(String mail, String mdp) {
    	Personne p = new Personne();
    	List resultat = em.createQuery("select p from personne where mail = '" + mail + "'"
                + " AND mdp = MD5('" + mdp + "')").getResultList();
        
        /* 
         * 
         * Code a finir r�cup�rer la personne du r�sultat
         * 
         */ 
        
        return p;
    }
	
	
	
	///////////////   CRUD    \\\\\\\\\\\\\\\\\\
	
    /**
     * Fonction pour CREER une nouvelle personne dans la BDD
     * @param nom		le nom de la personne � inscrire
     * @param prenom	le pr�nom de la personne � inscrire
     * @param email		le mail de la personne � inscrire
     * @param adresse	l'adresse de la personne � inscrire
     * @param tel		le t�l�phone de la personne � inscrire
     * @param mdp		le MDP de la personne � inscrire
     */
    public void createPersonne(String nom, String prenom, String email, String adresse, String tel, String mdp) {
    	
        /* 
         * 
         * Code a finir r�cup�rer la personne du r�sultat
         * 
         * em.createQuery(" INSERT INTO personne (nom_colonne_1, nom_colonne_2, ...
 				VALUES ('valeur 1', 'valeur 2', ...)");
         * 
         * 
         */ 
        
    }
    
    /**
     * Fonction pour LIRE une personne de la BDD
     * @param id	Num�ro unique de la personne � lire
     */
    public Personne readPersonne(Integer id) {
    	Personne p = new Personne();
        
        /* 
         * 
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
    
    
    /**
     * Fonction pour MODIFIER une nouvelle personne dans la BDD
     * @param id		le num�ro unique de la personne � modifier
     * @param nom		le nom de la personne � inscrire
     * @param prenom	le pr�nom de la personne � inscrire
     * @param email		le mail de la personne � inscrire
     * @param adresse	l'adresse de la personne � inscrire
     * @param tel		le t�l�phone de la personne � inscrire
     * @param mdp		le MDP de la personne � inscrire
     */
    public void updatePersonne(Integer id, String nom, String prenom, String email, String adresse, String tel, String mdp) {
    	
        /* 
         * 
         * Code a finir r�cup�rer la personne du r�sultat
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
     * @param id	Num�ro unique de la personne � supprimer
     */
    public void supprPersonne(Integer id) {
    	
        
        /* 
         * 
         * Code a finir r�cup�rer la personne du r�sultat
         * 
         * em.createQuery("delete from personne where id = '" + id + "'"
                +");
         * 
         * 
         */ 
        
    }
    
}
