package dao;

import java.util.List;

import bean.Aidee;
import bean.Personne;

public interface IAideeDAO {
	
	/////// Autres Requetes \\\\\\\
	/**
	 * Fonction pour récupérer la liste de tous les aidants d'un aidee
	 * @param id		le numéro unique de l'aidee
	 * @return			la liste des aidants
	 */
	public List<Personne> allAidant(Integer ID_Aidee);
	
	/**
	 * Recuperer la personne proche referente
	 * @param ID_Aidee
	 * @return
	 */
	public Personne readProcheRef(Integer ID_Aidee);
	
	/**
	 *recupere la personne medecin referente
	 * @param ID_Aidee
	 * @return retourne le medecin referent de la personne aidee
	 */
	public Personne readMedecinRef(Integer ID_Aidee);
	
	
	/**
	 * recuperer ID d'un aidee à partir d'une personne
	 * @param ID_Personne
	 * @return l'id_aidee à partir de l'id_personne
	 */
	public Integer readAideeByPersonne(Integer ID_Personne);
	
	
	
	/////// CRUD \\\\\\\
	
	/**
	 * Fonction pour CREER un nouveau aidee dans la BDD
	 * @param p					la personne qui va devenir aidant
	 * @param iD_MedecinRef		le numéro unique du medecin référents
	 * @param iD_ProcheRef		le numéro unique du proche référents
	 */
	public Aidee createAidee(Integer ID_Pers);
	
	/**
	 * Fonction pour LIRE un aidee dans la BDD
	 * @param id	Numéro unique de l'aidee à lire
	 */
	public Aidee readAidee(Integer id);

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
