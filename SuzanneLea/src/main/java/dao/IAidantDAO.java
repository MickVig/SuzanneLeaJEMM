package dao;

import java.util.List;

import bean.Aidant;
import bean.Personne;

public interface IAidantDAO {
	
	/////// Autres Requetes \\\\\\\
	/**
	 * Fonction pour récupérer tout les aidants du type choisi
	 * @param ID_Type 	numéro du type d'aidant sélectionner
	 * @return			une liste de personne correspondant aux aidants
	 */
	public List<Personne> readAllAidantType(Integer ID_Type);
	
	/**
	 * Foncgtion pour récuperer l'ID d'un Aidant à partir de l'Ide d'une personne
	 * @param ID_Personne
	 * @return ID_Aidant correspondant
	 */
	public Integer readAidantByPersonne(Integer ID_Personne);
	/////// CRUD \\\\\\\
	
	/**
	 * Fonction pour CREER un nouveau aidant dans la BDD
	 * @param p			la personne qui va devenir aidant
	 * @param ID_Type	le type d'aidant (dans ce cas on ne peut rajouter que des proches)
	 */
	public Aidant createAidant(Integer ID_pers, Integer ID_Type);
	
	/**
	 * Fonction pour LIRE un aidant dans la BDD
	 * @param id	Numéro unique de l'aidant à lire
	 */
	public Aidant readAidant(Integer id);
	
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
