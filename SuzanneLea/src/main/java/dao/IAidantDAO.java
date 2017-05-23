package dao;

import java.util.List;

import bean.Aidant;
import bean.Personne;

public interface IAidantDAO {
	
	/////// Autres Requetes \\\\\\\
	/**
	 * Fonction pour r�cup�rer tout les aidants du type choisi
	 * @param ID_Type 	num�ro du type d'aidant s�lectionner
	 * @return			une liste de personne correspondant aux aidants
	 */
	public List<Personne> readAllAidantType(Integer ID_Type);
	
	/**
	 * Foncgtion pour r�cuperer l'ID d'un Aidant � partir de l'Ide d'une personne
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
	 * @param id	Num�ro unique de l'aidant � lire
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
	 * @param id	Num�ro unique de l'aidant � supprimer
	 */
	public void supprAidant(Integer id);

}
