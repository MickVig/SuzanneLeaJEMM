package dao;

import java.util.List;

import bean.Personne;

public interface IPersonneDAO {
	/////// Autres Requetes \\\\\\\
	
	
	
	public Personne getPersonne(String nom, String prenom, String email, String adresse, String tel, String mdp);
	
	
	/**
	 * La fonction renvoie la personne si celle-ci existe dans la BDD
	 * @param mail	L'email rentr� par la personne
	 * @param mdp	Le mot de passe rentr� par la personne
	 * @return		La personne qui se connecte
	 */
	public Personne personneExiste(String mail, String mdp);
	
	
/////// CRUD \\\\\\\
	
	/**
   * Fonction pour CREER une nouvelle personne dans la BDD
   * @param nom		le nom de la personne � inscrire
   * @param prenom	le pr�nom de la personne � inscrire
   * @param email		le mail de la personne � inscrire
   * @param adresse	l'adresse de la personne � inscrire
   * @param tel		le t�l�phone de la personne � inscrire
   * @param mdp		le MDP de la personne � inscrire
   */
	public Personne createPersonne(String nom, String prenom, String email, String adresse, String tel, String mdp);
	
	/**
   * Fonction pour LIRE une personne de la BDD
   * @param id	Num�ro unique de la personne � lire
   */
	public Personne readPersonne(Integer id);
	
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
	public void updatePersonne(Integer id, String nom, String prenom, String email, String adresse, String tel, String mdp);
	
	/**
   * Fonction pour SUPPRIMER une personne de la BDD
   * @param id	Num�ro unique de la personne � supprimer
   */
	public void supprPersonne(Integer id);
	
}
