package dao;

import java.util.List;

import bean.Aidant;
import bean.Personne;

public interface IAideeDAO {
	
	/////// Autres Requetes \\\\\\\
	/**
	 * Fonction pour récupérer la liste de tout les aidants d'un aidee
	 * @param id		le numéro unique de l'aidee
	 * @return			la liste des aidants
	 */
	public List<Aidant> allAidant(Integer id);
	
	
	
	/////// CRUD \\\\\\\
	
	/**
	 * Fonction pour CREER un nouveau aidee dans la BDD
	 * @param p					la personne qui va devenir aidant
	 * @param iD_MedecinRef		le numéro unique du medecin référents
	 * @param iD_ProcheRef		le numéro unique du proche référents
	 */
	public void createAidee(Personne p, Integer iD_MedecinRef, Integer iD_ProcheRef);
	
	/**
	 * Fonction pour LIRE un aidee dans la BDD
	 * @param id	Numéro unique de l'aidee à lire
	 */
	public Personne readAidee(Integer id);
	
	/**
	 * Fonction pour MODIFIER un aidee dans la BDD
	 * @param p			la personne aidee
	 * @param iD_MedecinRef		le numéro unique du medecin référents
	 * @param iD_ProcheRef		le numéro unique du proche référents
	 */
	public void updateAidee(Personne p, Integer iD_MedecinRef, Integer iD_ProcheRef);
	
	
	/**
	 * Fonction pour SUPPRIMER un aidee de la BDD
	 * @param id	Numéro unique de l'aidee à supprimer
	 */
	public void supprAidee(Integer id);
}
