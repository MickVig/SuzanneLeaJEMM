package dao;

import java.util.List;

import bean.Aidee;
import bean.Personne;

public interface IAideeDAO {
	
	/////// Autres Requetes \\\\\\\
	/**
	 * Fonction pour r�cup�rer la liste de tous les aidants d'un aidee
	 * @param id		le num�ro unique de l'aidee
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
	 * recuperer ID d'un aidee � partir d'une personne
	 * @param ID_Personne
	 * @return l'id_aidee � partir de l'id_personne
	 */
	public Integer readAideeByPersonne(Integer ID_Personne);
	
	
	
	/////// CRUD \\\\\\\
	
	/**
	 * Fonction pour CREER un nouveau aidee dans la BDD
	 * @param p					la personne qui va devenir aidant
	 * @param iD_MedecinRef		le num�ro unique du medecin r�f�rents
	 * @param iD_ProcheRef		le num�ro unique du proche r�f�rents
	 */
	public Aidee createAidee(Integer ID_Pers);
	
	/**
	 * Fonction pour LIRE un aidee dans la BDD
	 * @param id	Num�ro unique de l'aidee � lire
	 */
	public Aidee readAidee(Integer id);

	/**
	 * Fonction pour MODIFIER un aidee dans la BDD
	 * @param p			la personne aidee
	 * @param iD_MedecinRef		le num�ro unique du medecin r�f�rents
	 * @param iD_ProcheRef		le num�ro unique du proche r�f�rents
	 */
	public void updateAidee(Personne p, Integer iD_MedecinRef, Integer iD_ProcheRef);
	
	
	/**
	 * Fonction pour SUPPRIMER un aidee de la BDD
	 * @param id	Num�ro unique de l'aidee � supprimer
	 */
	public void supprAidee(Integer id);
}
