package dao;

import bean.Personne;

public interface IAidantDAO {
	
	/////// Autres Requetes \\\\\\\
	
	
	/////// CRUD \\\\\\\
	
	/**
	 * Fonction pour CREER un nouveau aidant dans la BDD
	 * @param p			la personne qui va devenir aidant
	 * @param ID_Type	le type d'aidant (dans ce cas on ne peut rajouter que des proches)
	 */
	public void createAidant(Personne p, Integer ID_Type);
	
	/**
	 * Fonction pour LIRE un aidant dans la BDD
	 * @param id	Numéro unique de l'aidant à lire
	 */
	public Personne readAidant(Integer id);
	
	/**
	 * Fonction pour MODIFIER un aidant dans la BDD
	 * @param p			la personne aidante
	 * @param ID_Type	le type d'aidant
	 */
	public void updateAidant(Personne p, Integer ID_Type);
	
	
	/**
	 * Fonction pour SUPPRIMER un aidant de la BDD
	 * @param id	Numéro unique de l'aidant à supprimer
	 */
	public void supprAidant(Integer id);

}
