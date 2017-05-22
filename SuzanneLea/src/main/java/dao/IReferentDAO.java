package dao;

import bean.Referent;

public interface IReferentDAO {
	/////// CRUD \\\\\\\
	
	/**
	 * Fonction pour CREER un nouveau referent dans la BDD
	 * @param ID_Aidant		le num�ro unique de l'aidant r�f�rents
	 * @param ID_Aidee		le num�ro unique de l'aidee
	 */
	public void createRef(Integer ID_Aidant, Integer ID_Aidee);
	
	/**
	 * Fonction pour LIRE un r�f�rent de l'aidee et selon le type d'aidant choisi
	 * @param ID_Aidee	Num�ro unique de l'aidee
	 * @param ID_Type	Num�ro unique selon le type de referent
	 */
	public Referent readRef(Integer ID_Aidee, Integer ID_Type);
	
	/**
	 * Fonction pour LIRE tout les r�f�rents de l'aidee dans la BDD
	 * @param ID_Aidee	Num�ro unique de l'aidee
	 */
	public Referent readRef(Integer ID_Aidee);
	
	/**
	 * Fonction pour SUPPRIMER un referent dans la BDD
	 * @param ID_Aidant		le num�ro unique de l'aidant r�f�rents
	 * @param ID_Aidee		le num�ro unique de l'aidee
	 */
	public void supprRef(Integer ID_Aidant, Integer ID_Aidee);
}
