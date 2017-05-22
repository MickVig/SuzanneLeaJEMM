package dao;

import bean.Referent;

public interface IReferentDAO {
	/////// CRUD \\\\\\\
	
	/**
	 * Fonction pour CREER un nouveau referent dans la BDD
	 * @param ID_Aidant		le numéro unique de l'aidant référents
	 * @param ID_Aidee		le numéro unique de l'aidee
	 */
	public void createRef(Integer ID_Aidant, Integer ID_Aidee);
	
	/**
	 * Fonction pour LIRE un référent de l'aidee et selon le type d'aidant choisi
	 * @param ID_Aidee	Numéro unique de l'aidee
	 * @param ID_Type	Numéro unique selon le type de referent
	 */
	public Referent readRef(Integer ID_Aidee, Integer ID_Type);
	
	/**
	 * Fonction pour LIRE tout les référents de l'aidee dans la BDD
	 * @param ID_Aidee	Numéro unique de l'aidee
	 */
	public Referent readRef(Integer ID_Aidee);
	
	/**
	 * Fonction pour SUPPRIMER un referent dans la BDD
	 * @param ID_Aidant		le numéro unique de l'aidant référents
	 * @param ID_Aidee		le numéro unique de l'aidee
	 */
	public void supprRef(Integer ID_Aidant, Integer ID_Aidee);
}
