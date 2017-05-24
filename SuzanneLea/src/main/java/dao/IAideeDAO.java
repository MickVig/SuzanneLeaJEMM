package dao;

import java.util.List;

import bean.Aidee;
import bean.Personne;

public interface IAideeDAO {
	
	/////// Autres Requetes \\\\\\\
	/**
	 * Fonction pour r�cup�rer la liste de tous les aidants d'un aidee sauf le referent proche
	 * @param id		le num�ro unique de l'aidee
	 * @return			la liste des aidants
	 */
	public List<Personne> allAidant(Integer id);
	
	/**
	 * Recuperer tous les aidants d'un aidee m�me le referent
	 * @param ID_Aidee
	 * @return
	 */
	public List<Personne> allAidantAvecRef(Integer ID_Aidee);
	/**
	 * 
	 * @param ID_Aidee
	 * @return on r�cup�re la personne proche r�f�rente de la personne Aidee
	 */
	public Personne readProcheRef(Integer ID_Aidee);
	
	/**
	 * 
	 * @param ID_Aidee
	 * @return retourne le medecin referent de la personne aidee
	 */
	public Personne readMedecinRef(Integer ID_Aidee);
	
	
	
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
	 * 
	 * @param ID_Personne
	 * @return l'id_aidee � partir de l'id_personne
	 */
	public Integer readAideeByPersonne(Integer ID_Personne);
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
