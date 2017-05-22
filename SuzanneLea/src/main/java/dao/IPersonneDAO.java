package dao;

import java.util.List;

import bean.Personne;

public interface IPersonneDAO {
	/////// Autres Requetes \\\\\\\
	
	
	
	public Personne getPersonne(String nom, String prenom, String email, String adresse, String tel, String mdp);
	
	
	/**
	 * La fonction renvoie la personne si celle-ci existe dans la BDD
	 * @param mail	L'email rentré par la personne
	 * @param mdp	Le mot de passe rentré par la personne
	 * @return		La personne qui se connecte
	 */
	public Personne personneExiste(String mail, String mdp);
	
	
/////// CRUD \\\\\\\
	
	/**
   * Fonction pour CREER une nouvelle personne dans la BDD
   * @param nom		le nom de la personne à inscrire
   * @param prenom	le prénom de la personne à inscrire
   * @param email		le mail de la personne à inscrire
   * @param adresse	l'adresse de la personne à inscrire
   * @param tel		le téléphone de la personne à inscrire
   * @param mdp		le MDP de la personne à inscrire
   */
	public Personne createPersonne(String nom, String prenom, String email, String adresse, String tel, String mdp);
	
	/**
   * Fonction pour LIRE une personne de la BDD
   * @param id	Numéro unique de la personne à lire
   */
	public Personne readPersonne(Integer id);
	
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
	public void updatePersonne(Integer id, String nom, String prenom, String email, String adresse, String tel, String mdp);
	
	/**
   * Fonction pour SUPPRIMER une personne de la BDD
   * @param id	Numéro unique de la personne à supprimer
   */
	public void supprPersonne(Integer id);
	
}
